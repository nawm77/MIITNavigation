package com.example.miitnavigation.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TimeTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "time_id")
    private Time time;

    @ManyToOne
    @JoinColumn(name = "day_id")
    private Day day;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "auditorium_id")
    private Auditorium auditorium;

    private Boolean isEven;

    private String type;
}