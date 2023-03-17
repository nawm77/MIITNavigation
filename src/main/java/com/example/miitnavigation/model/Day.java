package com.example.miitnavigation.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Day")
public class Day {
    @Id
    @Column(name="id")
    private long id;

    @Column(name="dayName")
    private String dayName;
}
