package com.test.tutorplatform.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.tutorplatform.Entity.RatingEntity;

public interface RatingRepository extends JpaRepository<RatingEntity, Long> {
}

