package com.example.miitnavigation.mapper;

import com.example.miitnavigation.dto.TimeDTO;
import com.example.miitnavigation.model.Time;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TimeMapper {
    TimeMapper INSTANCE = Mappers.getMapper(TimeMapper.class);

    TimeDTO toDTO(Time time);
}
