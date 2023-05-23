package com.example.miitnavigation.service.impl;

import com.example.miitnavigation.model.Auditorium;
import com.example.miitnavigation.repository.AuditoriumRepository;
import com.example.miitnavigation.service.AuditoriumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class AuditoriumServiceImpl implements AuditoriumService {
    private final AuditoriumRepository auditoriumRepository;

    @Autowired
    public AuditoriumServiceImpl(AuditoriumRepository auditoriumRepository) {
        this.auditoriumRepository = auditoriumRepository;
    }

    @Async
    @Override
    public CompletableFuture<Auditorium> createAuditorium(Auditorium auditorium) {
        if (auditoriumRepository.existsByAuditoriumNumber(auditorium.getAuditoriumNumber())) {
            throw new IllegalArgumentException("Auditorium with the same name already exists");
        }
        return CompletableFuture.completedFuture(auditoriumRepository.save(auditorium));
    }

    @Override
    public boolean exists(String auditoriumNumber) {
        return auditoriumRepository.existsByAuditoriumNumber(auditoriumNumber);
    }

    @Async
    @Override
    public CompletableFuture<Optional<Auditorium>> getAuditoriumById(Long id) {
        return CompletableFuture.completedFuture(auditoriumRepository.findById(id));
    }

    @Async
    @Override
    public CompletableFuture<List<Auditorium>> getAllAudiences() {
        return CompletableFuture.completedFuture(auditoriumRepository.findAll());
    }

    @Async
    @Override
    public CompletableFuture<Void> deleteProductById(Long id) {
        auditoriumRepository.deleteById(id);
        return CompletableFuture.completedFuture(null);
    }
}
