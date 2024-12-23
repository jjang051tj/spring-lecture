package com.dydqja5750.gallery.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor

public class GalleryDto {
    private int id;

    @NotBlank(message = "제목은 필수 입력 사항입니다.")
    @Size(message = "제목은 1글자 이상 50글자 이하로 작성해 주세요.",min = 1,max = 50)
    private String title;

    @Size(message = "내용은 10글자 이상 1000글자 이하로 작성해 주세요.",min = 1,max = 1000)
    private String description;

    @Size(message = "포인트는 5글자 이하로 작성해 주세요.",min = 0,max = 5)
    private Double point;

    @NotBlank(message = "category는 필수 입력 사항입니다.")
    private String category;

    @NotBlank(message = "파일을 첨부해 주세요.")
    private MultipartFile img;

    private String originalFilename;

    private String renameFileName;

    private LocalDateTime regDate;

    @Builder
    public GalleryDto(String title, String description, Double point, String category, MultipartFile img, String originalFilename, String renameFileName, LocalDateTime regDate) {
        this.title = title;
        this.description = description;
        this.point = point;
        this.category = category;
        this.img = img;
        this.originalFilename = originalFilename;
        this.renameFileName = renameFileName;
        this.regDate = regDate;
    }
}
