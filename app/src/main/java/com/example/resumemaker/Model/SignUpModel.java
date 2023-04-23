package com.example.resumemaker.Model;

public class SignUpModel {

    private int SignUpID;
    private String Email, FullName, Mobile;

    public SignUpModel(String email, String fullName, String mobile) {
        Email = email;
        FullName = fullName;
        Mobile = mobile;
    }

    public int getSignUpID() {
        return SignUpID;
    }

    public void setSignUpID(int signUpID) {
        SignUpID = signUpID;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }
}
