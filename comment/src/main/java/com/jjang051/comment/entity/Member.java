package com.jjang051.comment.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "member_comment")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Member {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @Column(unique = true)
  private String userId;

  private String userName;

  @Column(unique = true)
  private String userEmail;

  private String password;

  private String role;

  private LocalDateTime regDate;

  @OneToMany
  private List<Board> boardList;

  @OneToMany
  private List<Comment> commentList;

  @Builder
  public Member(String userId,String userName, String userEmail, String password, LocalDateTime regDate) {
    this.userId=userId;
    this.userName = userName;
    this.userEmail = userEmail;
    this.password = password;
    this.regDate = regDate;
    //this.boardList = boardList;
  }
}
