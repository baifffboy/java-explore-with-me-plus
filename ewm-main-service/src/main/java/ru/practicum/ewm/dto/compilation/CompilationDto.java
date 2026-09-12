package ru.practicum.ewm.dto.compilation;

import lombok.Data;

import java.util.List;

@Data
public class CompilationDto {
    private Long id;
    private List<Long> events;
    private Boolean pinned;
    private String title;
}
