package com.example.miitnavigation.service;

import com.example.miitnavigation.model.Time;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface TimeService {
    CompletableFuture<Time> createTime(Time time);

    CompletableFuture<Optional<Time>> getTimeById(Long id);

    CompletableFuture<List<Time>> getAllTimes();

    CompletableFuture<Void> deleteTimeById(Long id);
}
