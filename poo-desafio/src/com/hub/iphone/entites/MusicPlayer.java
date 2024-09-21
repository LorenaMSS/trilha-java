package com.hub.iphone.entites;
import java.util.List;


public class MusicPlayer {
    private boolean musicPlaying;
    private List<String> musicList;
    private String selectedMusic;

    public MusicPlayer(List<String> musicList) {
        this.musicList = musicList;
        this.selectedMusic = null;
        this.musicPlaying = false; // Initialize musicPlaying to false
    }

    public String play() {
        if (selectedMusic == null) {
            return "Please select a music first.";
        } else if (!isSelectMusicValid(selectedMusic)) {
            return "Selected music is not in the list.";
        } else if (musicPlaying) {
            return selectedMusic + " is already playing.";
        } else {
            musicPlaying = true;
            return selectedMusic + " is now playing.";
        }
    }

    public String pause() {
        if (!musicPlaying) {
            return "No music is currently playing.";
        } else {
            musicPlaying = false;
            return "Music paused.";
        }
    }

    public String selectMusic(String music) {
        if (isSelectMusicValid(music)) {
            selectedMusic = music;
            return music + " selected.";
        } else {
            return "Music selection is invalid.";
        }
    }

    public void viewMusicList() {
        System.out.println("Music List:");
        musicList.forEach(music -> System.out.println("- " + music));
    }

    private boolean isSelectMusicValid(String music) {
        return musicList.contains(music);
    }

    public boolean isMusicPlaying() {
        return musicPlaying;
    }

    public String getSelectedMusic() {
        return selectedMusic;
    }
}