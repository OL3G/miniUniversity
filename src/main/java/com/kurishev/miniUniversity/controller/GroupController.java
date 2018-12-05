package com.kurishev.miniUniversity.controller;

import com.kurishev.miniUniversity.model.GroupEntity;

import com.kurishev.miniUniversity.model.StudentEntity;
import com.kurishev.miniUniversity.service.GroupServiceFacade;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupServiceFacade groupServiceFacade;

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<GroupEntity> addGroup(@RequestBody final GroupEntity group) {
        groupServiceFacade.addGroup(group);
        return new ResponseEntity<GroupEntity>(groupServiceFacade.findByGroup(group.getGroup()), HttpStatus.CREATED);
    }

    @PostMapping(value = "/allStudents", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<StudentEntity>> allStudents(@RequestBody final GroupEntity group) {
        List<StudentEntity> students = groupServiceFacade.findAllStudentsByGroupName(group.getGroup());
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}
