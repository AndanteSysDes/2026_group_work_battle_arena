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

    @Test
    void startShouldSetBattleResult() {
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

    @Test
    void afterStartGameShouldHaveBattleResult(){

    Player player = new Player(new Scanner("1\n"));
    player.setName("TestPlayer");
    player.setFighter(new Warrior());

    Player autoPlayer = new AutoPlayer(new Random());
    autoPlayer.setName("AutoPlayer");

    game.setPlayer(player);
    game.setAutoPlayer(autoPlayer);

    game.start();
    assertNotNull(game.getBattleResult());
    }

   @Test
    void gameShouldHaveBattleService(){

       Player player = new Player(new Scanner("1\n"));
       player.setName("TestPlayer");
       player.setFighter(new Warrior());

       Player autoPlayer = new AutoPlayer(new Random());
       autoPlayer.setName("AutoPlayer");

       game.setPlayer(player);
       game.setAutoPlayer(autoPlayer);

       game.start();
       game.showBattleResult();
       assertNotNull(game.getBattleService());

    }

    // saveBattleResult() -> We'll think later.


}