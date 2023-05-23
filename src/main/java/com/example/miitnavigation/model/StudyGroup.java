package com.example.miitnavigation.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class StudyGroup {
    @Id
    private long id;
    @Column(unique = true)
    private String groupName;

    @Override
    public String toString() {
        return "StudyGroup{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
