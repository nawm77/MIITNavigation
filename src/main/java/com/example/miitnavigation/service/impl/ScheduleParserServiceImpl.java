package com.example.miitnavigation.service.impl;

import com.example.miitnavigation.model.Subject;
import com.example.miitnavigation.repository.SubjectRepository;
import com.example.miitnavigation.service.ScheduleParserService;
import io.micrometer.core.annotation.Timed;
import lombok.extern.log4j.Log4j2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Log4j2
@Service
public class ScheduleParserServiceImpl implements ScheduleParserService {
    private final static byte INDEX_FIRST_COUPLE_IN_HTML_TABLE = 1;
    private final HashSet<String> couples = new HashSet<>();

    //todo relocate repository logic to service
    private final SubjectRepository subjectRepository;

    @Autowired
    public ScheduleParserServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    /**
     * @return groups set of couples
     */
    @Timed
    @Override
    public Set<String> parse() {
        try {
            String url = "https://www.miit.ru/timetable/186236";
            Document document = Jsoup.connect(url).get();
            Elements table = document.getElementsByClass("table timetable__grid");
            Elements rows = table.select("tr");
            for (int i = INDEX_FIRST_COUPLE_IN_HTML_TABLE; i < rows.size(); i++) {
                Elements lessons = rows.get(i).getElementsByClass("timetable__grid-day-lesson");
                for (Element lesson : lessons) {
                    String lessonName = lesson.ownText();
                    if (!lessonName.isEmpty()) {
                        couples.add(lessonName);
                    }
                }
            }
            for (String couple : couples) {
                Subject subject = new Subject();
                subject.setName(couple);
                subjectRepository.save(subject);
            }
            log.info(couples);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return couples;
    }
}
