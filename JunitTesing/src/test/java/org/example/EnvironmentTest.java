package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class EnvironmentTest {
    private Environment environment;
    private Entity entity1;
    private Entity entity2;
    private Hero entity3;
    private Hero entity4;
    private Alien entity5;
    private Alien entity6;


    @BeforeEach
    public void setUp() {
        environment = new Environment();
        entity1 = new Entity("Vendor", 100, 10);
        entity2 = new Entity("Hunter", 200, 20);
        entity3 = new Hero("Bolt", 200, 220, 50);
        entity4 = new Hero("Thror", 200, 220, 150);
        entity5 = new Alien("Rapture", 150, 75, false);
        entity6 = new Alien("E.T.", 100, 1, true);

    }

    @Test
    public void testAddEntity() {
        environment.addEntity(entity1);
        assertTrue(environment.getEntities().contains(entity1));
    }

    @Test
    public void testRemoveEntity() {
        environment.addEntity(entity1);
        environment.removeEntity(entity1);
        assertTrue(environment.getEntities().isEmpty());
    }

    @Test
    public void testRemoveNonExistingEntity() {
        environment.addEntity(entity1);
        assertEquals(1, environment.getEntities().size());
    }
    @Test
    public void addingAll() {
        environment.addEntity(entity1);
        environment.addEntity(entity2);
        environment.addEntity(entity3);
        environment.addEntity(entity4);
        environment.addEntity(entity5);
        environment.addEntity(entity6);
    assertEquals(6, environment.getEntities().size());
}
@Test
public void testCleanUp() {
        assertTrue(environment.getEntities().isEmpty());
}

    @AfterEach
    public void cleanUp() {
        if(environment.getEntities().isEmpty()){
            for (int i = environment.getEntities().size() -1;i >= 0; i-- ){
                environment.removeEntity(environment.getEntities().get(i));
            }
        }
    }

}
