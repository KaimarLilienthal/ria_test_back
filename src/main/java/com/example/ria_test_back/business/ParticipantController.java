package com.example.ria_test_back.business;

import com.example.ria_test_back.business.dto.ParticipantEventDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ParticipantController {
    @Resource
    private ParticipantsService participantsService;

    @GetMapping("/event/participants")
    @Operation(summary = "Kuvab ürituse id-le vastava nimekirja osavõtjatest",
            description = "Tagastab nimekirja osavõtjatest koos infoga: id, personFirstname, " +
                    "personLastname, personIdCode, companyName, companyRegistrationCode ja status")
    private List<ParticipantEventDto> findParticipantsBy(Integer eventId){
        return participantsService.findParticipantsBy(eventId);
    }

}
