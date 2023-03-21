package com.example.miitnavigation.repository;

import com.example.miitnavigation.model.GroupsTimetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupsTimetableRepository extends JpaRepository<GroupsTimetable, Long> {
}
