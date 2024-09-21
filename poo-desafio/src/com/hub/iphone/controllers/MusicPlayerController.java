package com.hub.iphone.controllers;

import com.hub.iphone.entites.MusicPlayer;
import java.util.Scanner;

public class MusicPlayerController {
    private MusicPlayer musicPlayer;

    public MusicPlayerController(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }

    public void showMenu(Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.println("\n--- Music Player Menu ---");
            System.out.println("1. Play Music");
            System.out.println("2. Pause Music");
            System.out.println("3. Select Music");
            System.out.println("4. View Music List");
            System.out.println("5. Back to Main Menu");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            String message = "";  // Variable to hold messages

            switch (choice) {
                case 1:
                    message = musicPlayer.play();
                    break;
                case 2:
                    message = musicPlayer.pause();
                    break;
                case 3:
                    System.out.print("Enter music name: ");
                    String music = scanner.nextLine();
                    message = musicPlayer.selectMusic(music);
                    break;
                case 4:
                    musicPlayer.viewMusicList();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    message = "Invalid option. Try again.";
            }

            // Print the message if it's not empty
            if (!message.isEmpty()) {
                System.out.println(message);
            }
        }
    }
}

