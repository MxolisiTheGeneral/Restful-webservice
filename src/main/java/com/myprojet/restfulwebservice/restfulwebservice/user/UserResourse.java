package com.myprojet.restfulwebservice.restfulwebservice.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

     //create the user
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user){

          User savedUser = service.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

       return  ResponseEntity.created(location)
                .build();
    }
}
