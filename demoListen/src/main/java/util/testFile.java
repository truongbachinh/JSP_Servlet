package util;

import java.io.*;

public class testFile {
    public static void main(String[] args) {

        File f = new File("./webapp/WEB-INF/db.txt");

        // Get the absolute pat/**/h of file f
        String absolute = f.getAbsolutePath();
        FileInputStream fin = null;

        try {

            fin = new FileInputStream(absolute);
            int data = fin.read();
            StringBuilder line = new StringBuilder();
            while (data != -1) {
                if (((char) data == '\n') || ((char) data == '\r')) {
                    System.out.println("New line: " + line.toString());
                    line.delete(0, line.length());
                    data = fin.read();
                    continue;
                }
                line.append((char) data);
                data = fin.read();
            }
            System.out.println("New line: " + line.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fin != null)
                    fin.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

