package com.test.tutorplatform.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.tutorplatform.Entity.SessionEntity;


public interface SessionRepository extends JpaRepository<SessionEntity, Long> {
}

