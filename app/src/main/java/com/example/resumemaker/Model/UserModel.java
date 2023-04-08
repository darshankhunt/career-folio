package com.example.resumemaker.Model;

public class UserModel {

    private int resumeTemplateId;
    private String fName,lName,profession,email,contactNumber,website,country,objective;
    private WorkModel workModel;
    private EducationModel educationModel;
    private SkillModel skillModel;


    public UserModel(int resumeTemplateId, String fName, String lName, String profession, String email, String contactNumber, String website, String country, String objective, WorkModel workModel, EducationModel educationModel, SkillModel skillModel) {
        this.resumeTemplateId = resumeTemplateId;
        this.fName = fName;
        this.lName = lName;
        this.profession = profession;
        this.email = email;
        this.contactNumber = contactNumber;
        this.website = website;
        this.country = country;
        this.objective = objective;
        this.workModel = workModel;
        this.educationModel = educationModel;
        this.skillModel = skillModel;
    }

    public UserModel(int resumeTemplateId, String fName, String lName, String profession, String email, String contactNumber, String website, String country, String objective) {
        this.resumeTemplateId = resumeTemplateId;
        this.fName = fName;
        this.lName = lName;
        this.profession = profession;
        this.email = email;
        this.contactNumber = contactNumber;
        this.website = website;
        this.country = country;
        this.objective = objective;
    }

    public UserModel(String fName, String lName, String profession) {
        this.fName = fName;
        this.lName = lName;
        this.profession = profession;
    }

    public UserModel(String email, String contactNumber, String website, String country) {
        this.email = email;
        this.contactNumber = contactNumber;
        this.website = website;
        this.country = country;
    }

    public UserModel(String objective) {
        this.objective = objective;
    }

    public UserModel(int resumeTemplateId) {
        this.resumeTemplateId = resumeTemplateId;
    }

    //    public UserModel(String resumeTemplateId){
//        this.resumeTemplateId = resumeTemplateId;
//    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public int getResumeTemplateId() {
        return resumeTemplateId;
    }

    public void setResumeTemplateId(int resumeTemplateId) {
        this.resumeTemplateId = resumeTemplateId;
    }

    public WorkModel getWorkModel() {
        return workModel;
    }

    public void setWorkModel(WorkModel workModel) {
        this.workModel = workModel;
    }

    public SkillModel getSkillModel() {
        return skillModel;
    }

    public void setSkillModel(SkillModel skillModel) {
        this.skillModel = skillModel;
    }

    public EducationModel getEducationModel() {
        return educationModel;
    }

    public void setEducationModel(EducationModel educationModel) {
        this.educationModel = educationModel;
    }


}



