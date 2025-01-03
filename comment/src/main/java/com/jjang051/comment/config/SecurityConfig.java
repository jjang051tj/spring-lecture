package com.jjang051.comment.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


import com.jjang051.comment.service.OAuth2DetailsService;


import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

  
  private final CustomLoginFailure customLoginFailure;
  
  private final OAuth2DetailsService oAuth2DetailsService;


  //스프링 부트 3 람다식으로 변경
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    httpSecurity.authorizeHttpRequests(
      (auth)->auth
      .requestMatchers("/","/member/signin","/member/login","/board/list",
                      "/mail/find-password",
                      "/mail/confirm",
                      "/board/view/**","/css/**","/images/**","/js/**")
      .permitAll()
      .anyRequest()
      .authenticated()
      )
      .formLogin(
        (auth)->auth
        .loginPage("/member/login")
        .usernameParameter("userId")
        //.passwordParameter("userPw")
        .loginProcessingUrl("/member/login")
        .defaultSuccessUrl("/",true)
        .failureHandler(customLoginFailure)
        .permitAll()
      )
      .logout(
        (auth)->auth
        .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
        .logoutSuccessUrl("/")
        .invalidateHttpSession(true)
      )
      .csrf((auth)->auth.disable());  //front에서 토큰 가지고 접근  jwt  리액트 vue에서 접근할때
      
      //소셜로그인
    httpSecurity.oauth2Login((auth)->auth
      .loginPage("/member/login")
      .defaultSuccessUrl("/board/list",true)
      .userInfoEndpoint(userInfo->userInfo.userService(oAuth2DetailsService))
    );
      return httpSecurity.build();
  }
}
