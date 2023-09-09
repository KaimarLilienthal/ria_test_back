package com.example.ria_test_back.business;

import com.example.ria_test_back.business.dto.EventDto;
import com.example.ria_test_back.business.dto.EventSimpleDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class EventController {
    @Resource
    private EventsService eventsService;

    @Resource
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EventController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @GetMapping("/updateEventStatus")
    @Operation(summary = "Liigitab sündmuse kas toimuvaks või toimunuks",
            description = "Muudab ürituse staatuse vastavalt localDate, kas 'F' tulevikus ja 'P' minevikus")
    public String updateEventStatus() {
        LocalDate currentDate = LocalDate.now();

        String updateQuery = "UPDATE event SET status = CASE WHEN event_date < ? THEN 'P' ELSE 'F' END";

        int rowsUpdated = jdbcTemplate.update(updateQuery, currentDate);

        return rowsUpdated + " rows updated.";
    }

    @GetMapping("/event")
    @Operation(summary = "Kuvab listi kõikidest tabelis olevatest tulevastest või toimunud üritustest vastavalt staatusele",
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

    @PostMapping("/event/new")
    @Operation(summary = "Salvestab uue Ürituse")
    public void addNewEvent(@RequestBody EventDto eventDto) {
        eventsService.addNewEventBy(eventDto);
    }

    @DeleteMapping("/event/delete")
    @Operation(summary = "Kustutab ürituse tema id järgi",
    description = "Otsib välja Ürituse, siis kõik sellega seotud osalejad, kustutab osalejad ja siis ürituse.")
    public void deleteEvent(@RequestParam Integer eventId) {
        eventsService.deleteEvent(eventId);
    }

}
