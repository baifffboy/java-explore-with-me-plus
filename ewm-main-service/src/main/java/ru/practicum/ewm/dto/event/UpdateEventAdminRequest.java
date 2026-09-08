package ru.practicum.ewm.dto.event;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
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
public class UpdateEventAdminRequest {
    // Краткое описание события. Длина текста не менее 20 и не более 2000 символов.
    @Size(min = 20, max = 2000)
    private String annotation;

    // Идентификатор категории к которой относится событие
    private Long category;

    // Полное описание события. Длина текста не менее 20 и не более 7000 символов.
    @Size(min = 20, max = 7000)
    private String description;

    // Дата и время на которые намечено событие. Дата и время должны быть в формате "yyyy-MM-dd HH:mm:ss"
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime eventDate;

    // Широта и долгота места проведения события
    @Valid
    private Location location;

    // Нужно ли оплачивать участие в событии
    private Boolean paid;

    // Ограничение на количество участников. Значение 0 - означает отсутствие ограничения
    @PositiveOrZero
    private Integer participantLimit;

    // Нужно ли пре-модерировать заявки на участие. true - если нужно, false - если не нужно
    private Boolean requestModeration;

    // Состояние события. Возможные значения: PUBLISHED, CANCELED
    private AdminEventStateAction stateAction;

    // Заголовок события. Длина заголовка не менее 3 и не более 120 символов.
    @Size(min = 3, max = 120)
    private String title;
}
