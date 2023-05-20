package com.example.miitnavigation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public final class Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private LocalDateTime timeStart;
    @Column(unique = true)
    private LocalDateTime timeEnd;
}
