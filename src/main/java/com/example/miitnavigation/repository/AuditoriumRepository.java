package com.example.miitnavigation.repository;

import com.example.miitnavigation.model.Auditorium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuditoriumRepository extends JpaRepository<Auditorium, Long> {
    Optional<Auditorium> findByAuditoriumNumber(String auditoriumNumber);
}
