package com.myprojet.restfulwebservice.restfulwebservice.user;

import org.springframework.stereotype.Component;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<User>();
    private int countUser = 3;

     static {

          users.add( new User(1,"MXOLISI", new Date()));
          users.add( new User(2,"Mcebo", new Date()));
          users.add( new User(3,"Treasure", new Date()));
     }

     // find all users
     public List<User> findAll(){
          return  users;
     }

     //find one user
    public User findOne(int id){
          for(User user:users){
               if(user.getId() == id){
                    return user;
               }
          }
           return  null;
    }

    // save user
    public User save(User user){
           if(user.getId() == null){
                user.setId(++countUser);
           }
           users.add(user);
           return  user;

    }

    //detele user
     public User deleteById(int id){

         Iterator<User> iterator = users.iterator();
           while(iterator.hasNext()){
               User user = iterator.next();
                if(user.getId() == id){
                     iterator.remove();
                     return  user;
                }
           }
            return  null;
     }


}
