package com.users.persistance.rest.users.persistance.rest.entity;

import lombok.Data;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.GeoIndexed;

@Data
@RedisHash
public class Address {
    @GeoIndexed
    private Point location;
    private String city;
}
