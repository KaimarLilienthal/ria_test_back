package com.example.ria_test_back.business;

import com.example.ria_test_back.business.dto.ParticipantEventDto;
import com.example.ria_test_back.domain.ParticipantService;
import com.example.ria_test_back.entities.Participant;
import com.example.ria_test_back.entities.ParticipantMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantsService {

    @Resource
    private ParticipantService participantService;

    @Resource
    private ParticipantMapper participantMapper;


    public List<ParticipantEventDto> findParticipantsBy(Integer eventId) {
        List<Participant> participants = participantService.findParticipantBy(eventId);
        return participantMapper.toDto1(participants);
    }
}
