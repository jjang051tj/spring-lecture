package com.jjang051.comment.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "boardId")
  @JsonIgnore
  private Board board;

  @ManyToOne
  @JoinColumn(name="writerId",referencedColumnName = "userId")
  private Member writer;

  @Builder
  public Comment(String content,LocalDateTime regDate, Board board, Member writer) {
    this.board = board;
    this.content= content;
    this.regDate=regDate;
    this.writer = writer;
  }
}
