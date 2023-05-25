package com.example.miitnavigation.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime timeStart;
    private LocalDateTime timeEnd;
    @OneToMany(mappedBy = "time", cascade = CascadeType.ALL)
    private List<TimeTable> timeTableList;

    @Override
    public String toString() {
        return "Time{" +
                "id=" + id +
                ", timeStart=" + timeStart +
                ", timeEnd=" + timeEnd +
                ", timeTableList=" + timeTableList +
                '}';
    }
}
