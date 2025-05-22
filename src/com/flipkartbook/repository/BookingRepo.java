package com.flipkartbook.repository;

import com.flipkartbook.model.Booking;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookingRepo {

    private final List<Booking> myBookings = new ArrayList<>();

    private static BookingRepo bookingRepo;
    private BookingRepo(){

    }
    public static BookingRepo getInstance(){
        if(bookingRepo == null){
            bookingRepo = new BookingRepo();
        }
        return bookingRepo;
    }

    public void save(Booking booking){
        myBookings.add(booking);
    }

    public List<Booking> findAllByUser(String userName){
       return myBookings.stream().filter(booking -> userName.equalsIgnoreCase(booking.getUserName())).collect(Collectors.toList());
    }

    public Optional<Booking> findByUserAndStart(String userName, String start){
        return myBookings.stream().filter(booking -> (userName.equalsIgnoreCase(booking.getUserName()) && start.equals(booking.getStart()))).findFirst();
    }

}
