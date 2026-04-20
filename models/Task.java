package models;

public class Task {
    private String title;
    private String deadline;
    private boolean completed;

    public Task(String title, String deadline) {
        this.title = title;
        this.deadline = deadline;
        this.completed = false;
    }

    public String getTitle() { return title; }
    public String getDeadline() { return deadline; }
    public boolean isCompleted() { return completed; }

    public void markDone() { completed = true; }
}