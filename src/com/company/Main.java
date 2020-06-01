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
                break;
            }
            System.out.println("Please try again!");
        }

        System.out.println("Shuttle name: " + shuttle_list.get(0).substring(0,shuttle_list.get(0).indexOf(",")));
    }

}
