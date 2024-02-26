package com.test.tutoringplatform.Service;

@Service
public class RatingService {
    @Autowired
    private RatingRepository ratingRepository;

    public Rating rateTutor(Rating rating) {
        return ratingRepository.save(rating);
    }

    // Additional methods as needed
}