package com.example.miitnavigation.scheduler;

import com.example.miitnavigation.model.Auditorium;
import com.example.miitnavigation.model.StudyGroup;
import com.example.miitnavigation.service.AuditoriumService;
import com.example.miitnavigation.service.parsers.AuditoriumParserService;
import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Log4j2
public class AuditoriumParserTask {
    private final AuditoriumParserService auditoriumParserService;
    private final AuditoriumService auditoriumService;
    private static final StudyGroup TEST_GROUP = new StudyGroup();

    @Autowired
    public AuditoriumParserTask(AuditoriumParserService auditoriumParserService, AuditoriumService auditoriumService) {
        this.auditoriumParserService = auditoriumParserService;
        this.auditoriumService = auditoriumService;
        TEST_GROUP.setGroupName("УВП-213");
        TEST_GROUP.setId(186236);
    }

    @PostConstruct
    @Scheduled(cron = "0 0 0 * * *")
    public void parse() {
        List<Auditorium> auditoriums = auditoriumParserService.parse(TEST_GROUP);
        for (Auditorium auditorium : auditoriums) {
            auditoriumService.createAuditorium(auditorium);
        }
        log.info("Parsing auditorium group complete");
    }
}
