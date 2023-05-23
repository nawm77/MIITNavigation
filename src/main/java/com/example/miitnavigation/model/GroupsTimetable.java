package com.example.miitnavigation.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class GroupsTimetable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn
    private StudyGroup studyGroup;
    @ManyToOne
    @JoinColumn
    private TimeTable timeTable;

    @Override
    public String toString() {
        return "GroupsTimetable{" +
                "id=" + id +
                ", studyGroup=" + studyGroup +
                ", timeTable=" + timeTable +
                '}';
    }
}
