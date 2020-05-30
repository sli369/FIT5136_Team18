package com.company;

import java.util.ArrayList;
import java.util.Date;

public class Candidate extends User{

    private String name;
    private Date dateOfBirth;
    private String address;
    private String nationality;
    private int identificationNumber;
    private boolean gender;
    private ArrayList allergies;
    private ArrayList foodPreference;
    private ArrayList qualifications;
    private int workExperience;
    private ArrayList occupation;
    private ArrayList computerSkill;
    private ArrayList language;

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(int identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public ArrayList getAllergies() {
        return allergies;
    }

    public void setAllergies(ArrayList allergies) {
        this.allergies = allergies;
    }

    public ArrayList getFoodPreference() {
        return foodPreference;
    }

    public void setFoodPreference(ArrayList foodPreference) {
        this.foodPreference = foodPreference;
    }

    public ArrayList getQualifications() {
        return qualifications;
    }

    public void setQualifications(ArrayList qualifications) {
        this.qualifications = qualifications;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    public ArrayList getOccupation() {
        return occupation;
    }

    public void setOccupation(ArrayList occupation) {
        this.occupation = occupation;
    }

    public ArrayList getComputerSkill() {
        return computerSkill;
    }

    public void setComputerSkill(ArrayList computerSkill) {
        this.computerSkill = computerSkill;
    }

    public ArrayList getLanguage() {
        return language;
    }

    public void setLanguage(ArrayList language) {
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
