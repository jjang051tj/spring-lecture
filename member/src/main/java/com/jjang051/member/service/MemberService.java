package com.jjang051.member.service;

import com.jjang051.member.dao.MemberDao;
import com.jjang051.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberDao memberDao;

    public int signup(MemberDto memberDto) {

        //db입력을 여기서 한다.
        //mybatis,jpa
        //business logic
        memberDto.setAddress(memberDto.getAddr01()+"/"+memberDto.getAddr02());
        memberDto.setOriginalProfile("");
        memberDto.setRenameProfile("");
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
}
