package com.jjang051.comment.config;

import java.io.IOException;
import java.net.URLEncoder;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CustomLoginFailure extends SimpleUrlAuthenticationFailureHandler {
  String errorMsg = "";
  @Override
	public void onAuthenticationFailure(HttpServletRequest request, 
                                      HttpServletResponse response,
			                                AuthenticationException exception) throws IOException, ServletException {
        //log.info("exception==={}",exception);                                             
        if(exception instanceof BadCredentialsException) {
          errorMsg = "아이디 패스워드 확인해 주세요.";
        } else if(exception instanceof UsernameNotFoundException){
          errorMsg = "존재하지 않는 회원입니다. 회원가입 해주세요.";
        } else {
          errorMsg = "알 수 없는 이유로 로그인이 되고 있지 않습니다, 잠시 후 다시 시도해 주세요.";
        }
        errorMsg = URLEncoder.encode(errorMsg, "UTF-8"); //한글은 깨져서 넘어온다
        setDefaultFailureUrl("/member/login?error=true&errorMsg="+errorMsg);
        //redirect되어서 넘어온다
        super.onAuthenticationFailure(request, response, exception);
	    }

}
