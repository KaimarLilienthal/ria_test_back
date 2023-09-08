package com.example.ria_test_back.business;

import com.example.ria_test_back.business.dto.EventDto;
import com.example.ria_test_back.business.dto.EventSimpleDto;
import com.example.ria_test_back.domain.EventRepository;
import com.example.ria_test_back.domain.EventService;
import com.example.ria_test_back.domain.ParticipantRepository;
import com.example.ria_test_back.domain.ParticipantService;
import com.example.ria_test_back.entities.Event;
import com.example.ria_test_back.entities.EventMapper;
import com.example.ria_test_back.entities.Participant;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EventsService {
    @Resource
    private EventService eventService;

    @Resource
    private EventMapper eventMapper;

    @Resource
    private EventRepository eventRepository;

    @Resource
    private ParticipantService participantService;


    public List<EventSimpleDto> findAllEventsByStatus(String status) {
        List<Event> events = eventService.findAllEventsBy(status);
        return eventMapper.toDto1(events);
    }

    @Transactional
    public void deleteEvent(Integer eventId) {
        Event event = eventService.getEvent(eventId);
        List<Participant> participants = participantService.findParticipantsBy(eventId);
        participantService.deleteAllEventParticipants(participants);
        eventService.deleteEvent(event);
    }

    public EventDto getEventById(Integer eventId) {
        Event event = eventService.getEventById(eventId);
        return eventMapper.toDto(event);
    }


    public void addNewEventBy(EventDto eventDto) {
        Event event = eventMapper.toEntity(eventDto);
        eventRepository.save(event);
    }
}
