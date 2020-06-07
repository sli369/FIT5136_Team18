package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Jsave {
    private ArrayList<Criteria> criterias;



   public void startCreateCriteria()
   {
       Criteria criteria = new Criteria();
       createCriteria(criteria);
   }
    ////////////////////////////////////////////////////////////////////////
    // Joyce code start
    ///////////////////////////////////////////////////////////////////////


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
        while (validate.checkRange(Integer.parseInt(minAge),15,90) == false){
            System.out.println("Please enter valid range of number");
            System.out.println("please enter the min age that above 15");
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
        while (validate.checkRange(Integer.parseInt(maxAge),15,90) == false){
            System.out.println("Please enter valid range of number");
            System.out.println("please enter the max age that below 90");
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
    ///////////////////////////////////////////////////////////////////////
}
