package com.company;

import java.io.*;
import java.util.*;


public class Mission {
    private int missionId;
    private String missionName;
    private String missionDescription;
    private String countryOfOrigin;
    private boolean countriesAllowed;
//- coordinator: Coordinator
    private ArrayList<Job> job;
    private String employmentRequirement;
    private ArrayList<Cargo> cargo;
    private Date launchDate;
    private String locationDestination;
    private int missionDuration;
    private char missionStatus;
//- candidate: ArrayList<Candidate>
//- shuttle:ArrayList<Shuttle>


    public Mission(ArrayList<Cargo> cargo) {
        this.cargo = cargo;
    }

    public Mission(int missionId, String missionName, String missionDescription, String countryOfOrigin,
                   boolean countriesAllowed, String employmentRequirement, Date launchDate, String locationDestination,
                   int missionDuration, char missionStatus, ArrayList<Job> job, ArrayList<Cargo> cargo) {
        this.missionId = missionId;
        this.missionName = missionName;
        this.missionDescription = missionDescription;
        this.countryOfOrigin = countryOfOrigin;
        this.countriesAllowed = countriesAllowed;
        this.employmentRequirement = employmentRequirement;
        this.launchDate = launchDate;
        this.locationDestination = locationDestination;
        this.missionDuration = missionDuration;
        this.missionStatus = missionStatus;
        this.job = job;
        this.cargo = cargo;
    }

    public int getMissionId() {
        return missionId;
    }

    public void setMissionId(int missionId) {
        this.missionId = missionId;
    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public String getMissionDescription() {
        return missionDescription;
    }

    public void setMissionDescription(String missionDescription) {
        this.missionDescription = missionDescription;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public boolean isCountriesAllowed() {
        return countriesAllowed;
    }

    public void setCountriesAllowed(boolean countriesAllowed) {
        this.countriesAllowed = countriesAllowed;
    }

    public String getEmploymentRequirement() {
        return employmentRequirement;
    }

    public void setEmploymentRequirement(String employmentRequirement) {
        this.employmentRequirement = employmentRequirement;
    }

    public Date getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

    public String getLocationDestination() {
        return locationDestination;
    }

    public void setLocationDestination(String locationDestination) {
        this.locationDestination = locationDestination;
    }

    public int getMissionDuration() {
        return missionDuration;
    }

    public void setMissionDuration(int missionDuration) {
        this.missionDuration = missionDuration;
    }

    public char getMissionStatus() {
        return missionStatus;
    }

    public void setMissionStatus(char missionStatus) {
        this.missionStatus = missionStatus;
    }

    public ArrayList<Job> addJob() {
        return job;
    }


    public ArrayList<Cargo> addCargo() {
        return cargo;
    }


}
