package com.example.miitnavigation.mapper;

import com.example.miitnavigation.dto.TimeTableDTO;
import com.example.miitnavigation.model.TimeTable;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TimeTableMapper {
    TimeTableMapper INSTANCE = Mappers.getMapper(TimeTableMapper.class);

    TimeTableDTO toDTO(TimeTable timeTable);
}
