package com.jjang051.comment.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.jjang051.comment.entity.Board;
import com.jjang051.comment.entity.Comment;
import com.jjang051.comment.entity.Member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
public class BoardDto {
  
  private Long id;

  private String title;

  private String content;

  private LocalDateTime regDate;
  
  private Member writer;
  
  //private List<Comment> commentList;
 

  @Builder
  public BoardDto(Long id,String title,String content, LocalDateTime regDate, Member writer) {
    this.id= id;
    this.title=title;
    this.content=content;
    this.regDate = regDate;
    this.writer = writer;
  }

  public static Board toEntity(BoardDto boardDto) {
    return Board.builder()
          .id(boardDto.getId())
          .title(boardDto.getTitle())
          .content(boardDto.getContent())
          .writer(boardDto.getWriter())
          .regDate(boardDto.getRegDate())
          .build();
  }

}
