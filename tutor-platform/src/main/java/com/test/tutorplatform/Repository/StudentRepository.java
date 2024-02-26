package com.test.tutorplatform.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.tutorplatform.Entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
}

