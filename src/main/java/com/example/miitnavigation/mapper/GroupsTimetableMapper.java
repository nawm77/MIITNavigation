package com.example.miitnavigation.mapper;

import com.example.miitnavigation.dto.GroupTimetableDTO;
import com.example.miitnavigation.model.GroupsTimetable;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GroupsTimetableMapper {
    GroupsTimetableMapper INSTANCE = Mappers.getMapper(GroupsTimetableMapper.class);

    GroupTimetableDTO toDTO(GroupsTimetable groupsTimetable);
}
