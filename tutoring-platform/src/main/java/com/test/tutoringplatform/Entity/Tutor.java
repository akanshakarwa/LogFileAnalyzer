package com.test.tutoringplatform.Entity;

@Entity
public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String expertise;

    // Constructors, getters, and setters
}