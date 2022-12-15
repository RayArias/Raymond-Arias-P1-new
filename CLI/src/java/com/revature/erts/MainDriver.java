package com.revature.erts;

import java.io.IOException;
import java.util.Scanner;
import java.lang.Integer;

public class MainDriver {
    public static void main(String[] args) {

        showTitle();
        int choice = mainMenu();

    }

    public static void showTitle() {
        clrscr();
        displn("Welcome to the Employee Reimbursement Ticket System (ERTS)");
        displn("----------------------------------------------------------");
        newln();
    }
    public static int mainMenu() {

        displn("1. Register as new user.");
        displn("2. Login as current user.");
        displn("3. Exit ERTS.");
        newln();

        disp("Enter choice: ");
        Scanner scanner = openCon();
        String choices = readln(scanner);
        newln();

        int choice = Integer.parseInt(choices);
        return choice;
    }

    // clears the screen in java
    public static void clrscr() { //Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static void displn(String msg) { System.out.println(msg); }

    public static void disp(String msg) { System.out.print(msg); }

    public static void newln() { System.out.println(); }

    public static Scanner openCon() {
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }

    public static String readln(Scanner scanner) {
        String output = scanner.nextLine();
        return output;
    }

}

