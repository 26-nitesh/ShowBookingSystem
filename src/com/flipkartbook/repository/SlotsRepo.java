package com.flipkartbook.repository;

import com.flipkartbook.model.ShowSlots;
import com.flipkartbook.utils.Genre;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SlotsRepo {

    private final List<ShowSlots> showSlotsList = new ArrayList<>();

    private static SlotsRepo slotsRepo;
    private SlotsRepo(){

    }
    public static SlotsRepo getInstance(){
        if(slotsRepo == null){
            slotsRepo = new SlotsRepo();
        }
        return slotsRepo;
    }

    public void addSlots(ShowSlots showSlots){
        showSlotsList.add(showSlots);
    }
    public List<ShowSlots> findAllByName(String showName) {
        return showSlotsList.stream().filter(slots -> showName.equalsIgnoreCase(slots.getShowName())).collect(Collectors.toList());
    }

    public Optional<ShowSlots> findByNameAndStart(String showName, String start) {
        return showSlotsList.stream().filter(slot -> (showName.equalsIgnoreCase(slot.getShowName())) && start.equals(slot.getStart())).findFirst();
    }
}
