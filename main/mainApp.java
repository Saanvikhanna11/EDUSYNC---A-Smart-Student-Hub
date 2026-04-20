package main;

import java.util.Scanner;
import models.*;
import services.*;

public class mainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AuthService auth = new AuthService();
        Student student = null;

        while (true) {
            System.out.println("1. Register\n2. Login");
            int ch = Integer.parseInt(sc.nextLine());

            if (ch == 1) {
                System.out.print("Username: ");
                String u = sc.nextLine();
                System.out.print("Password: ");
                String p = sc.nextLine();

                try {
                    auth.register(u, p);
                    System.out.println("Registered!");
                } catch (Exception e) {}
            }

            else if (ch == 2) {
                System.out.print("Username: ");
                String u = sc.nextLine();
                System.out.print("Password: ");
                String p = sc.nextLine();

                if (auth.login(u, p)) {
                    student = new Student(u, p);
                    System.out.println("Login Success!");
                    break;
                } else {
                    System.out.println("Wrong credentials!");
                }
            }
        }

        while (true) {

            System.out.println("\n1.GPA 2.Attendance 3.Add Task 4.View Tasks 5.Mark Done 6.Delete Task 7.Report 8.Add Timetable 9.View Timetable 10.Add Reminder 11.View Reminders 12.Exit");

            int ch = Integer.parseInt(sc.nextLine());

            switch (ch) {

                case 1:
                    System.out.print("Enter GPA: ");
                    student.setGpa(Double.parseDouble(sc.nextLine()));

                    System.out.print("Subjects count: ");
                    int n = Integer.parseInt(sc.nextLine());

                    for (int i = 0; i < n; i++) {
                        System.out.print("Name: ");
                        String name = sc.nextLine();

                        System.out.print("Marks: ");
                        int m = Integer.parseInt(sc.nextLine());

                        student.addSubject(new Subject(name, m));
                    }
                    break;

                case 2:
                    System.out.print("Attendance: ");
                    student.setAttendance(Integer.parseInt(sc.nextLine()));
                    break;

                case 3:
                    System.out.print("Task: ");
                    String t = sc.nextLine();
                    System.out.print("Deadline: ");
                    String d = sc.nextLine();
                    student.addTask(t, d);
                    break;

                case 4:
                    student.viewTasks();
                    break;

                case 5:
                    System.out.print("Index: ");
                    student.markTaskDone(Integer.parseInt(sc.nextLine()));
                    break;

                case 6:
                    System.out.print("Index: ");
                    student.deleteTask(Integer.parseInt(sc.nextLine()));
                    break;

                case 7:
                    student.showReport();
                    break;

                case 8:
                    System.out.print("Enter day: ");
                    String day = sc.nextLine();
                    student.getTimetable().addFullDay(day, sc);
                    break;

                case 9:
                    student.getTimetable().show();
                    break;

                case 10:
                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    System.out.print("Date: ");
                    String date = sc.nextLine();

                    System.out.print("Type (Today/Week/Alert): ");
                    String type = sc.nextLine();

                    student.addReminder(title, date, type);
                    break;

                case 11:
                    student.viewReminders();
                    break;

                case 12:
                    System.exit(0);
            }
        }
    }
}