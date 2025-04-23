package com.example.wp1.web;

import com.example.wp1.model.Event;
import com.example.wp1.service.EventService;
import com.example.wp1.service.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EventController {
    private final EventService eventService;
    private final LocationService locationService;


    public EventController(EventService eventService, LocationService locationService) {
        this.eventService = eventService;
        this.locationService = locationService;
    }

    @GetMapping("/events/add")
    public String getEventAddPage(Model model) {
        model.addAttribute("locations", locationService.findAll());
        return "add-event";
    }

    @GetMapping("/events/edit/{eventId}")
    public String getEventEditPage(Model model, @PathVariable(name = "eventId") long eventId) {
        model.addAttribute("locations", locationService.findAll());
        model.addAttribute("event", eventService.getEventById(eventId));
        return "add-event";
    }

    @GetMapping("/events")
    public String getEventsPage(@RequestParam(required = false) String error,@RequestParam(name = "locationId", required = false) Long locationId, Model model) {
        if(locationId != null) {
            model.addAttribute("events", eventService.findAllByLocationId(locationId));
        }else{
            model.addAttribute("events", eventService.listAll());
            model.addAttribute("locations", locationService.findAll());
        }
        return "listEvents";
    }

    @PostMapping("/events/add")
    public String saveEvent(@RequestParam(name = "name") String name,
                           @RequestParam(name = "description") String description,
                           @RequestParam(name="popularityScore") double popularityScore,
                           @RequestParam(name = "locationId") Long locationId) {
        eventService.addEvent(name, description, popularityScore, locationId);
        return "redirect:/events";
    }

    @PostMapping("/events/edit/{eventId}")
    public String editEvent(@PathVariable Long eventId,
                            @RequestParam(name = "name") String name,
                            @RequestParam(name = "description") String description,
                            @RequestParam(name="popularityScore") double popularityScore,
                            @RequestParam(name = "locationId") Long locationId) {
        eventService.editEvent(eventId, name, description, popularityScore, locationId);
        return "redirect:/events";
    }

    @GetMapping("/events/delete/{eventId}")
    public String deleteEvent(@PathVariable Long eventId) {
        eventService.deleteEvent(eventId);
        return "redirect:/events";
    }
}
