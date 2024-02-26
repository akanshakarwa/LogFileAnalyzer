package com.test.tutoringplatform.Service;

@Service
public class TutorService {
    @Autowired
    private TutorRepository tutorRepository;

    public Tutor registerTutor(Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    public List<Tutor> getTutorsBySubject(String expertise) {
        return tutorRepository.findByExpertise(expertise);
    }

    public Tutor getTutorById(Long tutorId) {
        return tutorRepository.findById(tutorId).orElse(null);
    }

    // Additional methods as needed
}
