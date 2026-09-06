package ru.practicum.ewm.service.impl;

import lombok.RequiredArgsConstructor;
import ru.practicum.ewm.dto.compilation.CompilationDto;
import ru.practicum.ewm.dto.compilation.NewCompilationDto;
import ru.practicum.ewm.dto.compilation.UpdateCompilationRequest;
import ru.practicum.ewm.mapper.CompilationMapper;
import ru.practicum.ewm.repository.CompilationRepository;
import ru.practicum.ewm.service.CompilationService;

import java.util.List;

@RequiredArgsConstructor
public class CompilationServiceImpl implements CompilationService {

    private final CompilationMapper compilationMapper;
    private final CompilationRepository compilationRepository;

    @Override
    public CompilationDto create(NewCompilationDto newCompilationDto) {
        return null;
    }

    @Override
    public Void delete(Long compId) {
        return null;
    }

    @Override
    public CompilationDto update(Long compId, UpdateCompilationRequest updateRequest) {
        return null;
    }

    @Override
    public List<CompilationDto> getCompilations(Boolean pinned, Integer from, Integer size) {
        return List.of();
    }

    @Override
    public CompilationDto getCompilation(Long compId) {
        return null;
    }
}
