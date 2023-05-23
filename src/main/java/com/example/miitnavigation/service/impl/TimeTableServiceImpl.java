package com.example.miitnavigation.service.impl;

import com.example.miitnavigation.model.TimeTable;
import com.example.miitnavigation.repository.TimeTableRepository;
import com.example.miitnavigation.service.TimeTableService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class TimeTableServiceImpl implements TimeTableService {
    @PersistenceContext
    private EntityManager entityManager;
    private final TimeTableRepository timeTableRepository;

    @Autowired
    public TimeTableServiceImpl(TimeTableRepository timeTableRepository) {
        this.timeTableRepository = timeTableRepository;
    }

    @Transactional
    public void saveTimeTable(TimeTable timeTable) {
        entityManager.persist(timeTable);
    }

    @Async
    @Override
    public CompletableFuture<TimeTable> createTimeTable(TimeTable timeTable) {
        return CompletableFuture.completedFuture(timeTableRepository.saveAndFlush(timeTable));
    }

    @Async
    @Override
    public CompletableFuture<Optional<TimeTable>> getTimeTableById(Long id) {
        return CompletableFuture.completedFuture(timeTableRepository.findById(id));
    }

    @Async
    @Override
    public CompletableFuture<List<TimeTable>> getTimeTableTeachers() {
        return CompletableFuture.completedFuture(timeTableRepository.findAll());
    }

    @Async
    @Override
    public CompletableFuture<Void> deleteTimeTableById(Long id) {
        timeTableRepository.deleteById(id);
        return CompletableFuture.completedFuture(null);
    }
}
