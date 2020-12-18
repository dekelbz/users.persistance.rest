package com.users.persistance.rest.users.persistance.rest.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Data
@RedisHash(timeToLive = 60 * 5)
public class User {
    @Id
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String phoneNumber;
    private String department;
    private String roleTitle;
    private Address address;
}
