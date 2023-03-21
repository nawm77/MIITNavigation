package com.example.miitnavigation.dto;

public record TeacherDTO(long id, String nameSurname) {
    @Override
    public String toString() {
        return "TeacherDTO{" +
                "nameSurname='" + nameSurname + '\'' +
                '}';
    }
}
