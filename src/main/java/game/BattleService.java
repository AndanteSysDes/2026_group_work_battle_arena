package game;

import java.util.Random;

public class BattleService {

    private Random random;
    private Player player;
    private Player autoPlayer;
    private int roundCounter;

    private BattleResult battleResult;


    public BattleService(Random random, Player player, Player autoPlayer) {
        this.random = random;
        this.player = player;
        this.autoPlayer = autoPlayer;
        this.roundCounter = 0;
    }


    public void battle(){
        while(!hasWinner()){
            takeTurn();
        }

        setBattleResult();
    }

    public void takeTurn(){
        //TODO : Make logic

        /*
        0. Addera roundCounter
        1. Bestämmer vilken ska attackera först slumpmässigt.
        2. Följande åtgärder ska utföras i den ordning som följer av resultatet i punkt 1
        a. Anropar Players inmata kommand metod
        -- anropar showBattleProcess()
        -- Gå till punkt 3

        b. Anropar AutoPlayers välja kommand slumpmässigt metod.
        -- anropar showBattleProcess()
        -- Gå till punkt 3

        3.Kolla om hasWinner
        hasWinner == true: sätt BattleResult i variabel.
        hasWinner == false: fortsätta
        */
    }

    public boolean hasWinner(){
        return !(player.getFighter().isAlive() && autoPlayer.getFighter().isAlive());
    }

    public void showBattleProcess(){
        //TODO : Make logic

    }



    public BattleResult getBattleResult() {
        return battleResult;
    }

    private void setBattleResult(){
        if(!hasWinner()){
            // TODO: need to throw something
            return;
        }

        String winner;
        if(player.getFighter().isAlive()){
            winner = player.getName();
        }else {
            winner = autoPlayer.getName();
        }

        String userName = player.getName();
        String userCharacter = player.getFighter().getName();
        String computerCharacter = autoPlayer.getFighter().getName();


        int totalRounds = roundCounter;

        this.battleResult = new BattleResult(userName, userCharacter, computerCharacter, winner, totalRounds);
    }



}
