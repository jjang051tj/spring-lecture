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
        LocalDateTime now = LocalDateTime.now(); //오늘날짜
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss"); //이미지 리네임 저장용
        DateTimeFormatter folderFormatter = DateTimeFormatter.ofPattern("yyyyMMdd"); // 폴더 저장용

        String time = now.format(formatter);
        String folderName = now.format(folderFormatter);  //폴더 이름

        File folder = new File(folderName);
        if(!folder.exists()){
            folder.mkdir();
        }
        String originalFilename = memberDto.getProfile().getOriginalFilename();

        String fileName = originalFilename.substring(0,originalFilename.lastIndexOf(".")); //원본 파일 이름
        String extension = originalFilename.substring(originalFilename.lastIndexOf(".")+1); //원본 파일 확장자

        String renameFile = fileName + "_" + time + "." + extension; // 원본파일_20241221111022.jpg
        File targetFile = new File(upload+folderName,renameFile); // 파일 생성하고
        try {
            memberDto.getProfile().transferTo(targetFile);  // 폴더에 옮기기
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        memberDto.setAddress(memberDto.getAddr01()+"/"+memberDto.getAddr02());
        memberDto.setOriginalProfile(originalFilename); //원본 파일이름 저장
        memberDto.setRenameProfile(folderName+"/"+renameFile); // 바뀐 이름 저장
        return memberDao.signUp(memberDto);
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
