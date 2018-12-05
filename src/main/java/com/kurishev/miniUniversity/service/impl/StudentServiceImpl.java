package com.kurishev.miniUniversity.service.impl;

import com.kurishev.miniUniversity.model.StudentEntity;
import com.kurishev.miniUniversity.repository.StudentRepository;
import com.kurishev.miniUniversity.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Slf4j
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Transactional
    @Override
    public void saveAll(List<StudentEntity> students) {
        studentRepository.saveAll(students);
    }
}
