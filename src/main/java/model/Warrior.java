package model;

import java.util.Random;

public class Warrior extends Fighter{
 private boolean isDefending;

    public Warrior(){
        super();
        this.specialAbility =ActionType.DEFENCE;
        this.maxHp =120;
        this.currentHp = this.maxHp;
        this.isDefending = false;

    }

    @Override
    public int attack(){
        Random random = new Random();
        int attackPoint = random.nextInt(5,16);
        return attackPoint;
    }

    @Override
    public void takeDamage(int damage){
        if(isDefending){
            damage = damage / 2;
            isDefending = false;
        }
        this.currentHp = Math.max(0,this.currentHp - damage);
    }

    @Override
    public int useAbility(){
        isDefending = true;
        hasSpecialAbilityUsed =true;
        return 0;
    }
}
