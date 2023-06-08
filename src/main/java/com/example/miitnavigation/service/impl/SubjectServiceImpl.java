package com.example.miitnavigation.service.impl;

import com.example.miitnavigation.model.Subject;
import com.example.miitnavigation.repository.SubjectRepository;
import com.example.miitnavigation.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Async
    @Override
    public CompletableFuture<Subject> createSubject(Subject subject) {
        return CompletableFuture.completedFuture(subjectRepository.save(subject));
    }

    public Subject findOrCreate(Subject subject) {
        return subjectRepository.findByName(subject.getName())
                .orElseGet(() -> subjectRepository.save(subject));
    }

    @Async
    @Override
    public CompletableFuture<Optional<Subject>> getSubjectById(Long id) {
        return CompletableFuture.completedFuture(subjectRepository.findById(id));
    }

    @Async
    @Override
    public CompletableFuture<List<Subject>> getAllSubjects() {
        return CompletableFuture.completedFuture(subjectRepository.findAll());
    }

    @Async
    @Override
    public CompletableFuture<Void> deleteSubjectById(Long id) {
        subjectRepository.deleteById(id);
        return CompletableFuture.completedFuture(null);
    }
}
