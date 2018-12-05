package com.kurishev.miniUniversity.service.impl;

import com.kurishev.miniUniversity.model.GroupEntity;
import com.kurishev.miniUniversity.model.StudentEntity;
import com.kurishev.miniUniversity.repository.GroupRepository;
import com.kurishev.miniUniversity.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    GroupRepository groupRepository;

    @Transactional
    @Override
    public void save(GroupEntity group) {
        groupRepository.save(group);
    }

    @Transactional(readOnly = true)
    @Override
    public GroupEntity findByGroup(String group) {
        return groupRepository.findByGroup(group);
    }

    @Transactional(readOnly = true)
    @Override
    public List<StudentEntity> findAllStudentsByGroupName(String group) {
        GroupEntity groupEntity = groupRepository.findByGroup(group);
        return groupEntity.getStudents();
    }
}
