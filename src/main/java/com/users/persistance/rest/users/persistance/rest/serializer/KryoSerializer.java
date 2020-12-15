package com.users.persistance.rest.users.persistance.rest.serializer;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import org.objenesis.strategy.StdInstantiatorStrategy;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.io.ByteArrayOutputStream;

public class KryoSerializer implements RedisSerializer<Object> {

    private static final ThreadLocal<Kryo> KRYO = ThreadLocal.withInitial(() -> {
        var kryo = new Kryo();
        kryo.setInstantiatorStrategy(new StdInstantiatorStrategy());
        kryo.setRegistrationRequired(false);
        return kryo;
    });

    @Override
    public byte[] serialize(Object o) throws SerializationException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (Output output = new Output(outputStream)){
            KRYO.get().writeClassAndObject(output, o);
        }
        return outputStream.toByteArray();
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        return KRYO.get().readClassAndObject(new Input(bytes));
    }
}
