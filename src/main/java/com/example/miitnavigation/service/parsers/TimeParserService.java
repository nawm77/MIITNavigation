package com.example.miitnavigation.service.parsers;

import com.example.miitnavigation.model.Time;

import java.util.List;

@FunctionalInterface
public interface TimeParserService {
    List<Time> parse();
}
