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
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    private List<TimeTable> timeTableList;
    private String name;

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", timeTableList=" + timeTableList +
                ", name='" + name + '\'' +
                '}';
    }
}
