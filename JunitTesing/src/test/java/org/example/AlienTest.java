package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlienTest {
    @Test
    public void testAlienInitialization() {
        Alien alien = new Alien("Test Alien", 120, 30, true);
        assertEquals("Test Alien", alien.getName());
        assertEquals(120, alien.getHp());
        assertEquals(30, alien.getAttack());
        assertEquals(true, alien.isTelepathic());
    }

}