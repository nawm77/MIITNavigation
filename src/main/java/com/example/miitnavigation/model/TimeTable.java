package com.example.miitnavigation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class TimeTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private Subject subject;

    @ManyToOne
    @JoinColumn
    private Teacher teacher;

    @ManyToOne
    @JoinColumn
    private Time time;

    @ManyToOne
    @JoinColumn
    private Day day;

    @ManyToOne
    @JoinColumn
    private Auditorium auditorium;

    private Boolean isEven;
}