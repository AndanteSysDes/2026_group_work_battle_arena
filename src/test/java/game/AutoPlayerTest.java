package game;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class AutoPlayerTest {

    AutoPlayer autoPlayer;

    @Test
    void chooseFighterShouldChooseWarriorWithAOneInThreeProbability(){
        autoPlayer = new AutoPlayer(new FixedRandomForFighter(0));

        assertEquals(Warrior.class, autoPlayer.getFighter().getClass());
    }

    @Test
    void chooseFighterShouldChooseMageWithAOneInThreeProbability(){
        autoPlayer = new AutoPlayer(new FixedRandomForFighter(1));

        assertEquals(Mage.class, autoPlayer.getFighter().getClass());

    }

    @Test
    void chooseFighterShouldChooseRangerWithAOneInThreeProbability(){
        autoPlayer = new AutoPlayer(new FixedRandomForFighter(2));

        assertEquals(Ranger.class, autoPlayer.getFighter().getClass());
    }

    @Test
    void inputCommandShouldReturnCollectValue(){
        //For menu selection, we'll assume the following:
        //1. Normal Attack
        //2. Special Attack

        int selectValue;
        autoPlayer = new AutoPlayer(new Random());

        for (int i = 0; i < 100; i++) {
            selectValue = autoPlayer.inputCommand();
            assertTrue(selectValue == 1  || selectValue == 2);
        }

    }

    @Test
    void inputCommandShouldChooseNormalAbilityWithA50PercentProbability() {
        //For menu selection, we'll assume the following:
        //1. Normal Attack
        //2. Special Attack

        autoPlayer = new AutoPlayer(new FixedRandomForCommand(1));
        int selectValue = autoPlayer.inputCommand();

        assertEquals(1, selectValue);
    }

    @Test
    void inputCommandShouldChooseSpecialAbilityWithA50PercentProbability() {
        //For menu selection, we'll assume the following:
        //1. Normal Attack
        //2. Special Attack

        autoPlayer = new AutoPlayer(new FixedRandomForCommand(2));
        int selectValue = autoPlayer.inputCommand();

        assertEquals(2, selectValue);
    }

    @Test
    void inputCommandShouldNotSelectSpecialAbilityIfItIsAlreadyUsed() {
        //For menu selection, we'll assume the following:
        //1. Normal Attack
        //2. Special Attack

        autoPlayer = new AutoPlayer(new FixedRandomForCommand(2));

        Fighter fighter = autoPlayer.getFighter();
        fighter.setHasSpecialAbilityUsed(true);
        int selectValue = autoPlayer.inputCommand();

        assertEquals(1, selectValue);

    }



    // Random mock
    class FixedRandomForFighter extends Random {
        int intValue;

        FixedRandomForFighter(int nextIntResult) {
            this.intValue = nextIntResult;
        }

        @Override
        public int nextInt(int bound) {
            assertEquals(3, bound);
            return intValue;
        }

    }

    class FixedRandomForCommand extends Random {
        int intValue;

        FixedRandomForCommand(int nextIntResult) {
            this.intValue = nextIntResult;
        }

        @Override
        public int nextInt(int bound) {
            return intValue;
        }

        @Override
        public int nextInt(int origin, int bound) {
            return intValue;
        }
    }
}