package game;

import model.Mage;
import model.Ranger;
import model.Warrior;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class BattleServiceTest {

    BattleService battleService;
    Random random;
    Player player;
    Player autoPlayer;


    @BeforeEach
    void setUp(){
        player =  new HumanPlayer(new Scanner("1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n"));
        autoPlayer = new AutoPlayer(new Random());
        player.setName("Player1");
        player.setFighter(new Warrior());
        autoPlayer.setName("Player2");
        autoPlayer.setFighter(new Ranger());

        random = new Random();

        battleService = new BattleService(random, player, autoPlayer);
    }

    @Test
    void battleShouldSetBattleResultWhenItHasWinner() throws IllegalStateException, IOException {
        player.getFighter().setCurrentHp(1);
        autoPlayer.getFighter().setCurrentHp(0);
        battleService.battle();

        BattleResult battleResult = battleService.getBattleResult();
        assertNotNull(battleResult);
    }

    @Test
    void battleShouldSetCollectBattleResult() throws IllegalStateException, IOException {
        Player player = new HumanPlayer(new Scanner("1\n1\n1"));
        Player autoPlayer = new AutoPlayer(new FixedRandomForCommand(1));

        player.setName("Player1");
        player.setFighter(new Ranger());
        autoPlayer.setName("Player2");
        autoPlayer.setFighter(new Mage());

        player.getFighter().setCurrentHp(105);
        autoPlayer.getFighter().setCurrentHp(1);

        battleService = new BattleService(random, player, autoPlayer);
        battleService.battle();

        BattleResult battleResult = battleService.getBattleResult();

        assertEquals("Player1", battleResult.getUserName());
        assertEquals("Ranger", battleResult.getUserCharacter());
        assertEquals("Mage", battleResult.getComputerCharacter());
        assertEquals("Player1", battleResult.getWinner());
        assertEquals(1, battleResult.getTotalRounds());
    }


    @Test
    void battleShouldCountRoundsCorrectly()  throws IllegalStateException, IOException{
        player.getFighter().setCurrentHp(1);
        autoPlayer.getFighter().setCurrentHp(1);
        battleService.battle();

        BattleResult battleResult = battleService.getBattleResult();

        assertEquals(1, battleResult.getTotalRounds());
    }

    @Test
    void battleShouldCountRoundsCorrectlyEvenIfItTakesTweOrMoreRounds() throws IllegalStateException, IOException {
        Player autoPlayer = new AutoPlayer(new FixedRandomForCommand(1));
        Player player = new HumanPlayer(new Scanner("1\n1\n"));

        player.setName("Player1");
        player.setFighter(new Mage());
        autoPlayer.setName("Player2");
        autoPlayer.setFighter(new Mage());

        battleService = new BattleService(random, player, autoPlayer);

        player.getFighter().setCurrentHp(14);
        autoPlayer.getFighter().setCurrentHp(14);
        battleService.battle();

        BattleResult battleResult = battleService.getBattleResult();

        assertEquals(2, battleResult.getTotalRounds());
    }

    @Test
    void hasWinnerShouldBeTrueWhenEitherPlayersHPIs0()  throws IllegalStateException, IOException{
        player.getFighter().setCurrentHp(1);
        autoPlayer.getFighter().setCurrentHp(0);
        assertTrue(battleService.hasWinner());
    }

    @Test
    void hasWinnerShouldBeFalseWhenBothPlayersHPIsOver0() {
        player.getFighter().setCurrentHp(1);
        autoPlayer.getFighter().setCurrentHp(1);
        assertFalse(battleService.hasWinner());
    }

    @Test
    void warriorCanUseTheSpecialAbility() throws IllegalStateException, IOException{
        Player autoPlayer = new AutoPlayer(new FixedRandomForCommand(1));
        Player player = new HumanPlayer(new Scanner("2 \n 1  \n 1"));

        player.setName("Player1");
        player.setFighter(new Warrior());
        player.getFighter().setCurrentHp(100);
        autoPlayer.setName("Player2");
        autoPlayer.setFighter(new Mage());
        autoPlayer.getFighter().setCurrentHp(1);

        assertFalse(player.getFighter().isHasSpecialAbilityUsed());
        battleService = new BattleService(random, player, autoPlayer);
        battleService.battle();
        assertTrue(battleService.hasWinner());
        assertTrue(player.getFighter().isHasSpecialAbilityUsed());

    }

    @Test
    void mageCanUseTheSpecialAbility() throws IllegalStateException, IOException{
        Player autoPlayer = new AutoPlayer(new FixedRandomForCommand(1));
        Player player = new HumanPlayer(new Scanner("2 \n 1  \n 1"));

        player.setName("Player1");
        player.setFighter(new Mage());
        player.getFighter().setCurrentHp(50);
        autoPlayer.setName("Player2");
        autoPlayer.setFighter(new Mage());
        autoPlayer.getFighter().setCurrentHp(1);

        assertFalse(player.getFighter().isHasSpecialAbilityUsed());
        battleService = new BattleService(random, player, autoPlayer);
        battleService.battle();
        assertTrue(battleService.hasWinner());
        assertTrue(player.getFighter().isHasSpecialAbilityUsed());

    }

    @Test
    void rangerCanUseTheSpecialAbility() throws IllegalStateException, IOException{
        Player autoPlayer = new AutoPlayer(new FixedRandomForCommand(1));
        Player player = new HumanPlayer(new Scanner("2 \n 1  \n 1"));

        player.setName("Player1");
        player.setFighter(new Ranger());
        player.getFighter().setCurrentHp(50);
        autoPlayer.setName("Player2");
        autoPlayer.setFighter(new Mage());
        autoPlayer.getFighter().setCurrentHp(1);

        assertFalse(player.getFighter().isHasSpecialAbilityUsed());
        battleService = new BattleService(random, player, autoPlayer);
        battleService.battle();
        assertTrue(battleService.hasWinner());
        assertTrue(player.getFighter().isHasSpecialAbilityUsed());

    }

    // MOCK
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