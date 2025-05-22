package com.flipkartbook.model;

import java.util.*;

public class User {
    private String userName;
    private Set<String> bookedTimes = new HashSet<>();

    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public Set<String> getBookedTime() {
        return bookedTimes;
    }

    public boolean addToBooked(String slot) {
        return bookedTimes.add(slot);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName);
    }
}
