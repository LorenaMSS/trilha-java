package com.hub.iphone.controllers;

import com.hub.iphone.entites.Telephone;
import java.util.Scanner;

public class TelephoneController {
    private Telephone telephone;

    public TelephoneController(Telephone telephone) {
        this.telephone = telephone;
    }

    public void showMenu(Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.println("\n--- Telephone Menu ---");
            System.out.println("1. Dial");
            System.out.println("2. Answer Call");
            System.out.println("3. Hang Up");
            System.out.println("4. View Call Log");
            System.out.println("5. Back to Main Menu");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter number to dial: ");
                    String number = scanner.nextLine();
                    telephone.dial(number);
                    break;
                case 2:
                    telephone.answer();
                    break;
                case 3:
                    telephone.hangUp();
                    break;
                case 4:
                    System.out.println("Call Log: " + telephone.getCallLog());
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}