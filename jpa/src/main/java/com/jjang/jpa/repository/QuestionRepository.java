package com.jjang.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jjang.jpa.entity.Question;
import java.util.List;


public interface QuestionRepository extends JpaRepository<Question,Integer> {
  //여기다가 필요하면 method를 만들어 쓰면 된다. 
  //Question findBySubject(String subject);
}
