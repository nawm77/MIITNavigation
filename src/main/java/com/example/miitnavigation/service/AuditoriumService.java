package com.example.miitnavigation.service;

import com.example.miitnavigation.model.Auditorium;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface AuditoriumService {
    CompletableFuture<Auditorium> createAuditorium(Auditorium auditorium);

    boolean exists(String auditoriumNumber);

    CompletableFuture<Optional<Auditorium>> getAuditoriumById(Long id);

    CompletableFuture<List<Auditorium>> getAllAudiences();

    CompletableFuture<Void> deleteProductById(Long id);
}
