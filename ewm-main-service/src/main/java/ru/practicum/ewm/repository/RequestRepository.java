package ru.practicum.ewm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.practicum.ewm.model.ParticipationRequest;
import ru.practicum.ewm.model.RequestStatus;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<ParticipationRequest, Long> {


    List<ParticipationRequest> findAllByRequesterId(Long requesterId);


    List<ParticipationRequest> findAllByEventId(Long eventId);


    boolean existsByRequesterIdAndEventId(Long requesterId, Long eventId);


    long countByEventIdAndStatus(Long eventId, RequestStatus status);

    List<ParticipationRequest> findAllByIdIn(List<Long> requestIds);
}