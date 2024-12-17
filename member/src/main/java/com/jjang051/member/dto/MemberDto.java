package com.jjang051.member.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class MemberDto {
    private int no;
    private String userId;
    private String userPw;
    private String userName;
    private String userEmail;
    private String tel;
    private int zipcode;
    private String address;
    private String regDate;
    private String originalProfile;
    private String renameProfile;
}
