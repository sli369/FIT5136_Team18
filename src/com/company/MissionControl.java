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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;


public class MissionControl {
    private ArrayList<Mission> missions;
    MainPageController mpc = new MainPageController();
    Main main = new Main();




    public ArrayList<Mission> getMissions(){
        missions = new ArrayList<Mission>();
        addMission();
        return missions;
    }

    public void showMissions(){
        missions = getMissions();
        System.out.println("Show all mission Id");
        for(int i=0; i<missions.size(); i++){
            System.out.println("mission id: " + missions.get(i).getMissionId() + "  mission name: "+ missions.get(i).getMissionName());
        }
    }


    public int getMissionsIndex(int id) {
        missions = getMissions();
        int index = 0;
        for (int i = 0; i < missions.size(); i++) {
            if (id == missions.get(i).getMissionId()) {
                index = i;
            }
        }
        return index;
    }

    public void showCorMission(String corName){
        for(Mission mission : missions){
            if (mission.getCoordinator().getName().equals(corName)){
                System.out.println("1.Mission Name:    " + mission.getMissionName());
                System.out.println("2.Mission description:    " + mission.getMissionDescription());
                System.out.println("3.Country of origin:    " + mission.getCountryOfOrigin());
                System.out.println("4.countries allowed:    " + mission.getCountriesAllowed());
                System.out.println("5.Coordinator information: " );
                System.out.println("    a.name: " + mission.getCoordinator().getName());
                System.out.println("    b.contact: " +mission.getCoordinator().getEmail() );
                System.out.println("6.Job information");
                for(int j = 0; j< mission.getJob().size(); j++) {
                    mission.getJob().get(j).showJob();
                }
                System.out.println("7.Employment requirements: " + mission.getEmploymentRequirement());
                System.out.println("    7.1 Age range is from: " + mission.getCriteria().getMinage() + " - " + mission.getCriteria().getMaxage());
                System.out.println("    7.2 computer skill require: " + mission.getCriteria().getComputerSkill());
                System.out.println("    7.3 experience requirements: " + mission.getCriteria().getExpYear() + "years");
                System.out.println("    7.4 qualification requiremnts: " + mission.getCriteria().getQualification());
                System.out.println("    7.5 language requirements: " + mission.getCriteria().getLanguage());
                System.out.println("8.Cargo requirements");
                System.out.println("     8.1 Cargo for: " + mission.getCargo().get(0).getCargoFor());
                System.out.println("     8.2 Cargo requirements: " + mission.getCargo().get(0).getRequirement());
                System.out.println("     8.2 Cargo quantity: " + mission.getCargo().get(0).getQuantity());
                System.out.println("9.Launch date: " + mission.getLaunchDate());
                System.out.println("10.Location: " + mission.getLocationDestination());
                System.out.println("11.Duration of the mission: " + mission.getMissionDuration());
                System.out.println("12.Status of the mission " + "(" + mission.getMissionStatus() +")");
                System.out.println("\n\n\n");

            }
        }
    }


    public void showOneMission(int missionId){
        missions = getMissions();
        Scanner sc = new Scanner(System.in);
//        missionId = sc.nextInt();
        int i = getMissionsIndex(missionId);

                System.out.println("1.Mission Name:    " + missions.get(i).getMissionName());
                System.out.println("2.Mission description:    " + missions.get(i).getMissionDescription());
                System.out.println("3.Country of origin:    " + missions.get(i).getCountryOfOrigin());
                System.out.println("4.countries allowed:    " + missions.get(i).getCountriesAllowed());
                System.out.println("5.Coordinator information: " );
                System.out.println("    a.name: " + missions.get(i).getCoordinator().getName());
                System.out.println("    b.contact: " + missions.get(i).getCoordinator().getEmail() );
                System.out.println("6.Job information");
                for(int j = 0; j<missions.get(i).getJob().size(); j++) {
                    missions.get(i).getJob().get(j).showJob();
                }
                System.out.println("7.Employment requirements: " + missions.get(i).getEmploymentRequirement());
                System.out.println("    7.1 Age range is from: " + missions.get(i).getCriteria().getMinage() + " - " + missions.get(i).getCriteria().getMaxage());
                System.out.println("    7.2 computer skill require: " + missions.get(i).getCriteria().getComputerSkill());
                System.out.println("    7.3 experience requirements: " + missions.get(i).getCriteria().getExpYear() + "years");
                System.out.println("    7.4 qualification requiremnts: " + missions.get(i).getCriteria().getQualification());
                System.out.println("    7.5 language requirements: " + missions.get(i).getCriteria().getLanguage());
                System.out.println("8.Cargo requirements");
                System.out.println("     8.1 Cargo for: " + missions.get(i).getCargo().get(0).getCargoFor());
                System.out.println("     8.2 Cargo requirements: " + missions.get(i).getCargo().get(0).getRequirement());
                System.out.println("     8.2 Cargo quantity: " + missions.get(i).getCargo().get(0).getQuantity());
                System.out.println("9.Launch date: " + missions.get(i).getLaunchDate());
                System.out.println("10.Location: " + missions.get(i).getLocationDestination());
                System.out.println("11.Duration of the mission: " + missions.get(i).getMissionDuration());
                System.out.println("12.Status of the mission " + "(" + missions.get(i).getMissionStatus() +")");

    }

    public void showMissionCriteria(int missionId){
        missions = getMissions();
        Scanner sc = new Scanner(System.in);
//        missionId = sc.nextInt();
        boolean findId;

        for(int i=0; i<missions.size(); i++){
            if(missionId == missions.get(i).getMissionId()){
                findId = true;
                System.out.println("1.occupation required");
                for(int j = 0; j<missions.get(i).getJob().size(); j++) {
                    missions.get(i).getJob().get(j).showJob();
                }
                System.out.println("2.Employment requirements: " + missions.get(i).getEmploymentRequirement());
                System.out.println("3.Age range is from: " + missions.get(i).getCriteria().getMinage() + " - " + missions.get(i).getCriteria().getMaxage());
                System.out.println("4.computer skill require: " + missions.get(i).getCriteria().getComputerSkill());
                System.out.println("5.experience requirements: " + missions.get(i).getCriteria().getExpYear() + "years");
                System.out.println("6.qualification requiremnts: " + missions.get(i).getCriteria().getQualification());
                System.out.println("7.language requirements: " + missions.get(i).getCriteria().getLanguage());
            }
            findId = false;
        }

    }

    public void addMission(){
        try{
            Workbook book = Workbook.getWorkbook(new File("mission.xls"));
            int sheetSize = book.getNumberOfSheets();
            Sheet sheet = book.getSheet(0);
            int row_total = sheet.getRows();
            int columns_total = sheet.getColumns();

            // get one line of mission
            for (int j = 1; j < row_total; j++) {

                int missionId;
                Date missionLauchDate;
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");
                String missionOrign;
                int missionDuration;
                int jobNumber;
                String missionDescription;
                String employeeRequire;
                String ageRange;
                int minExp;
                String qualification;
                String occupation;
                String skillRequire;
                String firLanguage;
                String secLanguage;
                String cargoFor;
                String cargoRequire;
                int cargoQuality;
                String missionName;
                String destination;
                ArrayList<String> countriesAllowed;
                char missionStatus;
                String corName;
                String corContact;
                Cell[] cells = sheet.getRow(j);
                missionId = Integer.parseInt(cells[0].getContents());
                missionLauchDate = format.parse(cells[1].getContents());
                missionOrign = cells[2].getContents();
                missionDuration = Integer.parseInt(cells[3].getContents());
                jobNumber = Integer.parseInt(cells[4].getContents());
                missionDescription = cells[5].getContents();
                employeeRequire = cells[6].getContents();
                ageRange = cells[7].getContents();
                minExp = Integer.parseInt(cells[8].getContents());
                qualification = cells[9].getContents();
                occupation = cells[10].getContents();
                skillRequire = cells[11].getContents();
                firLanguage = cells[12].getContents();
                secLanguage = cells[13].getContents();
                cargoFor = cells[14].getContents();
                cargoRequire = cells[15].getContents();
                cargoQuality = Integer.parseInt(cells[16].getContents());
                missionName = cells[17].getContents();
                String countrAll = cells[18].getContents();
                destination = cells[19].getContents();
                missionStatus = cells[20].getContents().charAt(0);
                corName = cells[21].getContents();
                corContact = cells[22].getContents();


                //set countries into arraylist
                if (countrAll.contains(",")) {
                    String[] a = countrAll.split(",");
                    countriesAllowed = new ArrayList<>(Arrays.asList(a));
                }else {
                    // only one country
                    countriesAllowed = new ArrayList<String>();
                    countriesAllowed.add(countrAll);
                }

                //set cargo
                Cargo cargo = new Cargo(cargoFor, cargoRequire, cargoQuality);
                ArrayList<Cargo> cargosPerMission = new ArrayList<Cargo>();
                cargosPerMission.add(cargo);

                // set job
                Job job = new Job(occupation, jobNumber);
                ArrayList<Job> missionJobs = new ArrayList<Job>();
                missionJobs.add(job);

                // set Cordinator
                Coordinator co = new Coordinator(corName, corContact);

                // set Criteria
                String[] age = ageRange.split("-");
                int minAge = Integer.parseInt(age[0]);
                int maxAge = Integer.parseInt(age[1]);
                String language = firLanguage + ", " + secLanguage;
//                String[] languages = language.split(",");
                MissionCriteria mc = new MissionCriteria(minAge, maxAge,skillRequire,minExp,qualification,language);


                // add those value in mission arraylist
                Mission mission = new Mission(missionId, missionName, missionDescription, missionOrign, countriesAllowed,
                        employeeRequire, missionLauchDate, destination, missionDuration, missionStatus, co, missionJobs, cargosPerMission,mc);

                missions.add(mission);

            }

            book.close();
//            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

//    check whether the input is blank
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

//    check whether the input is char
    public boolean isChar(String d){
        boolean isTure;
            if(d.charAt(0)== 'a' && d.charAt(0) == 'b' && d.charAt(0) == 'c' && d.charAt(0) == 'd' && d.charAt(0) == 'e' && d.charAt(0) == 'f'){
                isTure = true;
            }else {
                isTure = false;
            }
            return isTure;
    }

//    check whether the input is int
    public boolean isInt(String st){
        int temp = 0;
        try{
            temp = Integer.parseInt(st);
        }catch(Exception e){
            return false;
        }
        return true;
    }

    private String userCheckInput(String input) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Is that correct?");
        System.out.println("1.Yes, it is correct. 2.I need to modify again.");
        String str = sc.nextLine();
        while (!isInt(str)){
            System.out.println(" ----Please enter the number 1 or 2!!");
            str = sc.nextLine();
        }
        int number = Integer.parseInt(str);
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

    private String createMissionName(){
        Scanner sc = new Scanner(System.in);
        System.out.println("1.Please enter your mission name");
        String missionName = sc.nextLine();
        while (isBlank(missionName))
        {
            System.out.println("the input cannot be null, try to enter again");
            missionName = sc.nextLine();
        }
        System.out.println(missionName + " is your mission name");
        userCheckInput(missionName);
        return missionName;
    }

    private String createMissionDes(){
        Scanner sc = new Scanner(System.in);
        System.out.println("2.Please enter your mission description");
        String missionDes = sc.nextLine();
        while (isBlank(missionDes))
        {
            System.out.println("the input cannot be null, try to enter again");
            missionDes = sc.nextLine();
        }
        System.out.println(missionDes + " is your mission description");
        userCheckInput(missionDes);
        return missionDes;
    }

    private String createCountryOfOri(){
        Scanner sc = new Scanner(System.in);
        System.out.println("3.Please enter the country of origin");
        String countryOrigin = sc.nextLine();
        while (isBlank(countryOrigin))
        {
            System.out.println("the input cannot be null, try to enter again");
            countryOrigin = sc.nextLine();
        }
        System.out.println(countryOrigin + " is your country of origin");
        userCheckInput(countryOrigin);
        return countryOrigin;
    }

    private String createCountriesAllowed(){
        Scanner sc = new Scanner(System.in);
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
        return countriesAllow;
    }

    private String createCorrodinatorName(){
        Scanner sc = new Scanner(System.in);
        System.out.println("5.Please enter the Coordinator information");
        System.out.println("    (1) Please enter coordinator name");
        String corName = sc.nextLine();
        while (isBlank(corName))
        {
            System.out.println("the input cannot be null, try to enter again");
            corName = sc.nextLine();
        }
        userCheckInput(corName);
        return corName;
    }

    public String createCordinatorContact(){
        Scanner sc = new Scanner(System.in);
        System.out.println("    (2) Please enter the contact");
        String corContact = sc.nextLine();
        corContact = checkNumber(corContact);

        return corContact;
    }

    private String createJobName(){
        Scanner sc = new Scanner(System.in);
        System.out.println("6.Please enter the Job information");
        System.out.println("    (1) Please enter the job name");
        String jobName = sc.nextLine();
        while (isBlank(jobName))
        {
            System.out.println("the input cannot be null, try to enter again");
            jobName = sc.nextLine();
        }
        userCheckInput(jobName);
        return jobName;
    }

    private String createEmployeeRequirement(){
        Scanner sc = new Scanner(System.in);
        System.out.println("7.Please enter the employee requirements");
        String emRequire = sc.nextLine();
        while (isBlank(emRequire))
        {
            System.out.println("the input cannot be null, try to enter again");
            emRequire = sc.nextLine();
        }
        userCheckInput(emRequire);
        return emRequire;
    }

    private int createJobNumber(){
        Scanner sc = new Scanner(System.in);
        System.out.println("    (2) Please enter the job number");
        String jobNumber = sc.nextLine();
        while (!isInt(jobNumber)){
            System.out.println("    Please enter the number!!");
            jobNumber = sc.nextLine();
        }
        int jobNo = Integer.parseInt(jobNumber);
        return jobNo;
    }

    private MissionCriteria createMissionRequire(){
        Scanner sc = new Scanner(System.in);
        System.out.println("    (1) Please enter the age requirement: ");
        System.out.print("  min age: ");
        int minage = sc.nextInt();
        System.out.print("  max age: ");
        int maxage = sc.nextInt();
        System.out.println(" Age range is from: " + minage + " - " + maxage);

        System.out.println("    (2)Please Set the computer Skill ");
        System.out.println("Please choose your computerSkill(s):");
        System.out.println("1.novice  2.intermediate  3.advanced  4.expert  5.n/a");
        String computerSkill = "";
        int userInput = 0;
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
                computerSkill = "Novice";
                break;
            case 2:
                computerSkill = "Intermediate";
                break;
            case 3:
                computerSkill = "Advanced";
                break;

            case 4:
                computerSkill = "Expert";
                break;
            case 5:
                computerSkill = "n/a";
                break;
        }

        System.out.println("    computer requirement is: " + computerSkill);
        userCheckInput(computerSkill);

        System.out.println("    (3)Please Set the minimum working experience ");
        String minExp = sc.next();
        while (isBlank(minExp))
        {
            System.out.println("the input cannot be null, try to enter again");
            System.out.println("    hint: how many years e.g 5");
            minExp = sc.nextLine();
        }
        System.out.println("    Minimum working experience is: " + minExp + "yr");
        userCheckInput(minExp);

        System.out.println("    (4) Please enter the qualification requirements: ");
        String qualification = sc.nextLine();
        while (isBlank(qualification))
        {
            System.out.println("the input cannot be null, try to enter again");
            qualification = sc.nextLine();
        }
        System.out.println("    qualification requirement is " + qualification);
        userCheckInput(qualification);

        System.out.println( "   (5) Please enter the language requirement");
        System.out.println("        hint: please add common between languages if you enter many ");
        String languages = sc.nextLine();
        System.out.println("The require languages are " + languages);
        userCheckInput(languages);

        MissionCriteria mc = new MissionCriteria(minage, maxage,computerSkill,Integer.parseInt(minExp),qualification,languages);
        return mc;
    }

    private Cargo createCargo(){
        Scanner sc = new Scanner(System.in);
        System.out.println("8.Please set the cargo information");
        System.out.println("    8.1 Please select the cargo for (mission or journey)");
        String cargoFor = null;
        System.out.println("    ---1.mission  --2.journey");
        int userInput = 0;
        while(true) {
            try {
                userInput = sc.nextInt();
                while(true){
                    if(userInput>=1 && userInput<=2){
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
                cargoFor = "mission";
                break;
            case 2:
                cargoFor = "journey";
                break;

        }
        //check cargo for
        System.out.println("    cargo for " + cargoFor);
        System.out.println("\n");
        System.out.println("    8.2 Please enter cargos ");
        String cargo = sc.next();
        while (isBlank(cargo))
        {
            System.out.println("the input cannot be null, try to enter again");
            cargo = sc.nextLine();
        }
        System.out.println("    cargos are " + cargo);
        System.out.println("    8.3 Please enter the cargo quantity: ");
        int cargoQuantity = sc.nextInt();
        System.out.println("quantity is " + cargoQuantity);
        Cargo cg = new Cargo(cargoFor, cargo, cargoQuantity);
        return cg;
    }

    private Date createLaunchDate(){
        Scanner sc = new Scanner(System.in);
        System.out.println("9.Please set the launch date");
        System.out.println(" hint ('dd/mm/yyyy')");
        String launchTime = sc.nextLine();
        while (isBlank(launchTime))
        {
            System.out.println("the input cannot be null, try to enter again");
            launchTime = sc.nextLine();
        }
        //check to_date
        System.out.println(launchTime +" is your launch date");
        while (!checkDate(launchTime)){
            System.out.println("wrong date format, please follow the correct format with 'dd/MM/yyyy'");
            launchTime = sc.nextLine();
        }
        userCheckInput(launchTime);
        Date missionLauchDate = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");
        try {
            missionLauchDate = format.parse(launchTime);
        }
        catch (ParseException ex) {
            ex.printStackTrace();
        }
        return missionLauchDate;
    }

    private String createDestination(){
        Scanner sc = new Scanner(System.in);
        System.out.println("10.Please set the destination location");
        String location = sc.nextLine();
        while (isBlank(location))
        {
            System.out.println("the input cannot be null, try to enter again");
            location = sc.nextLine();
        }
        System.out.println(location + " is your destination location");
        userCheckInput(location);
        return location;
    }

    private int createDuration(){
        Scanner sc = new Scanner(System.in);
        System.out.println("11.Please set the mission duration");
        System.out.println("    hint(the unit is month)");
        String duration = sc.nextLine();
        while (!isInt(duration)){
            System.out.println("    Please enter the number!!");
            duration = sc.nextLine();
        }
        System.out.println( "Duration are " + duration +" months.");
        userCheckInput(duration);
        int dur = Integer.parseInt(duration);
        return dur;
    }

    private char createMissionStatus(){
        Scanner sc = new Scanner(System.in);
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
        status = checkChar(status);
        System.out.println("Your option is " + status);
        char noStatus = status.charAt(0);
        return noStatus;
    }

    public void createMission() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Now you are going to create a mission");
        System.out.println("****************************");

        // set mission name
       String missionName = createMissionName();
       clearScreen();

        // set mission Description
        String missionDes = createMissionDes();
        clearScreen();

        // set countries of origin
       String countryOrigin = createCountryOfOri();
        clearScreen();

        //set countries allowed
       String countriesAllow = createCountriesAllowed();
        ArrayList<String> countriesAllowed;
        if (countriesAllow.contains(",")) {
            String[] a = countriesAllow.split(",");
            countriesAllowed = new ArrayList<>(Arrays.asList(a));
        }else {
            // only one country
            countriesAllowed = new ArrayList<String>();
            countriesAllowed.add(countriesAllow);
        }
        clearScreen();

        // set coordinator
        String corName = createCorrodinatorName();
        String corContact = createCordinatorContact();
        Coordinator co = new Coordinator(corName, corContact);
        System.out.println("coordinator name is " + corName + " contact is " + corContact);
        clearScreen();

        // fill Job information
        String jobName = createJobName();
        int jobNo = createJobNumber();
        System.out.println("Job information is  " + jobNo + " of " + jobName + "s");
        Job job = new Job(jobName, jobNo);
        ArrayList<Job> missionJobs = new ArrayList<Job>();
        missionJobs.add(job);
        clearScreen();

        // set employee requirements
        String emRequire = createEmployeeRequirement();
        MissionCriteria mc = createMissionRequire();
        clearScreen();

        //8 please set cargo requirements
        Cargo cg = createCargo();
        ArrayList<Cargo> cargosPerMission = new ArrayList<Cargo>();
        cargosPerMission.add(cg);

        System.out.println("Here's you cargo information");
        System.out.println("cargo for " + cg.getCargoFor() + " cargos: " + cg.getRequirement() + " quantity " + cg.getQuantity());

        // set launch time

        Date missionLauchDate = createLaunchDate();
        clearScreen();

        // set location
        String location = createDestination();
        clearScreen();

        // set duration of the mission
        int duration = createDuration();
        clearScreen();

        // set status
        char noStatus = createMissionStatus();
        clearScreen();
        missions = getMissions();
        int i = missions.size();
        int missionId = missions.get(i-1).getMissionId() + 2;

        Mission mission = new Mission(missionId, missionName, missionDes, countryOrigin, countriesAllowed,
                emRequire, missionLauchDate, location, duration, noStatus, co, missionJobs, cargosPerMission,mc);

        missions.add(mission);

        System.out.println("You Mission has been created with MissionID " + missionId);
        System.out.println("    press [1] to save, press [2] to re-modify");
        int save = 0;
        while (true) {
            try {
                save = sc.nextInt();
                while (true) {
                    if (save >= 1 && save <= 2) {
                        break;
                    } else {
                        System.out.println("Wrong input! Please enter a valid option:");
                        save = sc.nextInt();
                    }
                }
                break;
            } catch (Exception e) {
                System.out.println("Wrong input! please enter an Integer: ");
                sc.next();
            }
        }

        switch (save) {
            case 1:
                //write back to excel
                saveMission(mission);
                System.out.println("You mission information has been saved, you can search id " + missionId + " to check it in the View Mission Page");
                System.out.println("  Press [enter] back to view this mission. ");
                sc.next();
                viewMissionPage(co.getName());
                break;
            case 2:
                missions.add(mission);
                modifyMissions(missionId);
                break;
        }


    }

    public void saveMission(Mission mission){
        WritableWorkbook writebook = null;
        InputStream in = null;
        String UTF8_ENCODING = "UTF-8";
        Scanner sc = new Scanner(System.in);
        try {
            WorkbookSettings setEncode = new WorkbookSettings();
            setEncode.setEncoding(UTF8_ENCODING);
            in = new FileInputStream(new File("mission.xls"));
            Workbook existingWorkbook = Workbook.getWorkbook(in);
            WritableWorkbook missionSave = Workbook.createWorkbook(new File("mission.xls"), existingWorkbook);
            WritableSheet sheet = missionSave.getSheet(0);
            int nextRow = sheet.getRows();
//            String value = sc.nextLine();
            String missionId = String.valueOf(mission.getMissionId());
            SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
            String missionLaunchDate = sf.format(mission.getLaunchDate());
            String originCountry = mission.getCountryOfOrigin();
            String duration = String.valueOf(mission.getMissionDuration());
            String numberJob = String.valueOf(mission.getJob().get(0).getNumber());
            String missionDes = mission.getMissionDescription();
            String employeeRquire = mission.getEmploymentRequirement();
            String ageRange = String.valueOf(mission.getCriteria().getMinage()) + " - " + String.valueOf(mission.getCriteria().getMaxage());
            String minExp = String.valueOf(mission.getCriteria().getExpYear());
            String qualification = mission.getCriteria().getQualification();
            String job = mission.getJob().get(0).getJobName();
            String computerSkill = mission.getCriteria().getComputerSkill();
            String[] language = mission.getCriteria().getLanguage().split(",");
            String fLanguage = language[0];
            String secLanguage = mission.getCriteria().getLanguage().substring(2, mission.getCriteria().getLanguage().length()-1);
            String cargoFor = mission.getCargo().get(0).getCargoFor();
            String cargoRequire = mission.getCargo().get(0).getRequirement();
            String cargoQuantity = String.valueOf(mission.getCargo().get(0).getQuantity());
            String missionName = mission.getMissionName();
            String countriesAllow = mission.getCountriesAllowed().toString();
            String destination = mission.getLocationDestination();
            char status = mission.getMissionStatus();
            String coorName = mission.getCoordinator().getName();
            String coorContact = mission.getCoordinator().getEmail();

            sheet.addCell(new Label(0, nextRow, missionId));
            sheet.addCell(new Label(1, nextRow, missionLaunchDate));
            sheet.addCell(new Label(2, nextRow, originCountry));
            sheet.addCell(new Label(3, nextRow, duration));
            sheet.addCell(new Label(4, nextRow, numberJob));
            sheet.addCell(new Label(5, nextRow, missionDes));
            sheet.addCell(new Label(6, nextRow, employeeRquire));
            sheet.addCell(new Label(7, nextRow, ageRange));
            sheet.addCell(new Label(8, nextRow, minExp));
            sheet.addCell(new Label(9, nextRow, qualification));
            sheet.addCell(new Label(10, nextRow, job));
            sheet.addCell(new Label(11, nextRow, computerSkill));
            sheet.addCell(new Label(12, nextRow,fLanguage));
            sheet.addCell(new Label(13, nextRow, secLanguage));
            sheet.addCell(new Label(14, nextRow, cargoFor));
            sheet.addCell(new Label(15, nextRow, cargoRequire));
            sheet.addCell(new Label(16, nextRow, cargoQuantity));
            sheet.addCell(new Label(17, nextRow, missionName));
            sheet.addCell(new Label(18, nextRow, countriesAllow));
            sheet.addCell(new Label(19, nextRow, destination));
            sheet.addCell(new Label(20, nextRow, String.valueOf(status)));
            sheet.addCell(new Label(21, nextRow, coorName));
            sheet.addCell(new Label(22, nextRow, coorContact));

            System.out.println("You add successfully");
            missionSave.write();
            missionSave.close();
            in.close();
        } catch (IOException | WriteException | BiffException e) {
            System.out.println(e.getMessage());
        }
    }


    public void modifyMissions(int id){
        boolean isDone = true;
        int i = getMissionsIndex(id);
        String coName = missions.get(i).getCoordinatorName();
        while (isDone) {
            showOneMission(id);

            System.out.println("\n\n");
            System.out.println("------- Please select an option to modify the mission: ");
            Scanner sc = new Scanner(System.in);
            int userInput = 0;
            String missionName;
            String des;
            String countryOri;
            String countriesAllowed;

            String coContact;
            String jobName;
            int jobNo;
            String empRequire;
            MissionCriteria mc;
            Cargo cargo;
            Date launchDate;
            String location;
            int duration;
            char status;

            while (true) {
                try {
                    userInput = sc.nextInt();
                    while (true) {
                        if (userInput >= 1 && userInput <= 12) {
                            break;
                        } else {
                            System.out.println("Wrong input! Please enter the number between 1 and 12:");
                            userInput = sc.nextInt();
                        }
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Wrong input! please enter an Integer: ");
                    sc.next();
                }
            }

            switch (userInput) {
                case 1:
                    missionName = createMissionName();
                    missions.get(i).setMissionName(missionName);
                    System.out.println("new mission name is " + missions.get(i).getMissionName());
                    isDone = isModifyDone();
                    break;
                case 2:
                    des = createMissionDes();
                    missions.get(i).setMissionDescription(des);
                    isDone = isModifyDone();
                    break;
                case 3:
                    countryOri = createCountryOfOri();
                    missions.get(i).setCountryOfOrigin(countryOri);
                    isDone = isModifyDone();
                    break;
                case 4:
                    countriesAllowed = createCountriesAllowed();
                    ArrayList<String> countriesAllow;
                    if (countriesAllowed.contains(",")) {
                        String[] a = countriesAllowed.split(",");
                        countriesAllow = new ArrayList<>(Arrays.asList(a));
                    }else {
                        // only one country
                        countriesAllow = new ArrayList<String>();
                        countriesAllow.add(countriesAllowed);
                    }
                    missions.get(i).setCountriesAllowed(countriesAllow);
                    isDone = isModifyDone();
                    break;
                case 5:
                    System.out.println("----You are not allowed to modify the coordinator information");
                    isDone = isModifyDone();
                    break;
                case 6:
                    jobName = createJobName();
                    jobNo = createJobNumber();
                    Job job = new Job(jobName, jobNo);
                    ArrayList<Job> missionJobs = new ArrayList<Job>();
                    missionJobs.add(job);
                    missions.get(i).setJob(missionJobs);
                    isDone = isModifyDone();
                    break;
                case 7:
                    empRequire = createEmployeeRequirement();
                    missions.get(i).setEmploymentRequirement(empRequire);
                    mc = createMissionRequire();
                    missions.get(i).setCriteria(mc);
                    isDone = isModifyDone();
                    break;
                case 8:
                    cargo = createCargo();
                    ArrayList<Cargo> cargos = new ArrayList<>();
                    cargos.add(cargo);
                    missions.get(i).setCargo(cargos);
                    isDone = isModifyDone();
                    break;
                case 9:
                    launchDate = createLaunchDate();
                    missions.get(i).setLaunchDate(launchDate);
                    isDone = isModifyDone();
                    break;
                case 10:
                    location = createDestination();
                    missions.get(i).setLocationDestination(location);
                    isDone = isModifyDone();
                    break;
                case 11:
                    duration = createDuration();
                    missions.get(i).setMissionDuration(duration);
                    isDone = isModifyDone();
                    break;
                case 12:
                    status = createMissionStatus();
                    missions.get(i).setMissionStatus(status);
                    isDone = isModifyDone();
                    break;

            }
        }
            System.out.println("Now back to the main page");
            clearScreen();
            mpc.WelcomePage(coName,2);


    }

    private boolean isModifyDone(){
        boolean isTrue;
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you wanna continuously modify the other attributes?");
        System.out.println("    Press [1] to continue, Press [2] to back");
        int userInput = 0;
        while (true) {
            try {
                userInput = sc.nextInt();
                while (true) {
                    if (userInput >= 1 && userInput <= 2) {
                        break;
                    } else {
                        System.out.println("Wrong input! Please enter the number 1 or 2");
                        userInput = sc.nextInt();
                    }
                }
                break;
            } catch (Exception e) {
                System.out.println("Wrong input! please enter an Integer: ");
                sc.next();
            }
        }
        if (userInput == 1){
            isTrue = true;
        }else
            isTrue = false;
        return isTrue;
    }

    public void viewMissionPage(String corName) {
        Scanner sc = new Scanner(System.in);
        MtmSystem mtm = new MtmSystem();
        int userInput = 0;
        showCorMission(corName);
        System.out.println("-- Please select an option: ");
        System.out.println("1. Select Mission with Mission ID to see details");
        System.out.println("2. Back to the Main Page");
        System.out.println("-- Please enter the number of your selection:");

        while (true) {
            try {
                userInput = sc.nextInt();
                while (true) {
                    if (userInput >= 1 && userInput <= 2) {
                        break;
                    } else {
                        System.out.println("Wrong input! Please enter a valid option:");
                        userInput = sc.nextInt();
                    }
                }
                break;
            } catch (Exception e) {
                System.out.println("Wrong input! please enter an Integer: ");
                sc.next();
            }
        }

        switch (userInput) {
            case 1:
                changeMissionDetailed(corName);
                break;
            case 2:

                mpc.WelcomePage(corName,2);
                break;
        }
    }

    public void changeMissionDetailed(String corName){
        Scanner sc = new Scanner(System.in);
        clearScreen();
        System.out.println("**********Change Mission Details************* ");
        System.out.println("Please enter the Mission Id ");
        String missionId = sc.nextLine();
        while (!isInt(missionId)){
            System.out.println("Please enter the correct Mission ID");
            missionId = sc.next();
        }
        int id = Integer.parseInt(missionId);
        showOneMission(id);
        System.out.println("");
        System.out.println("");
        System.out.println("----- Please select an option: -------");
        System.out.println("    1. I want to modify it.");
        System.out.println("    2. I want to select the space shuttle for this mission.");
        System.out.println("    3. I want to create criteria for this mission");
        System.out.println("    4. All good. Back to the last page");
        int userInput = 0;

        while (true) {
            try {
                userInput = sc.nextInt();
                while (true) {
                    if (userInput >= 1 && userInput <= 4) {
                        break;
                    } else {
                        System.out.println("Wrong input! Please enter a valid option:");
                        userInput = sc.nextInt();
                    }
                }
                break;
            } catch (Exception e) {
                System.out.println("Wrong input! please enter an Integer: ");
                sc.next();
            }
        }

        switch (userInput) {
            case 1:
                modifyMissions(id);
                clearScreen();
                break;
            case 2:
                ShuttleControl shuttleControl = new ShuttleControl();
                shuttleControl.shuttlePage();
                clearScreen();
                break;
            case 3:
                Jsave criteria = new Jsave();
                criteria.startCreateCriteria();
                break;
            case 4:
                viewMissionPage(corName);
                clearScreen();
        }
    }

    //check date

    public boolean checkDate(String value){
        Boolean isTrue;
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            date = sdf.parse(value);
            if (!value.equals(sdf.format(date))) {
                date = null;
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        if (date == null) {
            isTrue = false;
        } else {
            // Valid date format
            isTrue = true;
        }
        return isTrue;
    }



    //check char
    private String checkChar(String str){
        Scanner sc = new Scanner(System.in);
        int len = str.length();
        while (len != 1){
            System.out.println("    Please enter only one letter");
            str = sc.nextLine();
        }
        while(str.charAt(0)!='a' || str.charAt(0)!='b' ||str.charAt(0)!= 'c' ||str.charAt(0)!= 'd' ||str.charAt(0)!= 'e' ||str.charAt(0)!= 'f'){
            System.out.println("    Please enter the given letter (from a-f) ");
            str = sc.nextLine();
        }
        userCheckInput(str);
        return str;

    }


    //check contact
    private String checkNumber(String str){
        Scanner sc = new Scanner(System.in);
        while (!isInt(str)){
            System.out.println("---Please enter only numbers---");
            str = sc.nextLine();
        }
        while (str.length()!= 7){
            System.out.println("--Please enter the phone number with 7 number, try again: ");
            str = sc.nextLine();
        }

        return str;
    }

    //check cargo for
}
