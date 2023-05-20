package com.example.miitnavigation.service.parsers.impl;

import com.example.miitnavigation.model.Auditorium;
import com.example.miitnavigation.model.StudyGroup;
import com.example.miitnavigation.service.parsers.AuditoriumParserService;
import lombok.extern.log4j.Log4j2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Log4j2
public class AuditoriumParserServiceImpl implements AuditoriumParserService {
    /**
     * @param studyGroup метод парсит только аудитории у той группы, которую передали в параметре
     * @return список всех аудиторий у конкретной группы
     */
    @Override
    public List<Auditorium> parse(StudyGroup studyGroup) {
        List<Auditorium> auditoriumList = new ArrayList<>();
        Set<String> auditoriumSet = new HashSet<>();
        try {
            String url = "https://www.miit.ru/timetable/" + studyGroup.getId();
            Document doc = Jsoup.connect(url).get();
            Elements divElements = doc.select("div.mb-2");
            for (Element divElement : divElements) {
                Element aElement = divElement.selectFirst("a.timetable-icon-link.icon-location");
                if (aElement != null) {
                    String auditorium = aElement.text();
                    auditoriumSet.add(auditorium);
                }
            }
            auditoriumSet.forEach(element -> {
                Auditorium auditorium = new Auditorium();
                auditorium.setAuditoriumNumber(element);
                auditoriumList.add(auditorium);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info(auditoriumList.toString());
        return auditoriumList;
    }
}
