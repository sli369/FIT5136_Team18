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
        while (number != 1 && number != 2) {

            System.out.println("You have not enter an option number above. Please enter an option:");
            number = sc.nextInt();
        }
        if (number == 2) {
            System.out.println("Please re-modify it: ");
            input = sc.next();
            userCheckInput(input);
        }

        return input;
    }

    private void clearScreen(){
        System.out.println("\f");
        System.out.println("****************************");
    }

    public void createMission(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Now you are going to create a mission");
        System.out.println("****************************");

        // set mission name
        System.out.println("1.Please enter your mission name");
        String missionName = sc.nextLine();
        while (isBlank(missionName))
        {
            System.out.println("the input cannot be null, try to enter again");
            missionName = sc.nextLine();
        }
        System.out.println(missionName + " is your mission name");
        userCheckInput(missionName);
        clearScreen();

        // set mission Description
        System.out.println("2.Please enter your mission description");
        String missionDes = sc.nextLine();
        while (isBlank(missionDes))
        {
            System.out.println("the input cannot be null, try to enter again");
            missionDes = sc.nextLine();
        }
        System.out.println(missionDes + " is your mission description");
        userCheckInput(missionDes);
        clearScreen();

        // set countries of origin
        System.out.println("3.Please enter the country of origin");
        String countryOrigin = sc.nextLine();
        while (isBlank(countryOrigin))
        {
            System.out.println("the input cannot be null, try to enter again");
            countryOrigin = sc.nextLine();
        }
        System.out.println(countryOrigin + " is your country of origin");
        userCheckInput(countryOrigin);
        clearScreen();

        //set countries allowed
        System.out.println("4.Please enter the countries of allowed");
        System.out.println("hint (if you enter multiple values, please use common to seperate)");
        String countriesAllow = sc.nextLine();
        while (isBlank(countriesAllow))
        {
            System.out.println("the input cannot be null, try to enter again");
            countriesAllow = sc.nextLine();
        }
        System.out.println(countriesAllow + " is your country of origin");
        userCheckInput(countriesAllow);
        clearScreen();

        // set coordinator
        System.out.println("4.Please enter the Coordinator information");
        System.out.println("    (1) Please enter the name");
        String corName = sc.nextLine();
        while (isBlank(corName))
        {
            System.out.println("the input cannot be null, try to enter again");
            corName = sc.nextLine();
        }
        System.out.println("    (2) Please enter the contact");
        String corContact = sc.nextLine();
        while (isBlank(corContact))
        {
            System.out.println("the input cannot be null, try to enter again");
            corContact = sc.nextLine();
        }
        System.out.println("coordinator name is " + corName + " contact is " + corContact);
    }
}
