package com.jjang051.comment.service;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MailService03 {

  private final JavaMailSender javaMailSender;

  
  public void sendMail() {
    MimeMessage message = javaMailSender.createMimeMessage();
    try {
      message.setFrom("jjang051hta@naver.com");
      message.setRecipients(MimeMessage.RecipientType.TO, "jjang051@hanmail.net");
      message.setSubject("비밀번호 변경");
      message.setText("<h1>1234</h1>","UTF-8","html");
      javaMailSender.send(message);
    } catch (MessagingException e) {
      e.printStackTrace();
    }
  }

}
