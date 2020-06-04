package com.company;


import jxl.Workbook;

import java.io.File;
import java.util.Scanner;

public class MissionControl {


    public void writeFile(){
        try{
            Workbook workbook = Workbook.getWorkbook(new File("mission.xls"));

        }
        catch (Exception e){

        }
    }

    public boolean isBlank(String newValue)
    {
        boolean isTrue;
        if(newValue.trim().length() != 0)
        {
            isTrue = false;
        }else
        {
            isTrue = true;
        }
        return isTrue;
    }

    private String userCheckInput(String input) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Is that correct?");
        System.out.println("1.Yes, it is correct. 2.I need to modify again.");
        int number = sc.nextInt();
        while (number != 1) {
            while (number != 2) {
                System.out.println("You have not enter an option number above. Please enter an option:");
            }
            System.out.println("Please re-modify it: ");
            String next = sc.nextLine();
            userCheckInput(next);
        }
        return input;
    }


    public void createMission(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Now you are going to create a mission");
        System.out.println("****************************");

        // set mission name
        System.out.println("Please enter your mission name");
        String missionName = sc.nextLine();
        while (isBlank(missionName))
        {
            System.out.println("the input cannot be null, try to enter again");
            missionName = sc.nextLine();
        }
        System.out.println(missionName + " is your mission name");
        userCheckInput(missionName);

        // set mission Description
        System.out.println("Please enter your mission description");
        String missionDes = sc.nextLine();
        while (isBlank(missionDes))
        {
            System.out.println("the input cannot be null, try to enter again");
            missionDes = sc.nextLine();
        }
        System.out.println(missionDes + " is your mission description");
        userCheckInput(missionDes);



    }
}
