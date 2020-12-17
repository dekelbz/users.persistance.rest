package com.users.persistance.rest.users.persistance.rest.entity;

import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@Cache(region = "userCache", usage = CacheConcurrencyStrategy.READ_WRITE)
public class DbUser {
    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String phoneNumber;
    private String department;
    private String roleTitle;
}
