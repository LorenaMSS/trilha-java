package com.hub.iphone.entites;

import java.util.ArrayList;
import java.util.List;

public class Telephone {
    private boolean isRinging;
    private boolean isOnCall;
    private String currentCall;
    private List<String> callLog;
    private List<String> voicemail;

    public Telephone() {
        this.isRinging = false;
        this.isOnCall = false;
        this.currentCall = null;
        this.callLog = new ArrayList<>();
        this.voicemail = new ArrayList<>();
    }

    public void dial(String number) {
        if (isOnCall) {
            System.out.println("Cannot dial. Already on a call.");
            return;
        }
        currentCall = number;
        isRinging = true;
        System.out.println("Dialing " + number + "...");
    }

    public void answer() {
        if (isRinging) {
            isOnCall = true;
            isRinging = false;
            callLog.add(currentCall);
            System.out.println("Answering call from " + currentCall);
        } else {
            System.out.println("No incoming call to answer.");
        }
    }

    public void hangUp() {
        if (isOnCall) {
            System.out.println("Ending call with " + currentCall);
            isOnCall = false;
            currentCall = null;
        } else {
            System.out.println("No active call to hang up.");
        }
    }

    public void leaveVoicemail(String message) {
        if (currentCall != null) {
            System.out.println("Cannot leave a voicemail while on a call.");
            return;
        }
        if (isRinging) {
            voicemail.add(message);
            System.out.println("Leaving voicemail for " + currentCall + ": " + message);
            isRinging = false; 
        } else {
            System.out.println("No incoming call to leave a voicemail for.");
        }
    }

    public void listenVoicemail() {
        if (voicemail.isEmpty()) {
            System.out.println("No voicemails available.");
            return;
        }
        System.out.println("Listening to voicemails:");
        for (int i = 0; i < voicemail.size(); i++) {
            System.out.println((i + 1) + ": " + voicemail.get(i));
        }
    }

    public void clearVoicemail() {
        voicemail.clear();
        System.out.println("All voicemails have been cleared.");
    }

    public List<String> getCallLog() {
        return callLog;
    }

    public boolean isRinging() {
        return isRinging;
    }

    public boolean isOnCall() {
        return isOnCall;
    }
}