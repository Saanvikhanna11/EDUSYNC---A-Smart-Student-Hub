package models;

import java.util.HashMap;
import java.util.Scanner;

public class Timetable {

    private HashMap<String, String[]> schedule;

    public Timetable() {
        schedule = new HashMap<>();

        schedule.put("monday", new String[4]);
        schedule.put("tuesday", new String[4]);
        schedule.put("wednesday", new String[4]);
        schedule.put("thursday", new String[4]);
        schedule.put("friday", new String[4]);
    }

    // 🔥 NEW: Add FULL DAY at once
    public void addFullDay(String day, Scanner sc) {

        day = day.toLowerCase();

        if (!schedule.containsKey(day)) {
            System.out.println("Invalid day!");
            return;
        }

        String[] periods = schedule.get(day);

        System.out.println("Enter 4 subjects for " + day.toUpperCase());

        for (int i = 0; i < 4; i++) {
            System.out.print("Period " + (i + 1) + ": ");
            periods[i] = sc.nextLine();
        }

        System.out.println("Timetable updated!");
    }

    // 🔥 VIEW TIMETABLE (clean)
    public void show() {
        System.out.println("\n--- Weekly Timetable ---");

        for (String day : schedule.keySet()) {
            System.out.println(day.toUpperCase() + ":");

            String[] arr = schedule.get(day);

            for (int i = 0; i < 4; i++) {
                String sub = (arr[i] == null) ? "-" : arr[i];
                System.out.println("  Period " + (i + 1) + ": " + sub);
            }
        }
    }
}