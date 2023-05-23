package com.example.miitnavigation.controller;

import com.example.miitnavigation.dto.TimeTableDTO;
import com.example.miitnavigation.model.StudyGroup;
import com.example.miitnavigation.model.TimeTable;
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

    @Autowired
    public TimeTableController(TimeTableService timeTableService, TimeTableParser timeTableParser, StudyGroupService studyGroupService) {
        this.timeTableService = timeTableService;
        this.timeTableParser = timeTableParser;
        this.studyGroupService = studyGroupService;
    }

    @GetMapping("/timetable/{id}")
    public ResponseEntity<List<TimeTableDTO>> getTimeById(@PathVariable Long id) throws ExecutionException, InterruptedException {
        CompletableFuture<Optional<StudyGroup>> studyGroupById = studyGroupService.getStudyGroupById(id);
        StudyGroup studyGroup = studyGroupById.get().get();
        List<TimeTable> parse = timeTableParser.parse(studyGroup);
        for (TimeTable timeTable : parse) {
            timeTableService.saveTimeTable(timeTable);
        }
        CompletableFuture<List<TimeTable>> timeTable = timeTableService.getTimeTable();
//        return ResponseEntity.ok(timeTable.get().stream()
//                .map(TimeTableMapper.INSTANCE::toDTO)
//                .collect(Collectors.toList()));
        return ResponseEntity.ok(TimeTableDTO.toDTO(timeTable.get()));
    }
}