package com.example.ria_test_back.domain;

import com.example.ria_test_back.entities.Participant;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantService {
    @Resource
    private ParticipantRepository participantRepository;
    public List<Participant> findParticipantsBy(Integer eventId) {
        return participantRepository.findParticipantsBy(eventId);
    }

    public void deleteParticipantBy(Integer participantId) {
        participantRepository.deleteById(participantId);
    }

    public void addParticipant(Participant participant) {
        participantRepository.save(participant);
    }

    public Participant findParticipantBy(Integer participantId) {
      return participantRepository.findById(participantId).get();
    }
}
