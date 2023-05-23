//package com.example.miitnavigation.service.parsers.impl;
//
//import com.example.miitnavigation.service.parsers.DayParserService;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//@Log4j2
//public class DayParserServiceImpl implements DayParserService {
//    @Override
//    public List<Day> parse() {
//        List<String> dayOfWeeks = List.of("Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота", "Воскресенье");
//        List<Day> list = new ArrayList<>();
//        int i = 0;
//        for (String dayName : dayOfWeeks) {
//            Day day = new Day();
//            day.setDayName(dayName);
//            day.setId(i);
//            i++;
//            list.add(day);
//        }
//        return list;
//    }
//}
