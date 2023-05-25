package com.example.miitnavigation.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TimeTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "time_id")
    private Time time;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "auditorium_id")
    private Auditorium auditorium;

    private Boolean isEven;

    private String type;

    @Override
    public String toString() {
        return "TimeTable{" +
                "id=" + id +
                ", subject=" + subject +
                ", teacher=" + teacher +
                ", time=" + time +
                ", auditorium=" + auditorium +
                ", isEven=" + isEven +
                ", type='" + type + '\'' +
                '}';
    }
}