package com.example.miitnavigation.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@ToString
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
}
