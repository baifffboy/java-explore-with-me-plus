package ru.practicum.ewm.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import ru.practicum.ewm.model.Compilation;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CompilationRepositoryTest {

    @Autowired
    private CompilationRepository compilationRepository;

    @Test
    void shouldSaveAndFindCompilation() {
        Compilation compilation = Compilation.builder()
                .title("Test Compilation")
                .pinned(true)
                .build();

        Compilation saved = compilationRepository.save(compilation);
        Compilation found = compilationRepository.findById(saved.getId()).orElse(null);

        assertThat(found).isNotNull();
        assertThat(found.getTitle()).isEqualTo("Test Compilation");
        assertThat(found.getPinned()).isTrue();
    }

    @Test
    void shouldCheckExistsByTitle() {
        Compilation compilation = Compilation.builder()
                .title("Unique Compilation")
                .pinned(false)
                .build();
        compilationRepository.save(compilation);

        assertThat(compilationRepository.existsByTitle("Unique Compilation")).isTrue();
        assertThat(compilationRepository.existsByTitle("Non Existing")).isFalse();
    }

    @Test
    void shouldFindAllByPinned() {
        for (int i = 0; i < 3; i++) {
            Compilation compilation = Compilation.builder()
                    .title("Pinned " + i)
                    .pinned(true)
                    .build();
            compilationRepository.save(compilation);
        }

        for (int i = 0; i < 2; i++) {
            Compilation compilation = Compilation.builder()
                    .title("Not Pinned " + i)
                    .pinned(false)
                    .build();
            compilationRepository.save(compilation);
        }

        Pageable pageable = PageRequest.of(0, 10);
        var pinned = compilationRepository.findAllByPinned(true, pageable);
        var notPinned = compilationRepository.findAllByPinned(false, pageable);

        assertThat(pinned).hasSize(3);
        assertThat(notPinned).hasSize(2);
    }
}
