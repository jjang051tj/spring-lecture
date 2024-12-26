package com.jjang051.comment.service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
    Board board = Board.builder()
                  .title(title)
                  .content(content)
                  .regDate(LocalDateTime.now())
                  .build();
    boardRepository.save(board); // insert 
  }

  public List<Board> getList() {
    return boardRepository.findAll();
  }

  public Board getView(Long id) {
    Optional<Board> optionalBoard = boardRepository.findById(id);
    if(optionalBoard.isPresent()) {
      return optionalBoard.get();
    }
    return null;
  }
}
