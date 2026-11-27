package model;

import java.util.Random;

public class Ranger extends Fighter{


    public Ranger() {
        super(FighterType.RANGER);

    }

    @Override
    public int useAbility(){
        Random random = new Random();
        hasSpecialAbilityUsed = true;
        return random.nextInt(12,21);

    }
}
