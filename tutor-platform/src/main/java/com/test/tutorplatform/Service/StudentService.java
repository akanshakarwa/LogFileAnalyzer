package com.test.tutorplatform.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.tutorplatform.Entity.StudentEntity;
import com.test.tutorplatform.Repository.StudentRepository;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public StudentEntity registerStudent(StudentEntity student) {
        return studentRepository.save(student);
    }

    // Additional methods as needed
}
