package com.example.eventlogger.service;

import com.example.eventlogger.model.UserEvent;
import com.example.eventlogger.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class BatchingService {

    @Autowired
    private EventRepository eventRepository;

    private final List<UserEvent> buffer = new CopyOnWriteArrayList<>();

    public void addEventToBuffer(UserEvent event) {
        buffer.add(event);
    }

    @Scheduled(fixedRate = 10000)
    public void flushBuffer() {
        if (!buffer.isEmpty()) {
            List<UserEvent> toSave = List.copyOf(buffer);
            buffer.clear();
            eventRepository.saveAll(toSave);
            System.out.println("Saved " + toSave.size() + " events to the database.");
        }
    }
}
