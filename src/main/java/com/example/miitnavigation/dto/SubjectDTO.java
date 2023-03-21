package com.example.miitnavigation.dto;

public record SubjectDTO(long id, String name) {
    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                '}';
    }
}
