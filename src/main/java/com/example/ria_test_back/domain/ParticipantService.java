package com.example.ria_test_back.domain;

import com.example.ria_test_back.entities.Participant;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantService {
    @Resource
    private ParticipantRepository participantRepository;
    public List<Participant> findParticipantBy(Integer eventId) {
        return participantRepository.findParticipantsBy(eventId);
    }
}
