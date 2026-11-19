package game;

import model.Fighter;
import model.Mage;
import model.Ranger;
import model.Warrior;

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
    // Det kan vara privat
    public void chooseFighter(){
        int selectValue =  random.nextInt(3);
        Fighter fighter = switch (selectValue) {
            case 0 -> new Warrior();
            case 1 -> new Mage();
            case 2 -> new Ranger();
            default -> throw new IllegalStateException("Unexpected value: " + selectValue);
        };
        setFighter(fighter);
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
