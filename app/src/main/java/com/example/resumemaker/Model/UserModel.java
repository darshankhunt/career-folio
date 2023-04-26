package com.example.resumemaker.Model;

import java.util.List;

public class UserModel {

    private int resumeTemplateId;
    private String fName,lName,profession,email,contactNumber,website,country,objective,emailOfUser;
    private WorkModel workModel;
    private EducationModel educationModel;
    private SkillModel skillModel;

    private List<WorkModel> workList;
    private List<EducationModel> eduList;
    private List<SkillModel> skillList;

    public UserModel(){

    }

    public UserModel(int resumeTemplateId,String emailOfUser, String fName, String lName, String profession, String email, String contactNumber, String website, String country, String objective, List<WorkModel> workList, List<EducationModel> eduList, List<SkillModel> skillList) {
        this.resumeTemplateId = resumeTemplateId;
        this.emailOfUser = emailOfUser;
        this.fName = fName;
        this.lName = lName;
        this.profession = profession;
        this.email = email;
        this.contactNumber = contactNumber;
        this.website = website;
        this.country = country;
        this.objective = objective;
        this.workList = workList;
        this.eduList = eduList;
        this.skillList = skillList;
    }


    public UserModel(String email, String contactNumber, String website, String country) {
        this.email = email;
        this.contactNumber = contactNumber;
        this.website = website;
        this.country = country;
    }


    public String getEmailOfUser() {
        return emailOfUser;
    }

    public void setEmailOfUser(String emailOfUser) {
        this.emailOfUser = emailOfUser;
    }

    public List<EducationModel> getEduList() {
        return eduList;
    }

    public void setEduList(List<EducationModel> eduList) {
        this.eduList = eduList;
    }

    public List<SkillModel> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<SkillModel> skillList) {
        this.skillList = skillList;
    }

    public List<WorkModel> getWorkList() {
        return workList;
    }

    public void setWorkList(List<WorkModel> workList) {
        this.workList = workList;
    }

    public UserModel(String objective) {
        this.objective = objective;
    }



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



