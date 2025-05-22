package com.flipkartbook;

import com.flipkartbook.model.LiveShows;
import com.flipkartbook.model.ShowSlots;
import com.flipkartbook.model.User;
import com.flipkartbook.service.BookingService;
import com.flipkartbook.service.ShowServiceImpl;
import com.flipkartbook.service.ShowSlotServiceImpl;
import com.flipkartbook.service.UserService;
import com.flipkartbook.utils.Genre;

public class Test {
    public static void main(String[] args) {
         ShowSlotServiceImpl showSlotService = ShowSlotServiceImpl.getInstance();
         ShowServiceImpl showService =  ShowServiceImpl.getInstance();
         BookingService bookingService = BookingService.getInstance();
         UserService userService = UserService.getInstance();
         showService.registerShow(new LiveShows("TMKOC", Genre.COMEDY));
         showService.registerShow(new LiveShows("RRR", Genre.ACTION));
         showSlotService.onboardSlots(new ShowSlots("10:00","11:00",12,"TMKOC"));
         showSlotService.onboardSlots(new ShowSlots("10:00","12:00",12,"TMKOC")); // can't add as 2hrs
         showSlotService.onboardSlots(new ShowSlots("10:00","11:00",5,"TMKOC"));  // as previous slot found , capacity will be updated
         showSlotService.onboardSlots(new ShowSlots("10:00","11:00",12,"RRR"));
         showSlotService.onboardSlots(new ShowSlots("15:00","16:00",4,"TMKOC"));
         showSlotService.onboardSlots(new ShowSlots("20:00","21:00",3,"TMKOC"));


         bookingService.displayShowDetailsOnGerne(Genre.ACTION);
         bookingService.displayShowDetailsOnGerne(Genre.COMEDY); // will display on sorted order of same tmkoc based on start time

         showSlotService.onboardSlots(new ShowSlots("15:00","16:00",12,"OOO")); // can't be created because show isn't available

         showService.registerShow(new LiveShows("Hera Pheri", Genre.COMEDY));
         showSlotService.onboardSlots(new ShowSlots("18:00","19:00",5,"Hera Pheri"));
         showSlotService.onboardSlots(new ShowSlots("13:00","14:00",6,"Hera Pheri"));
         bookingService.displayShowDetailsOnGerne(Genre.COMEDY); // will display sorted on name, foloowed by slot timing

         userService.logout("7898");// can't log out as no logged in
         userService.login("user123");
         userService.register(new User("user456"));
         userService.login("user456");
         System.out.println(userService.isUserLoggedIn("user456"));
         System.out.println(userService.isUserLoggedIn("7yug"));

    }
}
