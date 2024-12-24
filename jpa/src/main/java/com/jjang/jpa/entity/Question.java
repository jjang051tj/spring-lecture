package com.jjang.jpa.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
//@Table(name = "table_question")
public class Question {

  @Id
  private Integer id;

  private String title;
  private String content;
  private LocalDateTime regDate;
}
