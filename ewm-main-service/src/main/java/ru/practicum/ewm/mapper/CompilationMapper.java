package ru.practicum.ewm.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.practicum.ewm.dto.compilation.CompilationDto;
import ru.practicum.ewm.dto.compilation.NewCompilationDto;
import ru.practicum.ewm.dto.compilation.UpdateCompilationRequest;
import ru.practicum.ewm.model.Compilation;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface CompilationMapper {

    @Mapping(target = "events",
            expression = "java(compilation.getEvents().stream().map(ru.practicum.ewm.model.Event::getId).collect(java.util.stream.Collectors.toList()))")
    CompilationDto toDto(Compilation compilation);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "events", ignore = true)
    Compilation toCompilation(NewCompilationDto newCompilationDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "events", ignore = true)
    void updateCompilation(@MappingTarget Compilation compilation, UpdateCompilationRequest updateCompilationRequest);
}
