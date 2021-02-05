package com.kimilm.board.dto;

public class UserVO {
    private int userNo;
    private String userId;
    private String userPassword;
    private String userName;
    private String userMail;

    public int getUserNo() {
        return this.userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return this.userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMail() {
        return this.userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

}
