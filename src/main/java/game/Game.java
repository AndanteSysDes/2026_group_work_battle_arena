package game;

import client.Client;

import java.io.EOFException;
import java.io.IOException;
import java.util.Random;

public class Game {

    private Player player;
    private Player autoPlayer;
    private BattleService battleService;
    private BattleResult battleResult;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getAutoPlayer() {
        return autoPlayer;
    }

    public void setAutoPlayer(Player autoPlayer) {
        this.autoPlayer = autoPlayer;
    }

    public BattleService getBattleService() {
        return battleService;
    }

    public void setBattleService(BattleService battleService) {
        this.battleService = battleService;
    }

    public BattleResult getBattleResult() {
        return battleResult;
    }

    public void playGame(){
        try{
            setUpPlayer();
            start();
            showBattleResult();
            saveBattleResult();


        }catch(IllegalStateException e){
            System.out.println(e.getMessage());
            System.out.println("Spelet har avbrutits");
        }catch (IOException e){
            System.out.println(e.getMessage());
            System.out.println("Spelet har avbrutits");
        }
    }

    protected void setUpPlayer() throws EOFException {
        player =new HumanPlayer();
        player.inputName();
        player.chooseFighter();
        autoPlayer = new AutoPlayer(new Random());
    }

    protected void start() throws IllegalStateException, IOException {

         if(player == null || autoPlayer == null){
             setUpPlayer();
         }
         battleService = new BattleService(new Random(),player,autoPlayer);
         battleService.battle();
         battleResult = battleService.getBattleResult();

     }

     protected void showBattleResult(){

         if(battleResult == null){
             System.out.println("Ingen strid har spelats ännu.");
             return;
         }
         System.out.println("------------------------------------------------");
         System.out.println("Battle resultat är :");
         System.out.println(battleResult);


     }

     protected void saveBattleResult(){

         if(battleService == null){
             System.out.println("Det finns inget resultat att spara.");
             return;
         }
         Client client = new Client();
         String result = client.save(battleResult);
         System.out.println(result);

     }
}
