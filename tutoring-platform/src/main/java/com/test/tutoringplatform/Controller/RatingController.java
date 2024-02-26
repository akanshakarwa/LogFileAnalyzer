package com.test.tutoringplatform.Controller;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    @PostMapping("/rate")
    public Rating rateTutor(@RequestBody Rating rating) {
        return ratingService.rateTutor(rating);
    }

    // Additional methods as needed
}
