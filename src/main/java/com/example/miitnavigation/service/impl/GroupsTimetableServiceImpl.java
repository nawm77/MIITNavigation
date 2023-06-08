package com.example.miitnavigation.service.impl;

import com.example.miitnavigation.model.GroupsTimetable;
import com.example.miitnavigation.model.TimeTable;
import com.example.miitnavigation.repository.GroupsTimetableRepository;
import com.example.miitnavigation.service.GroupsTimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class GroupsTimetableServiceImpl implements GroupsTimetableService {
    private final GroupsTimetableRepository groupsTimetableRepository;

    @Autowired
    public GroupsTimetableServiceImpl(GroupsTimetableRepository groupsTimetableRepository) {
        this.groupsTimetableRepository = groupsTimetableRepository;
    }

//    @Override
//    public List<TimeTable> findTimetableByGroupId(Long groupId) {
//        return groupsTimetableRepository.findTimeTableByGroupId(groupId);
//    }

    @Async
    @Override
    public CompletableFuture<GroupsTimetable> createGroupsTimetable(GroupsTimetable groupsTimetable) {
        return CompletableFuture.completedFuture(groupsTimetableRepository.save(groupsTimetable));
    }

    @Async
    @Override
    public CompletableFuture<Optional<GroupsTimetable>> getGroupsTimetableById(Long id) {
        return CompletableFuture.completedFuture(groupsTimetableRepository.findById(id));
    }

    @Async
    @Override
    public CompletableFuture<List<GroupsTimetable>> getAllGroupsTimetable() {
        return CompletableFuture.completedFuture(groupsTimetableRepository.findAll());
    }

    @Async
    @Override
    public CompletableFuture<Void> deleteGroupsTimetableById(Long id) {
        groupsTimetableRepository.deleteById(id);
        return CompletableFuture.completedFuture(null);
    }
}
