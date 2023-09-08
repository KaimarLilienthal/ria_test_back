package com.example.ria_test_back.domain;

import com.example.ria_test_back.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Integer> {
    @Query("select e from Event e where e.status = ?1")
    List<Event> findByStatus(String status);



}