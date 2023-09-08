package com.example.ria_test_back.entities;

import com.example.ria_test_back.business.dto.ParticipantEventDto;
import com.example.ria_test_back.business.dto.ParticipantFormDto;
import com.example.ria_test_back.business.dto.ParticipantInfoDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ParticipantMapper {

    ParticipantEventDto toDto1(Participant participant);

    List<ParticipantEventDto> toDto1(List<Participant> participant);

    @Mapping(source = "eventId", target = "event.id")
    Participant toEntity(ParticipantInfoDto participantInfoDto);

    ParticipantFormDto toDto3(Participant participant);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Participant partialUpdate(ParticipantFormDto participantFormDto, @MappingTarget Participant participant);
}