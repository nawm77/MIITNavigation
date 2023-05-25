package com.example.miitnavigation.repository;

import com.example.miitnavigation.model.TimeTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeTableRepository extends JpaRepository<TimeTable, Long> {
    @Query("SELECT t FROM TimeTable t JOIN FETCH t.subject JOIN FETCH t.teacher JOIN FETCH t.time JOIN FETCH t.auditorium")
    List<TimeTable> findAllWithFetch();
}
