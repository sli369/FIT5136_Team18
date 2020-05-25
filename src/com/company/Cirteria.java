package com.company;

import java.util.ArrayList;

public class Cirteria {
    private int minimumAge;
    private int maximumAge;
    private ArrayList<String> qualification;
    private int yearsOfWorkExperience;
    private ArrayList<String> occupations;
    private ArrayList<String> computerSkills;
    private ArrayList<String> languageSpoken;

    public Cirteria(int minimumAge, int maximumAge, ArrayList<String> qualification, int yearsOfWorkExperience, ArrayList<String> occupations, ArrayList<String> computerSkills, ArrayList<String> languageSpoken)
    {
        this.minimumAge = minimumAge;
        this.maximumAge = maximumAge;
        this.qualification = qualification;
        this.yearsOfWorkExperience = yearsOfWorkExperience;
        this.occupations = occupations;
        this.computerSkills = computerSkills;
        this.languageSpoken = languageSpoken;
    }

    public int getMinimumAge() {
        return minimumAge;
    }

    public void setMinimumAge(int minimumAge) {
        this.minimumAge = minimumAge;
    }

    public int getMaximumAge() {
        return maximumAge;
    }

    public void setMaximumAge(int maximumAge) {
        this.maximumAge = maximumAge;
    }

    public ArrayList<String> getQualification() {
        return qualification;
    }

    public void setQualification(ArrayList<String> qualification) {
        this.qualification = qualification;
    }

    public int getYearsOfWorkExperience() {
        return yearsOfWorkExperience;
    }

    public void setYearsOfWorkExperience(int yearsOfWorkExperience) {
        this.yearsOfWorkExperience = yearsOfWorkExperience;
    }

    public ArrayList<String> getOccupations() {
        return occupations;
    }

    public void setOccupations(ArrayList<String> occupations) {
        this.occupations = occupations;
    }

    public ArrayList<String> getComputerSkills() {
        return computerSkills;
    }

    public void setComputerSkills(ArrayList<String> computerSkills) {
        this.computerSkills = computerSkills;
    }

    public ArrayList<String> getLanguageSpoken() {
        return languageSpoken;
    }

    public void setLanguageSpoken(ArrayList<String> languageSpoken) {
        this.languageSpoken = languageSpoken;
    }
}