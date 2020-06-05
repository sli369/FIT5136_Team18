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

    public boolean isChar(String d){
        boolean isTure;
            if(d.charAt(0)== 'a' && d.charAt(0) == 'b' && d.charAt(0) == 'c' && d.charAt(0) == 'd' && d.charAt(0) == 'e' && d.charAt(0) == 'f'){
                isTure = true;
            }else {
                isTure = false;
            }
            return isTure;
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
        System.out.println("5.Please enter the Coordinator information");
        System.out.println("    (1) Please enter the name");
        String corName = sc.nextLine();
        while (isBlank(corName))
        {
            System.out.println("the input cannot be null, try to enter again");
            corName = sc.nextLine();
        }
        userCheckInput(corName);
        System.out.println("    (2) Please enter the contact");
        String corContact = sc.nextLine();
        while (isBlank(corContact))
        {
            System.out.println("the input cannot be null, try to enter again");
            corContact = sc.nextLine();
        }
        userCheckInput(corContact);
        System.out.println("coordinator name is " + corName + " contact is " + corContact);
        clearScreen();

        // fill Job information
        System.out.println("6.Please enter the Job information");
        System.out.println("    (1) Please enter the job name");
        String jobName = sc.nextLine();
        while (isBlank(jobName))
        {
            System.out.println("the input cannot be null, try to enter again");
            jobName = sc.nextLine();
        }
        userCheckInput(jobName);
        System.out.println("    (2) Please enter the job Description");
        String jobDes = sc.nextLine();
        while (isBlank(jobDes))
        {
            System.out.println("the input cannot be null, try to enter again");
            jobDes = sc.nextLine();
        }
        userCheckInput(jobDes);
        System.out.println("Job name is " + jobName + " description is " + jobDes);
        clearScreen();

        // set employee requirements
        System.out.println("7.Please enter the employee requirements");
        System.out.println("    (1) Please enter the requirements job name");
        String emRequire = sc.nextLine();
        while (isBlank(emRequire))
        {
            System.out.println("the input cannot be null, try to enter again");
            emRequire = sc.nextLine();
        }
        userCheckInput(emRequire);
        System.out.println("    (2) Please enter the number of requirements");
        int no = sc.nextInt();


        // set launch time
        System.out.println("9.Please set the launch date");
        System.out.println(" hint ('dd/mm/yyyy')");
        String launch_time = sc.nextLine();
        while (isBlank(launch_time))
        {
            System.out.println("the input cannot be null, try to enter again");
            launch_time = sc.nextLine();
        }
        //check to_date
        System.out.println(launch_time +" is your launch date");
        userCheckInput(launch_time);
        clearScreen();

        // set location
        System.out.println("10.Please set the destination location");
        String location = sc.nextLine();
        while (isBlank(location))
        {
            System.out.println("the input cannot be null, try to enter again");
            location = sc.nextLine();
        }
        System.out.println(location + " is your destination location");
        userCheckInput(location);
        clearScreen();

        // set duration of the mission
        System.out.println("11.Please set the mission duration");
        System.out.println("    hint(the unit is month)");
        String duration = sc.nextLine();
        System.out.println(duration + " is the duration month.");
        userCheckInput(duration);
        // check int

        int du = Integer.parseInt(duration);
        clearScreen();

        // set status
        System.out.println("12.Please select the mission status");
        System.out.println("    a. Planning phase");
        System.out.println("    b. Departed Earth ");
        System.out.println("    c. Landed on Mars ");
        System.out.println("    d. Mission in progress ");
        System.out.println("    e. Returned to Earth");
        System.out.println("    f. Mission completed ");
        System.out.print("Please select the option: ");
        String status = sc.nextLine();
        // check char
        while(isChar(status)){
            System.out.println("Please enter the correct option (lower case like: a)");
            status = sc.nextLine();
        }
        System.out.println("Your option is " + status);
        char noStatus = status.charAt(0);
        
    }
}
