package com.example.miitnavigation.service.impl;

import com.example.miitnavigation.model.StudyGroup;
import com.example.miitnavigation.repository.StudyGroupRepository;
import com.example.miitnavigation.service.StudyGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class StudyGroupServiceImpl implements StudyGroupService {
    private final StudyGroupRepository studyGroupRepository;

    @Autowired
    public StudyGroupServiceImpl(StudyGroupRepository studyGroupRepository) {
        this.studyGroupRepository = studyGroupRepository;
    }

    @Async
    @Override
    public CompletableFuture<StudyGroup> createStudyGroup(StudyGroup studyGroup) {
        return CompletableFuture.completedFuture(studyGroupRepository.save(studyGroup));
    }

    @Async
    @Override
    public CompletableFuture<Optional<StudyGroup>> getStudyGroupById(Long id) {
        return CompletableFuture.completedFuture(studyGroupRepository.findById(id));
    }

    @Async
    @Override
    public CompletableFuture<List<StudyGroup>> getAllStudyGroup() {
        return CompletableFuture.completedFuture(studyGroupRepository.findAll());
    }

    @Async
    @Override
    public CompletableFuture<Void> deleteStudyGroupById(Long id) {
        studyGroupRepository.deleteById(id);
        return CompletableFuture.completedFuture(null);
    }
}
