package com.company;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MainPageController {
    private MtmSystem mtm = new MtmSystem();
    public void WelcomePage(String user_name, int role){
        MissionControl missionControl = new MissionControl();

        ShuttleControl shuttleControl = new ShuttleControl();

        if(role == 3) {
        // admin page
            Scanner sc = new Scanner(System.in);
            int userInput = 0;
            System.out.println("-- Please select an option: ");
            System.out.println("1. Create a Mission");
            System.out.println("2. View all Missions");
            System.out.println("3. Select a Shuttle");
            System.out.println("4. Candidate Information");
            System.out.println("-- Please enter the number of your selection:");

            while (true) {
                try {
                    userInput = sc.nextInt();
                    while (true) {
                        if (userInput >= 1 && userInput <= 4) {
                            break;
                        } else {
                            System.out.println("Wrong input! Please enter a valid option:");
                            userInput = sc.nextInt();
                        }
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Wrong input! please enter an Integer: ");
                    sc.next();
                }
            }

            switch (userInput) {
                case 1:
                    missionControl.createMission();
                    break;
                case 2:
                    mtm.showMissions();
                    break;
                case 3:
                    shuttleControl.shuttlePage();
                    break;
                case 4:

            }
        }
        else if(role == 2) {
            // coordinator page
            Scanner sc = new Scanner(System.in);
            int userInput = 0;
            System.out.println("-- Please select an option: ");
            System.out.println("1. Create a Mission");
            System.out.println("2. View all Missions");
            System.out.println("3. Select a Shuttle");
            System.out.println("4. Candidate Information");
            System.out.println("-- Please enter the number of your selection:");

            while (true) {
                try {
                    userInput = sc.nextInt();
                    while (true) {
                        if (userInput >= 1 && userInput <= 4) {
                            break;
                        } else {
                            System.out.println("Wrong input! Please enter a valid option:");
                            userInput = sc.nextInt();
                        }
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Wrong input! please enter an Integer: ");
                    sc.next();
                }
            }

            switch (userInput) {
                case 1:
                    missionControl.createMission();
                    break;
                case 2:
                    missionControl.viewMissionPage(user_name);
                    break;
                case 3:
                    shuttleControl.shuttlePage();
                    break;
                case 4:

            }
        }
        else if(role == 1) {
            // candidate page
            CandidateControl candidatelist = new CandidateControl();
            ArrayList<Candidate> candidateList = candidatelist.getCandidate();
            Scanner sc = new Scanner(System.in);
            int userInput = 0;
            System.out.println("-- Please select an option: ");
            System.out.println("1. View my details");
            System.out.println("2. View my missions");

            while (true) {
                try {
                    userInput = sc.nextInt();
                    while (true) {
                        if (userInput >= 1 && userInput <= 4) {
                            break;
                        } else {
                            System.out.println("Wrong input! Please enter a valid option:");
                            userInput = sc.nextInt();
                        }
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Wrong input! please enter an Integer: ");
                    sc.next();
                }
            }

            switch (userInput) {
                case 1:
                    for (Candidate candidate : candidateList) {
                        if (candidate.getName().equals(user_name)) {
                            System.out.println("********** Your Personal Details **********");
                            System.out.println("ID: " + candidate.getId());
                            System.out.println("Name: " + candidate.getName());
                            System.out.println("Gender: " + candidate.getGender());
                            System.out.println("DOB: " + candidate.getDateOfBirth());
                            System.out.println("Address: " + candidate.getStreet() + ", " + candidate.getCity() + ", " + candidate.getPostal() + ", " + candidate.getState() + ", " + candidate.getCountry());
                            System.out.println("Phone: " + candidate.getPhone());
                            System.out.println("ID Type: " + candidate.getIdtype());
                            System.out.println("Allergies: " + candidate.getAllergies());
                            System.out.println("Food Preferences: " + candidate.getFoodPreference());
                            System.out.println("Qualifications: " + candidate.getQualifications());
                            System.out.println("Work Exp.: " + candidate.getWorkExperience());
                            System.out.println("Occupation: " + candidate.getOccupation());
                            System.out.println("Computer Skills: " + candidate.getComputerSkill());
                            System.out.println("Languages: " + candidate.getLanguage());
                            System.out.println("Nationality: " + candidate.getNationality());
                        }
                    }
                    break;
                case 2:
                    mtm.showMissions();
                    break;

            }
        }
    }

}
