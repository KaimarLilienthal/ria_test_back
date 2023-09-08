package com.example.ria_test_back.domain;

import com.example.ria_test_back.entities.Event;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    @Resource
    private EventRepository eventRepository;

    public List<Event> findAllEventsBy(String status) {
        return eventRepository.findByStatus(status);
    }

    public Event getEvent(Integer eventId) {
        return eventRepository.findById(eventId).get();
    }

    public Event getEventById(Integer eventId) {
        return eventRepository.findById(eventId).get();
    }

    public void deleteEvent(Event event) {
        eventRepository.delete(event);
    }
}
