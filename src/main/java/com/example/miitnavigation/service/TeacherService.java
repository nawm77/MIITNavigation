package com.example.miitnavigation.service;

import com.example.miitnavigation.model.Teacher;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface TeacherService {
    Teacher findOrCreate(Teacher teacher);

    CompletableFuture<Teacher> createTeacher(Teacher teacher);

    CompletableFuture<Optional<Teacher>> getTeacherById(Long id);

    CompletableFuture<List<Teacher>> getAllTeachers();

    CompletableFuture<Void> deleteTeacherById(Long id);
}
