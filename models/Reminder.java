package models;

public class Reminder {

    private String title;
    private String date;
    private String type;

    public Reminder(String title, String date, String type) {
        this.title = title;
        this.date = date;
        this.type = type;
    }

    public String getTitle() { return title; }
    public String getDate() { return date; }
    public String getType() { return type; }
}