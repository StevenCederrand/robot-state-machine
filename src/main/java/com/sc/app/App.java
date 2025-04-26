package com.sc.app;

import java.io.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("No arguments provided");
            return;
        }

        String robotInput = "";

        if (args[0].equals("-i")) { // Interactive Input
            robotInput = interactiveInput();
        } else if (args[0].equals("-f")) { // File Input
            if (args[1] == null) {
                return;
            }
            robotInput = fileInput(args[1]);
        }

        String report = World.fromString(robotInput)
                .run()
                .getReport();

        System.out.println(report);
    }

    private static String interactiveInput() {
        StringBuilder robotInput = new StringBuilder();

        Scanner s = new Scanner(System.in);
        System.out.println("Enter grid size(ex: '5 5'): ");
        robotInput.append(s.nextLine()).append("\n");
        System.out.print("Enter start pos + direction(ex: '5 5 S'): ");
        robotInput.append(s.nextLine().toUpperCase()).append("\n");
        System.out.print("Enter direction commands(ex: 'FFRFLLFRF'): ");
        robotInput.append(s.nextLine().toUpperCase());

        return robotInput.toString();
    }

    private static String fileInput(String filename) throws FileNotFoundException {
        StringBuilder robotInput = new StringBuilder();

        File f = new File(filename);
        Scanner myReader = new Scanner(f);

        while (myReader.hasNextLine()) {
            robotInput.append(myReader.nextLine()).append("\n");
        }
        myReader.close();

        return robotInput.toString();
    }
}
