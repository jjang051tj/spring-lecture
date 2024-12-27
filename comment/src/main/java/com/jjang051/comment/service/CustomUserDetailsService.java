package com.jjang051.comment.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jjang051.comment.dto.CustomUserDetails;
import com.jjang051.comment.entity.Member;
import com.jjang051.comment.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

  private final MemberRepository memberRepository;


  @Override
  public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
    Optional<Member> loggedMember = memberRepository.findByUserId(userId);
    if(loggedMember.isPresent()) {
      return new CustomUserDetails(loggedMember.get());
    }
    throw new UsernameNotFoundException("아이디 패스워드 확인해 주세요.");
  }

}
