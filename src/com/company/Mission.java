package com.company;

import java.util.ArrayList;
import java.util.Date;


public class Mission {
    private int missionId;
    private String missionName;
    private String missionDescription;
    private String countryOfOrigin;
    private ArrayList<String> countriesAllowed;
    private Coordinator coordinator;
    private ArrayList<Job> jobs;
    private String employmentRequirement;
    private ArrayList<Cargo> cargos;
    private Date launchDate;
    private String locationDestination;
    private int missionDuration;
    private char missionStatus;
    private ArrayList<Candidate> candidates;
    private MissionCriteria criteria;
    private ArrayList<Shuttle> shuttles;

    public Mission(int missionId){
        this.missionId = missionId;
    }

    public Mission(int missionId, String missionName, String missionDescription, String countryOfOrigin,
                   ArrayList<String> countriesAllowed, String employmentRequirement, Date launchDate, String locationDestination,
                   int missionDuration, char missionStatus, Coordinator coordinator, ArrayList<Job> jobs, ArrayList<Cargo> cargos, MissionCriteria criteria) {
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
        this.jobs = jobs;
        this.cargos = cargos;
        this.coordinator = coordinator;
        this.criteria = criteria;
//        this.candidates = candidates;
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

    public ArrayList<String> getCountriesAllowed() {
        return countriesAllowed;
    }

    public void setCountriesAllowed(ArrayList<String> countriesAllowed) {
        this.countriesAllowed = countriesAllowed;
    }

    public Coordinator getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(Coordinator coordinator) {
        this.coordinator = coordinator;
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
        return jobs;
    }

    public String getCoordinatorName(){
        return coordinator.getName();
    }

    public String getCoordinatorEmail(){
        return coordinator.getEmail();
    }

    public ArrayList<Cargo> addCargo() {
        return cargos;
    }

    public ArrayList<Job> getJob() {
        return jobs;
    }

    public void setJob(ArrayList<Job> job) {
        this.jobs = job;
    }

    public ArrayList<Cargo> getCargo() {
        return cargos;
    }

    public void setCargo(ArrayList<Cargo> cargo) {
        this.cargos = cargo;
    }

    public ArrayList<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(ArrayList<Candidate> candidates) {
        this.candidates = candidates;
    }

    public MissionCriteria getCriteria() {
        return criteria;
    }

    public void setCriteria(MissionCriteria criteria) {
        this.criteria = criteria;
    }

    public ArrayList<Shuttle> getShuttles() {
        return shuttles;
    }

    public void setShuttles(ArrayList<Shuttle> shuttles) {
        this.shuttles = shuttles;
    }


}
