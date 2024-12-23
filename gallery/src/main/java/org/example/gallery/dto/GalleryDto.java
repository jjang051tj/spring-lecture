package org.example.gallery.dto;

import jakarta.servlet.annotation.MultipartConfig;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@MultipartConfig
public class GalleryDto {
    private int id;
    @NotBlank(message = "제목은 필수 입력사항입니다")
    @Size(min = 1, max = 50, message = "최소 1자, 최대 50자 이내로 작성해주세요")
    private String title;
    @NotBlank(message = "내용은 필수 입력사항입니다")
    @Size(message = "최소 10자, 최대 1000자 이내로 작성해주세요", min = 10, max = 1000)
    private String description;
    @Range(max = 5, message = "점수는 0점에서 5점까지만 줄 수 있습니다")
    private Double point;
    @NotBlank(message = "카테고리는 필수 입력사항입니다")
    private String category;
    private MultipartFile img;
    private String originalFileName;
    private String renameFileName;
    private LocalDateTime regDate;

    @Builder
    public GalleryDto(String title, String description, Double point,
                      String category, MultipartFile img,
                      String originalFileName, String renameFileName) {
        this.title = title;
        this.description = description;
        this.point = point;
        this.category = category;
        this.img = img;
        this.originalFileName = originalFileName;
        this.renameFileName = renameFileName;
    }
}
