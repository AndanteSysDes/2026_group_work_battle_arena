package game;

import model.Ranger;
import model.Warrior;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class BattleServiceTest {

    BattleService battleService;
    Random random;
    Player player;
    Player autoPlayer;

    @BeforeEach
    void setUp(){
        player = new AutoPlayer(new Random());
        autoPlayer = new AutoPlayer(new Random());
        player.setName("Player1");
        player.setFighter(new Warrior());
        autoPlayer.setName("Player2");
        autoPlayer.setFighter(new Ranger());

        random = new Random();

        battleService = new BattleService(random, player, autoPlayer);
    }

    @Test
    void battleShouldSetBattleResultWhenItHasWinner() {
        player.getFighter().setCurrentHp(1);
        autoPlayer.getFighter().setCurrentHp(0);
        battleService.battle();

        BattleResult battleResult = battleService.getBattleResult();
        assertNotNull(battleResult);
    }

    @Test
    void battleShouldSetCollectBattleResult() {
        player.getFighter().setCurrentHp(1);
        autoPlayer.getFighter().setCurrentHp(0);
        battleService.battle();

        BattleResult battleResult = battleService.getBattleResult();

        assertEquals("Player1", battleResult.getUserName());
        assertEquals("Warrior", battleResult.getUserCharacter());
        assertEquals("Ranger", battleResult.getComputerCharacter());
        assertEquals("Player1", battleResult.getWinner());
        assertEquals(0, battleResult.getTotalRounds());
    }


    @Test
    void battleShouldCountRoundsCorrectly() {
        player.getFighter().setCurrentHp(1);
        autoPlayer.getFighter().setCurrentHp(1);
        battleService.battle();

        BattleResult battleResult = battleService.getBattleResult();

        assertEquals(1, battleResult.getTotalRounds());
    }

    @Test
    void battleShouldCountRoundsCorrectlyEvenIfItTakesTweOrMoreRounds() {
        player.getFighter().setCurrentHp(20);
        autoPlayer.getFighter().setCurrentHp(20);
        battleService.battle();

        BattleResult battleResult = battleService.getBattleResult();

        assertEquals(2, battleResult.getTotalRounds());
    }



    @Test
    void hasWinnerShouldBeTrueWhenEitherPlayersHPIs0() {
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
    void getBattleResult() {
    }
}