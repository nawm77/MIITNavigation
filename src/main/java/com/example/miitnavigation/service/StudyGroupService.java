package com.example.miitnavigation.service;

import com.example.miitnavigation.model.StudyGroup;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface StudyGroupService {
    CompletableFuture<StudyGroup> createStudyGroup(StudyGroup studyGroup);

    CompletableFuture<Optional<StudyGroup>> getStudyGroupById(Long id);

    CompletableFuture<List<StudyGroup>> getAllStudyGroup();

    CompletableFuture<Void> deleteStudyGroupById(Long id);
}
