package model;

import java.util.Random;

public class Warrior extends Fighter{
    private boolean isDefending;

    public Warrior(){
        super(FighterType.WARRIOR);

    }

    @Override
    public int takeDamage(int damage){
        if(damage == 0){
            return 0;
        }

        int actualDamage = damage;

        if(isDefending){
            actualDamage = damage/2;
//            super.takeDamage(damage/2);
            isDefending = false;
        }
        return super.takeDamage(actualDamage);

    }

    @Override
    public int useAbility(){
        isDefending = true;
        hasSpecialAbilityUsed =true;
        return 0;
    }
}
