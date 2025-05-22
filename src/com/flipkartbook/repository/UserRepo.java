package com.flipkartbook.repository;

import com.flipkartbook.model.User;

import java.util.*;

public class UserRepo {
    private  final Set<User> users = new HashSet<>();
    private String loggedInUser;

    private static UserRepo userRepo;
    private UserRepo(){

    }
    public static UserRepo getInstance() {
        if(userRepo == null){
            userRepo = new UserRepo();
        }
        return userRepo;
    }

    public void save(User user){
        users.add(user);
    }
    public Optional<User> findByUserName(String userName){
        return users.stream().filter(user -> userName.equalsIgnoreCase(user.getUserName())).findFirst();
    }

    public void logout(){
        if(loggedInUser == null){
            System.out.println("No logged in User");
        }else{
            this.loggedInUser = null;
        }
    }
    public String getLoggedInUser(){
        return this.loggedInUser;
    }


    public void setLoggedInUser(String userName) {
        this.loggedInUser = userName;
    }

}
