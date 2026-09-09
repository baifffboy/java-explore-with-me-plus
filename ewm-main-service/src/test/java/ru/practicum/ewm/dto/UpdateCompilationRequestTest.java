package ru.practicum.ewm.dto;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.practicum.ewm.dto.compilation.UpdateCompilationRequest;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class UpdateCompilationRequestTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    void shouldValidateValidUpdateCompilationRequest() {
        UpdateCompilationRequest dto = new UpdateCompilationRequest();
        dto.setId(1L);
        dto.setTitle("Updated Compilation");
        dto.setPinned(true);

        Set<ConstraintViolation<UpdateCompilationRequest>> violations = validator.validate(dto);
        assertThat(violations).isEmpty();
    }

    @Test
    void shouldFailWhenIdIsNull() {
        UpdateCompilationRequest dto = new UpdateCompilationRequest();
        dto.setTitle("Test");

        Set<ConstraintViolation<UpdateCompilationRequest>> violations = validator.validate(dto);
        assertThat(violations).isNotEmpty();
        assertThat(violations).anyMatch(v -> v.getPropertyPath().toString().equals("id"));
    }
}
