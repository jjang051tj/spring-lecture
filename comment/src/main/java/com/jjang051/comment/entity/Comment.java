package com.jjang051.comment.entity;

import java.time.LocalDateTime;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="comments")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  private String content;

  private LocalDateTime regDate;

  @ManyToOne
  @JoinColumn(name = "boardId")
  private Board board;

  @Builder
  public Comment(String content,LocalDateTime regDate, Board board) {
    this.board = board;
    this.content= content;
    this.regDate=regDate;
  }
}
