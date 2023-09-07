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
public class EventSimpleDto implements Serializable {
    Integer id;
    @NotNull
    @Size(max = 50)
    String eventName;
    @NotNull
    LocalDate eventDate;
}