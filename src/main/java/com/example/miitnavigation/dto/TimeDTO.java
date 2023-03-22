package com.example.miitnavigation.dto;

public record TimeDTO(long id, String timeStart, String timeEnd) {
    @Override
    public String toString() {
        return "TimeDTO{" +
                "timeStart='" + timeStart + '\'' +
                ", timeEnd='" + timeEnd + '\'' +
                '}';
    }
}
