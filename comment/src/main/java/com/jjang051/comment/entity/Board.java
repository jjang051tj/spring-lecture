package com.jjang051.comment.entity;


import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "board_comments")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Board {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)   
  private Long id;

  private String title;

  private String content;

  private LocalDateTime regDate;

  @ManyToOne
  //@JoinColumn(name="writerId",referencedColumnName = "userId")
  private Member writer;

  @OneToMany(mappedBy = "board", cascade = CascadeType.REMOVE)   //1:N
  private List<Comment> commentList;

  

  @Builder
  public Board(Long id,String title,String content, LocalDateTime regDate, Member writer) {
    this.id=id;
    this.title=title;
    this.content=content;
    this.regDate = regDate;
    this.writer = writer;
  }
}
