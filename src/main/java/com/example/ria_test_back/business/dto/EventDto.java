package com.example.ria_test_back.business.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.example.ria_test_back.entities.Event}
 */
@Value
public class EventDto implements Serializable {
    Integer id;
    @NotNull
    @Size(max = 50)
    String eventName;
    @NotNull
    @Size(max = 50)
    String eventPlace;
    @NotNull
    LocalDate eventDate;
    @NotNull
    @Size(max = 1000)
    String eventInfo;
    @NotNull
    String status;
}