package com.jjang051.comment.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.jjang051.comment.entity.Board;
import com.jjang051.comment.entity.Comment;
import com.jjang051.comment.repository.CommentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {
  private final CommentRepository commentRepository;

  public void write(String content, Board board) {
    Comment comment = Comment.builder()
    .board(board)
    .content(content)
    .regDate(LocalDateTime.now())
    .build();
    commentRepository.save(comment);
  }

  public void delete(Long id) {
    commentRepository.deleteById(id);
  }
}
