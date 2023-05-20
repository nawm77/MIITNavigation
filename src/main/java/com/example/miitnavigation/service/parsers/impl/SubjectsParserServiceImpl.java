package com.example.miitnavigation.service.parsers.impl;

import com.example.miitnavigation.model.StudyGroup;
import com.example.miitnavigation.model.Subject;
import com.example.miitnavigation.service.parsers.SubjectsParserService;
import io.micrometer.core.annotation.Timed;
import lombok.extern.log4j.Log4j2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Log4j2
@Service
public class SubjectsParserServiceImpl implements SubjectsParserService {
    private final static byte INDEX_FIRST_COUPLE_IN_HTML_TABLE = 1;

    /**
     * @param studyGroup метод парсит только предметы у той группы которую мы передали в параметре
     * @return список Subject
     */
    @Timed
    @Override
    public List<Subject> parse(StudyGroup studyGroup) {
        List<Subject> subjectList = new ArrayList<>();
        try {
            Set<String> allSubjects = searchAllLessonsInSchedule((int) studyGroup.getId());
            log.warn(allSubjects);
            for (String s : allSubjects) {
                Subject subject = new Subject();
                subject.setName(s);
                subjectList.add(subject);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return subjectList;
    }

    private Set<String> searchAllLessonsInSchedule(int groupId) throws IOException {
        Set<String> couples = new HashSet<>();

        String url = "https://www.miit.ru/timetable/" + groupId;
        Document document = Jsoup.connect(url).get();

        Elements table = document.getElementsByClass("table timetable__grid");
        Elements rows = table.select("tr");

        for (int i = INDEX_FIRST_COUPLE_IN_HTML_TABLE; i < rows.size(); i++) {
            Elements lessons = rows.get(i).getElementsByClass("timetable__grid-day-lesson");
            for (Element lesson : lessons) {
                String lessonName = lesson.ownText();
                lessonName = lessonName.trim().replaceAll("\\s+", " ").toLowerCase();
                if (!lessonName.isEmpty()) {
                    couples.add(lessonName);
                }
            }
        }
        return couples;
    }
}
