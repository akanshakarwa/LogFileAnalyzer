package com.test.tutorplatform.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.tutorplatform.Entity.RatingEntity;
import com.test.tutorplatform.Repository.RatingRepository;

@Service
public class RatingService {
    @Autowired
    private RatingRepository ratingRepository;

    public RatingEntity rateTutor(RatingEntity rating) {
        return ratingRepository.save(rating);
    }

    // Additional methods as needed
}