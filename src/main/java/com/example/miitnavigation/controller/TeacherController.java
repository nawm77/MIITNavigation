package com.example.miitnavigation.controller;

import com.example.miitnavigation.exception.ResourceNotFoundException;
import com.example.miitnavigation.exception.TeacherException;
import com.example.miitnavigation.model.Teacher;
import com.example.miitnavigation.service.TeacherService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Log4j2
@RestController
@RequestMapping("${api.base-path}")
public class TeacherController {
    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teachers")
    @ResponseBody
    public String getAllTeachers() {
        try {
            var teachersById = teacherService.getAllTeachers();
            log.info(teachersById);
            List<Teacher> teachers = teachersById.get();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            return gson.toJson(teachers);
        } catch (InterruptedException | ExecutionException e) {
            throw new TeacherException("Ошибка при получении списка преподавателей");
        }
    }

    @GetMapping("/teacher/{id}")
    @ResponseBody
    public String getTeacherById(@PathVariable long id) throws ExecutionException, InterruptedException {
        var teacherById = teacherService.getTeacherById(id);
        log.info(teacherById);
        Optional<Teacher> teacher = teacherById.get();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        if (teacher.isPresent()) {
            return gson.toJson(teacher.get());
        } else {
            throw new ResourceNotFoundException("Teacher not found");
        }
    }
}
