package models;

import java.util.ArrayList;

public class Student {

    private String username;
    private String password;

    private double gpa;
    private int attendance;

    private ArrayList<Task> tasks = new ArrayList<>();
    private ArrayList<Subject> subjects = new ArrayList<>();
    private ArrayList<Reminder> reminders = new ArrayList<>();

    private Timetable timetable = new Timetable();

    public Student(String u, String p) {
        username = u;
        password = p;
    }

    public void setGpa(double g) { this.gpa = g; }
    public void setAttendance(int a) { this.attendance = a; }

    public double getGpa() { return gpa; }
    public int getAttendance() { return attendance; }

    public Timetable getTimetable() { return timetable; }

    // ---------- SUBJECT ----------
    public void addSubject(Subject s) {
        subjects.add(s);
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    // ---------- TASKS ----------
    public void addTask(String title, String deadline) {
        tasks.add(new Task(title, deadline));
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks!");
            return;
        }

        for (int i = 0; i < tasks.size(); i++) {
            Task t = tasks.get(i);
            System.out.println(i + ". " + t.getTitle() +
                    " | " + t.getDeadline() +
                    " | " + (t.isCompleted() ? "Done" : "Pending"));
        }
    }

    public void markTaskDone(int idx) {
        if (idx >= 0 && idx < tasks.size()) {
            tasks.get(idx).markDone();
            System.out.println("Marked done!");
        }
    }

    public void deleteTask(int idx) {
        if (idx >= 0 && idx < tasks.size()) {
            tasks.remove(idx);
            System.out.println("Deleted!");
        }
    }

    // ---------- REMINDERS ----------
    public void addReminder(String title, String date, String type) {
        reminders.add(new Reminder(title, date, type));
    }

    public void viewReminders() {
        if (reminders.isEmpty()) {
            System.out.println("No reminders!");
            return;
        }

        System.out.println("\n--- Reminders & Alerts ---");

        for (Reminder r : reminders) {
            System.out.println(r.getType() + " | " + r.getTitle() + " | " + r.getDate());
        }
    }

    // ---------- REPORT ----------
    public void showReport() {
        System.out.println("\n--- REPORT ---");
        System.out.println("GPA: " + gpa);
        System.out.println("Attendance: " + attendance + "%");

        System.out.println("\nSubjects:");
        for (Subject s : subjects) {
            System.out.println(s.getName() + " : " + s.getMarks() + " Grade: " + s.getGrade());
        }

        System.out.println("\nTasks:");
        viewTasks();

        System.out.println("\nReminders:");
        viewReminders();
    }
}