//package com.example.miitnavigation.scheduler;
//
//import com.example.miitnavigation.model.StudyGroup;
//import com.example.miitnavigation.model.Subject;
//import com.example.miitnavigation.service.parsers.SubjectsParserService;
//import com.example.miitnavigation.service.SubjectService;
//import com.example.miitnavigation.service.parsers.impl.SubjectsParserServiceImpl;
//import jakarta.annotation.PostConstruct;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//@Log4j2
////fixme
//public class SubjectParserTask {
//    private final SubjectsParserService subjectsParserService;
//    private final SubjectService subjectService;
//    private static final StudyGroup TEST_GROUP = new StudyGroup();
//
//    @Autowired
//    public SubjectParserTask(SubjectsParserService subjectsParserService, SubjectService subjectService) {
//        this.subjectsParserService = subjectsParserService;
//        this.subjectService = subjectService;
//        TEST_GROUP.setGroupName("УВП-213");
//        TEST_GROUP.setId(186236);
//    }
//
//    @PostConstruct
//    public void init() {
//        List<Subject> subjects = subjectsParserService.parse(TEST_GROUP);
//        for (Subject value : subjects) {
//            Subject subject = new Subject();
//            subject.setName(value.getName());
//            subjectService.createSubject(subject);
//        }
//        log.info("Init parsing complete");
//    }
//
//    @Scheduled(cron = "0 0 0 * * *")
//    public void parse() {
//        subjectsParserService.parse(TEST_GROUP);
//        log.info("Parsing complete.");
//    }
//}
