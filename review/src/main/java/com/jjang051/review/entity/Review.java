package com.jjang051.review.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class Review {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  private String title;

  private String content;

  private LocalDateTime regDate;


  @Builder
  public Review(String title,String content, LocalDateTime regDate) {
    this.title=title;
    this.content= content;
    this.regDate = regDate;

  }



}
