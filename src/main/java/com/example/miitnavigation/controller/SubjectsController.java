//package com.example.miitnavigation.controller;
//
//import com.example.miitnavigation.exception.ResourceNotFoundException;
//import com.example.miitnavigation.exception.SubjectException;
//import com.example.miitnavigation.model.Subject;
//import com.example.miitnavigation.service.SubjectService;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//import java.util.concurrent.ExecutionException;
//
//@RestController
//@RequestMapping("${api.base-path}")
//public class SubjectsController {
//    private final SubjectService subjectService;
//
//    @Autowired
//    public SubjectsController(SubjectService subjectService) {
//        this.subjectService = subjectService;
//    }
//
//    @GetMapping("/subjects")
//    @ResponseBody
//    public String getAllSchedule() {
//        try {
//            var allSubjects = subjectService.getAllSubjects();
//            Gson gson = new GsonBuilder().setPrettyPrinting().create();
//            return gson.toJson(allSubjects.get());
//        } catch (InterruptedException | ExecutionException e) {
//            throw new SubjectException("Ошибка при получении списка предметов");
//        }
//    }
//
//    @GetMapping("/subject/{id}")
//    @ResponseBody
//    public String getScheduleById(@PathVariable long id) throws ExecutionException, InterruptedException {
//        var subjectById = subjectService.getSubjectById(id);
//        Optional<Subject> subject = subjectById.get();
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        if (subject.isPresent()) {
//            return gson.toJson(subject.get());
//        } else {
//            throw new ResourceNotFoundException("Subject not found");
//        }
//    }
//}
