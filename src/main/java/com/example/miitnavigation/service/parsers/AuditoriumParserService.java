package com.example.miitnavigation.service.parsers;

import com.example.miitnavigation.model.Auditorium;
import com.example.miitnavigation.model.StudyGroup;

import java.util.List;

@FunctionalInterface
public interface AuditoriumParserService {
    List<Auditorium> parse(StudyGroup group);
}
