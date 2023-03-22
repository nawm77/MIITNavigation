package com.example.miitnavigation.dto;

public record TimeTableDTO(long id, long subjectId, long teacherId, long timeId, long dayId, long auditoriumId,
                           boolean isEven) {
}
