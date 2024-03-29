package org.example;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Environment {
    private ArrayList<Entity> entities;

    public Environment() {
        this.entities = new ArrayList<>();
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public void removeEntity(Entity entity) {
        entities.remove(entity);
    }

    public void arrayCleanUp() {
        if (!entities.isEmpty()) {
            for (int i = entities.size() - 1; i >= 0; i--) {
                entities.remove(entities.get(i));
            }
        }
    }
    public ArrayList<Entity> getEntities(){
        return this.entities;
    }

}
