package com.redis.spring.entityBean;

/**
 * Created by startcaft on 2017/8/1.
 */
public class UserInfo implements java.io.Serializable {

    private String username;
    private int age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserInfo userInfo = (UserInfo) o;

        return username.equals(userInfo.username);
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }
}
