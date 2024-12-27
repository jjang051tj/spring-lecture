package com.jjang051.comment.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jjang051.comment.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
  Optional<Member> findByUserId(String userId);
}

  
