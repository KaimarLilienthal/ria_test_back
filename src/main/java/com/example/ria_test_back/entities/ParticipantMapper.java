package com.example.ria_test_back.entities;

import com.example.ria_test_back.business.dto.ParticipantDto;
import com.example.ria_test_back.entities.Participant;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ParticipantMapper {
    @Mapping(source = "eventStatus", target = "event.status")
    @Mapping(source = "eventEventInfo", target = "event.eventInfo")
    @Mapping(source = "eventEventDate", target = "event.eventDate")
    @Mapping(source = "eventEventPlace", target = "event.eventPlace")
    @Mapping(source = "eventEventName", target = "event.eventName")
    @Mapping(source = "eventId", target = "event.id")
    Participant toEntity(ParticipantDto participantDto);

    @InheritInverseConfiguration(name = "toEntity")
    ParticipantDto toDto(Participant participant);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Participant partialUpdate(ParticipantDto participantDto, @MappingTarget Participant participant);
}