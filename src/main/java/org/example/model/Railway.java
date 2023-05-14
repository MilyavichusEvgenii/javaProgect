package org.example.model;

public class Railway extends Toy{

    protected String name = "Железная дорога";


    public Railway(int ID, int frequencyOfLoss) {
        super(ID, frequencyOfLoss);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Railway{" +
                "name='" + name + '\'' +
                ", ID=" + ID +
                ", frequencyOfLoss=" + frequencyOfLoss +
                '}';
    }
}
