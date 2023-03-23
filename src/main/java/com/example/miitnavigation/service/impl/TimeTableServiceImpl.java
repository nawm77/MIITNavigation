package com.example.miitnavigation.service.impl;

import com.example.miitnavigation.model.TimeTable;
import com.example.miitnavigation.repository.TimeTableRepository;
import com.example.miitnavigation.service.TimeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class TimeTableServiceImpl implements TimeTableService {
    private final TimeTableRepository timeTableRepository;

    @Autowired
    public TimeTableServiceImpl(TimeTableRepository timeTableRepository) {
        this.timeTableRepository = timeTableRepository;
    }

    @Async
    @Override
    public CompletableFuture<TimeTable> createTimeTable(TimeTable timeTable) {
        return CompletableFuture.completedFuture(timeTableRepository.save(timeTable));
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
