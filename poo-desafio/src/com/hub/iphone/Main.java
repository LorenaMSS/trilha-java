package com.hub.iphone;

import com.hub.iphone.controllers.MainController;
import com.hub.iphone.entites.InternetBrowser;
import com.hub.iphone.entites.MusicPlayer;
import com.hub.iphone.entites.Telephone;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
public static void main(String[] args) 
{
    List<String> musicList = Arrays.asList(
        "Track 1 - Artist A",
        "Track 2 - Artist B",
        "Track 3 - Artist C",
        "Track 4 - Artist D",
        "Track 5 - Artist E",
        "Track 6 - Artist F",
        "Track 7 - Artist G",
        "Track 8 - Artist H",
        "Track 9 - Artist I",
        "Track 10 - Artist J"
    );

    IPhone iphone = new IPhone(musicList);

    iphone.start();
    }
}


 class IPhone {
    private MainController mainController;

    public IPhone(List<String> musicList) {
        MusicPlayer musicPlayer = new MusicPlayer(musicList);
        Telephone telephone = new Telephone();
        InternetBrowser browser = new InternetBrowser();
        this.mainController = new MainController(musicPlayer, telephone, browser);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        mainController.showMainMenu(scanner);
        scanner.close();
    }
}
