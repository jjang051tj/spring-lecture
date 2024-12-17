package com.jjang051.request.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {
    private String userName;
    private String userPw;
    private String userId;
    private String tel;
}
