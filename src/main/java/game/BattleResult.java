package game;

public class BattleResult {

    private String userName;
    private String userCharacter;
    private String computerCharacter;
    private String winner;
    private int totalRounds;

    public BattleResult(String userName, String userCharacter, String computerCharacter, String winner, int totalRounds) {
        this.userName = userName;
        this.userCharacter = userCharacter;
        this.computerCharacter = computerCharacter;
        this.winner = winner;
        this.totalRounds = totalRounds;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserCharacter() {
        return userCharacter;
    }

    public String getComputerCharacter() {
        return computerCharacter;
    }

    public String getWinner() {
        return winner;
    }

    public int getTotalRounds() {
        return totalRounds;
    }
}
