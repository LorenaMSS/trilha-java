package com.hub.iphone.controllers;

import com.hub.iphone.entites.InternetBrowser;
import com.hub.iphone.entites.MusicPlayer;
import com.hub.iphone.entites.Telephone;
import java.util.Scanner;

public class MainController {
    private MusicPlayerController musicPlayerController;
    private TelephoneController telephoneController;
    private InternetBrowserController internetBrowserController;

    public MainController(MusicPlayer musicPlayer, Telephone telephone, InternetBrowser browser) {
        this.musicPlayerController = new MusicPlayerController(musicPlayer);
        this.telephoneController = new TelephoneController(telephone);
        this.internetBrowserController = new InternetBrowserController(browser);
    }

    public void showMainMenu(Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Music Player");
            System.out.println("2. Telephone");
            System.out.println("3. Internet Browser");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    musicPlayerController.showMenu(scanner);;
                    break;
                case 2:
                    telephoneController.showMenu(scanner);
                    break;
                case 3:
                    internetBrowserController.showMenu(scanner);
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}