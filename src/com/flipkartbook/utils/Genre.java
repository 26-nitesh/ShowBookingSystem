package com.flipkartbook.utils;

public enum Genre {
    COMEDY("Comedy"), ACTION("Action"), SCIFI("Sci-Fi"), DRAMA("Drama"), HORROR("Horror");

    private final String value;

    Genre(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
