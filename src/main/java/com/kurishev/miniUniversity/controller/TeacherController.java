package com.kurishev.miniUniversity.controller;

import com.kurishev.miniUniversity.model.GroupEntity;
import com.kurishev.miniUniversity.model.StudentEntity;
import com.kurishev.miniUniversity.model.TeacherEntity;
import com.kurishev.miniUniversity.model.forms.TeacherForm;
import com.kurishev.miniUniversity.service.TeacherServiceFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherServiceFacade teacherServiceFacade;

    @PostMapping(value = "/addGroup", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<TeacherEntity> addGroup(@RequestBody final TeacherForm teacherForm) {
        teacherServiceFacade.addGroup(teacherForm);
        return new ResponseEntity<>(teacherServiceFacade.findByName(teacherForm.getTeacher()), HttpStatus.OK);
    }

    @PostMapping(value = "/groups", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Set<GroupEntity>> findAllGroupsByTeacherName(@RequestBody final TeacherForm teacherForm) {
        return new ResponseEntity<>(teacherServiceFacade.findAllGroupsByTeacherName(teacherForm.getTeacher()), HttpStatus.OK);
    }

    @PostMapping(value = "/students", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<StudentEntity>> findAllStudentsByTeacherName(@RequestBody final TeacherForm teacherForm) {
        return new ResponseEntity<>(teacherServiceFacade.findAllStudentsByTeacherName(teacherForm.getTeacher()), HttpStatus.OK);
    }
}
