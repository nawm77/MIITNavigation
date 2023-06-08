package com.example.miitnavigation.service.impl;

import com.example.miitnavigation.events.TimeTableCreatedEvent;
import com.example.miitnavigation.model.*;
import com.example.miitnavigation.repository.GroupsTimetableRepository;
import com.example.miitnavigation.repository.TimeTableRepository;
import com.example.miitnavigation.service.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Log4j2
@Service
@Transactional
public class TimeTableServiceImpl implements TimeTableService {
    private final GroupsTimetableRepository groupsTimetableRepository;
    private final TimeTableRepository timeTableRepository;
    private final ApplicationEventPublisher applicationEventPublisher;
    private final AuditoriumService auditoriumService;
    private final SubjectService subjectService;
    private final TeacherService teacherService;
    private final TimeService timeService;

    @Autowired
    public TimeTableServiceImpl(TimeTableRepository timeTableRepository,
                                ApplicationEventPublisher applicationEventPublisher,
                                AuditoriumService auditoriumService,
                                SubjectService subjectService,
                                TeacherService teacherService, TimeService timeService,
                                GroupsTimetableRepository groupsTimetableRepository) {
        this.timeTableRepository = timeTableRepository;
        this.applicationEventPublisher = applicationEventPublisher;
        this.auditoriumService = auditoriumService;
        this.subjectService = subjectService;
        this.teacherService = teacherService;
        this.timeService = timeService;
        this.groupsTimetableRepository = groupsTimetableRepository;
    }

    @Transactional
    public void saveTimeTable(TimeTable timeTable, long id) {
        Auditorium auditorium = auditoriumService.findOrCreate(timeTable.getAuditorium());
        timeTable.setAuditorium(auditorium);

        Subject subject = subjectService.findOrCreate(timeTable.getSubject());
        timeTable.setSubject(subject);

        Teacher teacher = teacherService.findOrCreate(timeTable.getTeacher());
        timeTable.setTeacher(teacher);

        Time time = timeService.findOrCreate(timeTable.getTime());
        timeTable.setTime(time);

        log.debug(auditorium);
        TimeTable save = timeTableRepository.save(timeTable);
        applicationEventPublisher.publishEvent(new TimeTableCreatedEvent(save, id));
    }

    @Override
    public boolean existsByGroupId(Long groupId) {
        return timeTableRepository.existsByGroupId(groupId);
    }

    @Override
    public List<TimeTable> findAllWithFetch() {
        return timeTableRepository.findAllWithFetch();
    }

    @Async
    @Override
    public CompletableFuture<TimeTable> createTimeTable(TimeTable timeTable) {
        return CompletableFuture.completedFuture(timeTableRepository.saveAndFlush(timeTable));
    }

    @Async
    @Override
    public CompletableFuture<Optional<TimeTable>> getTimeTableById(Long id) {
        return CompletableFuture.completedFuture(timeTableRepository.findById(id));
    }

    @Async
    @Override
    public CompletableFuture<List<TimeTable>> getTimeTable() {
        return CompletableFuture.completedFuture(timeTableRepository.findAll());
    }

    @Override
    public CompletableFuture<Void> dropTimeTable() {
        timeTableRepository.deleteAll();
        return CompletableFuture.completedFuture(null);
    }

    @Async
    @Override
    public CompletableFuture<Void> deleteTimeTableById(Long id) {
        timeTableRepository.deleteById(id);
        return CompletableFuture.completedFuture(null);
    }
}
