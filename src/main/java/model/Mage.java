package model;

import java.util.Random;

public class Mage extends Fighter{


    public Mage() {
        super();
        this.specialAbility = ActionType.HEAL;
        this.maxHp = 90;
        this.currentHp = this.maxHp;
    }



    @Override
    public int attack(){
        Random random = new Random();
        int attackPoint = random.nextInt(3,14);
        return attackPoint;
    }

    @Override
    public void takeDamage(int damage){
        currentHp = Math.max(0, currentHp-damage);
    }

    @Override
    public int useAbility(){
        hasSpecialAbilityUsed = true;
        int healPoint = 15;
        currentHp = Math.min(maxHp, currentHp + healPoint);
        return 0;
    }
}
