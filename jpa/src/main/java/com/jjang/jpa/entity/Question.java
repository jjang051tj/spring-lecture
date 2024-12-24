package com.jjang.jpa.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
// @SequenceGenerator(name="question_sequence_generator",
//     sequenceName = "seq_question",
//     initialValue = 1000,
//     allocationSize = 1
// )
//@Table(name = "table_question")
public class Question {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
 
  private Integer id;
  private String title;
  private String content;
  private LocalDateTime regDate;

  @Builder
  public Question(String title,String content, LocalDateTime regDate) {
    this.title=title;
    this.content= content;
    this.regDate = regDate;
  }
}
