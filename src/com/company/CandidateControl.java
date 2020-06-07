package com.company;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import java.io.File;
import java.util.ArrayList;

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


                Candidate candidate = new Candidate(id, name, dateOfBirth, street, city, state, postal, country, phone, idtype, gender, allergies, foodPreference, qualifications, workExperience, occupation, computerSkill, language, nationality);
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

    public void showCandidates(){
        candidates = getCandidate();
        System.out.println("Show all shuttle Id");
        for(int i=0; i<candidates.size(); i++){
            System.out.println("Shuttle id: " + candidates.get(i).getCity());
        }
    }


}
