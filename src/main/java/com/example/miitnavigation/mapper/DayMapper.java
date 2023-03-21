package com.example.miitnavigation.mapper;

import com.example.miitnavigation.dto.DayDTO;
import com.example.miitnavigation.model.Day;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DayMapper {
    DayMapper INSTANCE = Mappers.getMapper(DayMapper.class);

    DayDTO toDTO(Day day);
}
