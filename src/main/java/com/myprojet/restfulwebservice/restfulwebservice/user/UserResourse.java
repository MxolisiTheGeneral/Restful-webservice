package com.myprojet.restfulwebservice.restfulwebservice.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserResourse {

     @Autowired(required=true)
     private UserDaoService service;

     // retrieve all users
    @GetMapping("/users")
    public List<User> retrieveAll(){

        return service.findAll();

    }

    //retrieve one user
    @GetMapping("/users/{id}")
    public  User retrieveOne(@PathVariable int id){
          User user = service.findOne(id);

           return  user;
    }

}
