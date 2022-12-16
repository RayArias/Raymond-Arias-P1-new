package com.revature.erts.intrfcs;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleIF implements CRUD_IF<Scanner> {

    public ConsoleIF() { }

    @Override
    public Scanner open() {
        return new Scanner(System.in);
    }

    @Override
    public void close(Scanner scanner) {
        scanner.close();
    }

    @Override
    public String readln(Scanner scanner) {
        return scanner.nextLine();
    }

    @Override
    public void putln(String line) {
        System.out.println(line);
    }

    @Override
    public String readwd(Scanner scanner) {
        return scanner.nextLine();
    }

    @Override
    public void putwd(String word) {
        System.out.print(word);
    }

    public void newln() { System.out.println(); }

    // Clears the screen in Java
    public void clrscr() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }

}
