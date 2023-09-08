package com.example.ria_test_back.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "participant")
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @Column(name = "person_firstname")
    private String personFirstname;

    @Size(max = 255)
    @Column(name = "person_lastname")
    private String personLastname;

    @Size(max = 11)
    @Column(name = "person_id_code", length = 11)
    private String personIdCode;

    @Size(max = 255)
    @Column(name = "person_payment_type")
    private String personPaymentType;

    @Size(max = 1500)
    @Column(name = "person_info", length = 1500)
    private String personInfo;

    @Size(max = 255)
    @Column(name = "company_name")
    private String companyName;

    @Size(max = 50)
    @Column(name = "company_registration_code", length = 50)
    private String companyRegistrationCode;

    @Size(max = 50)
    @Column(name = "company_participant_sum", length = 50)
    private String companyParticipantSum;

    @Size(max = 255)
    @Column(name = "company_payment_type")
    private String companyPaymentType;

    @Size(max = 5000)
    @Column(name = "company_info", length = 5000)
    private String companyInfo;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @NotNull
    @Column(name = "status", nullable = false, length = Integer.MAX_VALUE)
    private String status;

}