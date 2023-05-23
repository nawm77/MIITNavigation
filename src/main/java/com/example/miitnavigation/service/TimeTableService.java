package com.example.miitnavigation.service;

import com.example.miitnavigation.model.TimeTable;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface TimeTableService {
    void saveTimeTable(TimeTable timeTable);

    CompletableFuture<TimeTable> createTimeTable(TimeTable timeTable);

    CompletableFuture<Optional<TimeTable>> getTimeTableById(Long id);

    CompletableFuture<List<TimeTable>> getTimeTable();

    CompletableFuture<Void> deleteTimeTableById(Long id);
}
