package com.example.miitnavigation.service.parsers;

import com.example.miitnavigation.model.StudyGroup;
import com.example.miitnavigation.model.Subject;

import java.util.List;

@FunctionalInterface
public interface SubjectsParserService {
    List<Subject> parse(StudyGroup studyGroup);
}
