package com.example.miitnavigation.mapper;

import com.example.miitnavigation.dto.GroupTimetableDTO;
import com.example.miitnavigation.model.GroupsTimetable;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubjectMapper {
    SubjectMapper INSTANCE = Mappers.getMapper(SubjectMapper.class);

    GroupTimetableDTO toDTO(GroupsTimetable groupsTimetable);
}
