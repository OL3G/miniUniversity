package com.kurishev.miniUniversity.service.impl;

import com.kurishev.miniUniversity.model.GroupEntity;
import com.kurishev.miniUniversity.model.StudentEntity;
import com.kurishev.miniUniversity.service.GroupService;
import com.kurishev.miniUniversity.service.GroupServiceFacade;
import com.kurishev.miniUniversity.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GroupServiceFacadeImpl implements GroupServiceFacade {
    @Autowired
    GroupService groupService;
    @Autowired
    StudentService studentService;

    @Transactional
    @Override
    public void addGroup(GroupEntity group) {
        studentService.saveAll(group.getStudents());
        groupService.save(group);
    }

    @Transactional(readOnly = true)
    @Override
    public GroupEntity findByGroup(String group) {
        return groupService.findByGroup(group);
    }

    @Transactional(readOnly = true)
    @Override
    public List<StudentEntity> findAllStudentsByGroupName(String group) {
        return groupService.findAllStudentsByGroupName(group);
    }
}
