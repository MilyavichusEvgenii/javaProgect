package org.example.model;

import java.io.FileWriter;

public class WriterToFile {
    public void writeToFile(User user){
        try (FileWriter fw = new FileWriter("ToysUser.txt", true)) {
            for (int i = 0; i < user.getBag().size(); i++) {
                fw.append(String.format("%s\n ", user.getBag().get(i).toString()));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
