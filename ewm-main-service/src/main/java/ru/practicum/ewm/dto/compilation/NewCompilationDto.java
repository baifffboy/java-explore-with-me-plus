package ru.practicum.ewm.dto.compilation;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class NewCompilationDto {

    private Set<Long> events;

    @Builder.Default
    @JsonSetter(nulls = Nulls.SKIP)
    private Boolean pinned = false;

    @NotBlank
    @Size(min = 1, max = 50)
    private String title;
}
