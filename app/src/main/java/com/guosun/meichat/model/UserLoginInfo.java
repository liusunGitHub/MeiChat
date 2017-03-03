package com.guosun.meichat.model;

import java.io.Serializable;

/**
 * Created by liuguosheng on 2017/1/17.
 */

public class UserLoginInfo implements Serializable {
    public String userId;
    public boolean isLogin;
    public String userName;
    public String userIconUrl;

    @Override
    public String toString() {
        return "UserLoginInfo{" +
                "userId='" + userId + '\'' +
                ", isLogin=" + isLogin +
                ", userName='" + userName + '\'' +
                ", userIconUrl='" + userIconUrl + '\'' +
                '}';
    }
}
