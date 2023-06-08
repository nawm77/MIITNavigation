package com.example.miitnavigation.service;

import com.example.miitnavigation.model.TimeTable;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface TimeTableService {
    boolean existsByGroupId(Long groupId);

    void saveTimeTable(TimeTable timeTable, long id);

    List<TimeTable> findAllWithFetch();

    CompletableFuture<TimeTable> createTimeTable(TimeTable timeTable);

    CompletableFuture<Optional<TimeTable>> getTimeTableById(Long id);

    CompletableFuture<List<TimeTable>> getTimeTable();

    CompletableFuture<Void> dropTimeTable();

    CompletableFuture<Void> deleteTimeTableById(Long id);
}
