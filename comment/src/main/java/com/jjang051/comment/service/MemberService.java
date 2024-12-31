package com.jjang051.comment.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jjang051.comment.dto.MemberDto;
import com.jjang051.comment.entity.Member;
import com.jjang051.comment.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {

  private final MemberRepository memberRepository;

  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  public Member signIn(MemberDto memberDto) {
    Member member = Member.builder()
                    .userId(memberDto.getUserId())
                    .userName(memberDto.getUserName())
                    .userEmail(memberDto.getUserEmail())
                    .role("ROLE_USER")     
                    .password(bCryptPasswordEncoder.encode(memberDto.getPassword()))
                    .addr01(memberDto.getAddr01())
                    .addr02(memberDto.getAddr02())
                    .zipcode(memberDto.getZipcode())
                    .tel(memberDto.getTel())
                    .regDate(LocalDateTime.now())
                    .build();
    Member responseMember =  memberRepository.save(member);
    log.info("responseMember==={}",responseMember);
    return responseMember;
  }

  public Member modify(MemberDto memberDto) {
    Member member = Member.builder()
                    .id(memberDto.getId())
                    .userId(memberDto.getUserId())
                    .userName(memberDto.getUserName())
                    .userEmail(memberDto.getUserEmail())
                    .role("ROLE_USER")     
                    .password(bCryptPasswordEncoder.encode(memberDto.getPassword()))
                    .addr01(memberDto.getAddr01())
                    .addr02(memberDto.getAddr02())
                    .zipcode(memberDto.getZipcode())
                    .tel(memberDto.getTel())
                    .regDate(LocalDateTime.now())
                    .build();

    Optional<Member> optionalMember = memberRepository.findByUserId(memberDto.getUserId());
    Member findedMember =  null;
    if(optionalMember.isPresent()) {
      findedMember = optionalMember.get();
      log.info("member.getPassword()=={} / findedMember.getPassword()==={}", 
        memberDto.getPassword(),
        findedMember.getPassword()  
      );
      if(bCryptPasswordEncoder.matches(memberDto.getPassword(), findedMember.getPassword())) {
        return memberRepository.save(member);  

      } 
    }
    return null;
  }
}
