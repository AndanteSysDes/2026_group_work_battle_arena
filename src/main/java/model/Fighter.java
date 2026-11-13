package model;

public abstract class Fighter implements SpecialAbility{

    protected String name;
    protected int currentHp;
    protected int maxHp;
    protected ActionType normalAbility;
    protected ActionType specialAbility;
    protected boolean hasSpecialAbilityUsed;

    public Fighter(){
        this.normalAbility =ActionType.ATTACK;
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

    public abstract int attack();
    public abstract void takeDamage( int damage );
    public boolean isAlive(){
        return 0 < currentHp;
    };







}
