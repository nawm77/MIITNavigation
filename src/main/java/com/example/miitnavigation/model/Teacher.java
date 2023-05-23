package com.example.miitnavigation.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nameSurname;
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<TimeTable> timeTableList;

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", nameSurname='" + nameSurname + '\'' +
                ", timeTableList=" + timeTableList +
                '}';
    }
}
