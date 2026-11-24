package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BattleResultConverterTest {

    @Test
    void parse() {
        String text = "Player1,Warrior,Mage,Player1,20";
        BattleResult battleResult = BattleResultConverter.parse(text);


        assertEquals("Player1", battleResult.getUserName());
        assertEquals("Warrior", battleResult.getUserCharacter());
        assertEquals("Mage", battleResult.getComputerCharacter());
        assertEquals("Player1", battleResult.getWinner());
        assertEquals(20, battleResult.getTotalRounds());
    }

    @Test
    void format() {
        BattleResult testResult = new BattleResult("TestUser", "Mage", "Ranger", "AutoPlayer",5);
        String formattedResult = BattleResultConverter.format(testResult);
        assertEquals("TestUser,Mage,Ranger,AutoPlayer,5", formattedResult);
    }
}