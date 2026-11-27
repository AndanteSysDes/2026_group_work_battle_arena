package game;

import model.FighterType;

public class BattleResultConverter {
    public static BattleResult parse(String text){

        if(text == null ){
            throw new IllegalArgumentException("input is null");
        }

        String[] data = text.split(",");

        if(data.length != 5){
            throw new IllegalArgumentException("Expected 5 comma-separated values");
        }


        String userName = data[0].trim();
        String userCharacter = data[1].trim();
        String computerCharacter = data[2].trim();
        String winner = data[3].trim();

        if(!FighterType.containsFighterName(userCharacter)){
            throw new IllegalArgumentException("invalid user character");
        }

        if(!FighterType.containsFighterName(computerCharacter)){
            throw new IllegalArgumentException("invalid computer character");
        }

        try{
            int totalRounds = Integer.parseInt(data[4].trim());
            return new BattleResult(userName, userCharacter, computerCharacter, winner, totalRounds);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("The 5th value must be a number.");
        }

    }

    public static String format(BattleResult result){

        return "%s,%s,%s,%s,%d".formatted(
                result.getUserName(),
                result.getUserCharacter(),
                result.getComputerCharacter(),
                result.getWinner(),
                result.getTotalRounds()
        );
    }
}
