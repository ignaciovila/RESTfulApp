package com.ignacio.vila.repository;

import com.ignacio.vila.model.user.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer>{

}
