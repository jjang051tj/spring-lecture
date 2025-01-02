package com.jjang051.comment.service;

import java.util.Random;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MailService {
  private final JavaMailSender javaMailSender;
  private final MemberService memberService;

  //private String randomNumber;

  private String makeRandomNumber() {
    Random random = new Random();
    int randomNumber = 100000 + random.nextInt(900000);
    return Integer.toString(randomNumber);
  }


  public void sendMail(String userEmail) {
    MimeMessage message =  javaMailSender.createMimeMessage();
        try {
            message.setFrom("jjang051hta@naver.com");  // 보내는 사람
            message.setRecipients(MimeMessage.RecipientType.TO,userEmail);  // 받는 사람
            message.setSubject("안녕하세요.");
            String sendRandomNumber =  makeRandomNumber();
            message.setText("<h1 style='text-align:center'><a href='http://localhost:8080/member/login'>"+sendRandomNumber+"</a></h1>","UTF-8","html");
            javaMailSender.send(message);
            memberService.updatePassword(sendRandomNumber,"jjang051");
            
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
  }


  public String sendAuthMail(String email) {
    MimeMessage message =  javaMailSender.createMimeMessage();
        try {
            message.setFrom("jjang051hta@naver.com");  // 보내는 사람
            message.setRecipients(MimeMessage.RecipientType.TO,email);  // 받는 사람
            message.setSubject("이메일 인증번호");
            String sendRandomNumber =  makeRandomNumber();
            message.setText("<h1 style='text-align:center'>"+sendRandomNumber+"</h1>","UTF-8","html");
            javaMailSender.send(message);
            return sendRandomNumber;
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
  }
}
