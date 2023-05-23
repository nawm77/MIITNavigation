package com.example.miitnavigation.scheduler;

import com.example.miitnavigation.model.StudyGroup;
import com.example.miitnavigation.model.Teacher;
import com.example.miitnavigation.service.TeacherService;
import com.example.miitnavigation.service.parsers.TeacherParserService;
import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Log4j2
//fixme
public class TeacherParserTask {
    private final TeacherParserService teacherParserService;
    private final TeacherService teacherService;
    private static final StudyGroup TEST_GROUP = new StudyGroup();

    @Autowired
    public TeacherParserTask(TeacherParserService teacherParserService, TeacherService teacherService) {
        this.teacherParserService = teacherParserService;
        this.teacherService = teacherService;
        TEST_GROUP.setGroupName("УВП-213");
        TEST_GROUP.setId(186236);
    }

    @PostConstruct
    public void init() {
        List<Teacher> teachers = teacherParserService.parse(TEST_GROUP);
        for (Teacher value : teachers) {
            Teacher teacher = new Teacher();
            teacher.setNameSurname(value.getNameSurname());
            teacherService.createTeacher(teacher);
        }
        log.info("Init parsing complete");
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void parse() {
        teacherParserService.parse(TEST_GROUP);
        log.info("Parsing complete.");
    }
}

