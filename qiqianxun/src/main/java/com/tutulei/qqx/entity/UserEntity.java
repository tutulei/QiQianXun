package com.tutulei.qqx.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "Qiqianxun", catalog = "")
public class UserEntity {
    private int userId;
    private String userPhone;
    private String userName;
    private String userPwd;
    private String userState;

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_phone")
    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "user_pwd")
    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    @Basic
    @Column(name = "user_state")
    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return userId == that.userId &&
                Objects.equals(userPhone, that.userPhone) &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(userPwd, that.userPwd) &&
                Objects.equals(userState, that.userState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userPhone, userName, userPwd, userState);
    }
}
