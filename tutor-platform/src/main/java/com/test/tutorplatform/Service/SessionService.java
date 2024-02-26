package com.test.tutorplatform.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.tutorplatform.Entity.SessionEntity;
import com.test.tutorplatform.Repository.SessionRepository;

@Service
public class SessionService {
    @Autowired
    private SessionRepository sessionRepository;

    public SessionEntity bookSession(SessionEntity session) {
        return sessionRepository.save(session);
    }

    public SessionEntity getSessionById(Long sessionId) {
        return sessionRepository.findById(sessionId).orElse(null);
    }

    // Additional methods as needed
}