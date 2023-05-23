package com.example.miitnavigation.repository;

import com.example.miitnavigation.model.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface TimeRepository extends JpaRepository<Time, Long> {
    boolean existsByTimeStartAndTimeEnd(LocalDateTime start, LocalDateTime end);
}
