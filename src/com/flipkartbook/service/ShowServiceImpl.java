package com.flipkartbook.service;

import com.flipkartbook.model.LiveShows;
import com.flipkartbook.repository.ShowRepo;
import com.flipkartbook.utils.Genre;

import java.util.*;

public class ShowServiceImpl implements IShowService {
    private final ShowRepo showRepo =  ShowRepo.getInstance();

    private ShowServiceImpl(){

    }
    private static ShowServiceImpl showService;
    public static ShowServiceImpl getInstance() {
        if(showService == null){
            showService = new ShowServiceImpl();
        }
        return showService;
    }

    @Override
    public void registerShow(LiveShows liveShow) {
        if(findByName(liveShow.getName()).isEmpty()) {
            showRepo.save(liveShow);
            System.out.println("Show "+liveShow.getName() +" added Successfully ");
        }else{
            System.out.println("Show with name " +liveShow.getName()+ " Already exist");
       }
    }
    @Override
    public Optional<LiveShows> findByName(String showName){
        return showRepo.findByName(showName);
    }

    public List<LiveShows> findAllShowsByGenre(Genre genre){
        List<LiveShows> output = showRepo.findAllByGenre(genre);
         output.sort(Comparator.comparing(LiveShows::getName));
         return output;
    }
}
