package org.example.model;

public class Designer extends Toy{

    protected String name = "Конструктор";

    public Designer(int ID, int frequencyOfLoss) {
        super(ID, frequencyOfLoss);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Designer{" +
                "name='" + name + '\'' +
                ", ID=" + ID +
                ", frequencyOfLoss=" + frequencyOfLoss +
                '}';
    }
}
