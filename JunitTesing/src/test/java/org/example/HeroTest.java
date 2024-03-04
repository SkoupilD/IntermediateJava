package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {
    static Hero hero;
    @BeforeEach
    public void setUp() {
        hero = new Hero("Test Human", 150, 25, 30);
    }
    @Test
    public void testHumanInitialization() {
        assertEquals("Test Human", hero.getName());
        assertEquals(150, hero.getHp());
        assertEquals(25, hero.getAttack());
        assertEquals(30, hero.getShield());
    }
    @Test
    public void testSetShield() {
        hero.setShield(250);
        assertEquals(250, hero.getShield());
    }
}