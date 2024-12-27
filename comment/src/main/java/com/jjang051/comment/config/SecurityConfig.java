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

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    httpSecurity.authorizeHttpRequests(
      (auth)->auth
      .requestMatchers("/","/member/join","/member/login","/css/**","/images/**","/js/**")
      .permitAll()
      .anyRequest()
      .authenticated()
      )
      .formLogin(
        (auth)->auth
        .loginPage("/member/login")
        .usernameParameter("userId")
        .loginProcessingUrl("/member/login")
        .defaultSuccessUrl("/",true)
        .permitAll()
      )
      .logout(
        (auth)->auth
        .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
        .logoutSuccessUrl("/")
        .invalidateHttpSession(true)
      );
      return httpSecurity.build();
  }
}
