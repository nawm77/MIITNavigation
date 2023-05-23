package com.example.miitnavigation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class StudyGroup {
    @Id
    private long id;
    private String groupName;
}
