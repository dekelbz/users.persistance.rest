package com.users.persistance.rest.users.persistance.rest.serializer;

import lombok.SneakyThrows;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.xerial.snappy.Snappy;

import java.util.Objects;

public class CompressionSerializer implements RedisSerializer<Object> {


    private final RedisSerializer<Object> innerSerializer;

    public CompressionSerializer(RedisSerializer<Object> innerSerializer) {
        this.innerSerializer = innerSerializer;
    }

    @Override
    @SneakyThrows
    public byte[] serialize(Object o) throws SerializationException {
        if (o == null) {
            return null;
        }
        return Snappy.compress(Objects.requireNonNull(innerSerializer.serialize(o)));
    }

    @Override
    @SneakyThrows
    public Object deserialize(byte[] bytes) throws SerializationException {
        return innerSerializer.deserialize(Snappy.uncompress(bytes));
    }
}
