package game;

import model.*;

import java.io.EOFException;

public abstract class Player {

    private String name;
    private Fighter fighter;

    public Player() {
        this.name = "Okänd spelare";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Fighter getFighter() {
        return fighter;
    }

    public void setFighter(Fighter fighter) {
        this.fighter = fighter;
    }

    public abstract void inputName() throws EOFException ;
    public abstract void chooseFighter() throws EOFException, IllegalStateException ;
    public abstract int inputCommand() throws EOFException ;
}


