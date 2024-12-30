package com.jjang051.comment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  //스프링 부트 3 람다식으로 변경

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    httpSecurity.authorizeHttpRequests(
      (auth)->auth
      .requestMatchers("/","/member/signin","/member/login","/css/**","/images/**","/js/**")
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
        .defaultSuccessUrl("/")
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
