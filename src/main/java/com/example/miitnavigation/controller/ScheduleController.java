package com.example.miitnavigation.controller;

import com.example.miitnavigation.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/miit/api/v1")
public class ScheduleController {
    private final SubjectService subjectService;

    @Autowired
    public ScheduleController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/schedule/{group}")
    @ResponseBody
    public String getSchedule(@PathVariable String group) throws ExecutionException, InterruptedException {
        var allSubjects = subjectService.getAllSubjects();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < allSubjects.get().size(); i++) {
            stringBuilder.append(allSubjects.get().get(i).toString()).append("\n");
        }
        return stringBuilder.toString();
    }
}
