package com.example.miitnavigation.mapper;

import com.example.miitnavigation.dto.AuditoriumDTO;
import com.example.miitnavigation.model.Auditorium;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuditoriumMapper {
    AuditoriumMapper INSTANCE = Mappers.getMapper(AuditoriumMapper.class);

    AuditoriumDTO toDTO(Auditorium auditorium);
}
