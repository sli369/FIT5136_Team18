package com.company;

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) {


        ArrayList<String> userList = readFile("users.txt");


        while (true) {
            System.out.println("\n***** Welcome to Mission to Mars *****\r\n");
            System.out.println("1.Login\t\t2.Sign up\t\t3.Exit\r\n");
            System.out.println("****************************");
            System.out.println("Please input your selection: ");
            try {
                int i = new Scanner(System.in).nextInt();
                switch (i) {
                    case 1:
                        login();
                        break;
                    case 2:
                        signup();
                        break;
                    case 3:
                        System.exit(0);
                    default:
                        System.out.println("Invalid input!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please try again!");
            }
        }
    }

    private static void login() {
        // read user input
        Scanner sc = new Scanner(System.in);
        ArrayList<String> userList = readFile("users.txt");
        System.out.println(userList);
        System.out.println("Please enter your username:");
        String input_username = sc.next();

        // search username in users.txt
        String u1 = null;
        for (String i : userList) {
            if (input_username.equals(i.substring(0,i.indexOf(",")))){
                u1 = i;
            }
        }

        if (!userList.contains(u1)){
            // if not exist
            System.out.print("Username doesn't exist, please try again!");
        } else {
            // if account exists
            while (true) {
                String[] user_record = u1.split(",");
                if (Integer.parseInt(user_record[2])>0) {
                    System.out.println("Please input your password: ");
                    String input_password = sc.next();

                    //login successful
                    if (input_password.equals(user_record[1])) {
                        System.out.println("Login successful!");

                        System.out.println("Hello!" + user_record[0]);

                        System.out.println("Please select an option: ");
                        System.out.println("1. Create a mission");
                        System.out.println("2. View all missions");
                        System.out.println("3. Select a space shuttle");
                        System.out.println("4. Candidate information");
                        try {
                            int i = new Scanner(System.in).nextInt();
                            switch (i) {
                                case 1:
                                    System.out.println("create mission");
                                    break;
                                case 2:
                                    System.out.println("view missions");
                                    break;
                                case 3:
                                    selectShuttle();
                                case 4:
                                    System.out.println("candidate information");
                                case 5:
                                    System.exit(0);
                                    break;
                                default:
                                    System.out.println("Invalid input!");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Please try again!");
                        }



                    }
                    // login failed
                    else {
                        // reduce attempts allowed
                        attemptPenalty(user_record[0]);
                        // re-read file to update attempt chances
                        ArrayList<String> list1 = readFile("users.txt");
                        String u2 = null;
                        for (String j : list1) {
                            if (j.startsWith(input_username)) {
                                u2 = j;
                            }
                        }
                        String[] user_record1 = u2.split(",");
                        if (Integer.parseInt(user_record1[2]) > 0) {
                            System.out.print("Incorrect password, you have " + user_record1[2] + " times left!");
                        } else {
                            System.out.println("You have input wrong password for 3 times, please contact admin!");
                            break;
                        }
                    }
                }else {
                    System.out.println("Your account has been locked, please contact admin!");
                    return;
                }
            }
        }
    }


    private static void signup() {
        ArrayList<String> list = readFile("users.txt");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Please input username: ");
            String input_username = sc.next();

            String u3 = null;
            for (String m : list) {
                if (input_username.equals(m.substring(0,m.indexOf(",")))){
                    u3 = m;
                }
            }

            if (list.contains(u3)){
                System.out.print("Username exists!");
            }else {
                System.out.println("Please input password: ");
                String input_password = sc.next();

                list.add(input_username + "," + input_password + ",3,3");
                writeFile(list, "users.txt");
                System.out.println("Registered successfully！");
                break;
            }
        }
    }

    private static ArrayList<String> readFile(String filename){
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(filename))) {
            String row = null;
            while ((row = in.readLine()) != null){
                list.add(row);
            }

            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    private static void writeFile(ArrayList<String> list, String filename){
        try (BufferedWriter out = new BufferedWriter(new FileWriter(filename))) {
            for (String s : list) {
                out.write(s);
                out.newLine();
            }

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void attemptPenalty(String n){
        ArrayList<String> list = readFile("users.txt");

        String s1 = null;
        for (String s : list) {
            if (n.equals(s.substring(0,s.indexOf(",")))){
                s1 = s;
            }
        }

        String[] split = s1.split(",");
        if (list.contains(s1)){
            int i = Integer.parseInt(split[2]);
            i = i-1;
            list.remove(s1);
            list.add(split[0]+","+split[1]+","+i+","+split[3]);
            writeFile(list, "users.txt");
        }
    }
// Simon's Code Starts Here ************************************************
    public static void selectShuttle(){


        ArrayList<String> shuttle_list = readFile("shuttles.txt");

        for(int i=0; i<shuttle_list.size(); i++){
            System.out.println((i + ". " + shuttle_list.get(i).substring(0,shuttle_list.get(i).indexOf(","))));
        }

        while(true) {
            System.out.println("Please choose one shuttle: ");
            int i = new Scanner(System.in).nextInt();
            if (i < shuttle_list.size()) {
                List<String> shuttle_info = Arrays.asList(shuttle_list.get(i).split(","));
                System.out.println("Name: " + shuttle_info.get(0));
                System.out.println("Manufacture Year: " + shuttle_info.get(1));
                System.out.println("Fuel Capacity (in litres): " + shuttle_info.get(2));
                System.out.println("Passenger Capacity: " + shuttle_info.get(3));
                System.out.println("Cargo Capacity (in kgs): " + shuttle_info.get(4));
                System.out.println("Travel Speed (kms/hr)" + shuttle_info.get(5));
                System.out.println("Origin Country: " + shuttle_info.get(6));
                System.out.println("\n\nWould you like to assign this shuttle to a mission?");
                System.out.println("1. Yes");
                System.out.println("2. No");
                int n = new Scanner(System.in).nextInt();
                switch(n){
                    case 1:
                        System.out.println("Which mission would you like to assign to?");
                        //show mission
                        int m = new Scanner(System.in).nextInt();

            }
            System.out.println("Please try again!");
        }




        }

    }

// Simon's Code Ends Here ************************************************





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
