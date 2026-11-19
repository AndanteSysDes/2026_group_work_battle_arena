package model;

import java.util.Random;

public class Mage extends Fighter{


    public Mage() {
        super();
        this.name = "Mage";
        this.maxHp = 90;
        this.currentHp = this.maxHp;
        this.specialAbility = ActionType.HEAL;
        this.minAttackPoint = 3;
        this.maxAttackPoint = 13;
    }

    @Override
    public int useAbility(){
        hasSpecialAbilityUsed = true;
        int healPoint = 15;
        currentHp = Math.min(maxHp, currentHp + healPoint);
        return 0;
    }
}
