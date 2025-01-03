package com.jjang051.comment.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jjang051.comment.entity.Board;
import com.jjang051.comment.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
  Optional<Member> findByUserId(String userId);

  @Query("select b from Board b join fetch b.writer where b.writer.userId = :userId")
  List<Board> findAllBoards(@Param("userId") String userId);
}

  
