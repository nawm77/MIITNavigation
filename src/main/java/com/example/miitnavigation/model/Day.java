package com.example.miitnavigation.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class Day {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String dayName;

    @OneToMany(mappedBy = "day", cascade = CascadeType.ALL)
    private List<TimeTable> timeTableList;

    public Day(String name) {
    }

}
