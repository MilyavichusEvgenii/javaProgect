package org.example.model;
import java.util.Scanner;

public class InputUser {
    Scanner in;
    public int Input(String message){
        in = new Scanner(System.in);
        int result = 0;
        try {
            System.out.println(message);
            if(in.hasNextInt()){
                result = in.nextInt();
                in.close();
            } else {
                System.out.println("Вы не ввели число");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}
