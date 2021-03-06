package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class MainPageController {
    private MtmSystem mtm = new MtmSystem();
    private EmployFast criteria = new EmployFast();
    public void WelcomePage(String user_name, int role){
        MissionControl missionControl = new MissionControl();
        CandidateControl cd = new CandidateControl();
        ShuttleControl shuttleControl = new ShuttleControl();

        if(role == 3) {
        // admin page
            Scanner sc = new Scanner(System.in);
            int userInput = 0;
            System.out.println("-- Please select an option: ");
            System.out.println("1. View all Missions");
            System.out.println("2. View candidates");
            System.out.println("3. Create Criteria");
            System.out.println("4. Logout");
            System.out.println("-- Please enter the number of your selection:");

            while (true) {
                try {
                    userInput = sc.nextInt();
                    while (true) {
                        if (userInput >= 1 && userInput <= 5) {
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
                    missionControl.showMissions();
                    WelcomePage(user_name, 3);
                    break;
                case 2:
                    cd.showCandidates();
                    WelcomePage(user_name, 3);
                case 3:
                    criteria.startCreateCriteria();
                    WelcomePage(user_name, 3);
                case 4:
                    System.out.println("Thank you for using Mission to Mars!");
                    System.exit(0);
            }
        }
        else if(role == 2) {
            // coordinator page
            Scanner sc = new Scanner(System.in);
            int userInput = 0;
            System.out.println("-- Please select an option: ");
            System.out.println("1. Create a Mission");
            System.out.println("2. View my Missions");
            System.out.println("3. Logout");
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
                    WelcomePage(user_name, 2);
                case 2:
                    missionControl.viewMissionPage(user_name);
                    WelcomePage(user_name, 2);
                case 3:
                    System.exit(0);

            }
        }
        else if(role == 1) {
            // candidate page
            CandidateControl candidatelist = new CandidateControl();
            ArrayList<Candidate> candidateList = candidatelist.getCandidate();
            Scanner sc = new Scanner(System.in);
            int userInput = 0;
            String option;
            Candidate target_candidate = null;
            
            for (Candidate candidate : candidateList) {
                
                if (candidate.getName().equals(user_name)) {
                    target_candidate = new Candidate(candidate.getId(), candidate.getName(), candidate.getDateOfBirth(), candidate.getStreet(), candidate.getCity(), candidate.getState(), candidate.getPostal(), candidate.getCountry(), candidate.getPhone(), candidate.getIdtype(), candidate.getGender(), candidate.getAllergies(), candidate.getFoodPreference(), candidate.getQualifications(), candidate.getWorkExperience(), candidate.getOccupation(), candidate.getComputerSkill(), candidate.getLanguage(), candidate.getNationality(), candidate.getMissionid());
                }
            }
          
            System.out.println("-- Please select an option: ");
            System.out.println("1. View my details");
            System.out.println("2. View my missions");
            System.out.println("3. Logout");
//            System.out.println(user_name);

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
                    System.out.println("********** Your Personal Details **********");
                    System.out.println("ID: " + target_candidate.getId());
                    System.out.println("Name: " + target_candidate.getName());
                    System.out.println("Gender: " + target_candidate.getGender());
                    System.out.println("DOB: " + target_candidate.getDateOfBirth());
                    System.out.println("Street: " + target_candidate.getStreet());
                    System.out.println("City: " + target_candidate.getCity());
                    System.out.println("Postal: " + target_candidate.getPostal());
                    System.out.println("State: " + target_candidate.getState());
                    System.out.println("Country: " + target_candidate.getCountry());
                    System.out.println("Phone: " + target_candidate.getPhone());
                    System.out.println("IDType: " + target_candidate.getIdtype());
                    System.out.println("Allergies: " + target_candidate.getAllergies());
                    System.out.println("FoodPreferences: " + target_candidate.getFoodPreference());
                    System.out.println("Qualifications: " + target_candidate.getQualifications());
                    System.out.println("WorkExp.: " + target_candidate.getWorkExperience());
                    System.out.println("Occupation: " + target_candidate.getOccupation());
                    System.out.println("ComputerSkills: " + target_candidate.getComputerSkill());
                    System.out.println("Languages: " + target_candidate.getLanguage());
                    System.out.println("Nationality: " + target_candidate.getNationality());

                    System.out.println("********** Would you like to update your details? **********");
                    System.out.println("1.Yes,  2.No");
                    while (true) {
                        try {
                            userInput = sc.nextInt();
                            while (true) {
                                if (userInput >= 1 && userInput <= 2) {
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
                            target_candidate = candidatelist.changeCandidateInfo(target_candidate);
                            candidatelist.saveCandidateInfo(target_candidate);
                            System.out.println("Your information has been updated!");
                            WelcomePage(user_name, 1);


                        case 2:
                            WelcomePage(user_name, 1);

                    }

                case 2:
                    String missions = target_candidate.getMissionid();
                    System.out.println("Your current mission is: " + missions);
                    WelcomePage(user_name, 1);
                case 3:
                    System.exit(0);
            }

        }



    }

}
