package com.example.miitnavigation.controller;

import com.example.miitnavigation.service.StudyGroupService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/miit/api/v1")
public class GroupController {
    private final StudyGroupService studyGroupService;

    @Autowired
    public GroupController(StudyGroupService studyGroupService) {
        this.studyGroupService = studyGroupService;
    }

    @GetMapping("/groups")
    public String getAllGroups() {
        log.info(studyGroupService.getAllStudyGroup());
        return studyGroupService.getAllStudyGroup().toString();
    }

//    @GetMapping("group/{id}")
//    public String getGroup(@PathVariable String id) {
//        return groupsTimetableService.getGroupsTimetableById(Long.valueOf(id)).toString();
//    }
}
