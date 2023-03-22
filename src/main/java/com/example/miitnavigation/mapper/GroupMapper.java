package com.example.miitnavigation.mapper;

import com.example.miitnavigation.dto.GroupDTO;
import com.example.miitnavigation.model.StudyGroup;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GroupMapper {
    GroupMapper INSTANCE = Mappers.getMapper(GroupMapper.class);

    GroupDTO toDTO(StudyGroup studyGroup);
}
