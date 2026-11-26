package model;

public enum ActionType {

    ATTACK ("Attack", "Utför attacker beroende på karaktärens attackstyrka." ),
    DEFENCE ("Defence", "Halverar skadan från nästa inkommande attack." ),
    HEAL ("Heal", "Återställer 15 HP, men HP kan aldrig överstiga Max HP." ),
    PRECISE_SHOT ("Precise shot", "Gör slumpmässigt 12-20 skada." );

    String displayName;
    String description;

    ActionType(String displayName, String description) {
        this.displayName = displayName;
        this.description = description;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getDescription() {
        return description;
    }
}
