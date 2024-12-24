package com.jjang051.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jjang051.comment.entity.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

}
