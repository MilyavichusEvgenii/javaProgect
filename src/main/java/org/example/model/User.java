package org.example.model;
import java.util.ArrayList;

public class User<Toy> {
    private int money;
    private ArrayList<org.example.model.Toy> bag;

    public User(int money, ArrayList<org.example.model.Toy> bag) {
        this.money = money;
        this.bag = bag;
    }

    public int getMoney() {
        return money;
    }

    public ArrayList<org.example.model.Toy> getBag() {
        return bag;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Ваш счет коинов равен: " + money;
    }
}
