package com.example.ria_test_back.business;

import com.example.ria_test_back.business.dto.EventDto;
import com.example.ria_test_back.business.dto.EventSimpleDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventController {
    @Resource
    private EventsService eventsService;

    @GetMapping("/event")
    @Operation(summary = "Kuvab listi kõikidest tabelis olevatest tulevastest või toimuvatest üritustest vastavalt staatusele",
            description = "Tagastab nimekirja üritustest koos infoga: id, eventName, eventDate")
    public List<EventSimpleDto> findAllEventsByStatus(@RequestParam String status) {
     return eventsService.findAllEventsByStatus(status);
    }

    @GetMapping("/event/info")
    @Operation(summary = "Kuvab id-le vastava ürituse",
            description = "Tagastab nimekirja üritusest koos infoga: id, eventName, eventDate, eventPlace, eventInfo ja status")
    public EventDto getEventById(@RequestParam Integer eventId) {
       return eventsService.getEventById(eventId);
    }


    @DeleteMapping("/event/delete")
    @Operation(summary = "Kustutab ürituse")
    public void deleteEvent(@RequestParam Integer eventId) {
        eventsService.deleteEvent(eventId);
    }

}
