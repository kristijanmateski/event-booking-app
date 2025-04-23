package com.example.wp1.service.impl;

import com.example.wp1.model.EventBooking;
import com.example.wp1.repository.EventBookingRepository;
import com.example.wp1.service.EventBookingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EventBookingServiceImpl implements EventBookingService {

    private EventBookingRepository eventBookingRepository;

    @Override
    public EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, int numberOfTickets) {
        EventBooking eventBooking = new EventBooking();
        eventBooking.setEventName(eventName);
        eventBooking.setAttendeeName(attendeeName);
        eventBooking.setAttendeeAddress(attendeeAddress);
        eventBooking.setNumberOfTickets((long) numberOfTickets);
        eventBookingRepository.add(eventBooking);
        return eventBooking;
    }
}
