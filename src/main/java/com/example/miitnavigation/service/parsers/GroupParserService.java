package com.example.miitnavigation.service.parsers;

import com.example.miitnavigation.model.StudyGroup;

import java.util.List;

@FunctionalInterface
public interface GroupParserService {
    List<StudyGroup> parse();
}
