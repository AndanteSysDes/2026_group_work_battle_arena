package model;

import java.util.Random;

public class Warrior extends Fighter{
    private boolean isDefending;

    public Warrior(){
        super();
        this.name = "Warrior";
        this.maxHp = 120;
        this.currentHp = this.maxHp;
        this.specialAbility = ActionType.DEFENCE;
        this.minAttackPoint = 5;
        this.maxAttackPoint = 15;
    }

    @Override
    public void takeDamage(int damage){
        if(isDefending){
            super.takeDamage(damage/2);
            isDefending = false;
        }else{
            super.takeDamage(damage);
        }
    }

    @Override
    public int useAbility(){
        isDefending = true;
        hasSpecialAbilityUsed =true;
        return 0;
    }
}
