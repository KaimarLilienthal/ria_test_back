package com.example.ria_test_back.domain.mapper;

import com.example.ria_test_back.business.dto.EventDto;
import com.example.ria_test_back.entities.Event;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface EventMapper {
    Event toEntity(EventDto eventDto);

    EventDto toDto(Event event);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Event partialUpdate(EventDto eventDto, @MappingTarget Event event);

}