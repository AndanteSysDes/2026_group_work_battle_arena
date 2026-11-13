package model;

public class Ranger extends Fighter{


    public Ranger() {
        super();
        this.specialAbility = ActionType.PRECISE_SHOT;
    }

    @Override
    public int attack(){
        // skriv någonting
        return 0;
    }
    @Override
    public void takeDamage(int damage){
        // skriv någonting
    }
    @Override
    public int useAbility(){
        // skriv någonting
        return 0;
    }
}
