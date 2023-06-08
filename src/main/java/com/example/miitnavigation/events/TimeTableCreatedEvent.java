package com.example.miitnavigation.events;

import com.example.miitnavigation.model.TimeTable;

public class TimeTableCreatedEvent {
    private final TimeTable timeTable;
    private final long id;

    public TimeTableCreatedEvent(TimeTable timeTable, long id) {
        super();
        this.timeTable = timeTable;
        this.id = id;
    }

    public TimeTable getTimeTable() {
        return timeTable;
    }

    public long getId() {
        return id;
    }
}
