//package com.example.miitnavigation.scheduler;
//
//import com.example.miitnavigation.model.Auditorium;
//import com.example.miitnavigation.model.StudyGroup;
//import com.example.miitnavigation.service.AuditoriumService;
//import com.example.miitnavigation.service.StudyGroupService;
//import com.example.miitnavigation.service.parsers.AuditoriumParserService;
//import jakarta.annotation.PostConstruct;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.concurrent.ExecutionException;
//
//@Component
//@Log4j2
////fixme
//public class AuditoriumParserTask {
//    private final AuditoriumParserService auditoriumParserService;
//    private final AuditoriumService auditoriumService;
//    private final StudyGroupService studyGroupService;
//    private static final StudyGroup TEST_GROUP = new StudyGroup();
//
//    @Autowired
//    public AuditoriumParserTask(AuditoriumParserService auditoriumParserService, AuditoriumService auditoriumService, StudyGroupService studyGroupService) {
//        this.auditoriumParserService = auditoriumParserService;
//        this.auditoriumService = auditoriumService;
//        this.studyGroupService = studyGroupService;
//        TEST_GROUP.setGroupName("УВП-213");
//        TEST_GROUP.setId(186236);
//    }
//
//    @Scheduled(cron = "0 0 0 * * *")
//    public void parse() throws ExecutionException, InterruptedException {
//        List<StudyGroup> groups = studyGroupService.getAllStudyGroup().get();
//        log.info(groups);
//        for (StudyGroup group : groups) {
//            List<Auditorium> auditoriums = auditoriumParserService.parse(group);
//            for (Auditorium auditorium : auditoriums) {
//                auditoriumService.createAuditorium(auditorium);
//            }
//        }
//        log.info("Parsing auditorium group complete");
//    }
//}
