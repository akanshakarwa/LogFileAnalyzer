package com.test.tutorplatform.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.tutorplatform.Entity.SessionEntity;
import com.test.tutorplatform.Service.SessionService;

@RestController
@RequestMapping("/sessions")
public class SessionController {
    @Autowired
    private SessionService sessionService;

    @PostMapping("/book")
    public SessionEntity bookSession(@RequestBody SessionEntity session) {
        return sessionService.bookSession(session);
    }

    @GetMapping("/{sessionId}")
    public SessionEntity getSessionById(@PathVariable Long sessionId) {
        return sessionService.getSessionById(sessionId);
    }

    // Additional methods as needed
}