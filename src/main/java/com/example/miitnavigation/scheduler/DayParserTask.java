//package com.example.miitnavigation.scheduler;
//
//import com.example.miitnavigation.service.DayService;
//import com.example.miitnavigation.service.parsers.DayParserService;
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
//public class DayParserTask {
//    private final DayService dayService;
//    private final DayParserService dayParserService;
//
//    @Autowired
//    public DayParserTask(DayService dayService, DayParserService dayParserService) {
//        this.dayService = dayService;
//        this.dayParserService = dayParserService;
//    }
//
//    @PostConstruct
//    @Scheduled(cron = "0 0 0 * * *")
//    public void parse() {
//        List<Day> days = dayParserService.parse();
//        for (Day day : days) {
//            log.info(day);
//            dayService.createDay(day);
//        }
//        log.info("Parsing days complete");
//    }
//}
