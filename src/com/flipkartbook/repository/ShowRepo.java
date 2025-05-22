package com.flipkartbook.repository;

import com.flipkartbook.model.LiveShows;
import com.flipkartbook.utils.Genre;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ShowRepo {

    private final List<LiveShows> liveShowsList = new ArrayList<>();

    private static ShowRepo showRepo;
    private ShowRepo(){

    }
    public static ShowRepo getInstance() {
        if(showRepo == null){
            showRepo = new ShowRepo();
        }
        return showRepo;
    }

    public void save(LiveShows liveShows){
        liveShowsList.add(liveShows);
    }


    public Optional<LiveShows> findByName(String showName) {
        return liveShowsList.stream().filter(show -> showName.equals(show.getName())).findFirst();
    }
    public List<LiveShows> findAllByGenre(Genre genre){
        return liveShowsList.stream().filter(show -> show.getGenre().equals(genre)).collect(Collectors.toList());
    }

    public List<LiveShows> findAll() {
        return liveShowsList;
    }
}
