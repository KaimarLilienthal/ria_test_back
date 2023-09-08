package com.example.ria_test_back.entities;

import com.example.ria_test_back.business.dto.ParticipantDto;
import com.example.ria_test_back.business.dto.ParticipantEventDto;
import com.example.ria_test_back.entities.Participant;
import org.mapstruct.*;

import java.util.List;

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

    Participant toEntity(ParticipantEventDto participantEventDto);

    ParticipantEventDto toDto1(Participant participant);

    List<ParticipantEventDto> toDto1(List<Participant> participant);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Participant partialUpdate(ParticipantEventDto participantEventDto, @MappingTarget Participant participant);
}