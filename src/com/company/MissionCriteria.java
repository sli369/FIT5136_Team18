package com.company;

public class MissionCriteria {
    private int minage;
    private int maxage;
    private String computerSkill;
    private int expYear;
    private String qualification;
    private String language;

    public MissionCriteria(int minage, int maxage, String computerSkill, int expYear, String qualification, String language) {
        this.minage = minage;
        this.maxage = maxage;
        this.computerSkill = computerSkill;
        this.expYear = expYear;
        this.qualification = qualification;
        this.language = language;
    }

    public int getMinage() {
        return minage;
    }

    public void setMinage(int minage) {
        this.minage = minage;
    }

    public int getMaxage() {
        return maxage;
    }

    public void setMaxage(int maxage) {
        this.maxage = maxage;
    }

    public String getComputerSkill() {
        return computerSkill;
    }

    public void setComputerSkill(String computerSkill) {
        this.computerSkill = computerSkill;
    }

    public int getExpYear() {
        return expYear;
    }

    public void setExpYear(int expYear) {
        this.expYear = expYear;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
