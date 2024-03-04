package org.example;

public class Alien extends Entity{
    private boolean telepathic;

    public Alien(String name, int hp, int attack, boolean telepathic) {
        super(name, hp, attack);
        this.telepathic = telepathic;
    }

    public boolean isTelepathic() {
        return telepathic;
    }

    public void setTelepathic(boolean telepathic) {
        this.telepathic = telepathic;
    }
}
