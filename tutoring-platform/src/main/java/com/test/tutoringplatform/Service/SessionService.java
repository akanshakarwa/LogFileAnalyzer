package com.test.tutoringplatform.Service;

@Service
public class SessionService {
    @Autowired
    private SessionRepository sessionRepository;

    public Session bookSession(Session session) {
        return sessionRepository.save(session);
    }

    public Session getSessionById(Long sessionId) {
        return sessionRepository.findById(sessionId).orElse(null);
    }

    // Additional methods as needed
}