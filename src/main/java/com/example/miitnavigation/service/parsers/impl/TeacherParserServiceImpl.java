package com.example.miitnavigation.service.parsers.impl;

import com.example.miitnavigation.model.StudyGroup;
import com.example.miitnavigation.model.Teacher;
import com.example.miitnavigation.service.parsers.TeacherParserService;
import lombok.extern.log4j.Log4j2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class TeacherParserServiceImpl implements TeacherParserService {
    @Override
    public List<Teacher> parse(StudyGroup studyGroup) {
        List<Teacher> teacherList = new ArrayList<>();
        try {
            String url = "https://www.miit.ru/timetable/" + studyGroup.getId();
            Document doc = Jsoup.connect(url).get();
            Elements divElements = doc.select("div.mb-2");
            for (Element divElement : divElements) {
                Element aElement = divElement.selectFirst("a.timetable-icon-link.icon-academic-cap");
                if (aElement != null) {
                    Teacher teacher = new Teacher();
                    String fullName = aElement.attr("title");
                    String[] nameParts = fullName.split(", ");
                    String initials = nameParts[0];
                    teacher.setNameSurname(initials);
                    teacherList.add(teacher);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info(teacherList);
        return teacherList;
    }
}
