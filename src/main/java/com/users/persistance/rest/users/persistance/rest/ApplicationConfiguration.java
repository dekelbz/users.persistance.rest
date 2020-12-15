package com.users.persistance.rest.users.persistance.rest;

import com.users.persistance.rest.users.persistance.rest.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@Configuration
public class ApplicationConfiguration {

    /*private final RedisConnectionFactory connectionFactory;

    public ApplicationConfiguration(RedisConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisSerializer<?> serializer) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);

        template.setDefaultSerializer(serializer);
        return template;
    }


    @Bean
    public RedisCacheConfiguration defaultRedisCacheConfiguration(CompressionSerializer<Object> serializer) {
        return RedisCacheConfiguration.defaultCacheConfig()
                .serializeValuesWith(RedisSerializationContext
                        .SerializationPair.fromSerializer(serializer));
    }*/

   /* @Bean
    CompressionSerializer defaultSerializer() {
        return new CompressionSerializer(new KryoSerializer());
    }

    @Bean
    public RedisCustomConversions redisCustomConversions(CompressionSerializer serializer) {
        Converter<Object, byte[]> bytesSerializer = new Converter<Object, byte[]>() {
            @Override
            public byte[] convert(Object source) {
                return serializer.serialize(source);
            }

        };
        Converter<byte[], Object> bytesDeserializer = new Converter<byte[], Object>() {
            @Override
            public Object convert(byte[] source) {
                return serializer.deserialize(source);
            }
        };

        Converter<String, byte[]> stringByteConverter = new Converter<String, byte[]>() {
            @Override
            public byte[] convert(String source) {
                return source.getBytes();
            }
        };
        Converter<byte[], String> byteStringConverter = new Converter<byte[], String>() {
            @Override
            public String convert(byte[] source) {
                return new String(source);
            }
        };
        return new RedisCustomConversions(Arrays.asList(bytesSerializer, bytesDeserializer, stringByteConverter, byteStringConverter));
    }*/

    @Bean
    public RepositoryRestConfigurer repositoryRestConfigurer()
    {
        return RepositoryRestConfigurer.withConfig(config -> config.exposeIdsFor(User.class));
    }

}
