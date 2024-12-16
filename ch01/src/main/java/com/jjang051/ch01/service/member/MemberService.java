package com.jjang051.ch01.service.member;

import org.springframework.stereotype.Service;

@Service
public class MemberService {
    public boolean login(String userId,String userPw) {
        if(userId.equals("jjang051") && userPw.equals("1234")) {
            return true;
        }
        return false;
    }
}
