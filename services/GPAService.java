package services;

import models.Student;
import models.Subject;

public class GPAService {

    public void calculateGPA(Student s) {

        double total = 0;

        for (Subject sub : s.getSubjects()) {
            total += sub.getMarks();
        }

        double gpa = total / s.getSubjects().size();
        s.setGpa(gpa);

        System.out.println("\n--- Subject Report ---");

        for (Subject sub : s.getSubjects()) {
            System.out.println(sub.getName() + " : " + sub.getMarks() + " Grade: " + sub.getGrade());
        }

        System.out.println("Calculated GPA: " + gpa);
    }
}