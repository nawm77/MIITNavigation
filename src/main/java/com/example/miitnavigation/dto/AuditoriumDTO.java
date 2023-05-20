package com.example.miitnavigation.dto;

public record AuditoriumDTO(long id, String auditoriumNumber) {
    @Override
    public String toString() {
        return "AuditoriumDTO{" +
                "auditoriumNumber=" + auditoriumNumber +
                '}';
    }
}
