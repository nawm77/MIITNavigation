//package com.example.miitnavigation.controller;
//
//import com.example.miitnavigation.service.DayService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("${api.base-path}")
//public class DayController {
//    private final DayService dayService;
//
//    @Autowired
//    public DayController(DayService dayService) {
//        this.dayService = dayService;
//    }
//
//    @GetMapping("/days")
//    public ResponseEntity<List<Day>> getAllDays() {
//        try {
//            List<Day> allDays = dayService.getAllDays().get();
//            return ResponseEntity.ok(allDays);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//
//    @GetMapping("/day/{id}")
//    public ResponseEntity<Day> getDayById(@PathVariable long id) {
//        try {
//            Optional<Day> day = dayService.getDayById(id).get();
//            return day.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//}
