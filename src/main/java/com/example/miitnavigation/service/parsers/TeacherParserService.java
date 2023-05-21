package com.example.miitnavigation.service.parsers;

import com.example.miitnavigation.model.StudyGroup;
import com.example.miitnavigation.model.Teacher;

import java.util.List;

@FunctionalInterface
public interface TeacherParserService {
    List<Teacher> parse(StudyGroup studyGroup);
}
