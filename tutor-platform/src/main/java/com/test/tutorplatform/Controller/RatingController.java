package com.test.tutorplatform.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.tutorplatform.Entity.RatingEntity;
import com.test.tutorplatform.Service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    @PostMapping("/rate")
    public RatingEntity rateTutor(@RequestBody RatingEntity rating) {
        return ratingService.rateTutor(rating);
    }

    // Additional methods as needed
}