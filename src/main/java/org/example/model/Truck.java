package org.example.model;

public class Truck extends Toy{

    protected String name = "Грузовик";


    public Truck(int ID, int frequencyOfLoss) {
        super(ID, frequencyOfLoss);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "name='" + name + '\'' +
                ", ID=" + ID +
                ", frequencyOfLoss=" + frequencyOfLoss +
                '}';
    }
}
