package model;

public enum FighterType {

    WARRIOR("Warrior", 120 , ActionType.DEFENCE, 5, 15),
    MAGE("Mage", 90, ActionType.HEAL, 3, 13),
    RANGER("Ranger", 105, ActionType.PRECISE_SHOT, 7, 17);

    private final String name;
    private final int maxHP;
    private final ActionType specialAbility;
    private final int minAttackPoint;
    private final int maxAttackPoint;

    FighterType(String name, int maxHP, ActionType specialAbility,
                int minAttackPoint, int maxAttackPoint) {
        this.name = name;
        this.maxHP = maxHP;
        this.specialAbility = specialAbility;
        this.minAttackPoint = minAttackPoint;
        this.maxAttackPoint = maxAttackPoint;
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
}
