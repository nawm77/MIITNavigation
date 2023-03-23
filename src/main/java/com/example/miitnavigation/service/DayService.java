package com.example.miitnavigation.service;

import com.example.miitnavigation.model.Day;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface DayService {
    CompletableFuture<Day> createDay(Day day);

    CompletableFuture<Optional<Day>> getDayById(Long id);

    CompletableFuture<List<Day>> getAllDays();

    CompletableFuture<Void> deleteDayById(Long id);
}
