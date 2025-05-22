package com.flipkartbook.model;

public class ShowSlots {
    private String start;
    private String end;
    private int capacity;
    private int booked = 0;
    private String showName;

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getBooked() {
        return booked;
    }

    public void setBooked(int booked) {
        this.booked = booked;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public ShowSlots() {
    }

    public ShowSlots(String start, String end, int capacity, String showName) {
        this.start = start;
        this.end = end;
        this.capacity = capacity;
        this.showName = showName;
    }

    @Override
    public String toString() {
        return "    {" +
                "start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", available seat=" + (capacity - booked) +
                '}';
    }
}
