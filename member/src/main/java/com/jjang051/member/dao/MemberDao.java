package com.jjang051.member.dao;

import com.jjang051.member.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
public interface MemberDao {
    int signUp(MemberDto memberDto);
}
