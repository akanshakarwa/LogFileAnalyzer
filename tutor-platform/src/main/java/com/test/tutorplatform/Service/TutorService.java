package com.test.tutorplatform.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.tutorplatform.Entity.TutorEntity;
import com.test.tutorplatform.Repository.TutorRepository;

@Service
public class TutorService {
    @Autowired
    private TutorRepository tutorRepository;

    public TutorEntity registerTutor(TutorEntity tutor) {
        return tutorRepository.save(tutor);
    }

    public List<TutorEntity> getTutorsBySubject(String expertise) {
        return tutorRepository.findByExpertise(expertise);
    }

    public TutorEntity getTutorById(Long tutorId) {
        return tutorRepository.findById(tutorId).orElse(null);
    }

    // Additional methods as needed
}