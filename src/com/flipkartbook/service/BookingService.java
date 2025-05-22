package com.flipkartbook.service;

import com.flipkartbook.model.LiveShows;
import com.flipkartbook.model.ShowSlots;
import com.flipkartbook.utils.Genre;

import java.util.List;

public class BookingService {

    private static BookingService bookingService;
    private BookingService(){

    }
    public static BookingService getInstance(){
        if(bookingService == null){
            bookingService = new BookingService();
        }
        return bookingService;
    }

    private final ShowServiceImpl showService = ShowServiceImpl.getInstance();
    private final ShowSlotServiceImpl showSlotService =  ShowSlotServiceImpl.getInstance();

    public void displayShowDetailsOnGerne(Genre genre){
        List<LiveShows> allShowsByGenre = showService.findAllShowsByGenre(genre);
        for(LiveShows show : allShowsByGenre){
            System.out.println(show);
            List<ShowSlots> allSlots = showSlotService.findAllSlotsByShowNames(List.of(show.getName()));
            for (ShowSlots slots: allSlots) {
                System.out.println(slots);
            }
        }

    }

}
