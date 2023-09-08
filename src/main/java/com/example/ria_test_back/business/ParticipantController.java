package com.example.ria_test_back.business;

import com.example.ria_test_back.business.dto.ParticipantEventDto;
import com.example.ria_test_back.business.dto.ParticipantFormDto;
import com.example.ria_test_back.business.dto.ParticipantInfoDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ParticipantController {
    @Resource
    private ParticipantsService participantsService;

    @GetMapping("/event/participants")
    @Operation(summary = "Toob andmebaasist ja kuvab ürituse id-le vastava nimekirja osavõtjatest",
            description = "Tagastab nimekirja osavõtjatest koos infoga: id, personFirstname, " +
                    "personLastname, personIdCode, companyName, companyRegistrationCode ja status")
    public List<ParticipantEventDto> findParticipantsBy(Integer eventId) {
        return participantsService.findParticipantsBy(eventId);
    }

    @GetMapping("/participant/info")
    @Operation(summary = "Toob andmebaasist ja kuvab osavõtja kogu info",
            description = "Info vaatamiseks ja hilisemaks muutmiseks")
    public ParticipantFormDto findParticipantBy(Integer participantId) {
        return participantsService.findParticipantBy(participantId);
    }


    @PostMapping("/participant/add")
    @Operation(summary = "Lisab üritusel osaleja")
    public void addParticipantToEvent(@RequestBody ParticipantInfoDto participantInfoDto) {
        participantsService.addParticipantBy(participantInfoDto);
    }

    @PutMapping("/participant/info/update")
    @Operation(summary = "Uuendatakse üritusel osaleja andmeid")
    public void updateParticipantInfo(@RequestParam Integer participantId, @RequestBody ParticipantFormDto participantFormDto) {
        participantsService.updateParticipantInfoBy(participantId, participantFormDto);
    }

    @DeleteMapping("/participant/delete")
    @Operation(summary = "Kustutab osavõtja tabelist",
            description = "Kustutab participantId abil")
            public void deleteParticipantBy(Integer participantId) {
        participantsService.deleteParticipantBy(participantId);
    }
}
