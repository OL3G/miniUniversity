package com.kurishev.miniUniversity.service;

import com.kurishev.miniUniversity.model.StudentEntity;

import java.util.List;

public interface StudentService {
    void saveAll(List<StudentEntity> students);
}
