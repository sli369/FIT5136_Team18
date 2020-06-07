package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        int flag = 0;
        ArrayList<String> userList = readFile();

//        // search username in users.txt
//        for (String i : userList) {
//            System.out.println(i.substring(0, i.indexOf(",")));
//        }


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
        MainPageController mainpage = new MainPageController();
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




                        System.out.println("Hello!" + user_record[4] + "\n");

                        mainpage.WelcomePage(user_record[4], Integer.parseInt(user_record[2]));

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
                System.out.println('\u000C');
                Zoe zoe = new Zoe();
                zoe.signupCandidate();
            }
            System.out.println("Please enter your FULL name: ");
            String fullname = sc.next();

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

                list.add(input_username + "," + input_password + ",3,1," + fullname);
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

}
