package com.example.miitnavigation.controller;

import com.example.miitnavigation.model.StudyGroup;
import com.example.miitnavigation.service.StudyGroupService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Log4j2
@RestController
@RequestMapping("${api.base-path}")
public class GroupController {
    private final StudyGroupService studyGroupService;

    @Autowired
    public GroupController(StudyGroupService studyGroupService) {
        this.studyGroupService = studyGroupService;
    }

    @GetMapping("/groups")
    public ResponseEntity<List<StudyGroup>> getAllGroups() {
        try {
            CompletableFuture<List<StudyGroup>> allStudyGroup = studyGroupService.getAllStudyGroup();
            List<StudyGroup> studyGroupList = allStudyGroup.get();
            return ResponseEntity.ok(studyGroupList);
        } catch (InterruptedException | ExecutionException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/group/{id}")
    public ResponseEntity<StudyGroup> getGroupById(@PathVariable long id) throws ExecutionException, InterruptedException {
        CompletableFuture<Optional<StudyGroup>> studyGroupById = studyGroupService.getStudyGroupById(id);
        Optional<StudyGroup> studyGroup = studyGroupById.get();
        return studyGroup.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
