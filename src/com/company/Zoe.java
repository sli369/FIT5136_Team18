package com.company;

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
import java.util.Iterator;
import java.util.Scanner;
import java.lang.StringBuffer;

public class Zoe {
    private  Boolean corrected;
    public Zoe() {
    }


    public void signupCandidate() {
        System.out.println('\u000C');
        Scanner sc = new Scanner(System.in);
        ArrayList<String> candidateRecord = new ArrayList<>();
        ArrayList<String> arrayListForChecking = new ArrayList<>();
        //Iterator it = arrayListForChecking.iterator();
        //Boolean entered = false;

        String fullName = signupCandiateName();
        candidateRecord.add(fullName);
        String dob = signupCandiateDob();
        candidateRecord.add(dob);
        String address = signupCandidateAddress();
        candidateRecord.add(address);
        String identificationType = signupCandiateIdentificationType();
        String identificationNumber = signupCandiateIdentificationNumber();
        //check identification together
        arrayListForChecking.add(identificationType);
        arrayListForChecking.add(identificationNumber);
        arrayListForChecking = userCheckInput("Identification", arrayListForChecking);
        //arrayListForChecking = userCheckInput("Identification", identificationType + ": "
        //        + identificationNumber, arrayListForChecking);
        identificationType = arrayListForChecking.get(0).toUpperCase();
        identificationNumber = arrayListForChecking.get(1);
        candidateRecord.add(identificationType);
        candidateRecord.add(identificationNumber);
        arrayListForChecking.clear();
        String nationality = signupCandiateNationality();
        candidateRecord.add(nationality);
        String gender = signupCandiateGender();
        String allergies = signupCandiateAllergies();
        String foodpreferences = signupCandiateFoodpreferences();
        String qulification = signupCandiateQualification();
        String[] OccupationAndWorkexperence = signupCandiateOccupation().split("~");
        String occupation = OccupationAndWorkexperence[0];
        String workexperence = OccupationAndWorkexperence[1];
        String computerskill = signupCandiateComputerskill();
        String language = signupCandiateLanguage();

        candidateRecord.add(gender);
        candidateRecord.add(allergies);
        candidateRecord.add(foodpreferences);
        candidateRecord.add(qulification);
        candidateRecord.add(occupation);
        candidateRecord.add(workexperence);
        candidateRecord.add(computerskill);
        candidateRecord.add(language);

        System.out.println("You have entered all personal details that required." +
                "\nYour personal details can be viewed and modified in \"View profile\" in the main page.");
        //Do something to the string buffer.(Add it to the excel

    }

    public String signupCandiateName() {
        //input name
        System.out.println("The next information awating to be entered is full name.");
        System.out.println("Please input your full name:");
        String fullName = forceinputString();
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
        arrayListForChecking = userCheckInput("your Date of Birth",arrayListForChecking);
        String dob = arrayListForChecking.get(0) + "/" + arrayListForChecking.get(1) + "/" + arrayListForChecking.get(2);
        System.out.println('\u000C');
        return dob;
    }

    public String signupCandidateAddress() {
        StringBuffer bufferForChecking = new StringBuffer();
        ArrayList<String> arrayListForChecking = new ArrayList<>();
        //input address
        System.out.println("The next information awating to be entered is address.");
        System.out.println("Please enter the street number of your address:");
        String streetNumber = forceinputInt();

        System.out.println("Please enter the street name of your address:");
        String streetName = forceinputString();

        System.out.println("Please enter the suburb/city name of your address:");
        String suburb = forceinputString();

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
        //arrayListForChecking = userCheckInput("address", bufferForChecking.toString(), arrayListForChecking);
        arrayListForChecking = userCheckInput("address", arrayListForChecking);

        String address = arrayListForChecking.get(0) + "," + arrayListForChecking.get(1) + " "
                + arrayListForChecking.get(2) + "," + arrayListForChecking.get(3) + " "
                + arrayListForChecking.get(4) + "," + arrayListForChecking.get(5) + ","
                + "," + arrayListForChecking.get(6);
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

    public String signupCandiateGender() {
        //input gender
        System.out.println("The next information awating to be entered is gender.");
        System.out.println("Please enter your gender by choosing an option:"
                + "\n1.Female 2.Male 3.Other" + "\ne.g. If you are female, enter 1.");
        String gender = forceinputInt();
        while (!(gender.equals("1")) || !(gender.equals("2")) || !(gender.equals("3"))) {
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
        while (!(allergies.equals("n/a"))) {
            stringBuffer.append(allergies);
            stringBuffer.append(",");
            arrayListForChecking.add(allergies);
            System.out.println("Please enter your next Allergies:");
            System.out.println("If you don't have more allergies, please enter n/a.");
            allergies = forceinputString();
        }
        if (allergies.equals("n/a")) {
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
        System.out.println('\u000C');
        return stringBuffer.toString();
    }

    public String signupCandiateFoodpreferences() {
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
        return foodPreferences;
    }

    public String signupCandiateQualification() {
        StringBuffer stringBuffer = new StringBuffer();
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

        System.out.println('\u000C');
        return stringBuffer.toString();
    }

    public String signupCandiateOccupation() {
        StringBuffer stringBuffer = new StringBuffer();
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
        stringBuffer.append(signupCandiateWorkexperience(occupationList));
        System.out.println('\u000C');
        return stringBuffer.toString();
    }

    public String signupCandiateWorkexperience(ArrayList occupationList) {
        StringBuffer stringBuffer = new StringBuffer();
        //input work experience
        System.out.println("The next information awating to be entered is work experience.");
        System.out.println("(Please round the number. e.g. enter 5 if worked for 4.5yr or 5.4yr)");
        Iterator<String> it = occupationList.iterator();
        while (it.hasNext()) {
            System.out.println("Please enter the number of year you worked as " + it.hasNext() + ".");
            String workyr = forceinputInt();
            stringBuffer.append(workyr);
            stringBuffer.append(",");
        }

        System.out.println('\u000C');
        return stringBuffer.toString();
    }

    public String signupCandiateComputerskill() {
        StringBuffer stringBuffer = new StringBuffer();
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

        System.out.println('\u000C');
        return stringBuffer.toString();
    }

    public String signupCandiateLanguage() {
        StringBuffer stringBuffer = new StringBuffer();
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

    private static String forceinputString() {
        Boolean entered = false;
        String nextinput = "";
        Scanner sc = new Scanner(System.in);
        while (entered == false) {
            nextinput = sc.nextLine();
            if (validation(nextinput) == true) {
                entered = true;
                System.out.println('\u000C');
                return nextinput;
            }
            System.out.println("The input is not correct, pleace enter again:");
        }
        return nextinput;
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

    //checked
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
        if(choice.equals("1")) {
            corrected = true;
        }
        if(choice.equals("2")) {
            corrected = false;
        }
        while (corrected == false) {
            System.out.println("Please enter the correct " + title + ":");
            input = sc.nextLine();
            userCheckInput(title, input);
        }

        return input;
    }

    //not checked
    private static ArrayList userCheckInput(String title, ArrayList<String> arrayListForChecking) {
        int index = 0;
        Scanner sc = new Scanner(System.in);
        StringBuffer displayBuffer = new StringBuffer();
        //ArrayList<String> displayInput = new ArrayList<>();
        //Iterator it2 = displayInput.iterator();
        Iterator it = arrayListForChecking.iterator();
        System.out.println("Is " + title + " correct?");
        while (it.hasNext())
        {
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
        if(choice.equals("1")) {
            return arrayListForChecking;
        }
        System.out.println("Choose an option above to modify:");
        it = arrayListForChecking.iterator();
        while (it.hasNext()) {
            displayBuffer.append(index+1);
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
        System.out.println("The part you want to modify: " + choosemodify + ". " + arrayListForChecking.get(Integer.parseInt(choosemodify) - 1) );
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

    private static void WriteExcel() {
        //String existingxlsPathName = "/Users/zoe/IdeaProjects/FIT5136_Team18/Candidate.xls";
        //WorkbookSettings wbSettings = new WorkbookSettings();
        //wbSettings.setLocale(new Locale("en", "EN"));
        //WritableWorkbook writebook = null;
        InputStream in = null;
        String UTF8_ENCODING = "UTF-8";
        Scanner sc = new Scanner(System.in);
        try {
            WorkbookSettings setEncode = new WorkbookSettings();
            setEncode.setEncoding(UTF8_ENCODING);
            in = new FileInputStream(new File("Candidate.xls"));
            Workbook existingWorkbook = Workbook.getWorkbook(in);
            WritableWorkbook workbookCopy = Workbook.createWorkbook(new java.io.File("Candidate.xls"), existingWorkbook);
            WritableSheet sheetToEdit = workbookCopy.getSheet(0);
            String value = sc.nextLine();
            sheetToEdit.addCell(new Label(5, 12, value));
            System.out.println("You add successfully");
            workbookCopy.write();
            workbookCopy.close();
            in.close();
        } catch (IOException | WriteException | BiffException e) {
            System.out.println(e.getMessage());
        }
    }

}
