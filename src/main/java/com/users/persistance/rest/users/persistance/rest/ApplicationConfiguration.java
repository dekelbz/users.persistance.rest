package com.users.persistance.rest.users.persistance.rest;

import com.users.persistance.rest.users.persistance.rest.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public RepositoryRestConfigurer repositoryRestConfigurer()
    {
        return RepositoryRestConfigurer.withConfig(config -> config.exposeIdsFor(User.class));
    }

}
