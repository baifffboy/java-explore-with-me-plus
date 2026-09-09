package ru.practicum.ewm.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "compilations", indexes = {
        @Index(name = "idx_compilations_events_compilation_id", columnList = "compilation_id"),
        @Index(name = "idx_compilations_events_event_id", columnList = "event_id")
})
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Compilation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "compilations_events",
            joinColumns = @JoinColumn(name = "compilation_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id")
    )
    @Builder.Default
    private Set<Event> events = new HashSet<>();

    @Column(nullable = false)
    private Boolean pinned;

    @Column(nullable = false, length = 256)
    private String title;
}
