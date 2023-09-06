package com.example.ria_test_back.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "event_name", nullable = false, length = 50)
    private String eventName;

    @Size(max = 50)
    @NotNull
    @Column(name = "event_place", nullable = false, length = 50)
    private String eventPlace;

    @NotNull
    @Column(name = "event_date", nullable = false)
    private LocalDate eventDate;

    @Size(max = 1000)
    @NotNull
    @Column(name = "event_info", nullable = false, length = 1000)
    private String eventInfo;

    @NotNull
    @Column(name = "status", nullable = false, length = Integer.MAX_VALUE)
    private String status;

}