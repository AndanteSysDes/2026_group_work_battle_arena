package model;

public class Mage extends Fighter{

    public Mage() {
        super();
        this.specialAbility = ActionType.HEAL;
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
