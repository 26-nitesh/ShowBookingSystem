package com.flipkartbook.service;

import com.flipkartbook.model.Booking;
import com.flipkartbook.model.LiveShows;
import com.flipkartbook.model.ShowSlots;
import com.flipkartbook.repository.BookingRepo;
import com.flipkartbook.utils.Genre;

import java.util.List;
import java.util.Optional;

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

    private final BookingRepo bookingRepo = BookingRepo.getInstance();

    private final UserService userService = UserService.getInstance();

    public void displayShowDetailsOnGerne(Genre genre){
        if(userService.getLoggedInUser() != null){
            List<LiveShows> allShowsByGenre = showService.findAllShowsByGenre(genre);
            for(LiveShows show : allShowsByGenre){
                System.out.println(show);
                List<ShowSlots> allSlots = showSlotService.findAllSlotsByShowNames(List.of(show.getName()));
                for (ShowSlots slots: allSlots) {
                    System.out.println(slots);
                }
            }
        }else{
            System.out.println("Error!! Please log in first to See Details..");
        }

    }
    public void bookShow(String showName, String start, int person){
        if(userService.getLoggedInUser() != null){
            Optional<ShowSlots> slotO = showSlotService.findByShowNameAndStart(showName, start);
            if(slotO.isPresent()){
                if(bookingRepo.findByUserAndStart(userService.getLoggedInUser(),start).isEmpty()){
                    ShowSlots slot = slotO.get();
                    int availble = slot.getCapacity() - slot.getBooked();
                    if(availble >= person){
                        slot.setBooked(slot.getBooked()+person);
                        Booking booking = new Booking();
                        booking.setPersons(person);
                        booking.setUserName(userService.getLoggedInUser());
                        booking.setStart(start);
                        booking.setShowName(showName);
                        bookingRepo.save(booking);
                        showSlotService.updateSeats(slot);
                    }else{
                        System.out.println("insufficient seats");
                    }
                }else{
                    System.out.println("User is already having a booking for the given time");
                }
            }else{
                System.out.println("No slots available for given input");
            }
        }else{
            System.out.println("Error!! Please log in first to PRoceed..");
        }
    }

    

}
