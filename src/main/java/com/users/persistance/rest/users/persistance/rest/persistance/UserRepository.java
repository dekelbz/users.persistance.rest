package com.users.persistance.rest.users.persistance.rest.persistance;

import com.users.persistance.rest.users.persistance.rest.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

//@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends PagingAndSortingRepository<User, String> {
}
