package com.example.ria_test_back.domain;

import com.example.ria_test_back.entities.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant, Integer> {
}