package com.example.wp1.service;

import com.example.wp1.model.Event;

import java.util.List;

public interface EventService {
    List<Event> listAll();

    void addEvent(String name, String description, double popularityScore, Long locationId);
    void editEvent(Long eventId, String name, String description, double popularityScore, Long locationId);
    void deleteEvent(Long eventId);
    Event getEventById(Long eventId);
    List<Event> findAllByLocationId(Long locationId);

}
