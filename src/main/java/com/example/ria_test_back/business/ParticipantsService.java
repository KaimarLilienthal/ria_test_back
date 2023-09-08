package com.example.ria_test_back.business;

import com.example.ria_test_back.business.dto.ParticipantEventDto;
import com.example.ria_test_back.business.dto.ParticipantFormDto;
import com.example.ria_test_back.business.dto.ParticipantInfoDto;
import com.example.ria_test_back.domain.EventService;
import com.example.ria_test_back.domain.ParticipantService;
import com.example.ria_test_back.entities.Event;
import com.example.ria_test_back.entities.Participant;
import com.example.ria_test_back.entities.ParticipantMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ParticipantsService {

    @Resource
    private ParticipantService participantService;

    @Resource
    private ParticipantMapper participantMapper;

    @Resource
    private EventService eventService;


    public List<ParticipantEventDto> findParticipantsBy(Integer eventId) {
        List<Participant> participants = participantService.findParticipantsBy(eventId);
        return participantMapper.toDto1(participants);
    }

    public void deleteParticipantBy(Integer participantId) {
        participantService.deleteParticipantBy(participantId);
    }

    public void addParticipantBy(ParticipantInfoDto participantInfoDto) {
        Participant participant = participantMapper.toEntity(participantInfoDto);
        Event event = eventService.getEventById(participantInfoDto.getEventId());
        participant.setEvent(event);
        participantService.addParticipant(participant);

    }

    public ParticipantFormDto findParticipantBy(Integer participantId) {
        Participant participant = participantService.findParticipantBy(participantId);
        return participantMapper.toDto3(participant);
    }

    @Transactional
    public void updateParticipantInfoBy(Integer participantId, ParticipantFormDto participantFormDto) {
        Participant participant = participantService.findParticipantBy(participantId);
        Participant partialUpdate = participantMapper.partialUpdate(participantFormDto, participant);
        participantService.addParticipant(partialUpdate);
    }
}
