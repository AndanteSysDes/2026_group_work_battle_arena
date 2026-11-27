package model;

import java.util.Random;

public class Mage extends Fighter{


    public Mage() {
        super(FighterType.MAGE);

    }

    @Override
    public int useAbility(){
        hasSpecialAbilityUsed = true;
        int healPoint = 15;
        currentHp = Math.min(maxHp, currentHp + healPoint);
        return 0;
    }
}
