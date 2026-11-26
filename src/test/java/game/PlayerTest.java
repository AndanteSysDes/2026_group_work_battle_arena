package game;
import model.Mage;
import model.Ranger;
import model.SpecialAbility;
import model.Warrior;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.EOFException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest{

    Player player;
    @BeforeEach
    void setUp() {
        player = new Player();
    }

    // InputName

    @Test
    void inputNameShouldStoreName() throws EOFException {
        Player player = new Player(new Scanner("Maahi"));
         player.inputName();
         assertEquals("Maahi", player.getName());
    }

    @Test
    void inputNameShouldTrimSpaces() throws EOFException{
        Player player = new Player(new Scanner("    Maahi  \n"));
        player.inputName();
         assertEquals("Maahi", player.getName());
    }

    @Test
    void inputNameShouldAskIfEmpty() throws EOFException{
        Player player = new Player(new Scanner("\nMaahi\n"));
        player.inputName();
        assertEquals("Maahi", player.getName());
    }
    @Test
    void inputNameShouldAskIfOnlySpaces() throws EOFException{
        Player player = new Player(new Scanner("   \nMaahi\n"));
        player.inputName();
        assertEquals("Maahi", player.getName());
    }

    // If Choose Fighter

    @Test
    void chooseFighterShouldWarriorOnInput1() throws EOFException{
        player = new Player(new Scanner("1\n"));
        player.chooseFighter();
        assertEquals(Warrior.class, player.getFighter().getClass());
    }

    @Test
    void chooseFighterShouldChooseMageOnInput2() throws EOFException{
        player = new Player(new Scanner("2\n"));
        player.chooseFighter();
        assertEquals(Mage.class, player.getFighter().getClass());
    }

    @Test
    void chooseFighterShouldChooseRangerOnInput3() throws EOFException{
        player = new Player(new Scanner("3\n"));
        player.chooseFighter();
        assertEquals(Ranger.class, player.getFighter().getClass());
    }

    @Test
    void inputCommandShouldNotAllowSpecialAbilityIfAlreadyUsed() throws EOFException{
        player = new Player(new Scanner("2\n1"));
        player.setFighter(new Warrior());
        player.getFighter().setHasSpecialAbilityUsed(true);

        assertEquals(1,player.inputCommand());
    }


   @Test
    void chooseFighterShouldChooseInvalidInput() throws EOFException{
        player = new Player(new Scanner("9\n1\n"));
        player.chooseFighter();
        assertEquals(Warrior.class, player.getFighter().getClass());
    }

    @Test
    void ChooseFighterShouldChooseBeNull(){
        player = new Player(new Scanner(""));
        assertNull(player.getFighter());
    }


    //inputCommand()

    @Test
    void inputCommandShouldReturn1ForNormalAttack() throws EOFException{
        // 1. Normal Attack
        // 2. Special Attack
        player = new Player(new Scanner("1\n"));
        assertEquals(1, player.inputCommand());
    }

    @Test
    void inputCommandShouldReturn2ForSpecialAttack() throws EOFException{
        player = new Player(new Scanner("2\n"));
        assertEquals(2, player.inputCommand());
    }

    @Test
    void inputCommandShouldReturCollectValue() throws EOFException{
        //1. Normal Attack
        //2. Special Attack

        int selectValue;
        player = new Player(new Scanner("1\n2\n2\n1\n1\n"));
        for(int i=0 ;i<5 ;i++){
            selectValue = player.inputCommand();
            assertTrue(selectValue == 1
                    || selectValue == 2);
        }
    }









}