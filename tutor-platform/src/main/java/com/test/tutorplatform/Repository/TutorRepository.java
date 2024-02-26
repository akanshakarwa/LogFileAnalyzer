package com.test.tutorplatform.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.tutorplatform.Entity.TutorEntity;

public interface TutorRepository extends JpaRepository<TutorEntity, Long> {
    List<TutorEntity> findByExpertise(String expertise);
}

