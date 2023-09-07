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
}
