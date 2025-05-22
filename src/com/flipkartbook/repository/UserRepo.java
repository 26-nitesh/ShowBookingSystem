package com.flipkartbook.repository;

import com.flipkartbook.model.User;

import java.util.*;

public class UserRepo {
    private  final Set<User> users = new HashSet<>();
    private final Set<String> loggedInUsers = new HashSet<>();

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
        if(!loggedInUsers.contains(userName)){
            System.out.println("No logged in User");
        }else{
            loggedInUsers.remove(userName);
        }
    }


    public boolean isUserLoggedIn(String userName) {
        return loggedInUsers.contains(userName);
    }

    public void addToLoggedInUser(String userName) {
        loggedInUsers.add(userName);
    }
}
