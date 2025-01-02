package com.jjang051.comment.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Autowired
  private CustomLoginFailure customLoginFailure;


  //스프링 부트 3 람다식으로 변경
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    httpSecurity.authorizeHttpRequests(
      (auth)->auth
      .requestMatchers("/","/member/signin","/member/login","/board/list","/mail/find-password","/board/view/**","/css/**","/images/**","/js/**")
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
      return httpSecurity.build();
  }
}
