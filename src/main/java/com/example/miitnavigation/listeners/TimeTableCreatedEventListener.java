package com.example.miitnavigation.listeners;

import com.example.miitnavigation.events.TimeTableCreatedEvent;
import com.example.miitnavigation.model.GroupsTimetable;
import com.example.miitnavigation.model.StudyGroup;
import com.example.miitnavigation.repository.StudyGroupRepository;
import com.example.miitnavigation.service.GroupsTimetableService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@Log4j2
public class TimeTableCreatedEventListener {

    private final StudyGroupRepository groupRepository;
    private final GroupsTimetableService groupsTimetableService;

    public TimeTableCreatedEventListener(StudyGroupRepository groupRepository, GroupsTimetableService groupsTimetableService) {
        this.groupRepository = groupRepository;
        this.groupsTimetableService = groupsTimetableService;
    }


    @TransactionalEventListener
    public void handleTimeTableCreatedEvent(TimeTableCreatedEvent event) {
        StudyGroup group = groupRepository.findById(event.getId()).orElseThrow(() -> new RuntimeException("Group not found"));
        GroupsTimetable groupsTimetable = new GroupsTimetable();
        groupsTimetable.setStudyGroup(group);
        groupsTimetable.setTimeTable(event.getTimeTable());
        groupsTimetableService.createGroupsTimetable(groupsTimetable);
    }
}
