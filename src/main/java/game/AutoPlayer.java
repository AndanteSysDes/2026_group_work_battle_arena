package game;

import model.*;

import java.util.Random;

public class AutoPlayer extends Player {
    private Random random ;

    public AutoPlayer(Random random){
        super();
        this.random = random;
        inputName();
        chooseFighter();
    }

    @Override
    public void inputName(){
        setName("AutoPlayer");
    }

    @Override
    public void chooseFighter(){
        int selectValue =  random.nextInt(3);
        String select = String.valueOf(selectValue+1);

        if(!FighterType.containsFighterOption(select)){
            throw new IllegalStateException("Unexpected value: " + selectValue);
        }

        if(select.equals(FighterType.WARRIOR.getInputValue())){
            setFighter(new Warrior());
        } else if(select.equals(FighterType.MAGE.getInputValue())){
            setFighter(new Mage());
        } else if(select.equals(FighterType.RANGER.getInputValue())){
            setFighter(new Ranger());
        }
        System.out.println(getName() + " valde " + getFighter().getName());
    }

    @Override
    public int inputCommand(){
        int selectValue;
        if(getFighter().isHasSpecialAbilityUsed()){
            return 1;
        }

        selectValue = random.nextInt(1,3);
        return selectValue;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

}
