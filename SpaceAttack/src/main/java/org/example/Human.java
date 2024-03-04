package org.example;

public class Human extends Entity{
    private int armor;
    public Human(String name, int hp, int attack, int armor){
        super(name, hp, attack);
        this.armor = armor;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }
}
