package se.ITHS.jimmy;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UserRegistrationService userRegServ = new UserRegistrationService();

        boolean running = true;


        System.out.println("Welcome, please choose an option.");
        while (running) {
            System.out.println("--------------------------------");
            System.out.println("Write 'n' to create new user.");
            System.out.println("Write 'q' to quit.");
            System.out.println("Write 'c' to check existing users.");
            System.out.println("--------------------------------");
            System.out.print("Write here: ");
            String createUser = sc.nextLine();

            switch (createUser) {
                case "n":
                    userRegServ.createNewUser(sc);
                    break;
                case "q":
                    System.out.println("Quiting program...");
                    running = false;
                    break;
                case "c":
                    userRegServ.getSavedUsers();
                    break;
                default:
                    System.out.println("Wrong input.");
            }
        }
        sc.close();
    }
}