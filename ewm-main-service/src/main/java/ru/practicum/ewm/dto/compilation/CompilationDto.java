package ru.practicum.ewm.dto.compilation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.practicum.ewm.dto.event.EventShortDto;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class CompilationDto {
    private Long id;
    private Set<EventShortDto> events;
    private Boolean pinned;
    private String title;
}
