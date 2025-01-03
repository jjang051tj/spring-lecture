package com.jjang051.comment.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.jjang051.comment.dto.CustomUserDetails;
import com.jjang051.comment.entity.Member;
import com.jjang051.comment.repository.MemberRepository;
import com.jjang051.comment.social.GoogleUserInfo;
import com.jjang051.comment.social.SocialUserInfo;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OAuth2DetailsService extends DefaultOAuth2UserService {

    //  변수들이 들어온다.
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {


        OAuth2User oAuth2User = super.loadUser(userRequest);
        log.info("userRequest=={}",userRequest);

        Map<String,Object> ouath2UserInfo =  (Map)oAuth2User.getAttributes();
        log.info("oAuth2User.getAttributes()=={}",oAuth2User.getAttributes());
        log.info("id==={}",userRequest.getClientRegistration().getRegistrationId());
        String provider = userRequest.getClientRegistration().getRegistrationId();
        SocialUserInfo socialUserInfo = null;
        if(provider.equals("google")) {
          socialUserInfo = new GoogleUserInfo(ouath2UserInfo);
        }
        Member returnMember = null;
        Optional<Member> findMember =
                memberRepository.findByUserId(socialUserInfo.getProviderId());
        // returnMember null이면  처음 로그인 사용자
        // returnMember null이 아니면   db에 이미 들어가 있는 사람 즉 처음 로그인이 아닌 사람.
        if(findMember.isPresent()) {
            returnMember = findMember.get();
        } else {
            //강제로 회원가입 시키겠다.
            Member member = Member.builder()
                    .userId(socialUserInfo.getProviderId())   
                    .userName(socialUserInfo.getName())       
                    .userEmail(socialUserInfo.getEmail())     
                    .regDate(LocalDateTime.now())
                    .role("ROLE_USER")
                    .password(
                            bCryptPasswordEncoder.encode(UUID.randomUUID().toString())
                    )
                    .build();
            memberRepository.save(member);
        }
        return new CustomUserDetails(returnMember,oAuth2User.getAttributes());
    }

}
