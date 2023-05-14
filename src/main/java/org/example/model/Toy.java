package org.example.model;

public abstract class Toy {
    protected int ID;
    protected int frequencyOfLoss;

    public Toy(int ID, int frequencyOfLoss) {
        this.ID = ID;
        this.frequencyOfLoss = frequencyOfLoss;
    }

    public int getID() {
        return ID;
    }

    public int getFrequencyOfLoss() {
        return frequencyOfLoss;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setFrequencyOfLoss(int frequencyOfLoss) {
        this.frequencyOfLoss = frequencyOfLoss;
    }
}


