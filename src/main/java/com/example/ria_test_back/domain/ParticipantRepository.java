package com.example.ria_test_back.domain;

import com.example.ria_test_back.entities.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ParticipantRepository extends JpaRepository<Participant, Integer> {
    @Query("select p from Participant p where p.event.id = ?1")
    List<Participant> findParticipantsBy(Integer id);


}