package com.example.miitnavigation.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public final class GroupsTimetable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "study_group_id")
    private StudyGroup studyGroup;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "time_table_id")
    private TimeTable timeTable;
}
