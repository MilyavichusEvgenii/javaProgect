package org.example.view;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Out {
    public void out (){
        System.out.println("Всего игрушек было выиграно в игре\n");
        String str;
        try(BufferedReader bf = new BufferedReader(new FileReader("ToysUser.txt"))){
            while ((str = bf.readLine()) != null) {
                System.out.println(str);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
