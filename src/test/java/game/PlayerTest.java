package game;
import model.Warrior;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    Player player;
    @BeforeEach
    void setUp() {
        player = new Player();
    }

    @Test
    void inputNameShouldStoreName(){
        //Player player = new Player(new Scanner("Maahi"));
         player.inputName();
         assertEquals("",player.getName());
    }

    @Test
    void inputName() {
    }

    @Test
    void chooseFighter() {
    }

    @Test
    void inputCommand() {
    }


}