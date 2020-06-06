package com.company;


import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class MissionControl {
    private ArrayList<Mission> missions;



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



    public void showOneMission(int missionId){
        missions = getMissions();
        Scanner sc = new Scanner(System.in);
//        missionId = sc.nextInt();
        boolean findId;

        for(int i=0; i<missions.size(); i++){
            if(missionId == missions.get(i).getMissionId()){
                findId = true;
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
                findId = false;
        }

    }

    private void addMission(){
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
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
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
        int number = sc.nextInt();
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

    public void createMission(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Now you are going to create a mission");
        System.out.println("****************************");

        // set mission name
        System.out.println("1.Please enter your mission name");
        String missionName = sc.nextLine();
        while (isBlank(missionName))
        {
            System.out.println("the input cannot be null, try to enter again");
            missionName = sc.nextLine();
        }
        System.out.println(missionName + " is your mission name");
        userCheckInput(missionName);
        clearScreen();

        // set mission Description
        System.out.println("2.Please enter your mission description");
        String missionDes = sc.nextLine();
        while (isBlank(missionDes))
        {
            System.out.println("the input cannot be null, try to enter again");
            missionDes = sc.nextLine();
        }
        System.out.println(missionDes + " is your mission description");
        userCheckInput(missionDes);
        clearScreen();

        // set countries of origin
        System.out.println("3.Please enter the country of origin");
        String countryOrigin = sc.nextLine();
        while (isBlank(countryOrigin))
        {
            System.out.println("the input cannot be null, try to enter again");
            countryOrigin = sc.nextLine();
        }
        System.out.println(countryOrigin + " is your country of origin");
        userCheckInput(countryOrigin);
        clearScreen();

        //set countries allowed
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
        clearScreen();

        // set coordinator
        System.out.println("5.Please enter the Coordinator information");
        System.out.println("    (1) Please enter the name");
        String corName = sc.nextLine();
        while (isBlank(corName))
        {
            System.out.println("the input cannot be null, try to enter again");
            corName = sc.nextLine();
        }
        userCheckInput(corName);
        System.out.println("    (2) Please enter the contact");
        String corContact = sc.nextLine();
        while (isBlank(corContact))
        {
            System.out.println("the input cannot be null, try to enter again");
            corContact = sc.nextLine();
        }
        userCheckInput(corContact);
        System.out.println("coordinator name is " + corName + " contact is " + corContact);
        clearScreen();

        // fill Job information
        System.out.println("6.Please enter the Job information");
        System.out.println("    (1) Please enter the job name");
        String jobName = sc.nextLine();
        while (isBlank(jobName))
        {
            System.out.println("the input cannot be null, try to enter again");
            jobName = sc.nextLine();
        }
        userCheckInput(jobName);
        System.out.println("    (2) Please enter the job Description");
        String jobDes = sc.nextLine();
        while (isBlank(jobDes))
        {
            System.out.println("the input cannot be null, try to enter again");
            jobDes = sc.nextLine();
        }
        userCheckInput(jobDes);
        System.out.println("Job name is " + jobName + " description is " + jobDes);
        clearScreen();

        // set employee requirements
        System.out.println("7.Please enter the employee requirements");
        String emRequire = sc.nextLine();
        while (isBlank(emRequire))
        {
            System.out.println("the input cannot be null, try to enter again");
            emRequire = sc.nextLine();
        }
        userCheckInput(emRequire);
        System.out.println("    (1) Please enter the age requirement: ");
        System.out.print("  min age: ");
        int minage = sc.nextInt();
        System.out.print("  max age: ");
        int maxage = sc.nextInt();
        System.out.println(" Age range is from: " + minage + " - " + maxage);

        System.out.println("    (2)Please Set the computer Skill ");
        String computerSkill = sc.nextLine();
        while (isBlank(computerSkill))
        {
            System.out.println("the input cannot be null, try to enter again");
            computerSkill = sc.nextLine();
        }
        System.out.println("    computer requirement is: " + computerSkill);
        userCheckInput(computerSkill);

        System.out.println("    (3)Please Set the minimum working experience ");
        String minExp = sc.nextLine();
        while (isBlank(minExp))
        {
            System.out.println("the input cannot be null, try to enter again");
            minExp = sc.nextLine();
        }
        System.out.println("    Minimum working experience is: " + minExp);
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
        userCheckInput(languages);
        clearScreen();

        //8 please set cargo requirements
        System.out.println("8.Please set the cargo information");
        System.out.println("    8.1 Please set the cargo for (mission or journey)");
        String cargoFor = sc.nextLine();
        while (isBlank(cargoFor))
        {
            System.out.println("the input cannot be null, try to enter again");
            cargoFor = sc.nextLine();
        }
        System.out.println("    8.2 Please enter the cargo ");
        String cargo = sc.nextLine();
        while (isBlank(cargo))
        {
            System.out.println("the input cannot be null, try to enter again");
            cargo = sc.nextLine();
        }
        System.out.println("    8.3 Please enter the cargo quantity: ");
        int cargoQuantity = sc.nextInt();

        System.out.println("Here's you cargo information");
        System.out.println("cargo for " + cargoFor + " cargos: " + cargo + " quantity " + cargoQuantity);

        // set launch time
        System.out.println("9.Please set the launch date");
        System.out.println(" hint ('dd/mm/yyyy')");
        String launch_time = sc.next();
        while (isBlank(launch_time))
        {
            System.out.println("the input cannot be null, try to enter again");
            launch_time = sc.nextLine();
        }
        //check to_date
        System.out.println(launch_time +" is your launch date");
        userCheckInput(launch_time);
        clearScreen();

        // set location
        System.out.println("10.Please set the destination location");
        String location = sc.nextLine();
        while (isBlank(location))
        {
            System.out.println("the input cannot be null, try to enter again");
            location = sc.nextLine();
        }
        System.out.println(location + " is your destination location");
        userCheckInput(location);
        clearScreen();

        // set duration of the mission
        System.out.println("11.Please set the mission duration");
        System.out.println("    hint(the unit is month)");
        String duration = sc.nextLine();
        System.out.println(duration + " is the duration month.");
        userCheckInput(duration);
        // check int

        int du = Integer.parseInt(duration);
        clearScreen();

        // set status
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
        while(isChar(status)){
            System.out.println("Please enter the correct option (lower case like: a)");
            status = sc.nextLine();
        }
        System.out.println("Your option is " + status);
        char noStatus = status.charAt(0);
        clearScreen();
        int i = missions.size();
        int missionId = missions.get(i).getMissionId() + 2;
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
                
                System.out.println("You mission information has been saved, you can search id " + missionId + "to check it in the View Mission Page");
                sc.nextLine();
                viewMissionPage();
                break;
            case 2:
                modifyMissions(missionId);
                break;
        }


    }


    public void  modifyMissions(int id){

    }

    public void viewMissionPage() {
        Scanner sc = new Scanner(System.in);
        MtmSystem mtm = new MtmSystem();
        int userInput = 0;
        missions = getMissions();
        mtm.showMissions();
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
                changeMissionDetailed();
                break;
            case 2:
                showMissions();
                break;
        }
    }

    public void changeMissionDetailed(){
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
        System.out.println("    1. I wanna modify it.");
        System.out.println("    2. I wanna select the space shuttle for this mission.");
        System.out.println("    3. All good. Back to the last page");
        int userInput = 0;

        while (true) {
            try {
                userInput = sc.nextInt();
                while (true) {
                    if (userInput >= 1 && userInput <= 3) {
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
                break;
            case 2:
                ShuttleControl shuttleControl = new ShuttleControl();
                shuttleControl.shuttlePage();
                break;
            case 3:
                viewMissionPage();
        }
    }
}
