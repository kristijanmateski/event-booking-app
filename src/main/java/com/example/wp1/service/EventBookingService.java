package com.example.wp1.service;

import com.example.wp1.model.EventBooking;

public interface EventBookingService {
    EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, int numberOfTickets);
}
