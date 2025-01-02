package com.jjang051.comment.service;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MailService {
  private final JavaMailSender javaMailSender;

  public void sendMail() {
    MimeMessage message =  javaMailSender.createMimeMessage();
        try {
            message.setFrom("jjang051hta@naver.com");  // 보내는 사람
            message.setRecipients(MimeMessage.RecipientType.TO,"jjang051@hanmail.net");  // 받는 사람
            message.setSubject("안녕하세요.");
            message.setText("1234","UTF-8","html");
            javaMailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
  }
}
