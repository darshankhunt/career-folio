package com.example.resumemaker.Model;

public class aboutModel {

    String FirstName;
    String LastName;
    String Profession;

    public aboutModel() {
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getProfession() {
        return Profession;
    }

    public void setProfession(String profession) {
        Profession = profession;
    }

    public aboutModel(String firstName, String lastName, String profession) {
        FirstName = firstName;
        LastName = lastName;
        Profession = profession;
    }



}
