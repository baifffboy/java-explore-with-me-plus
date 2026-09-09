package ru.practicum.ewm.dto;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Test;
import ru.practicum.ewm.dto.event.NewEventDto;
import ru.practicum.ewm.model.Location;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertFalse;

class EventDtoValidationTest {
    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    void locationWithoutLongitudeShouldBeInvalid() {
        NewEventDto dto = new NewEventDto();
        dto.setAnnotation("Достаточно длинная аннотация события");
        dto.setCategory(1L);
        dto.setDescription("Достаточно длинное описание события");
        dto.setEventDate(LocalDateTime.now().plusDays(1));
        dto.setLocation(new Location(55.75F, null));
        dto.setTitle("Новое событие");

        assertFalse(validator.validate(dto).isEmpty());
    }
}
