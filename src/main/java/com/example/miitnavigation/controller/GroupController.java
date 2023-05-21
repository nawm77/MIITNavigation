package com.example.miitnavigation.controller;

import com.example.miitnavigation.exception.GroupException;
import com.example.miitnavigation.exception.ResourceNotFoundException;
import com.example.miitnavigation.model.StudyGroup;
import com.example.miitnavigation.service.StudyGroupService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
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
    @ResponseBody
    public String getAllGroups() {
        try {
            var allStudyGroup = studyGroupService.getAllStudyGroup();
            log.info(allStudyGroup);
            List<StudyGroup> studyGroupList = allStudyGroup.get();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            return gson.toJson(studyGroupList);
        } catch (InterruptedException | ExecutionException e) {
            throw new GroupException("Ошибка при получении списка групп");
        }
    }

    @GetMapping("/group/{id}")
    @ResponseBody
    public String getGroupById(@PathVariable long id) throws ExecutionException, InterruptedException {
        var studyGroupById = studyGroupService.getStudyGroupById(id);
        log.info(studyGroupById);
        Optional<StudyGroup> studyGroup = studyGroupById.get();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        if (studyGroup.isPresent()) {
            return gson.toJson(studyGroup.get());
        } else {
            throw new ResourceNotFoundException("Group not found");
        }
    }
}
