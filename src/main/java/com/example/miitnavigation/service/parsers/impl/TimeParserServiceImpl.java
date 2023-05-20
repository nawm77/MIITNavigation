package com.example.miitnavigation.service.parsers.impl;

import com.example.miitnavigation.model.Time;
import com.example.miitnavigation.service.parsers.TimeParserService;
import lombok.extern.log4j.Log4j2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
public class TimeParserServiceImpl implements TimeParserService {
    @Override
    public List<Time> parse() {
        List<Time> timeList = new ArrayList<>();
        String url = "https://www.miit.ru/timetable/186236";
        try {
            Document document = Jsoup.connect(url).get();
            Elements timetableElements = document.select(".timetable__grid-text_gray");

            for (Element element : timetableElements) {
                String time = element.text();
                if (time.matches("\\d{2}:\\d{2} — \\d{2}:\\d{2}")) {
                    String[] times = time.split(" — ");
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                    LocalDate date = LocalDate.now();

                    LocalTime localTimeStart = LocalTime.parse(times[0], formatter);
                    LocalDateTime timeStart = LocalDateTime.of(date, localTimeStart);

                    LocalTime localTimeEnd = LocalTime.parse(times[1], formatter);
                    LocalDateTime timeEnd = LocalDateTime.of(date, localTimeEnd);

                    Time timeObj = new Time();
                    timeObj.setTimeStart(timeStart);
                    timeObj.setTimeEnd(timeEnd);
                    timeList.add(timeObj);
                    log.info(timeStart + " " + timeEnd);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return timeList;
    }
}
