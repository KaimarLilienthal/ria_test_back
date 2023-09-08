package com.example.ria_test_back.business.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.example.ria_test_back.entities.Participant}
 */
@Value
public class ParticipantDto implements Serializable {
    Integer id;
    @Size(max = 255)
    String personFirstname;
    @Size(max = 255)
    String personLastname;
    @Size(max = 11)
    String personIdCode;
    @Size(max = 255)
    String personPaymentType;
    @Size(max = 1500)
    String personInfo;
    @Size(max = 255)
    String companyName;
    @Size(max = 50)
    String companyRegistrationCode;
    @Size(max = 50)
    String companyParticipantSum;
    @Size(max = 255)
    String companyPaymentType;
    @Size(max = 5000)
    String companyInfo;
    Integer eventId;
    String eventEventName;
    String eventEventPlace;
    LocalDate eventEventDate;
    String eventEventInfo;
    String eventStatus;
    @NotNull
    String status;
}