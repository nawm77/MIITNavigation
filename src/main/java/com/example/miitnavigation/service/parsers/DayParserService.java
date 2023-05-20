package com.example.miitnavigation.service.parsers;

import com.example.miitnavigation.model.Day;

import java.util.List;

@FunctionalInterface
public interface DayParserService {
    List<Day> parse();
}
