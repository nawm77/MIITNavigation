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
import java.util.Objects;

@Service
@Log4j2
public class TimeTableParserImpl implements TimeTableParser {
    @Override
    public List<TimeTable> parse(StudyGroup studyGroup, boolean even) {
        List<TimeTable> tableList = new ArrayList<>();
        try {
            // Подключаемся к странице с расписанием
            Document doc = Jsoup.connect("https://www.miit.ru/timetable/" + studyGroup.getId()).get();

            // Находим контейнер с расписанием
            String isEven = even ? "#week-2" : "#week-1";
            Element timetableContainer = doc.selectFirst(isEven);

            // Парсинг вкладок
            Elements tabPanes = Objects.requireNonNull(timetableContainer).select("div.tab-pane");
            for (Element tabPane : tabPanes) {
                String tabId = tabPane.attr("id");
                log.debug("Tab ID: {}", tabId);

                // Парсинг блоков информации внутри вкладок
                Elements infoBlocks = tabPane.select("div.info-block");
                for (Element infoBlock : infoBlocks) {
                    String headerText = Objects.requireNonNull(infoBlock.selectFirst("span.info-block__header-text")).text();
                    log.debug("Header Text: {}", headerText);

                    // Парсинг элементов расписания внутри блоков информации
                    Elements timetableItems = infoBlock.select("div.timetable__list-timeslot");
                    for (Element timetableItem : timetableItems) {
                        TimeTable timeTable = new TimeTable();
                        String timeSlot = Objects.requireNonNull(timetableItem.selectFirst("div.mb-1")).text();
                        String type = Objects.requireNonNull(timetableItem.selectFirst("span.timetable__grid-text_gray")).text();
                        String description = timetableItem.ownText().trim();

                        // Какая сейчас пара
                        String[] parts = timeSlot.split("[,—]");
                        String timeSlotIndex = parts[0].trim();
                        log.debug("Part: {}", timeSlotIndex);

                        // Время начала и конца пар
                        String startTime = parts[1].trim();
                        String endTime = parts[2].trim();
                        LocalTime startLocalTime = LocalTime.parse(startTime);
                        LocalTime endLocalTime = LocalTime.parse(endTime);
                        log.debug("Start time: {}", startLocalTime);
                        log.debug("End time: {}", endLocalTime);

                        log.debug("Type: {}", type);
                        log.debug("Description: {}", description);

                        Element divElement = timetableItem.selectFirst("div.pl-4");
                        String subject = Objects.requireNonNull(divElement).ownText().trim();
                        log.debug("Subject: {}", subject);

                        // Парсинг ссылок на преподавателей
                        StringBuilder teacherName = new StringBuilder();
                        Elements teacherLinks = timetableItem.select("a[href^=\"/people/\"]");
                        for (Element teacherLink : teacherLinks) {
                            teacherName.append(teacherLink.text());
                        }
                        log.debug("Teacher: {}", teacherName);

                        // Парсинг ссылок на аудитории
                        StringBuilder location = new StringBuilder();
                        Elements locationLinks = timetableItem.select("a[href^=\"https://rut-miit.ru/report/public\"]");
                        for (Element locationLink : locationLinks) {
                            location.append(locationLink.text());
                        }
                        log.debug("Location: {}", location);

                        // Парсинг ссылок на группы
                        Elements groupLinks = timetableItem.select("a[href^=\"/timetable/\"]");
                        for (Element groupLink : groupLinks) {
                            String groupName = groupLink.text();
                            log.debug("Group: {}", groupName);
                        }

                        timeTable.setTime(Time.builder()
                                .timeStart(startLocalTime.atDate(LocalDate.now()))
                                .timeEnd(endLocalTime.atDate(LocalDate.now()))
                                .build());

                        // Проверка на null для преподавателя
                        if (teacherName.length() > 0) {
                            timeTable.setTeacher(Teacher.builder()
                                    .nameSurname(teacherName.toString())
                                    .build());
                        }

                        // Проверка на null для аудитории
                        if (location.length() > 0) {
                            timeTable.setAuditorium(Auditorium.builder()
                                    .auditoriumNumber(location.toString())
                                    .build());
                        }

                        timeTable.setSubject(Subject.builder()
                                .name(subject)
                                .build());
                        timeTable.setType(type);
                        timeTable.setIsEven(even);
                        tableList.add(timeTable);
                    }
                }
            }
        } catch (IOException | NullPointerException e) {
            throw new RuntimeException(e);
        }
        log.info("Parsing completed-{}: {}", studyGroup.getGroupName(), tableList);
        return tableList;
    }
}
