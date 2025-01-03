package com.jjang051.comment.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.jjang051.comment.entity.Member;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
public class CustomUserDetails implements UserDetails,OAuth2User {

  private final Member loggedMember;
  private Map<String,Object> attributes;
  
  public CustomUserDetails(Member loggedMember) {
    this.loggedMember = loggedMember;
  }  
  public CustomUserDetails(Member loggedMember, Map<String,Object> attributes) {
    this.loggedMember = loggedMember;
    this.attributes = attributes;
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

  @Override
  public Map<String, Object> getAttributes() {
    return attributes;
  }

  @Override
  public String getName() {
      return (String)attributes.get("name");
    
  }

}
