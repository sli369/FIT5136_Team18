package com.company;

import jxl.Cell;
import jxl.Sheet;
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
import java.util.Scanner;

public class CandidateControl {

    private static final String UTF8_ENCODING = "UTF-8";
    private ArrayList<Candidate> candidates;
    MainPageController mp = new MainPageController();

    public void addCandidate() {
        try {
            Workbook book = Workbook.getWorkbook(new File("Candidate.xls"));
            int sheetSize = book.getNumberOfSheets();
            Sheet sheet = book.getSheet(0);
            int row_total = sheet.getRows();
            int columns_total = sheet.getColumns();
            for (int j = 1; j < row_total; j++) {
                String id;
                String name;
                String dateOfBirth;
                String street;
                String city;
                String state;
                String postal;
                String country;
                String phone;
                String idtype;
                String gender;
                String allergies;
                String foodPreference;
                String qualifications;
                String workExperience;
                String occupation;
                String computerSkill;
                String language;
                String nationality;
                String missionid;


                Cell[] cells = sheet.getRow(j);
                id = cells[0].getContents();
                name = cells[1].getContents();
                dateOfBirth = cells[2].getContents();
                street = cells[3].getContents();
                city = cells[4].getContents();
                state = cells[5].getContents();
                postal = cells[6].getContents();
                country = cells[7].getContents();
                phone = cells[8].getContents();
                idtype = cells[9].getContents();
                gender = cells[10].getContents();
                allergies = cells[11].getContents();
                foodPreference = cells[12].getContents();
                qualifications = cells[13].getContents();
                workExperience = cells[14].getContents();
                occupation = cells[15].getContents();
                computerSkill = cells[16].getContents();
                language = cells[17].getContents();
                nationality = cells[18].getContents();
                missionid = cells[19].getContents();


                Candidate candidate = new Candidate(id, name, dateOfBirth, street, city, state, postal, country, phone, idtype, gender, allergies, foodPreference, qualifications, workExperience, occupation, computerSkill, language, nationality, missionid);
                candidates.add(candidate);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<Candidate> getCandidate(){
        candidates = new ArrayList<Candidate>();
        addCandidate();
        return candidates;
    }

//    public void showCandidates(){
//        candidates = getCandidate();
//        System.out.println("Show all shuttle Id");
//        for(int i=0; i<candidates.size(); i++){
//            System.out.println("Shuttle id: " + candidates.get(i).getCity());
//        }
//    }

    public Candidate changeCandidateInfo(Candidate candidate){
        String option;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the title you want to update (e.g Street): ");
        System.out.println("NOTE: ID, Name, Gender, DOB, Nationality cannot be changed!");

        while (true) {
            try {
                option = sc.next();
                while (true) {
                    if (option.equals("Street") || option.equals("City") || option.equals("Postal") || option.equals("State") || option.equals("Country") || option.equals("Phone") || option.equals("IDType") || option.equals("Allergies") || option.equals("FoodPreferences") || option.equals("Qualifications") || option.equals("WorkExp.") || option.equals("Occupation") || option.equals("ComputerSkills") || option.equals("Languages")) {
                        break;
                    } else {
                        System.out.println("Wrong input! Please re-enter");
                        option = sc.next();
                    }
                }
                break;
            } catch (Exception e) {
                System.out.println("Wrong input! please enter a Title (e.g Street): ");
                sc.next();
            }
        }

        if(option.equals("Street")){
            System.out.println("Please enter your new Street");
            String newStreet = sc.next();
            candidate.setStreet(newStreet);

        }
        else if(option.equals("City")){
            System.out.println("Please enter your new City");
            String newCity = sc.next();
            candidate.setCity(newCity);
        }
        else if(option.equals("Postal")){
            System.out.println("Please enter your new Postal");
            String newPostal = sc.next();
            candidate.setPostal(newPostal);
        }
        else if(option.equals("State")){
            System.out.println("Please enter your new State");
            String newState = sc.next();
            candidate.setState(newState);
        }
        else if(option.equals("Country")){
            System.out.println("Please enter your new Country");
            String newCountry = sc.next();
            candidate.setCountry(newCountry);
        }
        else if(option.equals("Phone")){
            System.out.println("Please enter your new Phone");
            String newPhone = sc.next();
            candidate.setPhone(newPhone);
        }
        else if(option.equals("IDType")){
            System.out.println("Please enter your new ID Type");
            String newIDType = sc.next();
            candidate.setIdtype(newIDType);
        }
        else if(option.equals("Allergies")){
            System.out.println("Please enter your new Allergies (split by ',')");
            String newAllergies = sc.next();
            candidate.setAllergies(newAllergies);
        }
        else if(option.equals("FoodPreferences")){
            System.out.println("Please choose your new Food Preferences");
            System.out.println("kosher, vegetarian, vegan, halal, none");
            String newFP;
            while (true) {
                try {
                    newFP = sc.next();
                    while (true) {
                        if (newFP.equals("kosher") || newFP.equals("vegetarian") || newFP.equals("vegan") || newFP.equals("halal") || newFP.equals("none")) {
                            break;
                        } else {
                            System.out.println("Wrong input! Please re-enter");
                            newFP = sc.next();
                        }
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Wrong input! please choose from the list: [kosher, vegetarian, vegan, halal, none]");
                    sc.next();
                }
            }
            candidate.setFoodPreference(newFP);
        }
        else if(option.equals("Qualifications")){
            System.out.println("Please enter your new Qualifications (split by ',')");
            String newQualifications = sc.next();
            candidate.setQualifications(newQualifications);
        }
        else if(option.equals("WorkExp.")){
            System.out.println("Please enter your new Work Exp.");
            String newWorkExp = sc.next();
            candidate.setWorkExperience(newWorkExp);
        }
        else if(option.equals("Occupation")){
            System.out.println("Please enter your new Occupation");
            String newOccupation = sc.next();
            candidate.setOccupation(newOccupation);
        }
        else if(option.equals("ComputerSkills")){
            System.out.println("Please enter your new Computer Skill levels");
            String newCS;
            while (true) {
                try {
                    newCS = sc.next();
                    while (true) {
                        if (newCS.equals("novice") || newCS.equals("intermediate") || newCS.equals("advanced") || newCS.equals("expert")) {
                            break;
                        } else {
                            System.out.println("Wrong input! Please re-enter");
                            newCS = sc.next();
                        }
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Wrong input! please choose from the list: [kosher, vegetarian, vegan, halal, none]");
                    sc.next();
                }
            }
            candidate.setComputerSkill(newCS);
        }
        else if(option.equals("Languages")){
            System.out.println("Please enter your new Languages (split by ',')");
            String newLanguages = sc.next();
            candidate.setLanguage(newLanguages);
        }

        return candidate;
    }



    public void saveCandidateInfo(Candidate candidate){
        candidates = getCandidate();
        int target = 0;
        for (int i = 0; i < candidates.size(); i++) {
            if (candidates.get(i).getName().equals(candidate.getName())) {
                target = i;
            }
        }
        InputStream in = null;
        try {
            WorkbookSettings setEncode = new WorkbookSettings();
            setEncode.setEncoding(UTF8_ENCODING);
            in = new FileInputStream(new File("Candidate.xls"));
            Workbook existingWorkbook = Workbook.getWorkbook(in);
            WritableWorkbook workbookCopy = Workbook.createWorkbook(new java.io.File("Candidate.xls"), existingWorkbook);
            WritableSheet sheetToEdit = workbookCopy.getSheet(0);

            String newStreet = candidate.getStreet();
            String newCity = candidate.getCity();
            String newState = candidate.getState();
            String newPostal = candidate.getPostal();
            String newCountry = candidate.getCountry();
            String newPhone = candidate.getPhone();
            String newIDType = candidate.getIdtype();
            String newAllergies = candidate.getAllergies();
            String newFP = candidate.getFoodPreference();
            String newQualifications = candidate.getQualifications();
            String newWorkExp = candidate.getWorkExperience();
            String newOccupation = candidate.getOccupation();
            String newCS = candidate.getComputerSkill();
            String newLanguages = candidate.getLanguage();

            sheetToEdit.addCell(new Label(3, target + 1, newStreet));
            sheetToEdit.addCell(new Label(4, target + 1, newCity));
            sheetToEdit.addCell(new Label(5, target + 1, newState));
            sheetToEdit.addCell(new Label(6, target + 1, newPostal));
            sheetToEdit.addCell(new Label(7, target + 1, newCountry));
            sheetToEdit.addCell(new Label(8, target + 1, newPhone));
            sheetToEdit.addCell(new Label(9, target + 1, newIDType));
            sheetToEdit.addCell(new Label(11, target + 1, newAllergies));
            sheetToEdit.addCell(new Label(12, target + 1, newFP));
            sheetToEdit.addCell(new Label(13, target + 1, newQualifications));
            sheetToEdit.addCell(new Label(14, target + 1, newWorkExp));
            sheetToEdit.addCell(new Label(15, target + 1, newOccupation));
            sheetToEdit.addCell(new Label(16, target + 1, newCS));
            sheetToEdit.addCell(new Label(17, target + 1, newLanguages));


            workbookCopy.write();
            workbookCopy.close();
            in.close();
        } catch (IOException | WriteException | BiffException e) {
            System.out.println(e.getMessage());
        }
    }

}
