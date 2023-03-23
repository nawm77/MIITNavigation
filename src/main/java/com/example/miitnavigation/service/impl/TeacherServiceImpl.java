package com.example.miitnavigation.service.impl;

import com.example.miitnavigation.model.Teacher;
import com.example.miitnavigation.repository.TeacherRepository;
import com.example.miitnavigation.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Async
    @Override
    public CompletableFuture<Teacher> createTeacher(Teacher teacher) {
        return CompletableFuture.completedFuture(teacherRepository.save(teacher));
    }

    @Async
    @Override
    public CompletableFuture<Optional<Teacher>> getTeacherById(Long id) {
        return CompletableFuture.completedFuture(teacherRepository.findById(id));
    }

    @Async
    @Override
    public CompletableFuture<List<Teacher>> getAllTeachers() {
        return CompletableFuture.completedFuture(teacherRepository.findAll());
    }

    @Async
    @Override
    public CompletableFuture<Void> deleteTeacherById(Long id) {
        teacherRepository.deleteById(id);
        return CompletableFuture.completedFuture(null);
    }
}
