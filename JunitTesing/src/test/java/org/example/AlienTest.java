package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlienTest {
    static Alien alien;
    @BeforeEach
    public void setUp() {
        alien = new Alien("Test Alien", 120, 30, true);
    }
    @Test
    public void testAlienInitialization() {
        assertEquals("Test Alien", alien.getName());
        assertEquals(120, alien.getHp());
        assertEquals(30, alien.getAttack());
        assertEquals(true, alien.isTelepathic());
    }
    @Test
    public void testTelepathic() {
        alien.setTelepathic(false);
        assertFalse(alien.isTelepathic());
    }

}