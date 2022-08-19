package fileutils;

import java.io.*;

public class CustomFileReader {
    public static String read(String filePath) {
        StringBuilder dates = new StringBuilder();
        try (BufferedReader bf = new BufferedReader(
                new FileReader(filePath));
        ) {
            String line;
            while ((line = bf.readLine()) != null){
                dates.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dates.toString();
    }

}

