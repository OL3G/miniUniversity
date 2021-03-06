package com.kurishev.miniUniversity.service;

import com.kurishev.miniUniversity.model.GroupEntity;
import com.kurishev.miniUniversity.model.StudentEntity;

import java.util.List;

public interface GroupServiceFacade {
    void addGroup(GroupEntity group);
    GroupEntity findByGroup(String group);

    List<StudentEntity> findAllStudentsByGroupName(String group);
}
