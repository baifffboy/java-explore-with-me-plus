package ru.practicum.ewm.mapper;

import org.mapstruct.*;
import ru.practicum.ewm.dto.event.*;
import ru.practicum.ewm.model.Event;
import ru.practicum.ewm.model.Location;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface EventMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "initiator", ignore = true)
    @Mapping(target = "createdOn", ignore = true)
    @Mapping(target = "publishedOn", ignore = true)
    @Mapping(target = "state", ignore = true)
    Event toEvent(NewEventDto dto);

    @Mapping(target = "confirmedRequests", source = "confirmedRequests")
    @Mapping(target = "views", source = "views")
    EventShortDto toShortDto(
            Event event,
            long confirmedRequests,
            long views
    );

    @Mapping(target = "confirmedRequests", source = "confirmedRequests")
    @Mapping(target = "views", source = "views")
    EventFullDto toFullDto(
            Event event,
            long confirmedRequests,
            long views
    );

    @BeanMapping(
            nullValuePropertyMappingStrategy =
                    NullValuePropertyMappingStrategy.IGNORE
    )
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "initiator", ignore = true)
    @Mapping(target = "createdOn", ignore = true)
    @Mapping(target = "publishedOn", ignore = true)
    @Mapping(target = "state", ignore = true)
    @Mapping(
            target = "location",
            source = "location",
            qualifiedByName = "copyLocation"
    )
    void updateFromUserRequest(
            UpdateEventUserRequest request,
            @MappingTarget Event event
    );

    @BeanMapping(
            nullValuePropertyMappingStrategy =
                    NullValuePropertyMappingStrategy.IGNORE
    )
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "initiator", ignore = true)
    @Mapping(target = "createdOn", ignore = true)
    @Mapping(target = "publishedOn", ignore = true)
    @Mapping(target = "state", ignore = true)
    @Mapping(
            target = "location",
            source = "location",
            qualifiedByName = "copyLocation"
    )
    void updateFromAdminRequest(
            UpdateEventAdminRequest request,
            @MappingTarget Event event
    );

    @Named("copyLocation")
    Location copyLocation(Location location);
}
