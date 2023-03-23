package com.example.miitnavigation.service.impl;

import com.example.miitnavigation.model.StudyGroup;
import com.example.miitnavigation.repository.StudyGroupRepository;
import com.example.miitnavigation.service.GroupParserService;
import com.example.miitnavigation.service.StudyGroupService;
import lombok.extern.log4j.Log4j2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;

@Log4j2
@Service
public class GroupParserServiceImpl implements GroupParserService {
    private final HashMap<Integer, String> allGroups = new HashMap<>();
    private final StudyGroupService studyGroupService;

    @Autowired
    public GroupParserServiceImpl(StudyGroupService studyGroupService) {
        this.studyGroupService = studyGroupService;
    }

    @Override
    public HashMap<Integer, String> parse() {
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
                    allGroups.put(Integer.valueOf(timetableId), groupName);
                    StudyGroup studyGroup = new StudyGroup();
                    studyGroup.setId(Long.parseLong(timetableId));
                    studyGroup.setGroupName(groupName);
                    studyGroupService.createStudyGroup(studyGroup);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return allGroups;
    }

}
