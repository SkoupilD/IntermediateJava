package org.example;

public class Hero extends Entity{
    private int shield;

    public Hero(String name, int hp, int attack, int shield) {
        super(name, hp, attack);
        this.shield = shield;
    }

    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }
}
