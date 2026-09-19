package ru.practicum.ewm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.practicum.ewm.model.Comment;

import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("""
            SELECT c
            FROM Comment c
            JOIN FETCH c.author
            JOIN FETCH c.event
            WHERE c.event.id = :eventId
            ORDER BY c.createdOn DESC, c.id DESC
            """)
    Page<Comment> findAllByEventId(@Param("eventId") Long eventId, Pageable pageable);

    @Query("""
            SELECT c
            FROM Comment c
            JOIN FETCH c.author
            JOIN FETCH c.event
            WHERE c.id = :commentId AND c.event.id = :eventId
            """)
    Optional<Comment> findByIdAndEventId(@Param("commentId") Long commentId,
                                         @Param("eventId") Long eventId);
}