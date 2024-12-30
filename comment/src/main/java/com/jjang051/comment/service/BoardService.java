package com.jjang051.comment.service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jjang051.comment.dto.BoardDto;
import com.jjang051.comment.entity.Board;
import com.jjang051.comment.entity.Member;
import com.jjang051.comment.repository.BoardRepository;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardService {

  private final BoardRepository boardRepository;

  public void write(BoardDto boardDto) {
    Board board = BoardDto.toEntity(boardDto);
    boardRepository.save(board); // insert 
  }

  public void write(String title,String content,Member writer) {
    Board board = Board.builder()
      .title(title)
      .content(content)
      .regDate(LocalDateTime.now())
      .writer(writer)
      .build();
    boardRepository.save(board); // insert 
  }
 


  public List<Board> getList() {
    Sort sort = Sort.by(Sort.Order.desc("id"));
    return boardRepository.findAll(sort);
  }

  public Board getView(Long id) {
    Optional<Board> optionalBoard = boardRepository.findById(id);
    if(optionalBoard.isPresent()) {
      return optionalBoard.get();
    }
    return null;
  }
}
