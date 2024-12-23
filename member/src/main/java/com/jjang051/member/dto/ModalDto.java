package com.jjang051.member.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ModalDto {
    private boolean isShow;
    private String title;
    private String content;
}
