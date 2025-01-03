package com.jjang051.comment.social;

import java.util.Map;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GoogleUserInfo implements SocialUserInfo {

  private final Map<String,Object> attributes;

  @Override
  public String getEmail() {
    return "jjang051@hanmail.net";
  }

  @Override
  public String getName() {
    return "장성호";
  }

  @Override
  public String getProvider() {
    return "google";
  }

  @Override
  public String getProviderId() {
    return null;
  }

}
