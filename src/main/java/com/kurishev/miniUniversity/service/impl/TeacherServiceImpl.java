package com.kurishev.miniUniversity.service.impl;

import com.kurishev.miniUniversity.model.GroupEntity;
import com.kurishev.miniUniversity.model.StudentEntity;
import com.kurishev.miniUniversity.model.TeacherEntity;
import com.kurishev.miniUniversity.repository.TeacherRepository;
import com.kurishev.miniUniversity.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherRepository teacherRepository;

    @Transactional(readOnly = true)
    @Override
    public TeacherEntity findByName(String name) {
        return teacherRepository.findByName(name);
    }

    @Transactional(readOnly = true)
    @Override
    public Set<GroupEntity> findAllGroupsByTeacherName(String name) {
        return teacherRepository.findByName(name).getGroups();
    }

    @Transactional(readOnly = true)
    @Override
    public List<StudentEntity> findAllStudentsByTeacherName(String name) {
        TeacherEntity teacherEntity = teacherRepository.findByName(name);
        Set<GroupEntity> groups = teacherEntity.getGroups();
        List<StudentEntity> students = new ArrayList<>();
        for (GroupEntity group: groups) {
            students.addAll(group.getStudents());
        }
        return students;
    }

    @Transactional
    @Override
    public void save(TeacherEntity updatingTeacher) {
        teacherRepository.save(updatingTeacher);
    }
}
