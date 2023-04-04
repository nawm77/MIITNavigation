package com.example.miitnavigation.scheduler;

import com.example.miitnavigation.service.ScheduleParserService;
import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class ScheduleParserTask {
    private final ScheduleParserService scheduleParserService;

    @Autowired
    public ScheduleParserTask(ScheduleParserService scheduleParserService) {
        this.scheduleParserService = scheduleParserService;
    }

    @PostConstruct
    public void init() {
        scheduleParserService.parse();
        log.info("Init parsing complete");
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void parse() {
        scheduleParserService.parse();
        log.info("Parsing complete.");
    }
}
