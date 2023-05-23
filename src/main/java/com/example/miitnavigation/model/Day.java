package com.example.miitnavigation.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    private String dayName;

//    @OneToMany(mappedBy = "day", cascade = CascadeType.ALL)
    private List<TimeTable> timeTableList;

    public Day(String name) {
    }

}
