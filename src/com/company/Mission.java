package com.company;

import java.io.*;
import java.util.*;


public class Mission {
    private int missionId;
    private String missionName;
    private String missionDescription;
    private String countryOfOrigin;
    private boolean countriesAllowed;
    private Coordinator coordinator;
    private ArrayList<Job> job;
    private String employmentRequirement;
    private ArrayList<Cargo> cargo;
    private Date launchDate;
    private String locationDestination;
    private int missionDuration;
    private char missionStatus;
    private ArrayList<Candidate> candidates;
    private ArrayList<Shuttle> shuttles;

    public Mission(int missionId){
        this.missionId = missionId;
    }

    public Mission(int missionId, String missionName, String missionDescription, String countryOfOrigin,
                   boolean countriesAllowed, String employmentRequirement, Date launchDate, String locationDestination,
                   int missionDuration, char missionStatus, ArrayList<Job> job, ArrayList<Cargo> cargo, ArrayList<Candidate> candidates, ArrayList<Shuttle> shuttles) {
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
        this.candidates = candidates;
        this.shuttles = shuttles;
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

    public String getCoordinatorName(){
        return coordinator.getName();
    }

    public String getCoordinatorEmail(){
        return coordinator.getEmail();
    }

    public ArrayList<Cargo> addCargo() {
        return cargo;
    }


    public ArrayList<Job> getJob() {
        return job;
    }

    public void setJob(ArrayList<Job> job) {
        this.job = job;
    }

    public ArrayList<Cargo> getCargo() {
        return cargo;
    }

    public void setCargo(ArrayList<Cargo> cargo) {
        this.cargo = cargo;
    }

    public ArrayList<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(ArrayList<Candidate> candidates) {
        this.candidates = candidates;
    }

    public ArrayList<Shuttle> getShuttles() {
        return shuttles;
    }

    public void setShuttles(ArrayList<Shuttle> shuttles) {
        this.shuttles = shuttles;
    }

    public void showMission(){
        System.out.println("1.Mission Name:    " + missionName);
        System.out.println("2.Mission description:    " + missionDescription);
        System.out.println("3.Country of origin:    " + countryOfOrigin);
        System.out.println("4.countries allowed:    " + countriesAllowed);
        System.out.println("5.Coordinator information: " );
        System.out.println("a.name: " + getCoordinatorName());
        System.out.println("b.contact: " + getCoordinatorEmail());
        System.out.println("6.Job information");
//        print
        System.out.println("7.Employment requirements");
//        print
        System.out.println("8.Cargo requirements");
        System.out.println("     8.1 Cargo for journey");
        System.out.println("     8.2 Cargo for mission");
        System.out.println("9.Launch date: " + launchDate);
        System.out.println("10.Location: " + locationDestination);
        System.out.println("11.Duration of the mission: " + missionDuration);
        System.out.println("12.Status of the mission " + "(" + missionStatus +")");



    }

}
