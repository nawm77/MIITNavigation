package com.example.miitnavigation.service;

import com.example.miitnavigation.model.Subject;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface SubjectService {
    CompletableFuture<Subject> createSubject(Subject subject);

    CompletableFuture<Optional<Subject>> getSubjectById(Long id);

    CompletableFuture<List<Subject>> getAllSubjects();

    CompletableFuture<Void> deleteSubjectById(Long id);
}
