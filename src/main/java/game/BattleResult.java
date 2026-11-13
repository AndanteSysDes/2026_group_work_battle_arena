package game;

public class BattleResult {

    private String UserName;
    private String UserCharacter;
    private String ComputerCharacter;
    private String Winner;
    private int totalRounds;

    public BattleResult(String userName, String userCharacter, String computerCharacter, String winner, int totalRounds) {
        UserName = userName;
        UserCharacter = userCharacter;
        ComputerCharacter = computerCharacter;
        Winner = winner;
        this.totalRounds = totalRounds;
    }

    public String getUserName() {
        return UserName;
    }

    public String getUserCharacter() {
        return UserCharacter;
    }

    public String getComputerCharacter() {
        return ComputerCharacter;
    }

    public String getWinner() {
        return Winner;
    }

    public int getTotalRounds() {
        return totalRounds;
    }
}
