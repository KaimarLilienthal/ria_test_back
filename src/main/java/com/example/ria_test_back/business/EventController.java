package com.example.ria_test_back.business;

import com.example.ria_test_back.entities.Event;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventController {
    @Resource
    private EventsService eventsService;

    @GetMapping("/event")
    @Operation(summary = "Kuvab listi kõikidest tabelis olevatest tulevastest või toimuvatest üritustest",
            description = "Tagastab listi koos infoga eventId, eventName, eventDate")
    public List<Event> findAllEventsByStatus(@RequestParam String status) {
       return eventsService.findAllEventsByStatus(status);
    }

}
