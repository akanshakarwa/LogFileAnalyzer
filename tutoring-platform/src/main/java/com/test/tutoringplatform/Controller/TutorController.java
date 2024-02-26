package com.test.tutoringplatform.Controller;

@RestController
@RequestMapping("/tutors")
public class TutorController {
    @Autowired
    private TutorService tutorService;

    @PostMapping("/register")
    public Tutor registerTutor(@RequestBody Tutor tutor) {
        return tutorService.registerTutor(tutor);
    }

    @GetMapping("/subject")
    public List<Tutor> getTutorsBySubject(@RequestParam String expertise) {
        return tutorService.getTutorsBySubject(expertise);
    }

    @GetMapping("/{tutorId}")
    public Tutor getTutorById(@PathVariable Long tutorId) {
        return tutorService.getTutorById(tutorId);
    }

    // Additional methods as needed
}