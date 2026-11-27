package game;
import model.Mage;
import model.Ranger;
import model.Warrior;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.EOFException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest{

    HumanPlayer player;
    @BeforeEach
    void setUp() {
        player = new HumanPlayer();
    }

    // InputName

    @Test
    void inputNameShouldStoreName() throws EOFException {
        HumanPlayer player = new HumanPlayer(new Scanner("Maahi"));
         player.inputName();
         assertEquals("Maahi", player.getName());
    }

    @Test
    void inputNameShouldTrimSpaces() throws EOFException{
        HumanPlayer player = new HumanPlayer(new Scanner("    Maahi  \n"));
        player.inputName();
         assertEquals("Maahi", player.getName());
    }

    @Test
    void inputNameShouldAskIfEmpty() throws EOFException{
        HumanPlayer player = new HumanPlayer(new Scanner("\nMaahi\n"));
        player.inputName();
        assertEquals("Maahi", player.getName());
    }
    @Test
    void inputNameShouldAskIfOnlySpaces() throws EOFException{
        HumanPlayer player = new HumanPlayer(new Scanner("   \nMaahi\n"));
        player.inputName();
        assertEquals("Maahi", player.getName());
    }

    // If Choose Fighter

    @Test
    void chooseFighterShouldWarriorOnInput1() throws EOFException{
        player = new HumanPlayer(new Scanner("1\n"));
        player.chooseFighter();
        assertEquals(Warrior.class, player.getFighter().getClass());
    }

    @Test
    void chooseFighterShouldChooseMageOnInput2() throws EOFException{
        player = new HumanPlayer(new Scanner("2\n"));
        player.chooseFighter();
        assertEquals(Mage.class, player.getFighter().getClass());
    }

    @Test
    void chooseFighterShouldChooseRangerOnInput3() throws EOFException{
        player = new HumanPlayer(new Scanner("3\n"));
        player.chooseFighter();
        assertEquals(Ranger.class, player.getFighter().getClass());
    }

    @Test
    void inputCommandShouldNotAllowSpecialAbilityIfAlreadyUsed() throws EOFException{
        player = new HumanPlayer(new Scanner("2\n1"));
        player.setFighter(new Warrior());
        player.getFighter().setHasSpecialAbilityUsed(true);

        assertEquals(1,player.inputCommand());
    }


   @Test
    void chooseFighterShouldChooseInvalidInput() throws EOFException{
        player = new HumanPlayer(new Scanner("9\n1\n"));
        player.chooseFighter();
        assertEquals(Warrior.class, player.getFighter().getClass());
    }

    @Test
    void ChooseFighterShouldChooseBeNull(){
        player = new HumanPlayer(new Scanner(""));
        assertNull(player.getFighter());
    }


    //inputCommand()

    @Test
    void inputCommandShouldReturn1ForNormalAttack() throws EOFException{
        // 1. Normal Attack
        // 2. Special Attack
        player = new HumanPlayer(new Scanner("1\n"));
        player.setFighter(new Warrior());
        assertEquals(1, player.inputCommand());
    }

    @Test
    void inputCommandShouldReturn2ForSpecialAttack() throws EOFException{
        player = new HumanPlayer(new Scanner("2\n"));
        player.setFighter(new Warrior());
        assertEquals(2, player.inputCommand());
    }

    @Test
    void inputCommandShouldReturCollectValue() throws EOFException{
        //1. Normal Attack
        //2. Special Attack

        int selectValue;
        player = new HumanPlayer(new Scanner("1\n2\n2\n1\n1\n"));
        player.setFighter(new Warrior());

        for(int i=0 ;i<5 ;i++){
            selectValue = player.inputCommand();
            assertTrue(selectValue == 1
                    || selectValue == 2);
        }
    }









}