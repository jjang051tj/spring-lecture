package com.jjang051.member.dao;

import com.jjang051.member.dto.MemberDto;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;


@Mapper
public interface MemberDao {

//    @Insert("insert into member values" +
//            "(SEQ_MEMBER.nextval,#{userId},#{userPw},#{userName},#{userEmail}," +
//            "#{zipcode},#{address},#{tel},#{originalProfile},#{renameProfile},sysdate)")
    int signUp(MemberDto memberDto);

    //@Select("select * from member where userId=#{userId} and userPw = #{userPw}")
    MemberDto login(MemberDto memberDto);

    @Select("select count(*) as count from member where userId = #{userId}")
    int idCheck(@Param("userId") String userId);

    @Select("select * from member where userId = #{userId}")
    MemberDto findById(@Param("userId") String userId);

    @Delete("delete from member where userId = #{userId} and userPw = #{userPw}")
    int deleteMember(@Param("userId") String userId, @Param("userPw") String userPw);
}
