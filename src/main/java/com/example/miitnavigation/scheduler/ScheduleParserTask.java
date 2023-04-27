package com.example.miitnavigation.scheduler;

import com.example.miitnavigation.model.Subject;
import com.example.miitnavigation.service.ScheduleParserService;
import com.example.miitnavigation.service.SubjectService;
import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Log4j2
public class ScheduleParserTask {
    private final ScheduleParserService scheduleParserService;
    private final SubjectService subjectService;

    @Autowired
    public ScheduleParserTask(ScheduleParserService scheduleParserService, SubjectService subjectService) {
        this.scheduleParserService = scheduleParserService;
        this.subjectService = subjectService;
    }

    @PostConstruct
    public void init() {
        List<Subject> subjects = scheduleParserService.parse();
        for (Subject value : subjects) {
            Subject subject = new Subject();
            subject.setName(value.getName());
            subjectService.createSubject(subject);
        }
        log.info("Init parsing complete");
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void parse() {
        scheduleParserService.parse();
        log.info("Parsing complete.");
    }
}
