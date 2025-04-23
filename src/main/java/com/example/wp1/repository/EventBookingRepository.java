package com.example.wp1.repository;

import com.example.wp1.model.EventBooking;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EventBookingRepository {
    List<EventBooking> eventBookings = new ArrayList<>();

    public void add(EventBooking eventBooking) {
        eventBookings.add(eventBooking);
    }
}
