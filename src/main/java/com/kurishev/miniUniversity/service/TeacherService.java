package com.kurishev.miniUniversity.service;

import com.kurishev.miniUniversity.model.GroupEntity;
import com.kurishev.miniUniversity.model.StudentEntity;
import com.kurishev.miniUniversity.model.TeacherEntity;

import java.util.List;
import java.util.Set;

public interface TeacherService {
    TeacherEntity findByName(String name);
    Set<GroupEntity> findAllGroupsByTeacherName(String name);
    List<StudentEntity> findAllStudentsByTeacherName(String name);
    void save(TeacherEntity updatingTeacher);
}
