package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {
    @Test
    public void testHumanInitialization() {
        Hero hero = new Hero("Test Human", 150, 25, 30);
        assertEquals("Test Human", hero.getName());
        assertEquals(150, hero.getHp());
        assertEquals(25, hero.getAttack());
        assertEquals(30, hero.getShield());
    }
}