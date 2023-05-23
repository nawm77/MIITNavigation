package com.example.miitnavigation.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public final class Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private LocalDateTime timeStart;
    @Column(unique = true)
    private LocalDateTime timeEnd;
    @OneToMany(mappedBy = "time", cascade = CascadeType.ALL)
    private List<TimeTable> timeTableList;
}
