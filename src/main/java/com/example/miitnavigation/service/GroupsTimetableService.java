package com.example.miitnavigation.service;

import com.example.miitnavigation.model.GroupsTimetable;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface GroupsTimetableService {
    CompletableFuture<GroupsTimetable> createGroupsTimetable(GroupsTimetable groupsTimetable);

    CompletableFuture<Optional<GroupsTimetable>> getGroupsTimetableById(Long id);

    CompletableFuture<List<GroupsTimetable>> getAllGroupsTimetable();

    CompletableFuture<Void> deleteGroupsTimetableById(Long id);
}
