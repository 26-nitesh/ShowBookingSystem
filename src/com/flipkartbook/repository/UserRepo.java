package com.flipkartbook.repository;

import com.flipkartbook.model.User;

import java.util.*;

public class UserRepo {
    private  final Set<User> users = new HashSet<>();
    private final Set<String> loggedInUser = new HashSet<>();

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

    public void logout(String userName){
        if(!loggedInUser.contains(userName)){
            System.out.println("No logged in User with userName "+ userName);
        }else{
           loggedInUser.remove(userName);
        }
    }
//    public String getLoggedInUser(){
//        return this.loggedInUser;
//    }


    public void addToLoggedIn(String userName) {
        loggedInUser.add(userName);
    }

    public boolean isLoggedIn(String userName) {
        return loggedInUser.contains(userName);
    }
}
