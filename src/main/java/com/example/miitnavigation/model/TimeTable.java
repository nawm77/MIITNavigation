package com.example.miitnavigation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public final class TimeTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int subjectId;
    private long teacherId;
    private long timeId;
    private long dayId;
    private long auditoriumId;
    private boolean isEven;
}
