package game;

import model.Fighter;
import model.Warrior;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game game;

    @BeforeEach
    public void setUp() {
        game = new Game();
    }

    // This test case is needed to use some test data from command prompt,
    // so I use InputStream to test it.
    @Test
    void testSetUpPlayer() {
        String input = "TestPlayer\n1\n";

        InputStream originalIn = System.in;

        try {
            System.setIn(new ByteArrayInputStream(
                    input.getBytes(StandardCharsets.UTF_8)
            ));

            game.setUpPlayer();

            assertEquals("TestPlayer", game.getPlayer().getName());
            assertInstanceOf(Warrior.class, game.getPlayer().getFighter());
            assertEquals("AutoPlayer", game.getAutoPlayer().getName());
            assertInstanceOf(Fighter.class, game.getAutoPlayer().getFighter());

        } finally {
            System.setIn(originalIn);
        }
    }

    // Need to test start()
    // 1. ARRANGE
    //  Make Player and AutoPlayer instances. You can set Scanner parameter or Random paramter.
    //  Then use game.setPlayer() and game.setAutoPlayer to pass them. Try not to use game.setUpPlayer()
    //  when you want to test the other method.
    // 2. ACT
    //  Call start().
    // 3. ASSERT
    //  Check if the Game instance has BattleResult as an instance variable. Not null.
    //  You don't need to check if the BattleResult's all value are correct,
    //  because it should be tested in BattleServiceTest.


    // You don't have to test showBattleResult() because it only shows the result.
    // But if you have time, it may be better to make a method like toString() in BattleResult class,
    // and just call that method in showBattleResult() in Game class.


    // saveBattleResult() -> We'll think later.
}