package com.sample.demo.SpringBootDemo.controller;

import com.sample.demo.SpringBootDemo.entity.Users;
import com.sample.demo.SpringBootDemo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController {

    @Autowired
    UsersService usersService;

//    @RequestMapping("/")
//    public String index() {
//        return "index.html";
//    }

    @GetMapping("/")
    private List<Users> getAllUsers()
    {
        return usersService.getAllUsers();
    }

    @PostMapping("/add")
    @ResponseBody
    public String addUser(@RequestParam String userName, @RequestParam String password, @RequestParam String email) {

        Users user = new Users();
        user.setUsername(userName);
        user.setPassword(password);

        usersService.saveOrUpdate(user);

        String ret = "User has been added, user name = " + userName + ", password = " + password + ", email = "
                + email;

        return ret;

    }

    @GetMapping("/user/{id}")
    private Users getUsers(@PathVariable("id") int id)
    {
        return usersService.getUsersById(id);
    }

}
