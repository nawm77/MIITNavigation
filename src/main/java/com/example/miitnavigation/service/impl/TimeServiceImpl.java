package com.example.miitnavigation.service.impl;

import com.example.miitnavigation.model.Time;
import com.example.miitnavigation.repository.TimeRepository;
import com.example.miitnavigation.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class TimeServiceImpl implements TimeService {
    private final TimeRepository timeRepository;

    @Autowired
    public TimeServiceImpl(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }

    @Override
    public Time findOrCreate(Time time) {
        return timeRepository.findByTimeStartAndTimeEnd(time.getTimeStart(), time.getTimeEnd())
                .orElseGet(() -> timeRepository.save(time));
    }

    @Async
    @Override
    public CompletableFuture<Time> createTime(Time time) {
        return CompletableFuture.completedFuture(timeRepository.save(time));
    }

    @Async
    @Override
    public CompletableFuture<Optional<Time>> getTimeById(Long id) {
        return CompletableFuture.completedFuture(timeRepository.findById(id));
    }

    @Async
    @Override
    public CompletableFuture<List<Time>> getAllTimes() {
        return CompletableFuture.completedFuture(timeRepository.findAll());
    }

    @Async
    @Override
    public CompletableFuture<Void> deleteTimeById(Long id) {
        timeRepository.deleteById(id);
        return CompletableFuture.completedFuture(null);
    }
}
