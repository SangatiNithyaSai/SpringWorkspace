package com.example.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.api.user.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}                     
