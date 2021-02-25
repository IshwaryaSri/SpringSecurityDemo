package com.sample.demo.SpringBootDemo.controller;

import com.sample.demo.SpringBootDemo.entity.Users;
import com.sample.demo.SpringBootDemo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UsersController {

    @Autowired
    UsersService usersService;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/login")
    public String index() {
        return "login.html";
    }

    @GetMapping("/")
    private List<Users> getAllUsers()
    {
        return usersService.getAllUsers();
    }

    @PostMapping("/add")
    @ResponseBody
    public void addUser(@RequestParam String userName, @RequestParam String password) {

        Users user = new Users();
        user.setUsername(userName);
        String encodedPassword = bCryptPasswordEncoder.encode(password);
        user.setPassword(encodedPassword);

        usersService.saveOrUpdate(user);

        System.out.println("User has been added, user name = " + user.getUsername() + ", password = " + encodedPassword);


    }

    @GetMapping("/user/{id}")
    private Users getUsers(@PathVariable("id") int id)
    {
        return usersService.getUsersById(id);
    }

}
