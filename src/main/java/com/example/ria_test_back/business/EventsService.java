package com.example.ria_test_back.business;

import com.example.ria_test_back.domain.EventService;
import com.example.ria_test_back.entities.Event;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventsService {
    @Resource
    private EventService eventService;



    public List<Event> findAllEventsByStatus(String status) {
        return eventService.findAllEventsBy(status);
    }
}
