package com.flipkartbook.model;

import com.flipkartbook.utils.Genre;

public class LiveShows {

    private String name;
    private Genre genre;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public LiveShows() {
    }

    public LiveShows(String name, Genre genre) {
        this.name = name;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "{" +
                "Show name='" + name + '\'' +
                ", genre=" + genre +
                '}';
    }
}
