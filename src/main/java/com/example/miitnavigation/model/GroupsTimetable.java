package com.example.miitnavigation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public final class GroupsTimetable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn
    private StudyGroup studyGroup;

    @ManyToOne
    @JoinColumn
    private TimeTable timeTable;
}
