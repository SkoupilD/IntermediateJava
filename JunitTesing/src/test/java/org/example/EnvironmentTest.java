package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class EnvironmentTest {
    private Environment environment;
    private Entity entity1;
    private Entity entity2;

    @BeforeEach
    public void setUp() {
        environment = new Environment();
        entity1 = new Entity("Entity1", 100, 10);
        entity2 = new Entity("Entity2", 200, 20);
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
}
