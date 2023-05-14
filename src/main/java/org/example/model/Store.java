package org.example.model;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Store <Designer, User> implements ServiceOfStore{
    ArrayList<Toy> assort;
    Random rn;
    @Override
    public void fillerOfStore(int a, int b, int c, int r1, int r2, int r3) {
        this.assort = new ArrayList<Toy>();
        int id = 1;
        for (int i = 0; i < a; i++) {
            assort.add(new org.example.model.Designer(id, r1));
            id+=1;
        }
        for (int i = 0; i < b; i++) {
            assort.add(new org.example.model.Railway(id, r2));
            id+=1;
        }
        for (int i = 0; i < c; i++) {
            assort.add(new org.example.model.Truck(id, r3));
            id+=1;
        }
    }

    @Override
    public void game(org.example.model.User user) {
        try (PrintWriter pw = new PrintWriter("ToysUser.txt");) {
            pw.close();
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Scanner in = new Scanner(System.in);
        WriterToFile writerToFile = new WriterToFile();
        rn = new Random();
        int rand;
        int stap;
        int cell;
        while (true) {
            System.out.println("Ваш счет коинов равен: " + user.getMoney());
            System.out.println("""
                    Чтоб играть: нажмите '1'
                    для выхода, нажмите '0'""");
            if (this.assort.size() == 0) {
                System.out.println("Игрушки в магазине закончилис, игра окончена.");
                if (user.getBag().size() > 0) {
                    writerToFile.writeToFile(user);
                }
                break;
            }
            if (user.getMoney() == 0) {
                System.out.println("У вас закончились коины, игра окончена.");
                if (user.getBag().size() > 0) {
                    writerToFile.writeToFile(user);
                }
                break;
            }
            bueTicket(user);
            stap = in.nextInt();
            if(stap == 1){
                for (int i = 0; i < this.assort.size(); i++) {
                    rand = rn.nextInt(1, assort.get(i).frequencyOfLoss + 1);
                    if (rand == 1) {
                        user.getBag().add(assort.get(i));
                        assort.remove(i);
                        break;
                    }
                }
            }
            if(stap == 0){
                if (user.getBag().size() > 0) {
                    writerToFile.writeToFile(user);
                }
                break;
            }
            cellToys(user);
        }
    }
     private void bueTicket(org.example.model.User user) {
        int money = user.getMoney() - 100;
        user.setMoney(money);
    }

    private void cellToys(org.example.model.User user){
        Scanner a = new Scanner(System.in);
        int choice;
        int money = 0;
//        for (int i = 0; i < user.getBag().size(); i++) {
        while (user.getBag().size() != 0) {
            System.out.println(user.getBag().get(user.getBag().size() - 1).toString());
            System.out.println("""
                    Для продажи предмета нажмите '1'
                    если не хотите продавать, нажмите '2'
                    для выхода из режима продажи предметов, нажмите '0'.""");
            choice = a.nextInt();
            if (choice == 1) {
                if (user.getBag().get(user.getBag().size() - 1) instanceof org.example.model.Designer && user.getBag().size() > 0) {
                    money += 300;
                    user.getBag().remove(user.getBag().size() - 1);
                }
                else if (user.getBag().get(user.getBag().size() - 1) instanceof org.example.model.Railway && user.getBag().size() > 0) {
                    money += 200;
                    user.getBag().remove(user.getBag().size() - 1);

                }
                else if (user.getBag().get(user.getBag().size() - 1) instanceof org.example.model.Truck && user.getBag().size() > 0) {
                    money += 100;
                    user.getBag().remove(user.getBag().size() - 1);
                }
                if (user.getBag().size() == 0) {
                    break;
                }
            }
            if (choice == 2) {
                money += 0;
            }
            if (choice == 0) {
                break;
            }
        }
//        }
        money = money + user.getMoney();
        user.setMoney(money);
    }

}
