package com.jjang051.comment.entity;


import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "board_comments")
@Getter
//@Setter 
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)   
  private Long id;

  private String title;

  private String content;

  private LocalDateTime regDate;

  @OneToMany(mappedBy = "board")   //1:N
  private List<Comment> commentList;

  @Builder
  public Board(String title,String content, LocalDateTime regDate) {
    this.title=title;
    this.content=content;
    this.regDate = regDate;
  }
}
