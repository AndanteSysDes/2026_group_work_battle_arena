package model;

import java.util.HashMap;
import java.util.Map;

public enum FighterType {

    WARRIOR("1", "Warrior", 120 , ActionType.DEFENCE, 5, 15),
    MAGE("2", "Mage", 90, ActionType.HEAL, 3, 13),
    RANGER("3", "Ranger", 105, ActionType.PRECISE_SHOT, 7, 17);

    private final String inputValue;
    private final String name;
    private final int maxHP;
    private final ActionType specialAbility;
    private final int minAttackPoint;
    private final int maxAttackPoint;

    FighterType(String inputValue, String name, int maxHP, ActionType specialAbility,
                int minAttackPoint, int maxAttackPoint) {
        this.inputValue = inputValue;
        this.name = name;
        this.maxHP = maxHP;
        this.specialAbility = specialAbility;
        this.minAttackPoint = minAttackPoint;
        this.maxAttackPoint = maxAttackPoint;
    }

    public String getInputValue() {
        return inputValue;
    }

    public String getName() {
        return name;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public ActionType getSpecialAbility() {
        return specialAbility;
    }

    public int getMinAttackPoint() {
        return minAttackPoint;
    }

    public int getMaxAttackPoint() {
        return maxAttackPoint;
    }


    public String getDescription() {
        String descriptionFormat ="%s. %s ---  HP:%d\n    Specialförmåga: %s\n    %s";
        return descriptionFormat.formatted(inputValue, name, maxHP, specialAbility.getDisplayName(), specialAbility.getDescription());
    }

    public static boolean containsFighterOption(String inputValue) {
        boolean result = false;
        for (FighterType fighter : FighterType.values()) {
            if (fighter.getInputValue().equals(inputValue)) {
                result = true;
            }
        }

        return result;
    }

    public static boolean containsFighterName(String name) {
        boolean result = false;
        for (FighterType fighter : FighterType.values()) {
            if (fighter.getName().equals(name)) {
                result = true;
            }
        }

        return result;
    }


}
