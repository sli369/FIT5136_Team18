package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        int flag = 0;
        ArrayList<String> userList = readFile();

        // search username in users.txt
        for (String i : userList) {
            System.out.println(i.substring(0, i.indexOf(",")));
        }


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
        ArrayList<String> userList = readFile();
        //清屏
        System.out.println('\u000C');

        System.out.println("Please enter your username:");
        String input_username = sc.next();

        // search username in users.txt
        String u1 = null;
        for (String i : userList) {
            if (input_username.equals(i.substring(0, i.indexOf(",")))) {
                u1 = i;
            }
        }

        if (!userList.contains(u1)) {
            // if not exist
            System.out.print("Username doesn't exist, please try again!");
        } else {
            // if account exists
            while (true) {
                String[] user_record = u1.split(",");
                if (Integer.parseInt(user_record[2]) > 0) {
                    System.out.println("Please input your password: ");
                    String input_password = sc.next();

                    //login successful
                    if (input_password.equals(user_record[1])) {
                        System.out.println("Login successful!");

                        System.out.println("Hello!" + user_record[0]);

                        System.out.println("TO BE CONTINUED");
                        String eee = sc.next();


                    }
                    // login failed
                    else {
                        // reduce attempts allowed
                        attemptPenalty(user_record[0]);
                        // re-read file to update attempt chances
                        ArrayList<String> list1 = readFile();
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
                } else {
                    System.out.println("Your account has been locked, please contact admin!");
                    return;
                }
            }
        }
    }


    private static void signup() {
        ArrayList<String> list = readFile();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Choose an account type:" + "\n1.Administrator  2.Coordinator  3.Candidate");
            if (sc.next().equals("3")) {
                signupCandidate();
            }
            System.out.println("Please input username: ");
            String input_username = sc.next();

            String u3 = null;
            for (String m : list) {
                if (input_username.equals(m.substring(0, m.indexOf(",")))) {
                    u3 = m;
                }
            }

            if (list.contains(u3)) {
                System.out.print("Username exists!");
            } else {
                System.out.println("Please input password: ");
                String input_password = sc.next();
                //这里要写加入user id

                list.add(input_username + "," + input_password + ",3,3");
                writeFile(list);
                System.out.println("Registered successfully！");
                break;
            }
        }
    }

    private static ArrayList<String> readFile() {
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader("users.txt"))) {
            String row = null;
            while ((row = in.readLine()) != null) {
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

    private static void writeFile(ArrayList<String> list) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter("users.txt"))) {
            for (String s : list) {
                out.write(s);
                out.newLine();
            }

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void attemptPenalty(String n) {
        ArrayList<String> list = readFile();

        String s1 = null;
        for (String s : list) {
            if (n.equals(s.substring(0, s.indexOf(",")))) {
                s1 = s;
            }
        }

        String[] split = s1.split(",");
        if (list.contains(s1)) {
            int i = Integer.parseInt(split[2]);
            i = i - 1;
            list.remove(s1);
            list.add(split[0] + "," + split[1] + "," + i + "," + split[3]);
            writeFile(list);
        }
    }

    private static void signupCandidate() {
        System.out.println('\u000C');
        Scanner sc = new Scanner(System.in);
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer bufferForChecking = new StringBuffer();
        ArrayList<String> arrayListForChecking = new ArrayList<>();
        //Iterator it = arrayListForChecking.iterator();
        //Boolean entered = false;

        //input name
        System.out.println("The next information awating to be entered is DOB.");
        System.out.println("Please input your full name:");
        String fullName = forceinputString();
        fullName = userCheckInput("Full name", fullName);
        stringBuffer.append(fullName);
        stringBuffer.append("~");
        System.out.println('\u000C');

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
        while (year.length() != 2){
            promptWrongEnter("month");
            month = forceinputInt();}
        bufferForChecking.append(month);
        arrayListForChecking.add(month);
        bufferForChecking.append("-");

        System.out.println("Please input the day of your DOB:" + "\n(2 digits. e.g. 01)");
        String day = forceinputInt();
        while (year.length() != 2) {
            promptWrongEnter("day");
            day = forceinputInt();
        }
        bufferForChecking.append(day);
        arrayListForChecking.add(day);

        userCheckInput("address", bufferForChecking.toString(),arrayListForChecking);
        stringBuffer.append(arrayListForChecking.get(0));
        stringBuffer.append("-");
        stringBuffer.append(arrayListForChecking.get(1));
        stringBuffer.append("-");
        stringBuffer.append(arrayListForChecking.get(2));

        stringBuffer.append("~");
        bufferForChecking.
        System.out.println('\u000C');

        //input address
        System.out.println("The next information awating to be entered is address.");
        System.out.println("Please enter the street number of your address:");
        String streetNumber = forceinputInt();

        System.out.println("Please enter the street name of your address:");
        String streetName = forceinputString();

        System.out.println("Please enter the suburb/city name of your address:");
        String suburb = forceinputInt();

        System.out.println("Please enter the postcode of your address:");
        String postcode = forceinputInt();

        System.out.println("Please enter the state of your address:");
        String state = forceinputString();

        System.out.println("Please enter the country of your address:");
        String country = forceinputString();

        System.out.println("Please enter other detials of your address:" + "\ne.g. Unit, Lot."
                + "(If your address doesn't has extra details, please enter n/a");
        String otherdetails = forceinputString();
        if (otherdetails.equals("n/a"))
            otherdetails = "";


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


        arrayListForChecking.add(otherdetails);
        arrayListForChecking.add(streetNumber);
        arrayListForChecking.add(streetName);
        arrayListForChecking.add(suburb);
        arrayListForChecking.add(postcode);
        arrayListForChecking.add(state);
        arrayListForChecking.add(country);
        userCheckInput("address", bufferForChecking.toString(),arrayListForChecking);

        stringBuffer.append(arrayListForChecking.get(0));
        stringBuffer.append(",");
        stringBuffer.append(arrayListForChecking.get(1));
        stringBuffer.append(" ");
        stringBuffer.append(arrayListForChecking.get(2));
        stringBuffer.append(",");
        stringBuffer.append(arrayListForChecking.get(3));
        stringBuffer.append(" ");
        stringBuffer.append(arrayListForChecking.get(4));
        stringBuffer.append(",");
        stringBuffer.append(arrayListForChecking.get(5));
        stringBuffer.append(",");
        stringBuffer.append(arrayListForChecking.get(6));
        stringBuffer.append("~");
        System.out.println('\u000C');


        //input nationality
        System.out.println("The next information awating to be entered is nationality.");
        System.out.println("Please enter your nationality:");
        String nationality = forceinputString();
        stringBuffer.append(nationality);
        stringBuffer.append("~");

        //input identification number
        System.out.println("The next information awating to be entered is identification number.");
        System.out.println("Please enter your identification type:");
        String identificationType = forceinputString().toUpperCase();
        stringBuffer.append(identificationType);
        stringBuffer.append(":");
        System.out.println("Please enter your identification number:");
        String identificationNumber = forceinputInt();
        stringBuffer.append(identificationNumber);
        stringBuffer.append("~");
        System.out.println('\u000C');

        //input gender
        System.out.println("The next information awating to be entered is gender.");
        System.out.println("Please enter your gender by choosing an option:"
                + "\n1.Female 2.Male 3.Other" + "e.g. If you are female, enter 1.");
        String gender = forceinputInt();
        while (!(gender.equals("1")) || !(gender.equals("2")) || !(gender.equals("3"))) {
            System.out.println("The option you choose is not correct.");
            gender = forceinputInt();
        }
        switch (gender) {
            case "1":
                gender = "Female";
                stringBuffer.append(gender);
                stringBuffer.append("~");
            case "2":
                gender = "Male";
                stringBuffer.append(gender);
                stringBuffer.append("~");
            case "3":
                gender = "Other";
                stringBuffer.append(gender);
                stringBuffer.append("~");
        }
        System.out.println('\u000C');

        //input allergies
        System.out.println("The next information awating to be entered is Allergies.");
        System.out.println("If you don't have any allergies, please enter n/a.");
        System.out.println("Please enter ( one of ) your Allergies:");
        String allergies = "";
        allergies = forceinputString();
        while (!(allergies.equals("n/a"))) {
            stringBuffer.append(allergies);
            stringBuffer.append(",");
            System.out.println("Please enter your next Allergies:");
            System.out.println("If you don't have more allergies, please enter n/a.");
            allergies = forceinputString();
        }
        if (allergies.equals("n/a"))
            allergies = "";
        stringBuffer.append(allergies);
        System.out.println('\u000C');

        //input food preferences
        System.out.println("The next information awating to be entered is food preferences.");
        System.out.println("Please enter your food preferences by choosing an option:"
                + "\n1.none 2.kosher 3.vegetarian 4.vegan 5.halal");
        String foodPreferences = forceinputInt();
        while (!(foodPreferences.equals("1") || foodPreferences.equals("2") || foodPreferences.equals("3")
                || foodPreferences.equals("4") || foodPreferences.equals("5")))
            foodPreferences = forceinputInt();
        switch (foodPreferences) {
            case "1":
                foodPreferences = "none";
                stringBuffer.append(gender);
                stringBuffer.append("~");
            case "2":
                foodPreferences = "kosher";
                stringBuffer.append(gender);
                stringBuffer.append("~");
            case "3":
                foodPreferences = "vegetarian";
                stringBuffer.append(gender);
                stringBuffer.append("~");
            case "4":
                foodPreferences = "vegan";
                stringBuffer.append(gender);
                stringBuffer.append("~");
            case "5":
                foodPreferences = "halal";
                stringBuffer.append(gender);
                stringBuffer.append("~");
        }
        stringBuffer.append(foodPreferences);
        System.out.println('\u000C');

        //input qualification(s)
        System.out.println("The next information awating to be entered is qualification(s).");
        System.out.println("Please enter ( one of ) your qualification:");
        System.out.println("(If you don't have any, please enter n/a.");
        String qalification = forceinputString();
        //
        while (!(qalification.equalsIgnoreCase("n/a"))) {
            stringBuffer.append(qalification);
            stringBuffer.append(",");

            //
            System.out.println("Please enter your next qalification:");
            System.out.println("If you don't have more qalification, please enter n/a.");
            qalification = forceinputString();
        }
        stringBuffer.append("~");
        System.out.println('\u000C');

        //inout occupation(s)
        System.out.println("The next information awating to be entered is occupation(s).");
        System.out.println("Please enter ( one of ) your occupation(s):");
        System.out.println("(If you don't have any, please enter n/a.");
        String occupation = forceinputString();
        ArrayList<String> occupationList = new ArrayList<>();
        while (!(occupation.equalsIgnoreCase("n/a"))) {
            stringBuffer.append(occupation);
            stringBuffer.append(",");
            String occupationAddtoList = occupation;
            occupationList.add(occupationAddtoList);
            //
            System.out.println("Please enter your next occupation:");
            System.out.println("If you don't have more occupation, please enter n/a.");
            occupation = forceinputString();
        }
        stringBuffer.append("~");
        System.out.println('\u000C');

        //input work experience
        System.out.println("The next information awating to be entered is work experience.");
        System.out.println("(Please round the number. e.g. enter 5 if worked for 4.5yr or 5.4yr)");
        Iterator<String> it = occupationList.iterator();
        while (it.hasNext()) {
            System.out.println("Please enter the number of year you worked as " + it.hasNext() + ".");
            String workyr = forceinputInt();
            stringBuffer.append(workyr);
        }
        stringBuffer.append("~");
        System.out.println('\u000C');

        //input computer skill
        System.out.println("The next information awating to be entered is computerSkill(s).");
        System.out.println("Please enter ( one of ) your computerSkill(s):");
        System.out.println("(If you don't have any, please enter n/a.");
        String computerSkill = forceinputString();

        while (!(computerSkill.equalsIgnoreCase("n/a"))) {
            stringBuffer.append(computerSkill);
            stringBuffer.append(",");
            //
            System.out.println("Please enter your next computerSkill:");
            System.out.println("If you don't have more computerSkill, please enter n/a.");
            computerSkill = forceinputString();
        }
        stringBuffer.append("~");
        System.out.println('\u000C');

        //input language(s) spoken
        //input computer skill
        System.out.println("The next information awating to be entered is language(s) spoken.");
        System.out.println("Please enter ( one of ) your language(s) spoken:");
        System.out.println("(If you don't have any, please enter n/a.");
        String language = forceinputString();
        while (!(language.equalsIgnoreCase("n/a"))) {
            stringBuffer.append(language);
            stringBuffer.append(",");
            //
            System.out.println("Please enter your next computerSkill:");
            System.out.println("If you don't have more computerSkill, please enter n/a.");
            language = forceinputString();
        }
        stringBuffer.append("~");
        System.out.println('\u000C');

        System.out.println("You have entered all personal details that required." +
                "\nYour personal details can be viewed and modified in \"View profile\" in the main page.");
        //Do something to the string buffer.(Add it to the excel)

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

    private static String forceinputString() {
        Boolean entered = false;
        String nextinput = "";
        Scanner sc = new Scanner(System.in);
        while (entered == false) {
            System.out.println("The input is not correct, pleace enter again:");
            nextinput = sc.nextLine();
            if (validation(nextinput) == true) {
                entered = true;
                System.out.println('\u000C');
            }
        }
        return nextinput;
    }

    private static String forceinputInt() {
        Boolean inputInt = false;
        Scanner sc = new Scanner(System.in);
        String year = sc.nextLine();
        while ((inputInt == false)) {
            if (isInteger(sc.nextLine()) == false) {
                System.out.println("The information has not been entered correctly. Please enter the year your Date of birth again:");
                year = sc.nextLine();
            } else {
                inputInt = true;
            }
        }
        return year;
    }

    private static String userCheckInput(String title, String input) {
        Scanner sc = new Scanner(System.in);
        System.out.println(title + ": " + input);
        System.out.println("Is that correct?");
        System.out.println("1.Yes, it is correct. 2.I need to modify it.");

        String choice = forceinputInt();
        while (!(choice.equals("2"))) {
            if (!(choice.equals("1"))) {
                System.out.println("You have not enter an option number above. Please enter an option:");
                choice = forceinputInt();
            }
            System.out.println("Please enter the correct " + title + ":");
            input = sc.nextLine();
            userCheckInput(title, input);
        }

        return input;
    }

    private static ArrayList userCheckInput(String title, String input, ArrayList<String> arrayListForChecking) {
        int index = 0;
        Scanner sc = new Scanner(System.in);
        StringBuffer displayBuffer = new StringBuffer();
        System.out.println("Which part of information you want to modify?");
        Iterator it = arrayListForChecking.iterator();
        while (it.hasNext()){
            displayBuffer.append(index);
            displayBuffer.append(it.next());
            displayBuffer.append(" ");
            index++;
        }
        System.out.println("Choose an option above to modify:");
        String choosemodify = forceinputInt();
        while (Integer.parseInt(choosemodify) > index || Integer.parseInt(choosemodify) < 0)
        {
            promptWrongEnter("option");
            choosemodify = forceinputInt();
        }
        String modification = "";
        if (isInteger(arrayListForChecking.get(Integer.parseInt(choosemodify))))
            modification = forceinputInt();
        else
            modification = forceinputString();

        arrayListForChecking.set(Integer.parseInt(choosemodify), modification);
        userCheckInput(title,input,arrayListForChecking);
        return arrayListForChecking;
    }

    private static void promptWrongEnter(String str) {
        System.out.println("You have not enter a correct " + str
                + ". Please enter it again.");
    }
}
