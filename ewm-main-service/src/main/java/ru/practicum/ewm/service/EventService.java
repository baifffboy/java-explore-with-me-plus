package ru.practicum.ewm.service;

import ru.practicum.ewm.dto.event.EventFullDto;
import ru.practicum.ewm.dto.event.NewEventDto;
import ru.practicum.ewm.dto.event.EventShortDto;
import ru.practicum.ewm.dto.event.UpdateEventUserRequest;
import ru.practicum.ewm.dto.event.UpdateEventAdminRequest;
import ru.practicum.ewm.dto.event.EventSort;
import ru.practicum.ewm.model.EventState;

import java.util.List;

public interface EventService {
    EventFullDto createEvent(Long userId, NewEventDto dto);

    List<EventShortDto> getUserEvents(Long userId, int from, int size);

    EventFullDto getUserEvent(Long userId, Long eventId);

    EventFullDto updateUserEvent(Long userId, Long eventId, UpdateEventUserRequest request);

    List<EventFullDto> getAdminEvents(List<Long> users, List<EventState> states, List<Long> categories,
                                      java.time.LocalDateTime rangeStart, java.time.LocalDateTime rangeEnd,
                                      int from, int size);

    EventFullDto updateAdminEvent(Long eventId, UpdateEventAdminRequest request);

    List<EventShortDto> getPublicEvents(String text, List<Long> categories, Boolean paid,
                                        java.time.LocalDateTime rangeStart, java.time.LocalDateTime rangeEnd,
                                        boolean onlyAvailable, EventSort sort, int from, int size);

    EventFullDto getPublicEvent(Long eventId);
}
