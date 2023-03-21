package com.example.miitnavigation.mapper;

import com.example.miitnavigation.dto.TeacherDTO;
import com.example.miitnavigation.model.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TeacherMapper {
    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    TeacherDTO toDTO(Teacher teacher);
}
