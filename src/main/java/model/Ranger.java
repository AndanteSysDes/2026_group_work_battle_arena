package model;

import java.util.Random;

public class Ranger extends Fighter{


    public Ranger() {
        super();
        this.specialAbility = ActionType.PRECISE_SHOT;
        this.maxHp =105;
        this.currentHp =this.maxHp;

    }

    @Override
    public int attack(){
        Random random = new Random();
        int attackPoint = random.nextInt(7,18);
        return attackPoint;

    }

    @Override
    public void takeDamage(int damage){
        this.currentHp =Math.max(0, this.currentHp- damage);
    }

    @Override
    public int useAbility(){
        Random random = new Random();
        hasSpecialAbilityUsed = true;
        return random.nextInt(12,21);

    }
}
