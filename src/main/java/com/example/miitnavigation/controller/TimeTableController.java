package com.example.miitnavigation.controller;

import com.example.miitnavigation.model.Day;
import com.example.miitnavigation.model.StudyGroup;
import com.example.miitnavigation.model.TimeTable;
import com.example.miitnavigation.service.DayService;
import com.example.miitnavigation.service.StudyGroupService;
import com.example.miitnavigation.service.TimeTableService;
import com.example.miitnavigation.service.parsers.TimeTableParser;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
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
public class TimeTableController {
    private final TimeTableService timeTableService;
    private final TimeTableParser timeTableParser;
    private final StudyGroupService studyGroupService;
    private final DayService dayService;

    @Autowired
    public TimeTableController(TimeTableService timeTableService, TimeTableParser timeTableParser, StudyGroupService studyGroupService, DayService dayService) {
        this.timeTableService = timeTableService;
        this.timeTableParser = timeTableParser;
        this.studyGroupService = studyGroupService;
        this.dayService = dayService;
    }

    @GetMapping("/timetable/{id}")
    public ResponseEntity<List<TimeTable>> getTimeById(@PathVariable Long id) throws ExecutionException, InterruptedException {
        CompletableFuture<Optional<StudyGroup>> studyGroupById = studyGroupService.getStudyGroupById(id);
        StudyGroup studyGroup = studyGroupById.get().get();
        List<TimeTable> parse = timeTableParser.parse(studyGroup);
        for (TimeTable timeTable : parse) {
            CompletableFuture<List<Day>> allDays = dayService.getAllDays();
            log.info(allDays.get());
//            timeTableServiceImpl.saveTimeTable(timeTable);
            timeTableService.createTimeTable(timeTable);
            log.info(timeTable);
        }
        return ResponseEntity.ok(parse);
    }
}