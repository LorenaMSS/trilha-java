package com.hub.iphone.entites;

import java.util.ArrayList;
import java.util.List;

public class InternetBrowser {
    private List<Tab> tabs;
    private int currentTabIndex;

    public InternetBrowser() {
        this.tabs = new ArrayList<>();
        this.currentTabIndex = -1;
    }

    public void openTab() {
        Tab newTab = new Tab();
        tabs.add(newTab);
        currentTabIndex = tabs.size() - 1;
        System.out.println("New tab opened. Total tabs: " + tabs.size());
    }

    public void switchToTab(int index) {
        if (index >= 0 && index < tabs.size()) {
            currentTabIndex = index;
            System.out.println("Switched to tab " + (index + 1));
        } else {
            System.out.println("Invalid tab index.");
        }
    }

    public void openUrl(String url) {
        if (currentTabIndex == -1) {
            System.out.println("No tab is currently open. Please open a tab first.");
            return;
        }
        tabs.get(currentTabIndex).openUrl(url);
    }

    public void goBack() {
        if (currentTabIndex != -1) {
            tabs.get(currentTabIndex).goBack();
        } else {
            System.out.println("No tab is currently open.");
        }
    }

    public void goForward() {
        if (currentTabIndex != -1) {
            tabs.get(currentTabIndex).goForward();
        } else {
            System.out.println("No tab is currently open.");
        }
    }

    public void viewHistory() {
        if (currentTabIndex != -1) {
            tabs.get(currentTabIndex).viewHistory();
        } else {
            System.out.println("No tab is currently open.");
        }
    }

    public void closeCurrentTab() {
        if (currentTabIndex != -1) {
            tabs.get(currentTabIndex).close();
            tabs.remove(currentTabIndex);
            currentTabIndex = tabs.size() - 1;
            System.out.println("Current tab closed.");
        } else {
            System.out.println("No tab is currently open.");
        }
    }

    public void closeAllTabs() {
        tabs.clear();
        currentTabIndex = -1;
        System.out.println("All tabs closed. History cleared.");
    }
}