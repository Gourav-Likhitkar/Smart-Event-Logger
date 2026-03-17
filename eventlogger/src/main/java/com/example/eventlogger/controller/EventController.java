package com.example.eventlogger.controller;

import com.example.eventlogger.model.UserEvent;
import com.example.eventlogger.repository.EventRepository;
import com.example.eventlogger.service.BatchingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@CrossOrigin(origins = "http://localhost:3000")
public class EventController {

    @Autowired
    private BatchingService batchingService;

    @Autowired
    private EventRepository eventRepository;

    @GetMapping
    public List<UserEvent> getAllEvents() {
        return eventRepository.findAll();
    }

    @PostMapping
    public String receiveEvent(@RequestBody UserEvent event) {
        batchingService.addEventToBuffer(event);
        return "Event received!";
    }
}