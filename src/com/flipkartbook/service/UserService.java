package com.flipkartbook.service;

import com.flipkartbook.model.User;
import com.flipkartbook.repository.UserRepo;

public class UserService {

    private UserService(){

    }
    private static UserService userService;
    public static UserService getInstance(){
        if(userService == null){
            userService = new UserService();
        }
        return userService;
    }
    private final UserRepo userRepo = UserRepo.getInstance();

    public void register(User user){
        if(userRepo.findByUserName(user.getUserName()).isEmpty()){
            userRepo.save(user);
            System.out.println("User Registered suceefully");
        }else{
            System.out.println("User Already Exist !! please login");
        }
    }

    public void login(String userName){
        if(userRepo.findByUserName(userName).isPresent()) {
            userRepo.addToLoggedIn(userName);
            System.out.println("User logged in sucessfully");
        }else{
            System.out.println("User Not found");
        }
    }
    public void logout(String userName){
        userRepo.logout(userName);
    }
//    public String getLoggedInUser(){
//        return userRepo.getLoggedInUser();
//    }
    public boolean isLoggedIn(String userName){
        return userRepo.isLoggedIn(userName);
    }
}
