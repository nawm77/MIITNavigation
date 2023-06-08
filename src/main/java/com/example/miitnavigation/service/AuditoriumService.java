package com.example.miitnavigation.service;

import com.example.miitnavigation.model.Auditorium;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface AuditoriumService {
    Auditorium findOrCreate(Auditorium auditorium);

    CompletableFuture<Optional<Auditorium>> getAuditoriumById(Long id);

    CompletableFuture<List<Auditorium>> getAllAudiences();

    CompletableFuture<Void> deleteProductById(Long id);
}
