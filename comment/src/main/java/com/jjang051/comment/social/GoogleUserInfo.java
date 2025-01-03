package com.jjang051.comment.social;

import java.util.Map;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class GoogleUserInfo implements SocialUserInfo {


  private final Map<String ,Object> attribute;  // 맵


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
        //userId
        return getProvider()+"_"+attribute.get("sub");
        // userId = google_109928619012501307465
        // userName = 장성호
    }

}
