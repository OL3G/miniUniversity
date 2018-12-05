package com.kurishev.miniUniversity.repository;

import com.kurishev.miniUniversity.model.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
}
