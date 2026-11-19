package model;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RangerTest {

    private  Ranger ranger;

    @BeforeEach
    void setup(){
        ranger = new Ranger();
    }

    // HP

    @Test
    void currentHPShouldBeSameAsMaxHPAtFirst(){
        assertEquals(ranger.getCurrentHp(),ranger.getMaxHp());
    }

    @Test
    void rangerShouldHave105MaxHp(){
        assertEquals(105,ranger.getMaxHp());
    }

    // attack()

    @Test
    void attackShouldReturnPositiveInt(){
        assertTrue(ranger.attack() > 0);
    }

    @Test
    void attackShouldReturnMinimum7(){
        assertTrue(ranger.attack() >= 7);
    }

    @Test
    void attackShouldReturnMaximum17(){
        assertTrue(ranger.attack() <= 17);
    }

    // takeDamage

    @Test
    void takeDamageShouldDecreaseCurrentHP(){
        ranger.takeDamage(10);
        assertEquals(95, ranger.getCurrentHp());
    }

    @Test
    void takeDamageShouldNotMakeHpBelow0(){
        ranger.takeDamage(200);
        assertEquals(0, ranger.getCurrentHp());
    }


    // specialAbility

    @Test
    void rangerShouldHaveSpecialAbilityPreciseShot(){
        assertEquals(ActionType.PRECISE_SHOT, ranger.getSpecialAbility());
    }

    @Test
    void useAbilityShouldReturnMinimum12(){
        assertTrue(ranger.useAbility() >= 12);
    }

    @Test
    void useAbilityShouldReturnMaximum20(){
        assertTrue(ranger.useAbility() <= 20);
    }



    @Test
    void useAbilityShouldNotChangeRangerHp(){
        ranger.useAbility();
        assertEquals(105, ranger.getCurrentHp());
    }

    @Test
    void hasSpecialAbilityUsedShouldReturnTrueAfterUsingSpecialAbility(){
        assertFalse(ranger.hasSpecialAbilityUsed);
        ranger.useAbility();
        assertTrue(ranger.hasSpecialAbilityUsed);
    }

    @Test
    void isAliveShouldReturnTrueIfCurrentHPIsGreaterThan0(){
        ranger.setCurrentHp(200);
        assertTrue(ranger.isAlive());
    }

    @Test
    void isAliveShouldReturnFalseIfCurrentHPIs0(){
        ranger.setCurrentHp(0);
        assertFalse(ranger.isAlive());
    }


}
