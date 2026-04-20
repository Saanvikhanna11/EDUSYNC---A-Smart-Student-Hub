package services;

import models.Student;

public class AttendanceService {

    public void calculateAttendance(Student s, int attended, int total) {

        int percent = (attended * 100) / total;
        s.setAttendance(percent);
    }
}