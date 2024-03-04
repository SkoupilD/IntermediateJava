package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntityTest {
    static Entity entity;
    @BeforeEach
    public void setUp() {
        entity = new Entity("Test Entity", 100, 20);
    }
    @Test
    public void testEntityInitialization() {
        assertEquals("Test Entity", entity.getName());
        assertEquals(100, entity.getHp());
        assertEquals(20, entity.getAttack());
    }
    @Test
    public void testEntitySetting() {
        entity.setAttack(200);
        entity.setHp(1);
        entity.setName("Test");
        assertEquals("Test", entity.getName());
        assertEquals(1, entity.getHp());
        assertEquals(200,entity.getAttack());
    }

}