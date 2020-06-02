package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Jsave {





    ////////////////////////////////////////////////////////////////////////
    // Joyce code start
    ///////////////////////////////////////////////////////////////////////


    //    private int numberOfEmployee;
    //    private byte requiredGender;
    public void createCriteria(String[] args) {

        //ArrayList<String> candidateList = readFile("users.txt");
        Validate validate = new Validate();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n********** create the criteria to select employees **********\r\n");
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
                        ageRange();
                        break;
                    case 2:
                        qualification();
                        break;
                    case 3:
                        yearsOfWorkExperience();
                    case 4:
                        occupations();
                    case 5:
                        computerSkills();
                    case 6:
                        languageSpoken();

                    default:
                        System.out.println("Invalid input!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please try again!");
            }
        }
    }




    //
    private Criteria ageRange(){
        Scanner sc = new Scanner(System.in);
        Criteria criteria = new Criteria();
        Validate validate = new Validate();
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
        System.out.println("Do you want to continue to set the qualification criteria? ");
        System.out.println("1.Yes\\t\\t2.No\\r\\n\" ");
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
            qualification();
        }
        else{
            System.out.println("Back to create criteria page");
            //不知道怎么回criteria page!!!!!!
            ;
        }

        return criteria;

    }

    private Criteria qualification(){
        Scanner sc = new Scanner(System.in);
        Criteria criteria = new Criteria();
        Validate validate = new Validate();

        System.out.println("please enter the qualifications you want to set, please split them with ','");
        String[] quali = sc.nextLine().split(",");
        criteria.setQualification(quali);
        System.out.println("you have set qualifications: " + quali);

        System.out.println("Do you want to continue to set the yearsOfWorkExperience criteria? ");
        System.out.println("1.Yes\\t\\t2.No\\r\\n\" ");
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
            yearsOfWorkExperience();
        }
        else{
            System.out.println("Back to create criteria page");
            //不知道怎么回criteria page!!!!!!
        }

        return criteria;
    }



    private Criteria yearsOfWorkExperience(){
        Scanner sc = new Scanner(System.in);
        Criteria criteria = new Criteria();
        Validate validate = new Validate();

        //补充！！！

        System.out.println("Do you want to continue to set the occupations criteria? ");
        System.out.println("1.Yes\\t\\t2.No\\r\\n\" ");
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
            occupations();
        }
        else{
            System.out.println("Back to create criteria page");
            //不知道怎么回criteria page!!!!!!
        }

        return criteria;

    }

    private Criteria occupations(){
        Scanner sc = new Scanner(System.in);
        Criteria criteria = new Criteria();
        Validate validate = new Validate();

        System.out.println("please enter the occupations you want to set, please split them with ','");
        String[] occu = sc.nextLine().split(",");
        criteria.setOccupations(occu);
        System.out.println("you have set occupations: " + occu);
        System.out.println("please set the number of employees you need with each kind of occupations");

        //for (int i = 0;i <= occu.length){

        // }
        //System.out.println("how many " + occu[0] + " you need?");
        //String n = sc.nextLine();
        //while (validate.checkInt(minAge) == false){
        // System.out.println("please enter valid integer number");
        //System.out.println("please enter the min age");
        //minAge = sc.nextLine();
        //}
        // while (validate.checkRange(Integer.parseInt(minAge),15,90) == false){
        // System.out.println("Please enter valid range of number");
        // System.out.println("please enter the min age that above 15");
        //minAge = sc.nextLine();
        //}
        // int minAgeInt = Integer.parseInt(minAge);
        //criteria.setMinimumAge(minAgeInt);


        System.out.println("Do you want to continue to set the computerSkills criteria? ");
        System.out.println("1.Yes\\t\\t2.No\\r\\n\" ");
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
            computerSkills();
        }
        else{
            System.out.println("Back to create criteria page");
            //不知道怎么回criteria page!!!!!!
        }

        return criteria;

    }

    private Criteria computerSkills(){
        Scanner sc = new Scanner(System.in);
        Criteria criteria = new Criteria();
        Validate validate = new Validate();

        System.out.println("please enter the computer skills you want to set, please split them with ','");
        String[] comp = sc.nextLine().split(",");
        criteria.setComputerSkills(comp);
        System.out.println("you have set computerSkills: " + comp);

        System.out.println("Do you want to continue to set the languageSpoken criteria? ");
        System.out.println("1.Yes\\t\\t2.No\\r\\n\" ");
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
            languageSpoken();
        }
        else{
            System.out.println("Back to create criteria page");
            //不知道怎么回criteria page!!!!!!
        }

        return criteria;

    }

    private Criteria languageSpoken(){
        Scanner sc = new Scanner(System.in);
        Criteria criteria = new Criteria();
        Validate validate = new Validate();

        System.out.println("please enter the language spoken you want to set, please split them with ','");
        String[] lang = sc.nextLine().split(",");
        criteria.setLanguageSpoken(lang);
        System.out.println("you have set language spoken: " + lang);

        System.out.println("You want to go back to criteria page or review the criteria created? ");
        System.out.println("1.criteria page\\t\\t2.review criteria\\r\\n\" ");
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
            System.out.println("Press space to go back to create criteria page");
            sc.nextLine();
            //不知道怎么回criteria page!!!!!!
        }
        else{
            System.out.println("Back to create criteria page");
            //不知道怎么回criteria page!!!!!!
        }

        return criteria;

    }

    ////////////////////////////////////////////////////////////////////////
    // Joyce code end
    ///////////////////////////////////////////////////////////////////////
}
