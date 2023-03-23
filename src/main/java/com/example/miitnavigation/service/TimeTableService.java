package com.example.miitnavigation.service;

import com.example.miitnavigation.model.TimeTable;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface TimeTableService {
    CompletableFuture<TimeTable> createTimeTable(TimeTable timeTable);

    CompletableFuture<Optional<TimeTable>> getTimeTableById(Long id);

    CompletableFuture<List<TimeTable>> getTimeTableTeachers();

    CompletableFuture<Void> deleteTimeTableById(Long id);
}
