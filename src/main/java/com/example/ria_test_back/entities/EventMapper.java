package com.example.ria_test_back.entities;

import com.example.ria_test_back.business.dto.EventDto;
import com.example.ria_test_back.business.dto.EventSimpleDto;
import com.example.ria_test_back.entities.Event;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface EventMapper {
    Event toEntity(EventDto eventDto);

    List<Event> toEntity(List<EventDto> eventDto);

    EventDto toDto(Event event);

    List<EventDto> toDto(List<Event> event);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Event partialUpdate(EventDto eventDto, @MappingTarget Event event);


    Event toEntity(EventSimpleDto eventSimpleDto);

    EventSimpleDto toDto1(Event event);

   List<EventSimpleDto> toDto1(List<Event> event);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Event partialUpdate(EventSimpleDto eventSimpleDto, @MappingTarget Event event);


}