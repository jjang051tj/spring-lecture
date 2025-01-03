package com.jjang051.comment.service;

import java.lang.reflect.Member;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.jjang051.comment.dto.CustomUserDetails;
import com.jjang051.comment.repository.MemberRepository;
import com.jjang051.comment.social.GoogleUserInfo;
import com.jjang051.comment.social.SocialUserInfo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class OAuth2DetailsService extends DefaultOAuth2UserService {

  private final MemberRepository memberRepository;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  @Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest)  {

    OAuth2User oAuth2User = super.loadUser(userRequest);
    Map<String, Object> oauth2UserInfo = (Map)oAuth2User.getAttributes();
    log.info("oAuth2User.getAttributes()=={}",oAuth2User.getAttributes());
    String provider = userRequest.getClientRegistration().getRegistrationId();
    SocialUserInfo socialUserInfo = null;
    if(provider.equals("google")) {
      socialUserInfo = new GoogleUserInfo(oauth2UserInfo);
    }
    Member returnMember =null;
    Optional<Member> findedMember = memberRepository.findByUserId(socialUserInfo.getProviderId());
    if(findedMember.isPresent()) {
      returnMember = findedMember.get();
    } else {
      //강제회원가입시키는 코드를 작성
    }
		return new CustomUserDetails(null, null);
	}
}
