package game;

public class BattleResult {

    private final String userName;
    private final String userCharacter;
    private final String computerCharacter;
    private final String winner;
    private final int totalRounds;

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
