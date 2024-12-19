package com.jjang051.member.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ToastDto {
    private boolean isShow;
    private String title;
    private String content;
}
