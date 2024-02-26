package com.test.tutorplatform.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.tutorplatform.Entity.StudentEntity;
import com.test.tutorplatform.Service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/register")
    public StudentEntity registerStudent(@RequestBody StudentEntity student) {
        return studentService.registerStudent(student);
    }

    
}