package com.hub.iphone.controllers;

import com.hub.iphone.entites.InternetBrowser;
import java.util.Scanner;


public class InternetBrowserController {
    private InternetBrowser browser;

    public InternetBrowserController(InternetBrowser browser) {
        this.browser = browser;
    }

    public void showMenu(Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.println("\n--- Internet Browser Menu ---");
            System.out.println("1. Open New Tab");
            System.out.println("2. Switch Tab");
            System.out.println("3. Open URL");
            System.out.println("4. Go Back");
            System.out.println("5. Go Forward");
            System.out.println("6. View History");
            System.out.println("7. Close Current Tab");
            System.out.println("8. Close All Tabs");
            System.out.println("9. Back to Main Menu");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    browser.openTab();
                    break;
                case 2:
                    System.out.print("Enter tab index: ");
                    int index = scanner.nextInt();
                    browser.switchToTab(index);
                    break;
                case 3:
                    System.out.print("Enter URL: ");
                    String url = scanner.nextLine();
                    browser.openUrl(url);
                    break;
                case 4:
                    browser.goBack();
                    break;
                case 5:
                    browser.goForward();
                    break;
                case 6:
                    browser.viewHistory();
                    break;
                case 7:
                    browser.closeCurrentTab();
                    break;
                case 8:
                    browser.closeAllTabs();
                    break;
                case 9:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
