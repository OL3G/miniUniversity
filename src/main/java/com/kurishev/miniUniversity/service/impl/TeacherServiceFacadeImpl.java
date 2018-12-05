package com.kurishev.miniUniversity.service.impl;

import com.kurishev.miniUniversity.model.GroupEntity;
import com.kurishev.miniUniversity.model.StudentEntity;
import com.kurishev.miniUniversity.model.TeacherEntity;
import com.kurishev.miniUniversity.model.forms.TeacherForm;
import com.kurishev.miniUniversity.service.GroupService;
import com.kurishev.miniUniversity.service.TeacherService;
import com.kurishev.miniUniversity.service.TeacherServiceFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class TeacherServiceFacadeImpl implements TeacherServiceFacade{
    @Autowired
    TeacherService teacherService;
    @Autowired
    GroupService groupService;

    @Transactional
    @Override
    public void addGroup(TeacherForm teacherForm) {
        TeacherEntity updatingTeacher = teacherService.findByName(teacherForm.getTeacher());
        GroupEntity addingGroup = groupService.findByGroup(teacherForm.getGroup());
        updatingTeacher.addGroup(addingGroup);
        teacherService.save(updatingTeacher);
    }

    @Transactional(readOnly = true)
    @Override
    public TeacherEntity findByName(String name) {
        return teacherService.findByName(name);
    }

    @Transactional(readOnly = true)
    @Override
    public Set<GroupEntity> findAllGroupsByTeacherName(String name) {
        return teacherService.findAllGroupsByTeacherName(name);
    }

    @Transactional(readOnly = true)
    @Override
    public List<StudentEntity> findAllStudentsByTeacherName(String name) {
        return teacherService.findAllStudentsByTeacherName(name);
    }

    @Transactional
    @Override
    public void save(TeacherEntity updatingTeacher) {
        teacherService.save(updatingTeacher);
    }
}
