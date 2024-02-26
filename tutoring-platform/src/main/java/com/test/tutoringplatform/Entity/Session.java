package com.test.tutoringplatform.Entity;

@Entity
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Tutor tutor;

    @ManyToOne
    private Student student;

    private LocalDateTime startTime;

    // Constructors, getters, and setters
}
