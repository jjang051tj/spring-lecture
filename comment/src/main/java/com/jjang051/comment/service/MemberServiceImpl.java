package com.jjang051.comment.service;

import java.lang.reflect.Member;

import com.jjang051.comment.dto.MemberDto;

public interface MemberServiceImpl {
  Member signIn(MemberDto memberDto);
}
