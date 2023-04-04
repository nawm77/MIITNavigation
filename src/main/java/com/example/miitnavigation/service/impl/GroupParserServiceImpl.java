package com.example.miitnavigation.service.impl;

import com.example.miitnavigation.model.StudyGroup;
import com.example.miitnavigation.service.GroupParserService;
import io.micrometer.core.annotation.Timed;
import lombok.extern.log4j.Log4j2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
public class GroupParserServiceImpl implements GroupParserService {

    @Timed
    @Override
    public List<StudyGroup> parse() {
        List<StudyGroup> studyGroupList = new ArrayList<>();
        try {
            String url = "https://www.miit.ru/timetable";
            Document document = Jsoup.connect(url).get();
            // Получаем все элементы <a> с атрибутом href, содержащим "/timetable/"
            Elements elements = document.select("a[href*=timetable]");

            // Перебираем элементы и выводим их текст и значение атрибута href
            for (Element element : elements) {
                String groupName = element.text();
                String timetableLink = element.attr("href");
                String timetableId = timetableLink.replaceAll("\\D", ""); // убираем все не-цифровые символы
                if (timetableId.length() > 0) {
                    StudyGroup studyGroup = new StudyGroup();
                    studyGroup.setId(Long.parseLong(timetableId));
                    studyGroup.setGroupName(groupName);
                    studyGroupList.add(studyGroup);
                }
            }
            log.info(studyGroupList.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return studyGroupList;
    }
}
