package com.jjang051.comment.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.jjang051.comment.entity.Board;
import com.jjang051.comment.entity.Member;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDto {

  private Long id;

  @NotBlank(message = "아이디는 필수입력사항입니다.")
  private String userId;
  
  private String userName;
  private String userEmail;

  @NotBlank(message = "아이디는 필수입력사항입니다.")
  private String password;
  private LocalDateTime regDate;
  private String role;

  private String zipcode;
  private String addr01;
  private String addr02;
  private String tel;
  
   
  public static MemberDto fromEntity(Member member) {
    return MemberDto.builder()
          .id(member.getId())
          .userId(member.getUserId())
          .password(member.getPassword())
          .role(member.getRole())
          .regDate(member.getRegDate())
          .userEmail(member.getUserEmail())
          .userName(member.getUserName())
          .zipcode(member.getZipcode())
          .addr01(member.getAddr01())
          .addr02(member.getAddr02())
          .build();
  }
}
