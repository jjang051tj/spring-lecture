package com.jjang051.comment.dto;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.jjang051.comment.entity.Member;

import lombok.RequiredArgsConstructor;

//@RequiredArgsConstructor
public class CustomUserDetails implements UserDetails {

  private final Member loggedMember;
  public CustomUserDetails(Member loggedMember) {
    this.loggedMember = loggedMember;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    Collection<GrantedAuthority> collection = new ArrayList<>();
    collection.add(new GrantedAuthority() {

      @Override
      public String getAuthority() {
        return loggedMember.getRole();
      }
    });
    return collection;
 }

  @Override
  public String getPassword() {
    return loggedMember.getPassword();
  }

  @Override
  public String getUsername() {
    // 시큐리티는 username을 아이디로 대신 사용하게끔 설계되어 있다. 
    // 만약 세팅을 userId로 했다면 userId를 던져야 한다. 그렇지 않다면 dto에 username을 만들어야 한다.
    return loggedMember.getUserId();
  }

}
