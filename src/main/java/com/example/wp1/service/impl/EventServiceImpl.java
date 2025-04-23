package com.example.wp1.service.impl;

import com.example.wp1.model.Event;
import com.example.wp1.model.Location;
import com.example.wp1.repository.jpa.EventJpaRepository;
import com.example.wp1.repository.jpa.LocationJpaRepository;
import com.example.wp1.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {
    private final EventJpaRepository eventJpaRepository;
    private final LocationJpaRepository locationJpaRepository;

    public EventServiceImpl(EventJpaRepository eventJpaRepository, LocationJpaRepository locationJpaRepository) {
        this.eventJpaRepository = eventJpaRepository;
        this.locationJpaRepository = locationJpaRepository;
    }


    @Override
    public List<Event> listAll() {
        return eventJpaRepository.findAll();
    }



    @Override
    public void addEvent(String name, String description, double popularityScore, Long locationId) {
        Location location = locationJpaRepository.findById(locationId).get();
        Event event = new Event(name,description,popularityScore);
        event.setLocation(location);
        eventJpaRepository.save(event);

    }

    @Override
    public void editEvent(Long eventId, String name, String description, double popularityScore, Long locationId) {
        Event event = eventJpaRepository.findById(eventId).get();
        Location location = locationJpaRepository.findById(locationId).get();
        event.setName(name);
        event.setDescription(description);
        event.setPopularityScore(popularityScore);
        event.setLocation(location);
        eventJpaRepository.save(event);
    }

    @Override
    public Event getEventById(Long eventId) {
        Optional<Event> event = eventJpaRepository.findById(eventId);

        if (event.isPresent()) {
            return event.get();
        }
        return null;
    }

    @Override
    public List<Event> findAllByLocationId(Long locationId) {
        return eventJpaRepository.findAllByLocationId(locationId);
    }

    @Override
    public void deleteEvent(Long eventId) {
        eventJpaRepository.deleteById(eventId);
    }
}
