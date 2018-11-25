package com.example.sis.data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Credentials {
    @Id
    private String userName;
    private String password;
    private UserType userType;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public enum UserType{
        STUDENT,
        ADMIN;
    }
}
