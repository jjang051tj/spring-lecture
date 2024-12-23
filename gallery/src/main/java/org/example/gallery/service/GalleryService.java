package org.example.gallery.service;

import jakarta.servlet.annotation.MultipartConfig;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.coobird.thumbnailator.Thumbnails;
import org.example.gallery.dao.GalleryDao;
import org.example.gallery.dto.GalleryDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
@MultipartConfig
public class GalleryService {

    @Value("${file.path}")
    private String filePath;

    public final GalleryDao galleryDao;

    public int write(GalleryDto galleryDto) {
        int result = 0;
        if (galleryDto.getImg() != null) {
            String writeFile = galleryDto.getImg().getOriginalFilename();
            if (writeFile != null && writeFile.contains(".")) {
                galleryDto.setOriginalFileName(writeFile);

                String onlyFileName = writeFile.substring(0, writeFile.lastIndexOf("."));
                String extension = writeFile.substring(writeFile.lastIndexOf("."));

                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");  
                String writeTime = now.format(format);

                DateTimeFormatter folderFormat = DateTimeFormatter.ofPattern("yyyyMMdd");
                String folderName = now.format(folderFormat);

                String renameFileName = onlyFileName + "_" + writeTime + extension;   

                Path folderPath = Paths.get(filePath+folderName);

                galleryDto.setRenameFileName(folderName +"/"+ renameFileName);
                try {
                    // 폴더가 없으면 만들어라
                    if (Files.notExists(folderPath)) {
                        Files.createDirectory(folderPath);
                    }

                    Path targetFile = Paths.get(filePath + folderName + "/" + renameFileName);
                    galleryDto.getImg().transferTo(targetFile.toFile());
                    // Thumbnails.of(targetFile.toFile())
                    //         .size(100, 100)
                    //         .toFile(targetFile.toFile());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return galleryDao.write(galleryDto);
    }

    public List<GalleryDto> getAllList() {
        return galleryDao.getAllList();
    }
}
