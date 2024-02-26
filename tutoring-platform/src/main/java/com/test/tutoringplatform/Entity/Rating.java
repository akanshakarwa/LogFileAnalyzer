package com.test.tutoringplatform.Entity;

@Entity
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Tutor tutor;

    private int rating;

    private String comments;

    // Constructors, getters, and setters
}
