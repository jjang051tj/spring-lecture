package com.jjang051.comment.social;

import java.util.Map;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GoogleUserInfo implements SocialUserInfo {

  private final Map<String,Object> attribute;

  @Override
  public String getEmail() {
    return (String) attribute.get("email");
  }

  @Override
  public String getName() {
    return (String) attribute.get("name");
  }

  @Override
  public String getProvider() {
    return "google";
  }

  @Override
  public String getProviderId() {
    return getProvider()+"_"+attribute.get("sub");
  }

}
