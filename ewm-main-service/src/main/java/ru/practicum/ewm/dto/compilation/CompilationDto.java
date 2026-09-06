package ru.practicum.ewm.dto.compilation;

import lombok.Data;
import ru.practicum.ewm.model.Event;

import java.util.List;

@Data
public class CompilationDto {
    private Long id;
    private List<Event> events;
    private Boolean pinned;
    private String title;
}
