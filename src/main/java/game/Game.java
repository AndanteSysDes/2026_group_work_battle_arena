package game;

import java.util.Random;

public class Game {

    private Player player;
    private Player autoPlayer;
    private BattleService battleService;
    private BattleResult battleResult;

     public Game(){

     }

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

    public void setUpPlayer(){
        //skapa instanser player och autoplayer
        //sätta dem variable
        player =new Player();
        player.inputName();
        player.chooseFighter();

        autoPlayer = new AutoPlayer(new Random());
        autoPlayer.inputName();
        autoPlayer.chooseFighter();

    }

    public void start() throws IllegalAccessException {

//        Skapa BattleService och ge Player och AutoPlayer till BattleService
//        anropar BattleService.battle() metod och tar emot BattleResult.
//
         if(player == null || autoPlayer == null){
             throw new IllegalAccessException("Anropa setUpPlayers() innan start()");
         }
         battleService = new BattleService(new Random(),player,autoPlayer);
         battleService.battle();
         battleResult = battleService.getBattleResult();


     }

     public void showBattleResult(){
         // Tar emot result från BattleService och visa vem som vann

         if(battleResult == null){
             System.out.println("Ingen strid har spelats ännu.");
             return;
         }

         System.out.println("Battle resultat är ");
         System.out.println("Spelare :" + battleResult.getUserName()
                 +" " + battleResult.getUserCharacter() );
         System.out.println("Auto Player :" + battleResult.getComputerCharacter());
         System.out.println("Antal rundor :" + battleResult.getTotalRounds());
         System.out.println("Vinnare :" + battleResult.getWinner());

         //Player winner = battleResult.getWinner();
//         if(winner == null){
//             System.out.println("Striden slutade oavgjort.");
//         }
//         else{
//             System.out.println("Vinnare : " + winner.getName());
//         }
     }

     public void saveBattleResult(){
         // anropa Client klass, ger BattleService, och fråga Client klass om spara data.

         if(battleService == null){
             System.out.println("Det finns inget resultat att spara.");
             return;
         }
//         Client client = new Client(battleService);
//         client.askTosave();
     }



}
