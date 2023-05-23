package com.example.miitnavigation.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Auditorium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String auditoriumNumber;
    @OneToMany(mappedBy = "auditorium", cascade = CascadeType.ALL)
    private List<TimeTable> timeTableList;
}
