package com.example.miitnavigation.service.parsers.impl;

import com.example.miitnavigation.model.*;
import com.example.miitnavigation.service.parsers.TimeTableParser;
import lombok.extern.log4j.Log4j2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class TimeTableParserImpl implements TimeTableParser {
    @Override
    public List<TimeTable> parse(StudyGroup studyGroup) {
        List<TimeTable> tableList = new ArrayList<>();
        try {
            // Подключаемся к странице с расписанием
            Document doc = Jsoup.connect("https://www.miit.ru/timetable/186236").get();

            // Находим контейнер с расписанием
            Element timetableContainer = doc.selectFirst("#week-2");

            // Парсинг вкладок
            Elements tabPanes = timetableContainer.select("div.tab-pane");
            for (Element tabPane : tabPanes) {
                String tabId = tabPane.attr("id");
                log.info("Tab ID: " + tabId);

                // Парсинг блоков информации внутри вкладок
                Elements infoBlocks = tabPane.select("div.info-block");
                for (Element infoBlock : infoBlocks) {
                    TimeTable timeTable = new TimeTable(); // Создаем новый экземпляр TimeTable для каждого блока информации
                    String headerText = infoBlock.selectFirst("span.info-block__header-text").text();
                    log.info("Header Text: " + headerText);

                    // Парсинг элементов расписания внутри блоков информации
                    Elements timetableItems = infoBlock.select("div.timetable__list-timeslot");
                    for (Element timetableItem : timetableItems) {

                        String timeSlot = timetableItem.selectFirst("div.mb-1").text();
                        String subject = timetableItem.selectFirst("span.timetable__grid-text_gray").text();
                        String description = timetableItem.ownText().trim();

                        //Какая сейчас пара
                        String[] parts = timeSlot.split("[,—]");
                        String timeSlotIndex = parts[0].trim();
                        log.info("Part: " + timeSlotIndex);

                        //Время начала и конца пар
                        String startTime = parts[1].trim();
                        String endTime = parts[2].trim();
                        LocalTime startLocalTime = LocalTime.parse(startTime);
                        LocalTime endLocalTime = LocalTime.parse(endTime);
                        log.info("Start time: " + startLocalTime);
                        log.info("End time: " + endLocalTime);

                        log.info("Subject: " + subject);
                        timeTable.setSubject(Subject.builder()
                                .name(subject)
                                .build());
//                        log.info("Description: " + description);

                        timeTable.setTime(Time.builder()
                                .timeStart(startLocalTime.atDate(LocalDate.now()))
                                .timeEnd(endLocalTime.atDate(LocalDate.now()))
                                .build());

                        Day day = new Day();
                        day.setDayName("Пятница");
                        timeTable.setDay(day);

                        // Парсинг ссылок на преподавателей
                        StringBuilder teacherStr = null;
                        Elements teacherLinks = timetableItem.select("a[href^=\"/people/\"]");
                        for (Element teacherLink : teacherLinks) {
                            teacherStr = new StringBuilder();
                            String teacherName = teacherLink.text();
                            teacherStr.append(teacherName);
                        }
                        Teacher teacher = Teacher.builder()
                                .nameSurname(teacherStr.toString())
                                .build();
                        timeTable.setTeacher(teacher);

                        // Парсинг ссылок на аудитории
                        StringBuilder auditoriumStr = null;
                        Elements locationLinks = timetableItem.select("a[href^=\"https://rut-miit.ru/report/public\"]");
                        for (Element locationLink : locationLinks) {
                            auditoriumStr = new StringBuilder();
                            String location = locationLink.text();
                            auditoriumStr.append(location);
                        }

                        Auditorium auditorium = Auditorium.builder()
                                .auditoriumNumber(auditoriumStr.toString())
                                .build();
                        timeTable.setAuditorium(auditorium);
                        timeTable.setIsEven(true);
                        log.info(timeTable);
                        tableList.add(timeTable);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return tableList;
    }
}
