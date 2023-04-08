package com.example.resumemaker.Model;

public class SkillModel {

    private String skill,skillLevel;

    public SkillModel(String skill, String skillLevel) {
        this.skill = skill;
        this.skillLevel = skillLevel;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(String skillLevel) {
        this.skillLevel = skillLevel;
    }
}
