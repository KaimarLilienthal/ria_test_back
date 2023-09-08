package com.example.ria_test_back.entities;

import com.example.ria_test_back.business.dto.EventDto;
import com.example.ria_test_back.business.dto.EventSimpleDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface EventMapper {
    Event toEntity(EventDto eventDto);

    EventDto toDto(Event event);

    EventSimpleDto toDto1(Event event);

    List<EventSimpleDto> toDto1(List<Event> event);

}