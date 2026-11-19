package model;

import java.util.Random;

public class Ranger extends Fighter{


    public Ranger() {
        super();
        this.name = "Ranger";
        this.maxHp =105;
        this.currentHp =this.maxHp;
        this.specialAbility = ActionType.PRECISE_SHOT;
        this.minAttackPoint = 7;
        this.maxAttackPoint = 17;
    }

    @Override
    public int useAbility(){
        Random random = new Random();
        hasSpecialAbilityUsed = true;
        return random.nextInt(12,21);

    }
}
