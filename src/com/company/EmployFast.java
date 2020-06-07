package com.company;

import jxl.Cell;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class EmployFast {
    private ArrayList<Criteria> criterias;


    ////////////////////////////////////////////////////////////////////////
    // Joyce code start
    ////////////////////////////////////////////////////////////////////////
    public void startCreateCriteria()
    {
        Criteria criteria = new Criteria();
        createCriteria(criteria);
    }



    //    private int numberOfEmployee;
    //    private byte requiredGender;

    private void clearScreen(){
        //System.out.println("\f");
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }


    public void createCriteria(Criteria criteria) {

        Validate validate = new Validate();
        Scanner sc = new Scanner(System.in);
        MissionControl mission = new MissionControl();

        while (true) {
            System.out.println("\n***************** create the criteria to select employees *****************\r\n");
            System.out.println("\n****** please select the criteria that you want to set ******\r\n");
            System.out.println("1.minimumAge & maximumAge\t\t2.qualification\t\t3.yearsOfWorkExperience\r\n");
            System.out.println("4.occupations\t\t5.computerSkills\t\t6.languageSpoken\r\n");
            System.out.println("*************************************************************");
            System.out.println("You can enter 'm' to check the mission");
            System.out.println("");
            System.out.println("You can enter 'a' to finish/exit creating a criteria or press enter to continue. ");

            //
            String enter = sc.nextLine();
            if (enter.equals("m")){
                System.out.println("please enter the ID of the mission that you want to check");
                int id = sc.nextInt();
                sc.nextLine();
                mission.showOneMission(id);
                System.out.println("please press enter to continue creating criteria");
                sc.nextLine();
                clearScreen();
            }

            //
            if (enter.equals("a")) {
                if (criteria.getNumberOfEmployee()!=0) {
                    System.out.println("enter number 1 to review the criteria created, enter number 2 to exit ");
                    System.out.println("1.review criteria\t\t2.exit\r\n");
                    String yn = sc.nextLine();
                    while (validate.checkInt(yn) == false) {
                        System.out.println("please enter valid integer number");
                        System.out.println("please input your selection: ");
                        yn = sc.nextLine();
                    }
                    while (validate.checkRange(Integer.parseInt(yn), 1, 2) == false) {
                        System.out.println("Please enter valid range of number");
                        System.out.println("Please input your selection: number between 1~2 ");
                        yn = sc.nextLine();
                    }
                    int ynInt = Integer.parseInt(yn);
                    if (ynInt == 1){
                        criteria.showCriteria();
                        System.out.println("Press enter to return");
                        sc.nextLine();
                        return;
                    }
                    else {
                        return;
                    }

                }
                else {
                    System.out.println("No criteria added, return to the create criteria page");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("\n***************** create the criteria to select employees *****************\r\n");
                }
            }
            System.out.println("\n****** please select the criteria that you want to set ******\r\n");
            System.out.println("1.minimumAge & maximumAge\t\t2.qualification\t\t3.yearsOfWorkExperience\r\n");
            System.out.println("4.occupations\t\t5.computerSkills\t\t6.languageSpoken\r\n");
            System.out.println("*************************************************************");
            System.out.println("Please input your selection: ");
            try {
                String c = sc.nextLine();
                while (validate.checkInt(c) == false){
                    System.out.println("please enter valid integer number");
                    System.out.println("please input your selection: ");
                    c = sc.nextLine();
                }
                while (validate.checkRange(Integer.parseInt(c),1,6) == false){
                    System.out.println("Please enter valid range of number");
                    System.out.println("Please input your selection: number between 1~6 ");
                    c = sc.nextLine();
                }
                int ci = Integer.parseInt(c);

                switch (ci) {
                    case 1:
                        ageRange(criteria);
                        clearScreen();
                        break;
                    case 2:
                        qualification(criteria);
                        clearScreen();
                        break;
                    case 3:
                        yearsOfWorkExperience(criteria);
                        clearScreen();
                        break;
                    case 4:
                        occupations(criteria);
                        clearScreen();
                        break;
                    case 5:
                        computerSkills(criteria);
                        clearScreen();
                        break;
                    case 6:
                        languageSpoken(criteria);
                        clearScreen();
                        break;

                    default:
                        System.out.println("Invalid input!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please try again!");
            }
        }
    }




    //
    private void ageRange(Criteria criteria){
        Scanner sc = new Scanner(System.in);
        Validate validate = new Validate();
        MissionControl mission = new MissionControl();
        System.out.println("Enter 'm' to check the criteria condition of mission");
        System.out.println("please press enter to continue setting the min age");
        //
        if (sc.nextLine().equals("m")){
            System.out.println("please enter the ID of the mission that you want to check");
            int id = sc.nextInt();
            sc.nextLine();
            mission.showMissionCriteria(id);
        }
        System.out.println("please enter the min age");
        String minAge = sc.nextLine();
        while (validate.checkInt(minAge) == false){
            System.out.println("please enter valid integer number");
            System.out.println("please enter the min age");
            minAge = sc.nextLine();
        }
        while (validate.checkRange(Integer.parseInt(minAge),18,55) == false){
            System.out.println("Please enter valid range of number");
            System.out.println("please enter the min age that not below 18");
            minAge = sc.nextLine();
        }
        int minAgeInt = Integer.parseInt(minAge);
        criteria.setMinimumAge(minAgeInt);
        System.out.println("you have set the minimum age as " + minAgeInt + ". Now please enter the max age");
        String maxAge = sc.nextLine();
        while (validate.checkInt(maxAge) == false){
            System.out.println("please enter valid integer number");
            System.out.println("please enter the max age");
            maxAge = sc.nextLine();
        }
        while (validate.checkRange(Integer.parseInt(maxAge),18,55) == false){
            System.out.println("Please enter valid range of number");
            System.out.println("please enter the max age that not over 55");
            maxAge = sc.nextLine();
        }
        int maxAgeInt = Integer.parseInt(maxAge);
        criteria.setMaximumAge(maxAgeInt);
        System.out.println("you have set the minimum age as " + minAgeInt + " and the max age " + maxAgeInt);
        //
        System.out.println("Whether you want to modify them? 1. modify\t\t2. no");
        String number = sc.nextLine();
        while (validate.checkInt(number) == false){
            System.out.println("please enter valid integer number");
            System.out.println("please input your selection: ");
            number = sc.nextLine();
        }
        while (validate.checkRange(Integer.parseInt(number),1,2) == false){
            System.out.println("Please enter valid range of number");
            System.out.println("Please input your selection: number between 1~2 ");
            number = sc.nextLine();
        }
        int numberInt = Integer.parseInt(number);
        if (numberInt == 1){
            System.out.println("please reenter the minimum age");
            String newMinAge = sc.nextLine();
            while (validate.checkInt(newMinAge) == false){
                System.out.println("please enter valid integer number");
                System.out.println("please enter the min age");
                newMinAge = sc.nextLine();
            }
            while (validate.checkRange(Integer.parseInt(newMinAge),15,90) == false){
                System.out.println("Please enter valid range of number");
                System.out.println("please enter the min age that above 15");
                newMinAge = sc.nextLine();
            }
            int newMinAgeInt = Integer.parseInt(newMinAge);
            criteria.setMinimumAge(newMinAgeInt);
            System.out.println("you have reset the minimum age as " + newMinAgeInt + ". Now please enter the max age");
            String newMaxAge = sc.nextLine();
            while (validate.checkInt(newMaxAge) == false){
                System.out.println("please enter valid integer number");
                System.out.println("please enter the max age");
                newMaxAge = sc.nextLine();
            }
            while (validate.checkRange(Integer.parseInt(newMaxAge),15,90) == false){
                System.out.println("Please enter valid range of number");
                System.out.println("please enter the max age that below 90");
                newMaxAge = sc.nextLine();
            }
            int newMaxAgeInt = Integer.parseInt(newMaxAge);
            criteria.setMaximumAge(newMaxAgeInt);
            System.out.println("you have set the minimum age as " + newMinAgeInt + " and the max age " + newMaxAgeInt);
            System.out.println("Please press enter to continue");
            sc.nextLine();
        }
        else{
            System.out.println("Please press enter to continue");
            sc.nextLine();
        }
        //
        System.out.println("Do you want to continue to set the qualification criteria? ");
        System.out.println("1.Yes\t\t2.No\r\n ");
        String yn = sc.nextLine();
        while (validate.checkInt(yn) == false){
            System.out.println("please enter valid integer number");
            System.out.println("please input your selection: ");
            yn = sc.nextLine();
        }
        while (validate.checkRange(Integer.parseInt(yn),1,2) == false){
            System.out.println("Please enter valid range of number");
            System.out.println("Please input your selection: number between 1~2 ");
            yn = sc.nextLine();
        }
        int ynInt = Integer.parseInt(yn);
        if (ynInt == 1){
            qualification(criteria);
        }
        else{
            System.out.println("Back to create criteria page");

            createCriteria(criteria);

        }


    }

    private void qualification(Criteria criteria){
        Scanner sc = new Scanner(System.in);
        Validate validate = new Validate();
        MissionControl mission = new MissionControl();
        System.out.println("Enter 'm' to check the criteria condition of mission");
        System.out.println("please press enter to continue setting the qualifications");
        //
        if (sc.nextLine().equals("m")) {
            System.out.println("please enter the ID of the mission that you want to check");
            int id = sc.nextInt();
            sc.nextLine();
            mission.showMissionCriteria(id);

        }
        System.out.println("please enter the qualifications you want to set, please split them with ','");
        String[] quali = sc.nextLine().split(",");
        criteria.setQualification(quali);
        System.out.println("you have set qualifications: " + Arrays.toString(quali));
        //
        System.out.println("Whether you want to modify them? 1. modify\t\t2. no");
        String number = sc.nextLine();
        while (validate.checkInt(number) == false){
            System.out.println("please enter valid integer number");
            System.out.println("please input your selection: ");
            number = sc.nextLine();
        }
        while (validate.checkRange(Integer.parseInt(number),1,2) == false){
            System.out.println("Please enter valid range of number");
            System.out.println("Please input your selection: number between 1~2 ");
            number = sc.nextLine();
        }
        int numberInt = Integer.parseInt(number);
        if (numberInt == 1){
            System.out.println("please reenter the qualifications");
            //modify body start
            //
            String[] newQuali = sc.nextLine().split(",");
            criteria.setQualification(newQuali);
            System.out.println("you have set qualifications: " + Arrays.toString(newQuali));
            //
            //modify body end
            System.out.println("Please press enter to continue");
            sc.nextLine();
        }
        else{
            System.out.println("Please press enter to continue");
            sc.nextLine();
        }
        //
        System.out.println("Do you want to continue to set the yearsOfWorkExperience criteria? ");
        System.out.println("1.Yes\t\t2.No\r\n" );
        String yn = sc.nextLine();
        while (validate.checkInt(yn) == false){
            System.out.println("please enter valid integer number");
            System.out.println("please input your selection: ");
            yn = sc.nextLine();
        }
        while (validate.checkRange(Integer.parseInt(yn),1,2) == false){
            System.out.println("Please enter valid range of number");
            System.out.println("Please input your selection: number between 1~2 ");
            yn = sc.nextLine();
        }
        int ynInt = Integer.parseInt(yn);
        if (ynInt == 1){
            yearsOfWorkExperience(criteria);
        }
        else{
            System.out.println("Back to create criteria page");
            createCriteria(criteria);
        }

    }



    private void yearsOfWorkExperience(Criteria criteria){
        Scanner sc = new Scanner(System.in);
        Validate validate = new Validate();
        MissionControl mission = new MissionControl();
        System.out.println("Enter 'm' to check the criteria condition of mission");
        System.out.println("please press enter to continue setting the years of work Experience");
        //
        if (sc.nextLine().equals("m")) {
            System.out.println("please enter the ID of the mission that you want to check");
            int id = sc.nextInt();
            sc.nextLine();
            mission.showMissionCriteria(id);

        }
        System.out.println("please enter the years of work Experience");
        String year = sc.nextLine();
        while (validate.checkInt(year) == false){
            System.out.println("please enter valid integer number");
            System.out.println("please enter the years of work Experience");
            year = sc.nextLine();
        }
        while (validate.checkRange(Integer.parseInt(year),0,100) == false){
            System.out.println("Please enter valid range of number");
            year = sc.nextLine();
        }
        int yearInt = Integer.parseInt(year);
        criteria.setYearsOfWorkExperience(yearInt);
        System.out.println("you have set the years of work Experience required " + yearInt );
//
        System.out.println("Whether you want to modify them? 1. modify\t\t2. no");
        String number = sc.nextLine();
        while (validate.checkInt(number) == false){
            System.out.println("please enter valid integer number");
            System.out.println("please input your selection: ");
            number = sc.nextLine();
        }
        while (validate.checkRange(Integer.parseInt(number),1,2) == false){
            System.out.println("Please enter valid range of number");
            System.out.println("Please input your selection: number between 1~2 ");
            number = sc.nextLine();
        }
        int numberInt = Integer.parseInt(number);
        if (numberInt == 1){
            System.out.println("please reenter the years of work Experience");
            //modify body start
            //
            String newYear = sc.nextLine();
            while (validate.checkInt(newYear) == false){
                System.out.println("please enter valid integer number");
                System.out.println("please enter the years of work Experience");
                newYear = sc.nextLine();
            }
            while (validate.checkRange(Integer.parseInt(newYear),0,100) == false){
                System.out.println("Please enter valid range of number");
                newYear = sc.nextLine();
            }
            int newYearInt = Integer.parseInt(newYear);
            criteria.setYearsOfWorkExperience(newYearInt);
            System.out.println("you have set the years of work Experience required " + newYearInt );
            //
            //modify body end
            System.out.println("Please press enter to continue");
            sc.nextLine();
        }
        else{
            System.out.println("Please press enter to continue");
            sc.nextLine();
        }
        //
        System.out.println("Do you want to continue to set the occupations criteria? ");
        System.out.println("1.Yes\t\t2.No\r\n ");
        String yn = sc.nextLine();
        while (validate.checkInt(yn) == false){
            System.out.println("please enter valid integer number");
            System.out.println("please input your selection: ");
            yn = sc.nextLine();
        }
        while (validate.checkRange(Integer.parseInt(yn),1,2) == false){
            System.out.println("Please enter valid range of number");
            System.out.println("Please input your selection: number between 1~2 ");
            yn = sc.nextLine();
        }
        int ynInt = Integer.parseInt(yn);
        if (ynInt == 1){
            occupations(criteria);
        }
        else{
            System.out.println("Back to create criteria page");
            createCriteria(criteria);
        }


    }

    private void occupations(Criteria criteria){
        Scanner sc = new Scanner(System.in);
        Validate validate = new Validate();
        MissionControl mission = new MissionControl();
        System.out.println("Enter 'm' to check the criteria condition of mission");
        System.out.println("please press enter to continue setting the occupations");
        //
        if (sc.nextLine().equals("m")) {
            System.out.println("please enter the ID of the mission that you want to check");
            int id = sc.nextInt();
            sc.nextLine();
            mission.showMissionCriteria(id);

        }
        System.out.println("please enter the occupations you want to set, please split them with ','");
        String[] occu = sc.nextLine().split(",");
        criteria.setOccupations(occu);
        System.out.println("you have set occupations: " + Arrays.toString(occu));
        //
        System.out.println("Whether you want to modify them? 1. modify\t\t2. no");
        String number = sc.nextLine();
        while (validate.checkInt(number) == false){
            System.out.println("please enter valid integer number");
            System.out.println("please input your selection: ");
            number = sc.nextLine();
        }
        while (validate.checkRange(Integer.parseInt(number),1,2) == false){
            System.out.println("Please enter valid range of number");
            System.out.println("Please input your selection: number between 1~2 ");
            number = sc.nextLine();
        }
        int numberInt = Integer.parseInt(number);
        if (numberInt == 1){
            System.out.println("please reenter the occupations");
            //modify body start
            //
            String[] newOccu = sc.nextLine().split(",");
            criteria.setOccupations(newOccu);
            System.out.println("you have set occupations: " + Arrays.toString(newOccu));
            //
            //modify body end
            System.out.println("Please press enter to continue");
            sc.nextLine();
        }
        else{
            System.out.println("Please press enter to continue");
            sc.nextLine();
        }
        //
        //int index = occu.length-1;
        System.out.println("please set the number of employees you need with each kind of occupations");
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int i = 0;i <= occu.length-1;i++){
            System.out.println("please enter the number that how many " + occu[i] + " you need");
            String n = sc.nextLine();
            while (validate.checkInt(n) == false){
                System.out.println("please enter valid integer number");
                System.out.println("please enter the number again that how many" + occu[i] + " you need");
                n = sc.nextLine();
            }
            while (validate.checkRange(Integer.parseInt(n),0,100) == false){
                System.out.println("Please enter valid range of number");
                n = sc.nextLine();
            }
            int nInt = Integer.parseInt(n);
            criteria.setNumberOfEmployee(nInt);
            numbers.add(nInt);
        }

        criteria.setEmployeeOccupation(numbers);
        int totalNumberOfEmployee = criteria.getNumberOfEmployee();
        System.out.println("The total number of employee required in this mission is: " + totalNumberOfEmployee);
        System.out.println("Do you want to continue to set the computerSkills criteria? ");
        System.out.println("1.Yes\t\t2.No\r\n ");
        String yn = sc.nextLine();
        while (validate.checkInt(yn) == false){
            System.out.println("please enter valid integer number");
            System.out.println("please input your selection: ");
            yn = sc.nextLine();
        }
        while (validate.checkRange(Integer.parseInt(yn),1,2) == false){
            System.out.println("Please enter valid range of number");
            System.out.println("Please input your selection: number between 1~2 ");
            yn = sc.nextLine();
        }
        int ynInt = Integer.parseInt(yn);
        if (ynInt == 1){
            computerSkills(criteria);
        }
        else{
            System.out.println("Back to create criteria page");
            createCriteria(criteria);
        }


    }

    private void computerSkills(Criteria criteria){
        Scanner sc = new Scanner(System.in);
        Validate validate = new Validate();
        MissionControl mission = new MissionControl();
        System.out.println("Enter 'm' to check the criteria condition of mission");
        System.out.println("please press enter to continue setting the computer skills");
        //
        if (sc.nextLine().equals("m")) {
            System.out.println("please enter the ID of the mission that you want to check");
            int id = sc.nextInt();
            sc.nextLine();
            mission.showMissionCriteria(id);

        }
        System.out.println("please enter the computer skills you want to set, please split them with ','");
        String[] comp = sc.nextLine().split(",");
        criteria.setComputerSkills(comp);
        System.out.println("you have set computerSkills: " + Arrays.toString(comp));
//
        System.out.println("Whether you want to modify them? 1. modify\t\t2. no");
        String number = sc.nextLine();
        while (validate.checkInt(number) == false){
            System.out.println("please enter valid integer number");
            System.out.println("please input your selection: ");
            number = sc.nextLine();
        }
        while (validate.checkRange(Integer.parseInt(number),1,2) == false){
            System.out.println("Please enter valid range of number");
            System.out.println("Please input your selection: number between 1~2 ");
            number = sc.nextLine();
        }
        int numberInt = Integer.parseInt(number);
        if (numberInt == 1){
            System.out.println("please reenter the computerSkills");
            //modify body start
            //
            String[] newComp = sc.nextLine().split(",");
            criteria.setComputerSkills(newComp);
            System.out.println("you have set computerSkills: " + Arrays.toString(newComp));
            //
            //modify body end
            System.out.println("Please press enter to continue");
            sc.nextLine();
        }
        else{
            System.out.println("Please press enter to continue");
            sc.nextLine();
        }
        //
        System.out.println("Do you want to continue to set the languageSpoken criteria? ");
        System.out.println("1.Yes\t\t2.No\r\n ");
        String yn = sc.nextLine();
        while (validate.checkInt(yn) == false){
            System.out.println("please enter valid integer number");
            System.out.println("please input your selection: ");
            yn = sc.nextLine();
        }
        while (validate.checkRange(Integer.parseInt(yn),1,2) == false){
            System.out.println("Please enter valid range of number");
            System.out.println("Please input your selection: number between 1~2 ");
            yn = sc.nextLine();
        }
        int ynInt = Integer.parseInt(yn);
        if (ynInt == 1){
            languageSpoken(criteria);
        }
        else{
            System.out.println("Back to create criteria page");
            createCriteria(criteria);
        }


    }

    private void languageSpoken(Criteria criteria){
        Scanner sc = new Scanner(System.in);
        Validate validate = new Validate();
        MissionControl mission = new MissionControl();
        System.out.println("Enter 'm' to check the criteria condition of mission");
        System.out.println("please press enter to continue setting the language spoken");
        //
        if (sc.nextLine().equals("m")) {
            System.out.println("please enter the ID of the mission that you want to check");
            int id = sc.nextInt();
            sc.nextLine();
            mission.showMissionCriteria(id);

        }
        System.out.println("please enter the language spoken you want to set, please split them with ','");
        String[] lang = sc.nextLine().split(",");
        criteria.setLanguageSpoken(lang);
        System.out.println("you have set language spoken: " + Arrays.toString(lang));
        //
        System.out.println("Whether you want to modify them? 1. modify\t\t2. no");
        String number = sc.nextLine();
        while (validate.checkInt(number) == false){
            System.out.println("please enter valid integer number");
            System.out.println("please input your selection: ");
            number = sc.nextLine();
        }
        while (validate.checkRange(Integer.parseInt(number),1,2) == false){
            System.out.println("Please enter valid range of number");
            System.out.println("Please input your selection: number between 1~2 ");
            number = sc.nextLine();
        }
        int numberInt = Integer.parseInt(number);
        if (numberInt == 1){
            System.out.println("please reenter the language spoken");
            //modify body start
            //
            String[] newLang = sc.nextLine().split(",");
            criteria.setLanguageSpoken(newLang);
            System.out.println("you have set language spoken: " + Arrays.toString(newLang));
            //
            //modify body end
            System.out.println("Please press enter to continue");
            sc.nextLine();
        }
        else{
            System.out.println("Please press enter to continue");
            sc.nextLine();
        }
        //
        System.out.println("You want to go back to criteria page or review the criteria created? ");
        System.out.println("1.criteria page\t\t2.review criteria\r\n");
        String yn = sc.nextLine();
        while (validate.checkInt(yn) == false){
            System.out.println("please enter valid integer number");
            System.out.println("please input your selection: ");
            yn = sc.nextLine();
        }
        while (validate.checkRange(Integer.parseInt(yn),1,2) == false){
            System.out.println("Please enter valid range of number");
            System.out.println("Please input your selection: number between 1~2 ");
            yn = sc.nextLine();
        }
        int ynInt = Integer.parseInt(yn);
        if (ynInt == 2){
            criteria.showCriteria();
            System.out.println("Press enter to go back to create criteria page");
            sc.nextLine();
            createCriteria(criteria);
        }
        else{
            System.out.println("Back to create criteria page");
            createCriteria(criteria);
        }


    }

    ////////////////////////////////////////////////////////////////////////
    // Joyce code end
    ////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////////////////////////////////////////
    // Qixin He code start
    ////////////////////////////////////////////////////////////////////////



        private Boolean corrected;


        public void signupCandidate() {
            System.out.println('\u000C');
            clearConsole();
            Scanner sc = new Scanner(System.in);
            ArrayList<String> candidateRecord = new ArrayList<>();
            ArrayList<String> arrayListForChecking = new ArrayList<>();

            String fullName = signupCandiateName();
            candidateRecord.add(fullName);
            String dob = signupCandiateDob();
            candidateRecord.add(dob);
            String address = signupCandidateAddress();
            String[] addressArray = address.split("~");
            String street = addressArray[0];
            String city = addressArray[1];
            String postal = addressArray[2];
            String state = addressArray[3];
            String country = addressArray[4];
            String phone = signupCandidatePhone();
            candidateRecord.add(street);
            candidateRecord.add(city);
            candidateRecord.add(state);
            candidateRecord.add(postal);
            candidateRecord.add(country);
            candidateRecord.add(phone);
            String identificationType = signupCandiateIdentificationType();
            String identificationNumber = signupCandiateIdentificationNumber();
            //￥check identification together
            arrayListForChecking.add(identificationType);
            arrayListForChecking.add(identificationNumber);
            arrayListForChecking = userCheckInput("Identification", arrayListForChecking);
            //￥arrayListForChecking = userCheckInput("Identification", identificationType + ": "
            //￥        + identificationNumber, arrayListForChecking);
            identificationType = arrayListForChecking.get(0).toUpperCase();
            identificationNumber = arrayListForChecking.get(1);
            candidateRecord.add(identificationType);
            candidateRecord.add(identificationNumber);
            arrayListForChecking.clear();
            //input gender and allowed modify gender selection
            corrected = false;
            String gender = signupCandiateGender(true);
            candidateRecord.add(gender);
            //allergies
            String allergies = signupCandiateAllergies();
            candidateRecord.add(allergies);
//food preference
            corrected = false;
            String foodpreferences = signupCandiateFoodpreferences(true);
            candidateRecord.add(foodpreferences);
//qalification
            String qalification = signupCandiateQualification();
            candidateRecord.add(qalification);
            //years of work and occupation
            String[] OccupationAndWorkexperence = signupCandiateOccupation().split("~");
            String occupation = OccupationAndWorkexperence[0];
            String workexperence = OccupationAndWorkexperence[1];
            candidateRecord.add(workexperence);
            candidateRecord.add(occupation);
            //computer skill
            String computerskill = signupCandiateComputerskill(true);
            candidateRecord.add(computerskill);
            //language known
            String language = signupCandiateLanguage();
            candidateRecord.add(language);

            String nationality = signupCandiateNationality();
            candidateRecord.add(nationality);

            System.out.println(candidateRecord);


//FOR TESTING
//        Iterator it = candidateRecord.iterator();
//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }
//
//        writeExcelWithArrayList(candidateRecord);
//
//        System.out.println("You have entered all personal details that required." +
//                "\nYour personal details can be viewed and modified in \"View profile\" in the main page.");
//        System.out.println("System will request your criminal and health records by using your identification ["
//                + identificationType + "]: [" + identificationNumber +"] automaticlly.");

        }

        public String signupCandiateName() {
            //input name
            System.out.println("The next information awating to be entered is full name.");
            System.out.println("Please input your full name:" + "\n(Use a space to saperate different parts of your full name.)"
                    + "\ne.g. \"Jack Smith\"");
            String fullName = convert(forceinputString());
            fullName = removeExtraSpaces(fullName);
            fullName = userCheckInput("Full name", fullName);
            System.out.println('\u000C');
            return fullName;
        }

        public String signupCandiateDob() {
            StringBuffer bufferForChecking = new StringBuffer();
            ArrayList<String> arrayListForChecking = new ArrayList<>();
            //input dob
            System.out.println("The next information awating to be entered is DOB.");
            System.out.println("Please input the year your Date of birth:" + "\n(4 digits. e.g. 1980)");
            String year = forceinputInt();
            while (year.length() != 4) {
                promptWrongEnter("year");
                year = forceinputInt();
            }
            bufferForChecking.append(year);
            arrayListForChecking.add(year);
            bufferForChecking.append("-");

            System.out.println("Please input the month of your DOB:" + "\n(2 digits. e.g. 01)");
            String month = forceinputInt();
            while (month.length() != 2) {
                promptWrongEnter("month");
                month = forceinputInt();
            }
            bufferForChecking.append(month);
            arrayListForChecking.add(month);
            bufferForChecking.append("-");

            System.out.println("Please input the day of your DOB:" + "\n(2 digits. e.g. 01)");
            String day = forceinputInt();
            while (day.length() != 2) {
                promptWrongEnter("day");
                day = forceinputInt();
            }
            bufferForChecking.append(day);
            arrayListForChecking.add(day);
            //arrayListForChecking = userCheckInput("your Date of Birth", bufferForChecking.toString(), arrayListForChecking);
            arrayListForChecking = userCheckInput("your Date of Birth", arrayListForChecking);
            //check Strings length
            while (arrayListForChecking.get(0).length() != 4 || arrayListForChecking.get(1).length() != 2
                    || arrayListForChecking.get(2).length() != 2) {
                System.out.println("The format of the DOB you just entered is not correct, please check again.");
                System.out.println("YEAR must be 4 digits, MONTH must be 2 digits, DAY must be 4 digits.");
                arrayListForChecking = userCheckInput("your Date of Birth", arrayListForChecking);
            }

            String dob = arrayListForChecking.get(2) + "/" + arrayListForChecking.get(1) + "/" + arrayListForChecking.get(0);
            System.out.println('\u000C');
            return dob;
        }

        public String signupCandidatePhone() {
            Scanner sc = new Scanner(System.in);
            //input phone
            System.out.println("The next information awating to be entered is [Phone Number].");
            System.out.println("Please enter your phone number:");
            String phone = forceinputInt();
            phone = userCheckInput("Phone", phone);
            System.out.println(phone);
            return phone;
        }

        public String signupCandidateAddress() {
            Scanner sc = new Scanner(System.in);
            StringBuffer bufferForChecking = new StringBuffer();
            ArrayList<String> arrayListForChecking = new ArrayList<>();
            //input address
            System.out.println("The next information awating to be entered is address.");
            System.out.println("Please enter the street number of your address:");
            String streetNumber = forceinputInt();

            System.out.println("Please enter the street name of your address:");
            System.out.println("Use a space to separate different part of the street names.");
            String streetName = forceinputString();

            System.out.println("Please enter the suburb/city name of your address:");
            String suburb = forceinputString();

            System.out.println("Please enter the postcode of your address:");
            String postcode = removeExtraSpaces(sc.nextLine());

            System.out.println("Please enter the state of your address:");
            String state = forceinputString();

            System.out.println("Please enter the country of your address:");
            String country = forceinputString();

            System.out.println("Please enter other detials of your address:" + "\ne.g. Unit, Lot."
                    + "(If your address doesn't has extra details, please enter n/a");
            String otherdetails = forceinputString();


        /*
        bufferForChecking.append(otherdetails);
        bufferForChecking.append(",");
        bufferForChecking.append(streetNumber);
        bufferForChecking.append(" ");
        bufferForChecking.append(streetName);
        bufferForChecking.append(",");
        bufferForChecking.append(suburb);
        bufferForChecking.append(" ");
        bufferForChecking.append(postcode);
        bufferForChecking.append(",");
        bufferForChecking.append(state);
        bufferForChecking.append(",");
        bufferForChecking.append(country);

         */
            if (!otherdetails.equalsIgnoreCase("n/a"))
                arrayListForChecking.add(otherdetails);

            arrayListForChecking.add(streetNumber);
            arrayListForChecking.add(streetName);
            arrayListForChecking.add(suburb);
            arrayListForChecking.add(postcode);
            arrayListForChecking.add(state);
            arrayListForChecking.add(country);
            //arrayListForChecking = userCheckInput("address", bufferForChecking.toString(), arrayListForChecking);
            arrayListForChecking = userCheckInput("address", arrayListForChecking);
            String address = "Information input not Successfully, please modify it in the main page after successfully registered and loged in.";
            String street = "";
            String city = "";
            String postal = "";
            if (arrayListForChecking.size() == 7) {
                street = arrayListForChecking.get(0) + "," + arrayListForChecking.get(1) + " "
                        + arrayListForChecking.get(2);
                city = arrayListForChecking.get(3);
                postal = arrayListForChecking.get(4);
                state = arrayListForChecking.get(5);
                country = arrayListForChecking.get(6);

            }
            //if there is no otherdetails in the address
            else if (arrayListForChecking.size() == 6) {
                street = arrayListForChecking.get(0) + " " + arrayListForChecking.get(1);
                city = arrayListForChecking.get(2);
                postal = arrayListForChecking.get(3);
                state = arrayListForChecking.get(4);
                country = arrayListForChecking.get(5);

            }
            address = street + "~" + city + "~" + postal + "~" + state + "~" + country;
            System.out.println('\u000C');
            return address;
        }

        public String signupCandiateNationality() {
            //input nationality
            System.out.println("The next information awating to be entered is nationality.");
            System.out.println("Please enter your nationality:");
            String nationality = forceinputString();
            nationality = userCheckInput("Nationality", nationality);
            return nationality;
        }

        public String signupCandiateIdentificationType() {
            //input identification number
            System.out.println("The next information awating to be entered is identification type.");
            System.out.println("Please enter your identification type:");
            String identificationType = forceinputString().toUpperCase();
            return identificationType;
        }

        public String signupCandiateIdentificationNumber() {
            System.out.println("Please enter your identification number:");
            String identificationNumber = forceinputInt();
            System.out.println('\u000C');
            return identificationNumber;
        }

        public String signupCandiateGender(Boolean corrected) {
            //input gender
            if (corrected == true) {
                System.out.println("The next information awating to be entered is gender.");
            }
            System.out.println("Please enter your gender by choosing an option:"
                    + "\n1.Female 2.Male 3.Other" + "\ne.g. If you are female, enter 1.");
            String gender = forceinputInt();
            while (!((gender.equals("1")) || (gender.equals("2")) || (gender.equals("3")))) {
                System.out.println("The option you choose is not correct.");
                gender = forceinputInt();
            }
            switch (gender) {
                case "1":
                    gender = "Female";
                    break;
                case "2":
                    gender = "Male";
                    break;
                case "3":
                    gender = "Other";
                    break;
            }
            gender = userCheckInput("Gender", gender);
            System.out.println('\u000C');
            return gender;
        }

        public String signupCandiateAllergies() {
            ArrayList<String> arrayListForChecking = new ArrayList<>();
            StringBuffer stringBuffer = new StringBuffer();
            //input allergies
            System.out.println("The next information awating to be entered is Allergies.");
            System.out.println("If you don't have any allergies, please enter n/a.");
            System.out.println("Please enter ( one of ) your Allergies:");
            String allergies = "";
            allergies = forceinputString();
            while (!(allergies.equalsIgnoreCase("n/a"))) {
                stringBuffer.append(allergies);
                stringBuffer.append(",");
                arrayListForChecking.add(allergies);
                System.out.println("Please enter your next Allergies:");
                System.out.println("If you don't have more allergies, please enter n/a.");
                allergies = forceinputString();
            }
            if (arrayListForChecking.size() == 0 && allergies.equalsIgnoreCase("n/a")) {
                allergies = "n/a";
                stringBuffer.append(allergies);
                arrayListForChecking.add(allergies);
            }
            arrayListForChecking = userCheckInput("Allergie(s)", arrayListForChecking);
            //arrayListForChecking = userCheckInput("Allergie(s)", stringBuffer.toString(), arrayListForChecking);
            stringBuffer.delete(0, stringBuffer.length());
            Iterator it = arrayListForChecking.iterator();
            while (it.hasNext()) {
                stringBuffer.append(it.next());
                stringBuffer.append(",");
            }
            stringBuffer.delete(stringBuffer.length() - 1, stringBuffer.length());
            clearConsole();

            return stringBuffer.toString();
        }

        public String signupCandiateFoodpreferences(Boolean corrected) {
            //input food preferences
            if (corrected == true) {
                System.out.println("The next information awating to be entered is food preferences.");
            }
            System.out.println("Please enter your food preferences by choosing an option:"
                    + "\n1.none 2.kosher 3.vegetarian 4.vegan 5.halal");
            String foodPreferences = forceinputInt();
            while (!(foodPreferences.equals("1") || foodPreferences.equals("2") || foodPreferences.equals("3")
                    || foodPreferences.equals("4") || foodPreferences.equals("5")))
                foodPreferences = forceinputInt();
            switch (foodPreferences) {
                case "1":
                    foodPreferences = "none";
                    break;
                case "2":
                    foodPreferences = "kosher";
                    break;
                case "3":
                    foodPreferences = "vegetarian";
                    break;

                case "4":
                    foodPreferences = "vegan";
                    break;
                case "5":
                    foodPreferences = "halal";
                    break;
            }
            System.out.println('\u000C');
            foodPreferences = userCheckInput("Food Preference", foodPreferences);
            return foodPreferences;
        }

        public String signupCandiateQualification() {
            ArrayList<String> arrayListForChecking = new ArrayList<>();
            StringBuffer stringBuffer = new StringBuffer();
            //input qualification(s)
            System.out.println("The next information awating to be entered is qualification(s).");
            System.out.println("Please enter ( one of ) your qualification:");
            System.out.println("(If you don't have any, please enter n/a.");
            String qalification = forceinputString();
            //
            while (!(qalification.equalsIgnoreCase("n/a"))) {
                arrayListForChecking.add(qalification);
                System.out.println("Please enter your next qalification:");
                System.out.println("If you don't have more qalification, please enter n/a.");
                qalification = forceinputString();
            }
            if (qalification.equalsIgnoreCase("n/a") && arrayListForChecking.size() == 0) {
                qalification = "n/a";
                arrayListForChecking.add(qalification);
            }
            arrayListForChecking = userCheckInput("Qalification(s)", arrayListForChecking);

            Iterator it = arrayListForChecking.iterator();
            while (it.hasNext()) {
                stringBuffer.append(it.next());
                stringBuffer.append((","));
            }
            stringBuffer.delete(stringBuffer.length() - 1, stringBuffer.length());
            System.out.println('\u000C');
            return stringBuffer.toString();
        }

        public String signupCandiateOccupation() {
            ArrayList<String> arrayListForChecking = new ArrayList<>();
            StringBuffer stringBuffer = new StringBuffer();
            //inout occupation(s)
            System.out.println("The next information awating to be entered is occupation(s).");
            System.out.println("Please enter ( one of ) your occupation(s):");
            System.out.println("(If you don't have any, please enter n/a.");
            String occupation = forceinputString();
            ArrayList<String> occupationList = new ArrayList<>();
            while (!(occupation.equalsIgnoreCase("n/a"))) {
                //stringBuffer.append(occupation);
                //stringBuffer.append(",");
                //String occupationAddtoList = occupation;
                arrayListForChecking.add(occupation);
                //occupationList.add(occupationAddtoList);
                //
                System.out.println("Please enter your next occupation:");
                System.out.println("If you don't have more occupation, please enter n/a.");
                occupation = forceinputString();
            }
            if (occupation.equalsIgnoreCase("n/a") && arrayListForChecking.size() == 0) {
                occupation = "n/a";
                arrayListForChecking.add(occupation);
            }

            arrayListForChecking = userCheckInput("Occupation", arrayListForChecking);
            Iterator it = arrayListForChecking.iterator();
            while (it.hasNext()) {
                stringBuffer.append(it.next());
                stringBuffer.append((", "));
            }
            stringBuffer.delete(stringBuffer.length() - 2, stringBuffer.length());
            stringBuffer.append("~");
            stringBuffer.append(signupCandiateWorkexperience(arrayListForChecking));
            System.out.println('\u000C');
            return stringBuffer.toString();
        }

        public String signupCandiateWorkexperience(ArrayList occupationList) {
            StringBuffer stringBuffer = new StringBuffer();
            //input work experience
            System.out.println("The next information awating to be entered is work experience.");
            System.out.println("(Please round the number. e.g. enter 5 if worked for 4.5yr or 5.4yr)");
            Iterator<String> it = occupationList.iterator();
            Iterator<String> it2 = occupationList.iterator();
            while (it.hasNext()) {
                System.out.println("Please enter the number of year you worked as " + it.next() + ".");
                String workyr = forceinputInt();
                workyr = userCheckInput("Work experience rounded as year for " + it2.next(), workyr);
                stringBuffer.append(workyr + "yr");
                stringBuffer.append(",");
            }
            stringBuffer.delete(stringBuffer.length() - 1, stringBuffer.length());
            System.out.println('\u000C');
            return stringBuffer.toString();
        }

        public String signupCandiateComputerskill(Boolean firstGetin) {
            ArrayList<String> arrayListForChecking = new ArrayList<>();
            StringBuffer stringBuffer = new StringBuffer();
            //input computer skill
            String computerSkills = null;
            int userInput = 0;
            Scanner sc = new Scanner(System.in);
            if(firstGetin == true)
                System.out.println("The next information awating to be entered is computerSkill(s).");
            System.out.println("Please choose your computerSkill(s):");
            System.out.println("1.novice  2.intermediate  3.advanced  4.expert  5.n/a");
            while(true) {
                try {
                    userInput = sc.nextInt();
                    while(true){
                        if(userInput>=1 && userInput<=5){
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


            switch (userInput) {
                case 1:
                    computerSkills = "Novice";
                    break;
                case 2:
                    computerSkills = "Intermediate";
                    break;
                case 3:
                    computerSkills = "Advanced";
                    break;

                case 4:
                    computerSkills = "Expert";
                    break;
                case 5:
                    computerSkills = "n/a";
                    break;
            }
            System.out.println('\u000C');
            computerSkills = userCheckInput("Computer Skills", computerSkills);
            return computerSkills;

        }

        public String signupCandiateLanguage() {
            StringBuffer stringBuffer = new StringBuffer();
            ArrayList<String> arrayListForChecking = new ArrayList<>();
            //input language(s) spoken
            System.out.println("The next information awating to be entered is language(s) spoken.");
            System.out.println("Please enter ( one of ) your language(s) spoken:");
            System.out.println("(If you don't have any, please enter n/a.");
            String language = forceinputString();
            while (!(language.equalsIgnoreCase("n/a"))) {
                arrayListForChecking.add(language);
                System.out.println("Please enter your next language(s) spoken:");
                System.out.println("If you don't have more language(s) spoken, please enter n/a.");
                language = forceinputString();
            }
            if (language.equalsIgnoreCase("n/a") && arrayListForChecking.size() == 0) {
                language = "n/a";
                arrayListForChecking.add(language);
            }
            arrayListForChecking = userCheckInput("Language Spoken", arrayListForChecking);
            Iterator it = arrayListForChecking.iterator();
            while (it.hasNext()) {
                stringBuffer.append(it.next());
                stringBuffer.append((","));
            }
            stringBuffer.delete(stringBuffer.length() - 1, stringBuffer.length());
            System.out.println('\u000C');
            return stringBuffer.toString();


        }


        //https://stackoverflow.com/questions/237159/whats-the-best-way-to-check-if-a-string-represents-an-integer-in-java
        public static boolean isInteger(String str) {
            if (str == null) {
                return false;
            }
            int length = str.length();
            if (length == 0) {
                return false;
            }
            int i = 0;
            if (str.charAt(0) == '-') {
                if (length == 1) {
                    return false;
                }
                i = 1;
            }
            for (; i < length; i++) {
                char c = str.charAt(i);
                if (c < '0' || c > '9') {
                    return false;
                }
            }
            return true;
        }

        private static boolean validation(String str) {
            boolean correct = false;
            if (!(str.trim().isEmpty()))
                correct = true;
            return correct;
        }

        private String forceinputString() {
            Boolean entered = false;
            String nextinput = "";
            Scanner sc = new Scanner(System.in);
            while (entered == false) {
                nextinput = sc.nextLine();
                if (validation(nextinput) == true) {
                    System.out.println('\u000C');
                    return removeExtraSpaces(convert(nextinput.trim()));
                }
                System.out.println("The input is not correct, pleace enter again:");
            }
            return removeExtraSpaces(nextinput);
        }

        private static String forceinputInt() {
            Boolean inputInt = false;
            Scanner sc = new Scanner(System.in);
            String anInt = sc.nextLine();
            while ((inputInt == false)) {
                if (isInteger(anInt) == false) {
                    System.out.println("The information has not been entered correctly. Please enter again:");
                    anInt = sc.nextLine();
                } else {
                    inputInt = true;
                }
            }
            return anInt;
        }

        //checked - original
    /*
    private String userCheckInput(String title, String input) {
        Scanner sc = new Scanner(System.in);
        System.out.println(title + ": " + input);
        System.out.println("Is that correct?");
        System.out.println("1.Yes, it is correct. 2.I need to modify it.");
        String choice = forceinputInt();
        while (!(choice.equals("1") || choice.equals("2"))) {
            System.out.println("You have not enter an option number above. Please enter an option:");
            choice = forceinputInt();
        }
        if (choice.equals("1")) {
            corrected = true;
        }
        if (choice.equals("2")) {
            corrected = false;
        }
        while (corrected == false) {
            System.out.println("Please enter the correct " + title + ":");
            input = sc.nextLine();
            userCheckInput(title, input);
        }

        return input;
    }

     */
        private String userCheckInput(String title, String input) {
            Scanner sc = new Scanner(System.in);
            System.out.println(title + ": " + input);
            System.out.println("Is that correct?");
            System.out.println("1.Yes, it is correct. 2.I need to modify it.");
            //force the user to input either 1 or 2
            String choice = forceinputInt();
            while (!(choice.equals("1") || choice.equals("2"))) {
                System.out.println("You have not enter an option number above. Please enter an option:");
                choice = forceinputInt();
            }
            //handle "user want to correct gender" case
            if (title.equals("Gender") || title.equals("Food Preference") || title.equals("Computer Skills")) {
                if ((choice.equals("1")))
                    return input;
                if ((choice.equals("2"))) {
                    if (title.equals("Gender")) {
                        input = signupCandiateGender(false);
                        return convert(removeExtraSpaces(input));
                    }
                    if (title.equals("Food Preference")) {
                        input = signupCandiateFoodpreferences(false);
                        return convert(removeExtraSpaces(input));
                    }
                    if (title.equals("Computer Skills")) {
                        input = signupCandiateComputerskill(false);
                        return convert(removeExtraSpaces(input));
                    }
                }
            }


            if (choice.equals("1")) {
                corrected = true;
            }
            if (choice.equals("2")) {
                corrected = false;
            }
            while (corrected == false) {
                System.out.println("Please enter the correct " + title + ":");
                input = sc.nextLine();
                userCheckInput(title, convert(removeExtraSpaces(input)));
            }

            return convert(removeExtraSpaces(input));
        }

        //checked-original
    /*
    private static ArrayList userCheckInput(String title, ArrayList<String> arrayListForChecking) {
        int index = 0;
        Scanner sc = new Scanner(System.in);
        StringBuffer displayBuffer = new StringBuffer();
        //ArrayList<String> displayInput = new ArrayList<>();
        //Iterator it2 = displayInput.iterator();
        Iterator it = arrayListForChecking.iterator();
        System.out.println("Is " + title + " correct?");
        while (it.hasNext()) {
            System.out.print(it.next());
            System.out.print(" ");

        }
        System.out.println(" ");
        System.out.println("1.Yes, it is correct. 2.I need to modify it.");
        String choice = forceinputInt();
        while (!(choice.equals("1") || choice.equals("2"))) {
            System.out.println("You have not enter an option number above. Please enter an option:");
            choice = forceinputInt();
        }
        if (choice.equals("1")) {
            return arrayListForChecking;
        }
        System.out.println("Choose an option above to modify:");
        it = arrayListForChecking.iterator();
        while (it.hasNext()) {
            displayBuffer.append(index + 1);
            displayBuffer.append(". ");
            displayBuffer.append(it.next());
            displayBuffer.append("  ");
            index++;
        }
        System.out.println(displayBuffer.toString());
        String choosemodify = forceinputInt();
        while (Integer.parseInt(choosemodify) > index + 1 || Integer.parseInt(choosemodify) <= 0) {
            promptWrongEnter("option");
            choosemodify = forceinputInt();
        }
        String modification = "";
        System.out.println("The part you want to modify: " + choosemodify + ". " + arrayListForChecking.get(Integer.parseInt(choosemodify) - 1));
        System.out.println("Please enter the correct information for this part:");
        if (isInteger(arrayListForChecking.get(Integer.parseInt(choosemodify) - 1)))
            modification = forceinputInt();

        else
            modification = forceinputString();

        arrayListForChecking.set(Integer.parseInt(choosemodify) - 1, modification);
        userCheckInput(title, arrayListForChecking);
        System.out.println('\u000C');
        return arrayListForChecking;
    }

     */

        private ArrayList userCheckInput(String title, ArrayList<String> arrayListForChecking) {
            int index = 0;
            Scanner sc = new Scanner(System.in);
            StringBuffer displayBuffer = new StringBuffer();
            //ArrayList<String> displayInput = new ArrayList<>();
            //Iterator it2 = displayInput.iterator();
            Iterator it = arrayListForChecking.iterator();
            System.out.println("Is the information of " + title + " correct?");
            while (it.hasNext()) {
                System.out.print(it.next());
                System.out.print(" ");

            }
            System.out.println(" ");
            System.out.println("1.Yes, it is correct. 2.I need to modify it.");
            String choice = forceinputInt();
            while (!(choice.equals("1") || choice.equals("2"))) {
                System.out.println("You have not enter an option number above. Please enter an option:");
                choice = forceinputInt();
            }
            if (choice.equals("1")) {
                return arrayListForChecking;
            }
            System.out.println("Choose an option above to modify:");
            it = arrayListForChecking.iterator();
            while (it.hasNext()) {
                displayBuffer.append(index + 1);
                displayBuffer.append(". \"");
                displayBuffer.append(convert(removeExtraSpaces(it.next().toString())));
                displayBuffer.append("\" part   ");
                index++;
            }
            System.out.println(displayBuffer.toString());
            System.out.println(index + 1 + ". Other option(s)");
            String choosemodify = forceinputInt();
            while (Integer.parseInt(choosemodify) > index + 1 || Integer.parseInt(choosemodify) <= 0) {
                promptWrongEnter("option");
                choosemodify = forceinputInt();
            }
            String modification = "";
            if (Integer.parseInt(choosemodify) == index + 1) {
                //user choosing other option of allergies part /Qalification(s) part/Occupation
                //allowing user to add more information or remove information
                if (title.equals("Allergie(s)") || title.equals("Qalification(s)")
                        || title.equals("Occupation") || title.equals("Computer Skill")
                        || title.equals("Language Spoken")) {
                    System.out.println("============MODIFY " + title.toUpperCase() + "===============");
                    System.out.println("You can enter \"less\" if you want to remove a " + title
                            + "\nor enter \"more\" to enter a new " + title);
                    modification = forceinputString();
                    while (!(modification.equalsIgnoreCase("more") || modification.equalsIgnoreCase("less"))) {
                        promptWrongEnter("option");
                        modification = forceinputString();
                    }
                    if (modification.equalsIgnoreCase("less")) {
                        System.out.println("Which one you want to remove?");
                        System.out.println(displayBuffer.toString());
                        choosemodify = forceinputInt();
                        index = arrayListForChecking.size() + 1;
                        while (Integer.parseInt(choosemodify) > index + 1 || Integer.parseInt(choosemodify) <= 0) {
                            promptWrongEnter("option");
                            choosemodify = forceinputInt();
                        }
                        System.out.println("The " + title + ": " + arrayListForChecking.get(Integer.parseInt(choosemodify) - 1) + " has been removed.");
                        arrayListForChecking.remove(Integer.parseInt(choosemodify) - 1);
                    }
                    if (modification.equalsIgnoreCase("more")) {
                        System.out.println("Please enter a new " + title + ":");
                        modification = forceinputString();
                        arrayListForChecking.add(modification);
                    }
                    userCheckInput(title, arrayListForChecking);
                    return arrayListForChecking;
                } else {
                    System.out.println("There is no other option for " + title);
                    userCheckInput(title, arrayListForChecking);
                    return arrayListForChecking;
                }
            }
            System.out.println("The part you want to modify: " + choosemodify + ". " + arrayListForChecking.get(Integer.parseInt(choosemodify) - 1));
            System.out.println("Please enter the correct information for this part:");
            if (isInteger(arrayListForChecking.get(Integer.parseInt(choosemodify) - 1)))
                modification = forceinputInt();

            else
                modification = forceinputString();

            arrayListForChecking.set(Integer.parseInt(choosemodify) - 1, modification);
            userCheckInput(title, arrayListForChecking);
            System.out.println('\u000C');
            return arrayListForChecking;
        }


        private void promptWrongEnter(String str) {
            System.out.println("You have not enter a correct " + str
                    + ". Please enter it again.");
        }

        //
        public void writeExcelWithArrayList(ArrayList record) {
            InputStream in = null;
            String UTF8_ENCODING = "UTF-8";
            Scanner sc = new Scanner(System.in);
            try {
                try {
                    WorkbookSettings setEncode = new WorkbookSettings();
                    setEncode.setEncoding(UTF8_ENCODING);
                    in = new FileInputStream(new java.io.File("Candidate.xls"));
                    Workbook existingWorkbook = Workbook.getWorkbook(in);
                    WritableWorkbook workbookCopy = Workbook.createWorkbook(new java.io.File("Candidate.xls"), existingWorkbook);
                    WritableSheet sheetToEdit = workbookCopy.getSheet(0);
                    int emptyRowNumber = 0;
                    Cell[] cells = sheetToEdit.getColumn(0);
                    emptyRowNumber = cells.length;
                    Cell lastIdCell = cells[cells.length - 1];
                    String lastIdExist = lastIdCell.getContents();
                    String newId = String.valueOf(Integer.parseInt(lastIdExist) + 1);
                    sheetToEdit.addCell(new Label(0, emptyRowNumber, newId));
                    for (int j = 0; j < record.size(); j++) {
                        sheetToEdit.addCell(new Label(j + 1, emptyRowNumber, record.get(j).toString()));
                    }
                    System.out.println("Your record has been recorded by the system.");
                    workbookCopy.write();
                    workbookCopy.close();
                    in.close();
                } catch (IOException | WriteException | BiffException e) {
                    System.out.println(e.getMessage());
                } finally {
                    in.close();
                }
            } catch (IOException a) {
                System.out.println("IOException happened in your finally block QAQ.");
            }
        }

        public void readLastExcelRecordToArray() {
            InputStream in = null;
            String UTF8_ENCODING = "UTF-8";
            Scanner sc = new Scanner(System.in);
            try {
                try {
                    WorkbookSettings setEncode = new WorkbookSettings();
                    setEncode.setEncoding(UTF8_ENCODING);
                    in = new FileInputStream(new java.io.File("mission.xls"));
                    Workbook existingWorkbook = Workbook.getWorkbook(in);
                    WritableWorkbook workbookCopy = Workbook.createWorkbook(new java.io.File("mission.xls"), existingWorkbook);
                    WritableSheet sheetToEdit = workbookCopy.getSheet(0);
                    int lastRowNumber = 0;
                    Cell[] cells = sheetToEdit.getColumn(0);
                    lastRowNumber = cells.length -1;
                    Cell[] lastMissionRecord = sheetToEdit.getRow((lastRowNumber));
                    for (int j = 0; j < lastMissionRecord.length; j++) {
                        System.out.println(lastMissionRecord[j].getContents());
                    }
                    System.out.println("Your record has been extracted.");
                    workbookCopy.write();
                    workbookCopy.close();
                    in.close();
                } catch (IOException | WriteException | BiffException e) {
                    System.out.println(e.getMessage());
                } finally {
                    in.close();
                }
            } catch (IOException a) {
                System.out.println("IOException happened in your finally block QAQ.");
            }
        }

        public void readExcelAllMission() {
            InputStream in = null;
            String UTF8_ENCODING = "UTF-8";
            Scanner sc = new Scanner(System.in);
            try {
                try {
                    WorkbookSettings setEncode = new WorkbookSettings();
                    setEncode.setEncoding(UTF8_ENCODING);
                    in = new FileInputStream(new File("mission.xls"));
                    Workbook existingWorkbook = Workbook.getWorkbook(in);
                    WritableWorkbook workbookCopy = Workbook.createWorkbook(new java.io.File("mission.xls"), existingWorkbook);
                    WritableSheet sheetToEdit = workbookCopy.getSheet(0);
                    int lastRowNumber = 0;
                    Cell[] cells = sheetToEdit.getColumn(0);
                    Cell[] missionNameCells = sheetToEdit.getColumn(17);
                    for (int j = 0; j < cells.length; j++) {
                        System.out.println("mission id:" + cells[j].getContents()+ "  mission name: " + missionNameCells[j].getContents());
                    }
                    System.out.println("Your record has been extracted.");
                    workbookCopy.write();
                    workbookCopy.close();
                    in.close();
                } catch (IOException | WriteException | BiffException e) {
                    System.out.println(e.getMessage());
                } finally {
                    in.close();
                }
            } catch (IOException a) {
                System.out.println("IOException happened in your finally block QAQ.");
            }
        }

        //unchecked
        public final void clearConsole() {
            try {
                final String os = System.getProperty("os.name");

                if (os.contains("Windows")) {
                    Runtime.getRuntime().exec("cls");
                } else {
                    Runtime.getRuntime().exec("clear");
                }
            } catch (final Exception e) {
                //  Handle any exceptions.
            }
        }

        //https://www.geeksforgeeks.org/java-program-convert-first-character-uppercase-sentence/
        private String convert(String str) {
            // Create a char array of given String
            char ch[] = str.toCharArray();
            for (int i = 0; i < str.length(); i++) {

                // If first character of a word is found
                if (i == 0 && ch[i] != ' ' ||
                        ch[i] != ' ' && ch[i - 1] == ' ') {

                    // If it is in lower-case
                    if (ch[i] >= 'a' && ch[i] <= 'z') {

                        // Convert into Upper-case
                        ch[i] = (char) (ch[i] - 'a' + 'A');
                    }
                }

                // If apart from first character
                // Any one is in Upper-case
                else if (ch[i] >= 'A' && ch[i] <= 'Z')

                    // Convert into Lower-Case
                    ch[i] = (char) (ch[i] + 'a' - 'A');
            }

            // Convert the char array to equivalent String
            String st = new String(ch);
            return st;
        }

        public String removeExtraSpaces(String str) {
            ArrayList<String> strings = new ArrayList<>();
            String[] StringArray = str.split(" ");
            StringBuffer stringBuffer = new StringBuffer();
            if (StringArray.length > 1) {
                for (int i = 0; i <= StringArray.length - 1; i++) {
                    strings.add(StringArray[i]);
                }
                //https://stackoverflow.com/questions/5520693/in-java-remove-empty-elements-from-a-list-of-strings
                strings.removeAll(Arrays.asList("", null));
                Iterator it = strings.iterator();
                while (it.hasNext()) {
                    stringBuffer.append(it.next());
                    stringBuffer.append(" ");

                }
                stringBuffer.delete(stringBuffer.length() - 1, stringBuffer.length());
                return stringBuffer.toString();
            }
            return str;
        }

    ////////////////////////////////////////////////////////////////////////
    // Qixin He code end
    ////////////////////////////////////////////////////////////////////////

    }


