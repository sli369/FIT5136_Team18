package com.company;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import java.io.File;
import java.util.ArrayList;

public class Candidate{
    private String id;
    private String name;
    private String dateOfBirth;
    private String street;
    private String city;
    private String state;
    private String postal;
    private String country;
    private String phone;
    private String idtype;
    private String gender;
    private String allergies;
    private String foodPreference;
    private String qualifications;
    private String workExperience;
    private String occupation;
    private String computerSkill;
    private String language;
    private String nationality;
    private String missionid;

    public Candidate(String id, String name, String dateOfBirth, String street, String city, String state, String postal, String country, String phone, String idtype, String gender, String allergies, String foodPreference, String qualifications, String workExperience, String occupation, String computerSkill, String language, String nationality, String missionid) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.street = street;
        this.city = city;
        this.state = state;
        this.postal = postal;
        this.country = country;
        this.phone = phone;
        this.idtype = idtype;
        this.gender = gender;
        this.allergies = allergies;
        this.foodPreference = foodPreference;
        this.qualifications = qualifications;
        this.workExperience = workExperience;
        this.occupation = occupation;
        this.computerSkill = computerSkill;
        this.language = language;
        this.nationality = nationality;
        this.missionid = missionid;
    }

    public void setMissionid(String missionid) {
        this.missionid = missionid;
    }

    public String getMissionid() {
        return missionid;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return street;
    }

    public void setAddress(String address) {
        this.street = address;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String isGender() {
        return gender;
    }

    public void setGender(boolean String) {
        this.gender = gender;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getFoodPreference() {
        return foodPreference;
    }

    public void setFoodPreference(String foodPreference) {
        this.foodPreference = foodPreference;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getComputerSkill() {
        return computerSkill;
    }

    public void setComputerSkill(String computerSkill) {
        this.computerSkill = computerSkill;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdtype() {
        return idtype;
    }

    public String getPhone() {
        return phone;
    }

    public String getCountry() {
        return country;
    }

    public String getPostal() {
        return postal;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getId() {
        return id;
    }

    public void setIdtype(String idtype) {
        this.idtype = idtype;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }



//    public void showCandidates(){
//        candidates = getCandidate();
//
//    }



}
