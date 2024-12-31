package com.jjang051.comment.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {

  @NotBlank(message = "아이디는 필수입력사항입니다.")
  private String userId;

  @NotBlank(message = "패스워드는 필수입력사항입니다.")
  private String password;
  
}
