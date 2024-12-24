package com.jjang051.comment.service;


import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.jjang051.comment.entity.Board;
import com.jjang051.comment.entity.Member;
import com.jjang051.comment.repository.BoardRepository;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

  private final BoardRepository boardRepository;

  public void write(String title,String content) {
    Member member = Member.builder()
                            .userId("jjang051")
                            .userName("장성호")
                            .password("1234")
                            .userEmail("jjang051@hanmail.net")
                          .build();
    Board board = Board.builder()
                  .title(title)
                  .content(content)
                  .regDate(LocalDateTime.now())
                  //.writer(member)
                  .build();

    boardRepository.save(board);

  }

}
