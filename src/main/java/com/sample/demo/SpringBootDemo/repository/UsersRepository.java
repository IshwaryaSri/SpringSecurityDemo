package com.sample.demo.SpringBootDemo.repository;

import com.sample.demo.SpringBootDemo.entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface UsersRepository extends CrudRepository<Users, Integer> {

    Users findByUsername(String username);
}
