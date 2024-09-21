package com.hub.iphone.entites;

import java.util.ArrayList;
import java.util.List;

class Tab {
    private List<String> history;
    private int currentPageIndex;

    public Tab() {
        this.history = new ArrayList<>();
        this.currentPageIndex = -1; 
    }

    public void openUrl(String url) {
        if (currentPageIndex < history.size() - 1) {
            history = history.subList(0, currentPageIndex + 1);
        }
        history.add(url);
        currentPageIndex++;
        System.out.println("Opened in tab: " + url);
    }

    public void goBack() {
        if (currentPageIndex > 0) {
            currentPageIndex--;
            System.out.println("Went back to: " + history.get(currentPageIndex));
        } else {
            System.out.println("No previous page to go back to.");
        }
    }

    public void goForward() {
        if (currentPageIndex < history.size() - 1) {
            currentPageIndex++;
            System.out.println("Went forward to: " + history.get(currentPageIndex));
        } else {
            System.out.println("No next page to go forward to.");
        }
    }

    public void viewHistory() {
        if (history.isEmpty()) {
            System.out.println("No browsing history available for this tab.");
            return;
        }
        System.out.println("Browsing History for this tab:");
        for (int i = 0; i < history.size(); i++) {
            System.out.println((i + 1) + ": " + history.get(i) + (i == currentPageIndex ? " (current)" : ""));
        }
    }

    public void close() {
        history.clear();
        currentPageIndex = -1;
        System.out.println("Tab closed. History cleared.");
    }
}