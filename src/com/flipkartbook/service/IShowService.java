package com.flipkartbook.service;

import com.flipkartbook.model.LiveShows;

import java.util.Optional;

public interface IShowService {
    void registerShow(LiveShows liveShow);
    Optional<LiveShows> findByName(String showName);
}
