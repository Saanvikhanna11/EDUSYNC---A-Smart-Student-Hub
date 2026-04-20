package services;

import java.io.*;

public class AuthService {

    public void register(String u, String p) throws IOException {
        FileWriter fw = new FileWriter("users.txt", true);
        fw.write(u + "," + p + "\n");
        fw.close();
    }

    public boolean login(String u, String p) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("users.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                if (arr[0].equals(u) && arr[1].equals(p)) {
                    return true;
                }
            }
        } catch (Exception e) {}

        return false;
    }
}