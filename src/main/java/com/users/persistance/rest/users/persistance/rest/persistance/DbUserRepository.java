package com.users.persistance.rest.users.persistance.rest.persistance;

import com.users.persistance.rest.users.persistance.rest.entity.DbUser;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface DbUserRepository extends PagingAndSortingRepository<DbUser, Long> {
}
