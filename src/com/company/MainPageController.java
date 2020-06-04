package com.company;

import java.util.Scanner;

public class MainPageController {
    public void WelcomePage(){
        MissionControl missionControl = new MissionControl();
        MtmSystem mtm = new MtmSystem();
        ShuttleControl shuttleControl = new ShuttleControl();

        Scanner sc = new Scanner(System.in);
        int userInput=0;
        System.out.println("-- Please select an option: ");
        System.out.println("1. Create a Mission");
        System.out.println("2. View all Missions");
        System.out.println("3. Select a Shuttle");
        System.out.println("4. Candidate Information");
        System.out.println("-- Please enter the number of your selection:");

        while(true) {
            try {
                userInput = sc.nextInt();
                while(true){
                    if(userInput>=1 && userInput<=4){
                        break;
                    }
                    else{
                        System.out.println("Wrong input! Please enter a valid option:");
                        userInput = sc.nextInt();
                    }
                }
                break;
            }catch(Exception e) {
                System.out.println("Wrong input! please enter an Integer: ");
                sc.next();
            }
        }

        switch(userInput){
            case 1:
                missionControl.createMission();
            case 2:
                mtm.showMissions();
            case 3:
                shuttleControl.shuttlePage();
            case 4:

        }
    }



}
