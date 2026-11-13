package model;

public class Warrior extends Fighter{

    public Warrior(){
        super();
        this.specialAbility =ActionType.DEFENCE;

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
