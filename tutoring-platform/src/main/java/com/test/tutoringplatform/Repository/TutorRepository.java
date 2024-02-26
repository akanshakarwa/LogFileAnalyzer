package com.test.tutoringplatform.Repository;

public interface TutorRepository extends JpaRepository<Tutor, Long> {
    List<Tutor> findByExpertise(String expertise);
}