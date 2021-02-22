package com.sample.demo.SpringBootDemo.service;

import com.sample.demo.SpringBootDemo.entity.Users;
import com.sample.demo.SpringBootDemo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService {

    @Autowired
    UsersRepository usersRepository;

    public List<Users> getAllUsers()
    {
        List<Users> users = new ArrayList<Users>();
        usersRepository.findAll().forEach(users1 -> users.add(users1));
        return users;
    }

    public Users getUsersById(int id)
    {
        return usersRepository.findById(id).get();
    }

    public void saveOrUpdate(Users users)
    {
        usersRepository.save(users);
    }
}
