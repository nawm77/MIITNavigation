package com.example.miitnavigation.controller;

import com.example.miitnavigation.model.StudyGroup;
import com.example.miitnavigation.model.TimeTable;
import com.example.miitnavigation.service.StudyGroupService;
import com.example.miitnavigation.service.TimeTableService;
import com.example.miitnavigation.service.parsers.TimeTableParser;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Log4j2
@RestController
@RequestMapping("${api.base-path}")
public class TimeTableController {
    private final TimeTableService timeTableService;
    private final TimeTableParser timeTableParser;
    private final StudyGroupService studyGroupService;

    @Autowired
    public TimeTableController(TimeTableService timeTableService, TimeTableParser timeTableParser,
                               StudyGroupService studyGroupService) {
        this.timeTableService = timeTableService;
        this.timeTableParser = timeTableParser;
        this.studyGroupService = studyGroupService;
    }

    @GetMapping("/timetable/{id}")
    public ResponseEntity<List<TimeTable>> getTimeById(@PathVariable Long id,
                                                       @RequestParam(required = false) Boolean isEven) {
        CompletableFuture<Optional<StudyGroup>> studyGroupById = studyGroupService.getStudyGroupById(id);
        Optional<StudyGroup> optionalStudyGroup = studyGroupById.join();
        if (optionalStudyGroup.isPresent()) {
            StudyGroup studyGroup = optionalStudyGroup.get();
            timeTableService.dropTimeTable();
            //fixme сейчас данные в БД сохраняются просто так, надо доделать все связи, сохранение по сути не работает!
            //fixme необходимо доделать асинхронную работу с БД
            if (isEven != null) {
                List<TimeTable> parse = timeTableParser.parse(studyGroup, isEven);
                for (TimeTable timeTable : parse) {
                    timeTableService.saveTimeTable(timeTable);
                }
            } else {
                List<TimeTable> parse1 = timeTableParser.parse(studyGroup, true);
                List<TimeTable> parse2 = timeTableParser.parse(studyGroup, false);
                parse1.addAll(parse2);
                for (TimeTable timeTable : parse1) {
                    timeTableService.saveTimeTable(timeTable);
                }
            }
            List<TimeTable> allWithFetch = timeTableService.findAllWithFetch();
            return ResponseEntity.ok(allWithFetch);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}