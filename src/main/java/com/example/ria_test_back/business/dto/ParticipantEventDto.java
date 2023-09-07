package com.example.ria_test_back.business.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.ria_test_back.entities.Participant}
 */
@Value
public class ParticipantEventDto implements Serializable {
    Integer id;
    @Size(max = 255)
    String personFirstname;
    @Size(max = 255)
    String personLastname;
    @Size(max = 11)
    String personIdCode;
    @Size(max = 255)
    String companyName;
    @Size(max = 50)
    String companyRegistrationCode;
    @NotNull
    String status;
}