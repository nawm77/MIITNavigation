package com.example.miitnavigation.scheduler;

import com.example.miitnavigation.model.StudyGroup;
import com.example.miitnavigation.service.parsers.GroupParserService;
import com.example.miitnavigation.service.StudyGroupService;
import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Log4j2
public class GroupParserTask {
    private final GroupParserService groupParserService;
    private final StudyGroupService studyGroupService;

    @Autowired
    public GroupParserTask(GroupParserService groupParserService, StudyGroupService studyGroupService) {
        this.groupParserService = groupParserService;
        this.studyGroupService = studyGroupService;
    }

    @PostConstruct
    @Scheduled(cron = "0 0 0 * * *")
    public void parse() {
        List<StudyGroup> studyGroups = groupParserService.parse();
        for (StudyGroup studyGroup : studyGroups) {
            studyGroupService.createStudyGroup(studyGroup);
        }
        log.info("Parsing study group complete");
    }
}
