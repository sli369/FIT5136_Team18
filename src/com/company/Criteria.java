package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Criteria {
    private int minimumAge;
    private int maximumAge;
    private String[] qualification;
    private int yearsOfWorkExperience;
    private String[] occupations;
    private String[] computerSkills;
    private String[] languageSpoken;
    private ArrayList<Integer> employeeOccupation;
    private int numberOfEmployee;
    private byte requiredGender;

    public Criteria(){
        numberOfEmployee = 0;
    }


    public Criteria(int minimumAge, int maximumAge, String[] qualification, int yearsOfWorkExperience, String[] occupations, String[] computerSkills, String[] languageSpoken, ArrayList<Integer> employeeOccupation, int numberOfEmployee, byte requiredGender) {
        this.minimumAge = minimumAge;
        this.maximumAge = maximumAge;
        this.qualification = qualification;
        this.yearsOfWorkExperience = yearsOfWorkExperience;
        this.occupations = occupations;
        this.computerSkills = computerSkills;
        this.languageSpoken = languageSpoken;
        this.employeeOccupation = employeeOccupation;
        this.numberOfEmployee = numberOfEmployee;
        this.requiredGender = requiredGender;
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

    public String[] getQualification() {
        return qualification;
    }

    public void setQualification(String[] qualification) {
        this.qualification = qualification;
    }

    public int getYearsOfWorkExperience() {
        return yearsOfWorkExperience;
    }

    public void setYearsOfWorkExperience(int yearsOfWorkExperience) {
        this.yearsOfWorkExperience = yearsOfWorkExperience;
    }

    public String[] getOccupations() {
        return occupations;
    }

    public void setOccupations(String[] occupations) {
        this.occupations = occupations;
    }

    public String[] getComputerSkills() {
        return computerSkills;
    }

    public void setComputerSkills(String[] computerSkills) {
        this.computerSkills = computerSkills;
    }

    public String[] getLanguageSpoken() {
        return languageSpoken;
    }

    public void setLanguageSpoken(String[] languageSpoken) {
        this.languageSpoken = languageSpoken;
    }

    public int getNumberOfEmployee() {
        return numberOfEmployee;
    }

    public void setNumberOfEmployee(int number) {
        numberOfEmployee = numberOfEmployee + number;

    }

    public ArrayList<Integer> getEmployeeOccupation() {
        return employeeOccupation;
    }

    public void setEmployeeOccupation(ArrayList<Integer> employeeOccupation) {
        this.employeeOccupation = employeeOccupation;
    }

    public byte isRequiredGender() {
        return requiredGender;
    }

    public void setRequiredGender(byte requiredGender) {
        this.requiredGender = requiredGender;
    }

    public void showCriteria(){
        System.out.println("1.Minimum age:    " + minimumAge);
        System.out.println("2.Maximum age:    " + maximumAge);
        System.out.println("3.Qualifications:    " + Arrays.toString(qualification));
        System.out.println("4.Years of work experience:    " + yearsOfWorkExperience);
        System.out.println("5.Occupations and the number of employee required:  ");//+ Arrays.toString(occupations) );
        for (int i = 0; i <= occupations.length-1; i++){
            System.out.println("            "+occupations[i] + "  " + employeeOccupation.get(i));
        }
        System.out.println("6.Computer skills:    " + Arrays.toString(computerSkills));
        System.out.println("7.Language spoken:    " + Arrays.toString(languageSpoken));
        System.out.println("8.Number of employees required:    " + numberOfEmployee);

    }

    //addCriteria method!!!

}
