package com.ignacio.vila.repository;

import org.springframework.data.repository.CrudRepository;

import com.ignacio.vila.model.user.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
