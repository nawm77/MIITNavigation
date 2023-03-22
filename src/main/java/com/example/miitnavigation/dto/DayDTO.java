package com.example.miitnavigation.dto;

public record DayDTO(long id, String dayName) {
    @Override
    public String toString() {
        return "DayDTO{" +
                "dayName='" + dayName + '\'' +
                '}';
    }
}
