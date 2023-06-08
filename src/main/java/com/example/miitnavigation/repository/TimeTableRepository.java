package com.example.miitnavigation.repository;

import com.example.miitnavigation.model.TimeTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeTableRepository extends JpaRepository<TimeTable, Long> {
    @Query("SELECT t FROM TimeTable t JOIN FETCH t.subject JOIN FETCH t.teacher JOIN FETCH t.time JOIN FETCH t.auditorium")
    List<TimeTable> findAllWithFetch();

    @Query("SELECT CASE WHEN COUNT(t) > 0 THEN true ELSE false END FROM TimeTable t JOIN t.groupsTimetableList g WHERE g.studyGroup.id = :groupId")
    boolean existsByGroupId(Long groupId);

//    @Query("SELECT tt FROM TimeTable tt JOIN tt.groupsTimetableList gtl JOIN gtl.studyGroup sg WHERE sg.id = :groupId")
//    List<TimeTable> findByStudyGroup(@Param("groupId") Long groupId);
}
