package com.test.tutorplatform.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.tutorplatform.Entity.TutorEntity;
import com.test.tutorplatform.Service.TutorService;

@RestController
@RequestMapping("/tutors")
public class TutorController {
    @Autowired
    private TutorService tutorService;

    @PostMapping("/register")
    public TutorEntity registerTutor(@RequestBody TutorEntity tutor) {
        return tutorService.registerTutor(tutor);
    }

    @GetMapping("/subject")
    public List<TutorEntity> getTutorsBySubject(@RequestParam String expertise) {
        return tutorService.getTutorsBySubject(expertise);
    }

    @GetMapping("/{tutorId}")
    public TutorEntity getTutorById(@PathVariable Long tutorId) {
        return tutorService.getTutorById(tutorId);
    }

    // Additional methods as needed
}