package com.revature.erts;

import com.revature.erts.intrfcs.ConsoleIF;

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
        closeCon(scanner);
        newln();

        int choice = Integer.parseInt(choices);
        return choice;
    }

    public static void clrscr() {

        ConsoleIF cif = new ConsoleIF();
        cif.clrscr();

    }

    public static void displn(String line) {

        ConsoleIF cif = new ConsoleIF();
        cif.putln(line);

    }

    public static void disp(String word) {

        ConsoleIF cif = new ConsoleIF();
        cif.putwd(word);

    }

    public static void newln() {

        ConsoleIF cif = new ConsoleIF();
        cif.newln();

    }

    public static Scanner openCon() {

        ConsoleIF cif = new ConsoleIF();
        return cif.open();

    }

    public static void closeCon(Scanner scanner) {

        ConsoleIF cif = new ConsoleIF();
        cif.close(scanner);

    }

    public static String readln(Scanner scanner) {

        ConsoleIF cif = new ConsoleIF();
        return cif.readln(scanner);

    }

}

