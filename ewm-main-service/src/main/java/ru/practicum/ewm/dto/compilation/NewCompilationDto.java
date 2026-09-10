package ru.practicum.ewm.dto.compilation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import ru.practicum.ewm.model.Event;

import java.util.Set;

@Data
@Builder
public class NewCompilationDto {

    private Set<Event> events;

    @Builder.Default
    private Boolean pinned = false;

    @NotBlank
    @Size(min = 1, max = 50)
    private String title;
}
