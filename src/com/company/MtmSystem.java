package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class MtmSystem {
    private ArrayList<User> users;
    private ArrayList<Mission> missions;
    private ArrayList<Shuttle> shuttles;
    private ArrayList<Criteria> criterias;
    private ArrayList<Cargo> cargos;
    private ArrayList<Job> jobs;
//    // get list of mission
//    public static void main(String args[]){
//
//    }

    public ArrayList<Mission> getMissions(){
        missions = new ArrayList<Mission>();

        return missions;
    }

    public void showMissions(){
        missions = getMissions();
        System.out.println("Show all mission Id");
        for(int i=0; i<missions.size(); i++){
            System.out.println("mission id: " + missions.get(i).getMissionId() + "  mission name: "+ missions.get(i).getMissionName());
        }
    }

    public void showOneMission(){
        Scanner sc = new Scanner(System.in);
        int missionId = sc.nextInt();
        missions = getMissions();
        for(int i=0; i<missions.size(); i++){
            if(missionId == missions.get(i).getMissionId()){
                System.out.println("mission id: " + missions.get(i).getMissionId() + "  mission name: "+ missions.get(i).getMissionName());
            }
        }
    }



//    public void showMissionCriteria(int missionId){
//        missions = getMissions();
//        Scanner sc = new Scanner(System.in);
////        missionId = sc.nextInt();
//        boolean findId;
//
//        for(int i=0; i<missions.size(); i++){
//            if(missionId == missions.get(i).getMissionId()){
//                findId = true;
//                System.out.println("1.occupation required");
//                for(int j = 0; j<missions.get(i).getJob().size(); j++) {
//                    missions.get(i).getJob().get(j).showJob();
//                }
//                System.out.println("2.Employment requirements: " + missions.get(i).getEmploymentRequirement());
//                System.out.println("3.Age range is from: " + missions.get(i).getCriteria().getMinage() + " - " + missions.get(i).getCriteria().getMaxage());
//                System.out.println("4.computer skill require: " + missions.get(i).getCriteria().getComputerSkill());
//                System.out.println("5.experience requirements: " + missions.get(i).getCriteria().getExpYear() + "years");
//                System.out.println("6.qualification requiremnts: " + missions.get(i).getCriteria().getQualification());
//                System.out.println("7.language requirements: " + missions.get(i).getCriteria().getLanguage());
//            }
//            findId = false;
//        }
//
//    }


}
