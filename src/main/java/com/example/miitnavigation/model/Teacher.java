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
public final class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String nameSurname;
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<TimeTable> timeTableList;
}
