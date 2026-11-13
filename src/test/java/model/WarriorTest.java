package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WarriorTest {

    Warrior warrior;

    @BeforeEach
    void setup(){
        warrior = new Warrior();
    }

    // HP
    @Test
    void currentHPShouldBeSameAsMaxHPAtFirst(){
        int currentHP = warrior.getCurrentHp();
        int maxHP = warrior.getMaxHp();
        assertEquals(currentHP, maxHP);

    }

    @Test
    void warriorShouldHave120MaxHP(){
        int maxHP = warrior.getMaxHp();
        assertEquals(120, maxHP);

    }

    // ATTACK()
    //Randomness requires many runs for the test to say anything.


    @Test
    void attackShouldReturnPositiveInt(){
        int attackPoint = warrior.attack();
        assertTrue(attackPoint > 0);
    }

    @Test
    void attackShouldReturnMinimum5(){
        int attackPoint = warrior.attack();
        assertTrue(attackPoint >= 5);
    }

    @Test
    void attackShouldReturnMaximum15(){
        int attackPoint = warrior.attack();
        assertTrue(attackPoint <= 15);
    }

    // takeDamage()

    @Test
    void takeDamageShouldDecreaseCurrentHP(){
        warrior.takeDamage(10);
        assertEquals(110, warrior.getCurrentHp());
    }

    @Test
    void takeDamageShouldNotMakeHPBelow0(){
        warrior.takeDamage(130);
        assertEquals(0, warrior.getCurrentHp());
    }

   @Test
    void warriorShouldHaveAttackAsNormalAbility(){
        ActionType normalAbilityForWarrior = warrior.getNormalAbility();
        assertEquals(ActionType.ATTACK, normalAbilityForWarrior);
    }

   @Test
    void takeDamageShouldNotMakeHpBelow0EventWithDefend(){
        warrior.useAbility();
        warrior.takeDamage(240);
        assertEquals(0, warrior.getCurrentHp());
    }

//    @Test
//    void warriorShouldTakeNormalDamageWithoutDefend(){
//        warrior.takeDamage(20);
//        assertEquals(100, warrior.getCurrentHp());
//    }

    //Special Ability Defend
    @Test
    void warriorShouldHaveSpecialAbilityIsDefend(){
        assertEquals(ActionType.DEFENCE,warrior.getSpecialAbility());

    }

    @Test
    void defendHaveDamageTakeNextTurn(){
    warrior.useAbility();
    warrior.takeDamage(20);
    assertEquals(110, warrior.getCurrentHp());
    }

    @Test
    void defendHaveDamageOnlyLastOneTurn(){
        warrior.useAbility();
        warrior.takeDamage(20);
        assertEquals(110, warrior.getCurrentHp());
        warrior.takeDamage(20);
        assertEquals(90, warrior.getCurrentHp());
    }


    @Test
    void warriorShouldHaveDamageIsNormalWithoutDefend(){
        warrior.takeDamage(20);

        assertEquals(100, warrior.getCurrentHp());
    }
    @Test
    void attack() {
    }

    @Test
    void takeDamage() {
    }

    @Test
    void useAbility() {
    }
}