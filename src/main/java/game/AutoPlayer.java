package game;

import model.Fighter;

import java.util.Random;

public class AutoPlayer extends Player {

    Fighter fighter;
    Random random ;

    public AutoPlayer(Random random){
        super();
        this.random = random;
    }


    @Override
    public void chooseFighter(){
        // skriv någonting
    }

    @Override
    public int inputCommand(){
        // skriv någonting
        return 0;
    }




}
