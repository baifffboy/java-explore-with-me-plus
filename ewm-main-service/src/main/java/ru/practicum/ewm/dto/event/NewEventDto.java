package ru.practicum.ewm.dto.event;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.practicum.ewm.model.Location;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class NewEventDto {
    // Краткое описание события. Длина текста не менее 20 и не более 2000 символов.
    @NotBlank
    @Size(min = 20, max = 2000)
    private String annotation;

    // Идентификатор категории к которой относится событие
    @NotNull
    private Long category;

    // Полное описание события. Длина текста не менее 20 и не более 7000 символов.
    @NotBlank
    @Size(min = 20, max = 7000)
    private String description;

    // Дата и время на которые намечено событие. Дата и время должны быть в формате "yyyy-MM-dd HH:mm:ss"
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime eventDate;

    //
    //Широта и долгота места проведения события
    @Valid
    @NotNull
    private Location location;

    // Нужно ли оплачивать участие в событии
    private boolean paid;

    // Ограничение на количество участников. Значение 0 - означает отсутствие ограничения
    @PositiveOrZero
    private int participantLimit;

    // Нужно ли пре-модерировать заявки на участие. true - если нужно, false - если не нужно
    private boolean requestModeration = true;

    // Заголовок события. Длина заголовка не менее 3 и не более 120 символов.
    @NotBlank
    @Size(min = 3, max = 120)
    private String title;
}
