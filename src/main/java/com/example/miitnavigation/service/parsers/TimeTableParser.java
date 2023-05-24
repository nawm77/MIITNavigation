package com.example.miitnavigation.service.parsers;

import com.example.miitnavigation.model.StudyGroup;
import com.example.miitnavigation.model.TimeTable;

import java.util.List;

public interface TimeTableParser {
    List<TimeTable> parse(StudyGroup studyGroup, boolean even);
}
