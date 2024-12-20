package com.jjang051.member.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class MemberDto {
    private int no;

    @NotBlank(message = "ID는 필수입력사항입니다.")
    @Size(message = "ID는 3글자 이상 10글자 이하로 작성해 주세요.", min = 3,max = 10)
    private String userId;

    @NotBlank(message = "PASSWORD는 필수입력사항입니다.")
    @Size(message = "PASSWORD는 3글자 이상 10글자 이하로 작성해 주세요.", min = 3,max = 10)
    private String userPw;

    private String userName;

    @Email(message = "이메일 형식에 맞게 써주세요.")
    private String userEmail;
    private String tel;
    private int zipcode;
    private String address;
    private String regDate;
    private String addr01;
    private String addr02;

    private MultipartFile profile;

    private String originalProfile;
    private String renameProfile;
}
