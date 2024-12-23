package com.dydqja5750.gallery.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class GalleryService {

    @Value("${file.path}")
    private String upload;

    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    DateTimeFormatter folderFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");

    String time = now.format(formatter);
    String folderName = folderFormatter.format(now);


}
