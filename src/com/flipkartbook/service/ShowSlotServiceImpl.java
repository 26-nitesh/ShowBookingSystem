package com.flipkartbook.service;

import com.flipkartbook.model.ShowSlots;
import com.flipkartbook.repository.SlotsRepo;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ShowSlotServiceImpl {
    private final IShowService showService = ShowServiceImpl.getInstance();
    private final SlotsRepo slotsRepo =  SlotsRepo.getInstance();

    private static ShowSlotServiceImpl showSlotService;

    private ShowSlotServiceImpl(){

    }
    public static ShowSlotServiceImpl getInstance() {
        if(showSlotService == null){
            showSlotService = new ShowSlotServiceImpl();
        }
        return showSlotService;
    }

    public void onboardSlots(ShowSlots showSlots){
        if(showSlots.getShowName() != null && showSlots.getStart() != null){
            if(showService.findByName(showSlots.getShowName()).isPresent()){
                Optional<ShowSlots> existingSlots = slotsRepo.findByNameAndStart(showSlots.getShowName(), showSlots.getStart());
                if(existingSlots.isPresent()){
                    if(showSlots.getEnd() == null || (showSlots.getEnd() != null && isTimeSlotValid(showSlots.getStart(), showSlots.getEnd()))){
                        System.out.println("Slots with this time already found , Updating capacity");
                        ShowSlots showSlots1 = existingSlots.get();
                        showSlots1.setCapacity(showSlots1.getCapacity()+showSlots.getCapacity());
                        System.out.println("Slots Updated SucessFully");
                    }else{
                            System.out.println("Time Slot is not valid");
                        }
                }else{
                  if(showSlots.getEnd() == null || (showSlots.getEnd() != null && isTimeSlotValid(showSlots.getStart(), showSlots.getEnd()))){
                      slotsRepo.addSlots(showSlots);
                      System.out.println("Slots Added SucessFully");
                  }else{
                          System.out.println("Time Slot is not valid");
                      }
                }
            }else{
                System.out.println("Show is Not Available to add slots");
            }
        }else{
            System.out.println("Null passed for showname or slot start");
        }
    }

    private boolean isTimeSlotValid(String start, String end) {
        String[] s = start.split(":");
        String[] e = end.split(":");
        return Integer.parseInt(e[0])-Integer.parseInt(s[0]) == 1
                && Integer.parseInt(s[1]) == 0
                && Integer.parseInt(e[1]) ==0;
    }

    public List<ShowSlots> findAllSlotsByShowNames(List<String> showNames){
        List<ShowSlots> showSlots = new ArrayList<>();
        for(String show : showNames){
            List<ShowSlots> eachShowSlots = slotsRepo.findAllByName(show);
            if(!eachShowSlots.isEmpty()){
                showSlots.addAll(eachShowSlots);
            }
        }
        showSlots.sort(Comparator.comparing(slot -> LocalTime.parse(slot.getStart())));
        return showSlots;
    }
}
