package com.jjang051.member.service;

import com.jjang051.member.dao.MemberDao;
import com.jjang051.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor
@Service
@Slf4j
public class MemberService {

    @Value("${file.path}")
    private String upload;


    private final MemberDao memberDao;

    public int signup(MemberDto memberDto) {

        //db입력을 여기서 한다.
        //mybatis,jpa
        //business logic
        log.info("memberDto==={}",memberDto.getUserId());
        log.info("memberDto.getProfile()==={}",memberDto.getProfile().toString());
        log.info("memberDto.getProfile()==={}",memberDto.getProfile().getOriginalFilename());

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        DateTimeFormatter folderFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        String time = now.format(formatter);
        String folderName = upload+now.format(folderFormatter);
        File folder = new File(folderName);
        if(!folder.exists()){
            folder.mkdir();
        }

        String originalFilename = memberDto.getProfile().getOriginalFilename();
        String fileName = originalFilename.substring(0,originalFilename.lastIndexOf("."));
        String extension = originalFilename.substring(originalFilename.lastIndexOf(".")+1);
        String renameFile = fileName + "_" + time + "." + extension;
        File targetFile = new File(folderName,renameFile);
        try {
            memberDto.getProfile().transferTo(targetFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        log.info("renameFile==={}", renameFile);
        //renameProifle  slide02_20241220110424.jpg

        log.info("fileName==={}",fileName);
        log.info("extension==={}",extension);


        System.out.println("log");


        memberDto.setAddress(memberDto.getAddr01()+"/"+memberDto.getAddr02());
        memberDto.setOriginalProfile("");
        memberDto.setRenameProfile("");
        //return memberDao.signUp(memberDto);
        //날짜별 폴더 만들고 파일을 업로드
        return 0;
    }

    public MemberDto login(MemberDto memberDto) {
        return memberDao.login(memberDto);
    }

    public int idCheck(String userId) {
        return memberDao.idCheck(userId);
    }

    public MemberDto findById(String userId) {
        return memberDao.findById(userId);
    }

    public int deleteMember(String userId, String userPw) {
        return memberDao.deleteMember(userId,userPw);
    }

    public int deleteMember(MemberDto memberDto) {
        return memberDao.deleteMembeAjax(memberDto);
    }


}
