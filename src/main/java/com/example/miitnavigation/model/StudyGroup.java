package com.example.miitnavigation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
public final class StudyGroup {
    @Id
    private long id;
    private String groupName;
}
