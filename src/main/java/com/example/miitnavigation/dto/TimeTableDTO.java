package com.example.miitnavigation.dto;

//public record TimeTableDTO(long id, long subjectId, long teacherId, long timeId, long dayId, long auditoriumId,
//                           boolean isEven) {
//}

import com.example.miitnavigation.model.TimeTable;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class TimeTableDTO{
    private long id;
    private long subjectId;
    private long teacherId;
    private long timeId;
    private long auditoriumId;
    private boolean isEven;
    public static List<TimeTableDTO> toDTO(List<TimeTable> timeTable) {
        return timeTable.stream().map(timeTable1 -> new TimeTableDTO(timeTable1.getId(),
                timeTable1.getSubject().getId(),
                timeTable1.getTeacher().getId(),
                timeTable1.getTime().getId(),
                timeTable1.getAuditorium().getId(),
                timeTable1.getIsEven())).collect(Collectors.toList());
    }
}