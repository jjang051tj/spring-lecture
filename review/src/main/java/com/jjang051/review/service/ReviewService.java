package com.jjang051.review.service;

import org.springframework.stereotype.Service;

import com.jjang051.review.entity.Review;
import com.jjang051.review.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReviewService {
  private final ReviewRepository reviewRepository;
  public void write(String title, String content) {
    Review saveReview = Review.builder()
                              .title(title)
                              .content(content)
                              .build();
    reviewRepository.save(saveReview);
  }
}
