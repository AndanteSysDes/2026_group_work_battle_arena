package game;

import model.ActionType;

import java.util.*;

public class BattleService {

    private Random random;
    private Player player;
    private Player autoPlayer;
    private int roundCounter;

//    private HashMap<Integer, String> commandMenu;


    private BattleResult battleResult;


    public BattleService(Random random, Player player, Player autoPlayer) {
        this.random = random;
        this.player = player;
        this.autoPlayer = autoPlayer;
        this.roundCounter = 0;
//        commandMenu = new HashMap<>();
//        commandMenu.put(1, "Vanlig attack");
//        commandMenu.put(2, "Specialförmåga");
    }

    public void battle(){
        System.out.println("Battle Started!!");
        while(!hasWinner()){
            takeTurn();
        }
        setBattleResult();
    }

    private void takeTurn(){
        roundCounter++;
        System.out.println("Round " + roundCounter);

        ArrayList<Player> turnOrder = getRandomPlayerOrder();

        for(Player turnPlayer : turnOrder){
            showStatus();

            System.out.println(turnPlayer.getName() + "s tur.");

            int selectedCommand = turnPlayer.inputCommand();

            switch (selectedCommand) {
                case 1 -> normalAttack(turnPlayer, turnOrder);
                case 2 -> specialAttack(turnPlayer, turnOrder);
                default -> {
                    // Something wrong. show message and throw exception.
                    return;
                }
            }

            if(hasWinner()){
                System.out.println("Matchen är slut!!");
                return;
            }
        }
    }

    public boolean hasWinner(){
        return !(player.getFighter().isAlive() && autoPlayer.getFighter().isAlive());
    }

    private void showBattleProcess(
            Player attacker,
            Player defender,
            ActionType type,
            int damage
    ){
        String MessageForNormalAttack = attacker.getName() + " har attackerat "+ defender.getName() +".";
        String MessageForDamageTaker = defender.getName() + " fick " + damage + " skadepoäng";
        String MessageForSpecialAbility = attacker.getName() + " har använt " + type.toString() + ".";
        String MessageForDefence = attacker.getName() + " halverar skadan från nästa inkommande attack.";
        String MessageForHeal = attacker.getName() + " återfår 15 HP.";
        String MessageForPreciseShot =
                "Pilen "+attacker.getName()+" sköt träffade "+ defender.getName() +"s vitala punkt!\n"
                + MessageForDamageTaker;

        if(type==ActionType.ATTACK){
            System.out.println(MessageForNormalAttack);
            System.out.println(MessageForDamageTaker);
        }else{
            System.out.println(MessageForSpecialAbility);

            switch (type){
                case DEFENCE ->   System.out.println(MessageForDefence);
                case HEAL ->  System.out.println(MessageForHeal);
                case PRECISE_SHOT ->  System.out.println(MessageForPreciseShot);
                case null, default -> throw new IllegalStateException("Unexpected value: " + type);
            }
        }

    }

    private void showStatus(){
        System.out.println("---------------------------------------------------------");

        System.out.println(player.getName() + "("+player.getFighter().getName()+")     HP: "
                + player.getFighter().getCurrentHp()
        );
        System.out.println(autoPlayer.getName() + "("+autoPlayer.getFighter().getName()+")     HP: "
                + autoPlayer.getFighter().getCurrentHp()
        );

        System.out.println("---------------------------------------------------------");
    }

    private ArrayList<Player> getRandomPlayerOrder(){
        ArrayList<Player> playerOrder = new ArrayList<>(
                List.of(player, autoPlayer)
        );
        Collections.shuffle(playerOrder);
        return playerOrder;
    }

    private Player chooseTarget(Player attacker, ArrayList<Player> playerList){
        Player target = playerList.get(random.nextInt(playerList.size()));
        while(target == attacker){
            target = playerList.get(random.nextInt(playerList.size()));
        }
        return target;
    }

    private void normalAttack(Player attacker, ArrayList<Player> playerList){
        Player defender = chooseTarget(attacker, playerList);

        int damage = attacker.getFighter().attack();
        defender.getFighter().takeDamage(damage);

        showBattleProcess(attacker, defender, attacker.getFighter().getNormalAbility(), damage);
    }

    private void specialAttack(Player attacker, ArrayList<Player> playerList){
        Player defender = chooseTarget(attacker, playerList);

        int damage = attacker.getFighter().useAbility();
        defender.getFighter().takeDamage(damage);

        showBattleProcess(attacker, defender, attacker.getFighter().getSpecialAbility(), damage);
    }

    private Player setBattleResult(){
        if(!hasWinner()){
            // TODO: need to throw something
            return null;
        }

        Player winner;
        if(player.getFighter().isAlive()){
            winner = player;
        }else {
            winner = autoPlayer;
        }

        String userName = player.getName();
        String userCharacter = player.getFighter().getName();
        String computerCharacter = autoPlayer.getFighter().getName();


        int totalRounds = roundCounter;

        this.battleResult = new BattleResult(userName, userCharacter, computerCharacter, winner.getName(), totalRounds);
        return winner;
    }

    public BattleResult getBattleResult() {
        return battleResult;
    }
}
