package services;

import java.io.*;
import java.util.ArrayList;
import models.Task;

public class FileService {

    public void saveTasks(ArrayList<Task> tasks) throws IOException {
        FileWriter fw = new FileWriter("tasks.txt");

        for (Task t : tasks) {
            fw.write(t.getTitle() + "," + t.getDeadline() + "," + t.isCompleted() + "\n");
        }

        fw.close();
    }

    public ArrayList<Task> loadTasks() throws IOException {

        ArrayList<Task> tasks = new ArrayList<>();
        File file = new File("tasks.txt");

        if (!file.exists()) return tasks;

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;

        while ((line = br.readLine()) != null) {
            String[] d = line.split(",");

            Task t = new Task(d[0], d[1]);

            if (d[2].equals("true")) {
                t.markDone();
            }

            tasks.add(t);
        }

        br.close();
        return tasks;
    }
}