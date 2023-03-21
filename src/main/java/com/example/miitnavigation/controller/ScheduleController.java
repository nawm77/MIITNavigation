package com.example.miitnavigation.controller;

import com.example.miitnavigation.service.ScheduleParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/miit/api/v1")
public class ScheduleController {
    private final ScheduleParserService scheduleParserService;

    @Autowired
    public ScheduleController(ScheduleParserService scheduleParserService) {
        this.scheduleParserService = scheduleParserService;
    }

    @GetMapping("/schedule")
    public String getSchedule() {
        return scheduleParserService.parse().toString();
    }
}
