package model;

import java.util.Random;

public abstract class Fighter implements SpecialAbility{

    protected String name;
    protected int maxHp;
    protected int currentHp;
    protected ActionType normalAbility;
    protected ActionType specialAbility;
    protected boolean hasSpecialAbilityUsed;
    protected Random random;
    protected int minAttackPoint;
    protected int maxAttackPoint;

    public Fighter(){
        this.normalAbility =ActionType.ATTACK;
        this.random = new Random();
    }

    public Fighter(Random random){
        this.normalAbility =ActionType.ATTACK;
        this.random = random;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public ActionType getNormalAbility() {
        return normalAbility;
    }

    public void setNormalAbility(ActionType normalAbility) {
        this.normalAbility = normalAbility;
    }

    public ActionType getSpecialAbility() {
        return specialAbility;
    }

    public void setSpecialAbility(ActionType specialAbility) {
        this.specialAbility = specialAbility;
    }

    public boolean isHasSpecialAbilityUsed() {
        return hasSpecialAbilityUsed;
    }

    public void setHasSpecialAbilityUsed(boolean hasSpecialAbilityUsed) {
        this.hasSpecialAbilityUsed = hasSpecialAbilityUsed;
    }

    public int attack(){
        int attackPoint = random.nextInt(minAttackPoint, maxAttackPoint+1);
        return attackPoint;
    };

    public void takeDamage( int damage ){
        this.currentHp =Math.max(0, this.currentHp- damage);
    };

    public boolean isAlive(){
        return 0 < currentHp;
    };







}
