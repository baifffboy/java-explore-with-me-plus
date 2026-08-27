package ru.practicum.ewm.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.practicum.ewm.EndpointHitDto;
import ru.practicum.ewm.EndpointHitRequestDto;
import ru.practicum.ewm.model.Hit;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface HitMapper {

    Hit toEntity(EndpointHitRequestDto requestDto);

    EndpointHitDto toDto(Hit hit);
}
