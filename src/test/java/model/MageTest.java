package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MageTest {
    Mage mage;

    @BeforeEach
    void setUp() {
        mage = new Mage();
    }

    @Test
    void currentHPShouldBeSameAsMaxHPAtFirst(){
        int currentHP = mage.getCurrentHp();
        int maxHP = mage.getMaxHp();
        assertEquals(currentHP,maxHP);
    }

    @Test
    void mageShouldHave90MaxHP(){
        int maxHP = mage.getMaxHp();
        assertEquals(90, maxHP);
    }

    @Test
    void attackShouldReturnPositiveInt() {
        int attackPoint = mage.attack();
        assertTrue(attackPoint > 0);
    }

    @Test
    void attackShouldReturnMinimum3(){
        int attackPoint = mage.attack();
        assertTrue(attackPoint >= 3);
    }

    @Test
    void attackShouldReturnMaximum13(){
        int attackPoint = mage.attack();
        assertTrue(attackPoint <= 13);
    }

    @Test
    void takeDamageShouldDecreaseCurrentHP() {
        mage.takeDamage(10);
        assertEquals(80, mage.getCurrentHp());
    }

    @Test
    void takeDamageShouldNotDecreaseCurrentHPBelow0(){
        mage.takeDamage(100);
        assertEquals(0, mage.getCurrentHp());
    }

    @Test
    void mageShouldHaveAttackAsNormalAbility(){
        ActionType normalAbilityForMage = mage.getNormalAbility();
        assertEquals(ActionType.ATTACK, normalAbilityForMage);
    }

    @Test
    void mageShouldHaveHealAsSpecialAbility(){
        ActionType specialAbilityForMage = mage.getSpecialAbility();
        assertEquals(ActionType.HEAL, specialAbilityForMage);
    }

    @Test
    void useAbilityIncreaseCurrentHP15() {
        mage.setCurrentHp(50);
        mage.useAbility();
        assertEquals(65, mage.getCurrentHp());
    }

    @Test
    void useAbilityShouldNotIncreaseHPOverMaxHP(){
        mage.setCurrentHp(80);
        mage.useAbility();
        assertEquals(90, mage.getCurrentHp());
    }

    @Test
    void hasSpecialAbilityUsedShouldReturnTrueAfterUsingSpecialAbility(){
        assertFalse(mage.hasSpecialAbilityUsed);
        mage.useAbility();
        assertTrue(mage.hasSpecialAbilityUsed);
    }

    @Test
    void isAliveShouldReturnTrueIfCurrentHPIsGreaterThan0(){
        mage.setCurrentHp(30);
        assertTrue(mage.isAlive());
    }

    @Test
    void isAliveShouldReturnFalseIfCurrentHPIs0(){
        mage.setCurrentHp(0);
        assertFalse(mage.isAlive());
    }


}