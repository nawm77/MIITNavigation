package com.example.miitnavigation.scheduler;

import com.example.miitnavigation.model.Time;
import com.example.miitnavigation.service.TimeParserService;
import com.example.miitnavigation.service.TimeService;
import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Log4j2
public class TimeParserTask {
    private final TimeParserService timeParserService;
    private final TimeService timeService;

    @Autowired
    public TimeParserTask(TimeParserService timeParserService, TimeService timeService) {
        this.timeParserService = timeParserService;
        this.timeService = timeService;
    }

    @PostConstruct
    @Scheduled(cron = "0 0 0 * * *")
    public void parse() {
        List<Time> timeList = timeParserService.parse();
        for (Time time : timeList) {
            timeService.createTime(time);
        }
        log.info("Parsing time complete");
    }
}
