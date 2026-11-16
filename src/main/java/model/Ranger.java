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
        // skriv någonting
        Random random = new Random();
        int attackPoint = random.nextInt(7,17);
        return attackPoint;

    }
    @Override
    public void takeDamage(int damage){
        // skriv någonting
        this.currentHp =Math.max(0, this.currentHp- damage);
    }
    @Override
    public int useAbility(){
        // skriv någonting
        Random random = new Random();
        return random.nextInt(12,20);
    }
}
