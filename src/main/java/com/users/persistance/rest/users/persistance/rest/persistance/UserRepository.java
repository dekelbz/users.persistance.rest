package com.users.persistance.rest.users.persistance.rest.persistance;

import com.users.persistance.rest.users.persistance.rest.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepository extends PagingAndSortingRepository<User, String> {
}
