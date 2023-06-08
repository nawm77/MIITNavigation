package com.example.miitnavigation.repository;

import com.example.miitnavigation.model.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface TimeRepository extends JpaRepository<Time, Long> {
    Optional<Time> findByTimeStartAndTimeEnd(LocalDateTime start, LocalDateTime end);
}
