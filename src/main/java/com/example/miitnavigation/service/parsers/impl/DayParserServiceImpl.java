package com.example.miitnavigation.service.parsers.impl;

import com.example.miitnavigation.model.Day;
import com.example.miitnavigation.service.parsers.DayParserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class DayParserServiceImpl implements DayParserService {
    @Override
    public List<Day> parse() {
        List<String> dayOfWeeks = List.of("Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота", "Воскресенье");
        return dayOfWeeks.stream()
                .map(Day::new)
                .collect(Collectors.toList());
    }
}
