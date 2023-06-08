package com.example.miitnavigation.repository;

import com.example.miitnavigation.model.GroupsTimetable;
import com.example.miitnavigation.model.TimeTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupsTimetableRepository extends JpaRepository<GroupsTimetable, Long> {
    @Query("SELECT tt FROM GroupsTimetable gt JOIN gt.timeTable tt WHERE gt.studyGroup.id = :groupId")
    List<TimeTable> findTimeTableByGroupId(@Param("groupId") Long groupId);
}
