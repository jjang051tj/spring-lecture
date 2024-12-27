package com.jjang051.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jjang051.review.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

}
