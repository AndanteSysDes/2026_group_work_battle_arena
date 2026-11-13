package game;

public class Game {

    private Player player;
    private Player autoPlayer;
    private BattleService battleService;

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

    public void start(){
        // skriv någonting
     }

     public void showBattleResult(){
         // skriv någonting
     }

     public void saveBattleResult(){
         // skriv någonting
     }

     public void setUpPlayer(){
         //skapa instanser player och autoplayer
         //sätta dem variable

     }

}
