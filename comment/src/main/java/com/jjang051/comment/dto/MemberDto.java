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
  private String userId;
  private String userName;
  private String userEmail;
  private String password;
  private LocalDateTime regDate;
  private String role;

  public static MemberDto fromEntity(Member member) {
    return MemberDto.builder()
          .userId(member.getUserId())
          .password(member.getPassword())
          .role(member.getRole())
          .regDate(member.getRegDate())
          .userEmail(member.getUserEmail())
          .userName(member.getUserName())
          .build();
  }
}
