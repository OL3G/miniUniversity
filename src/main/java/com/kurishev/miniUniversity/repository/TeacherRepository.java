package com.kurishev.miniUniversity.repository;

import com.kurishev.miniUniversity.model.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<TeacherEntity, Long> {
    TeacherEntity findByName(String name);
}

