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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Zoe {
    private Boolean corrected;

    public Zoe() {
    }


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
        String computerskill = signupCandiateComputerskill();
        candidateRecord.add(computerskill);
        //language known
        String language = signupCandiateLanguage();
        candidateRecord.add(language);

        String nationality = signupCandiateNationality();
        candidateRecord.add(nationality);


//FOR TESTING
        Iterator it = candidateRecord.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        writeExcelWithArrayList(candidateRecord);

        System.out.println("You have entered all personal details that required." +
                "\nYour personal details can be viewed and modified in \"View profile\" in the main page.");
        System.out.println("System will request your criminal and health records by using your identification ["
                + identificationType + "]: [" + identificationNumber +"] automaticlly.");

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

    public String signupCandiateComputerskill() {
        ArrayList<String> arrayListForChecking = new ArrayList<>();
        StringBuffer stringBuffer = new StringBuffer();
        //input computer skill
        System.out.println("The next information awating to be entered is computerSkill(s).");
        System.out.println("Please enter ( one of ) your computerSkill(s):");
        System.out.println("(If you don't have any, please enter n/a.");
        String computerSkill = forceinputString();

        while (!(computerSkill.equalsIgnoreCase("n/a"))) {
            arrayListForChecking.add(computerSkill);
            //
            System.out.println();
            System.out.println("Please enter your next computerSkill:");
            System.out.println("If you don't have more computerSkill, please enter n/a.");
            computerSkill = forceinputString();
        }
        if (computerSkill.equalsIgnoreCase("n/a") && arrayListForChecking.size() == 0) {
            computerSkill = "n/a";
            arrayListForChecking.add(computerSkill);
        }
        arrayListForChecking = userCheckInput("Computer Skill", arrayListForChecking);
        Iterator it = arrayListForChecking.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next());
            stringBuffer.append((","));
        }
        stringBuffer.delete(stringBuffer.length() - 1, stringBuffer.length());
        System.out.println('\u000C');
        return stringBuffer.toString();
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
        if (title.equals("Gender") || title.equals("Food Preference")) {
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


    private static void promptWrongEnter(String str) {
        System.out.println("You have not enter a correct " + str
                + ". Please enter it again.");
    }

    //
    public void writeExcelWithArrayList(ArrayList record) {
        //String existingxlsPathName = "/Users/zoe/IdeaProjects/FIT5136_Team18/Candidate.xls";
        //WorkbookSettings wbSettings = new WorkbookSettings();
        //wbSettings.setLocale(new Locale("en", "EN"));
        //WritableWorkbook writebook = null;
        InputStream in = null;
        String UTF8_ENCODING = "UTF-8";
        Scanner sc = new Scanner(System.in);
        try {
            try {
                WorkbookSettings setEncode = new WorkbookSettings();
                setEncode.setEncoding(UTF8_ENCODING);
                in = new FileInputStream(new File("Candidate.xls"));
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

    //unchecked
    public final static void clearConsole() {
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
}
