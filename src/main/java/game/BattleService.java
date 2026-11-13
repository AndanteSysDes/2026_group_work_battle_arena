package game;

import java.util.Random;

public class BattleService {

    private int roundCounter;
    private BattleResult battleResult;
    private Random random;
    Player player;
    Player autoPlayer;


    public BattleService(Random random, Player player, Player autoPlayer) {
        this.random = random;
        this.player = player;
        this.autoPlayer = autoPlayer;
        this.roundCounter = 0;
    }

    public BattleResult getBattleResult() {
        return battleResult;
    }
    public void battle(){

    }

    public void takeTurn(){
    }

    public boolean hasWinner(){
        return false;
    }

    public void showBattleProcess(){

    }



}
