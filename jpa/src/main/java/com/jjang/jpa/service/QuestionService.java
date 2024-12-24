package com.jjang.jpa.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjang.jpa.entity.Question;
import com.jjang.jpa.repository.QuestionRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class QuestionService {
  
  private final QuestionRepository questionRepository;

  public void write(String title,String content) {
    Question question = Question.builder()
                        .title(title)
                        .content(content)
                        .regDate(LocalDateTime.now())
                        .build();
    log.info("title==={},content==={}",title,content);
    Question savedQuestion = questionRepository.save(question);
    log.info("savedQuestion==={}",savedQuestion);
  }
  public List<Question> getList() {
    return questionRepository.findAll();
  }

}
