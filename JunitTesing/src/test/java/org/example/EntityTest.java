package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntityTest {
    @Test
    public void testEntityInitialization() {
        Entity entity = new Entity("Test Entity", 100, 20);
        assertEquals("Test Entity", entity.getName());
        assertEquals(100, entity.getHp());
        assertEquals(20, entity.getAttack());
    }

}