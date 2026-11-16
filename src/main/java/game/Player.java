package game;

import model.Fighter;
import model.Mage;
import model.Ranger;
import model.Warrior;

import java.util.Scanner;

public class Player {

   private String name;
    private Fighter fighter;
    Scanner scanner;

    public Player(){
        this.name = "Maahi";
        this.scanner= new Scanner(System.in);
    }

    public Player(Scanner scanner){
//        this.name = "Maahi";
        this.scanner= scanner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Fighter getFighter() {
        return fighter;
    }

    public void setFighter(Fighter fighter) {
        this.fighter = fighter;
    }

    public void inputName(){
        //Scanner scanner = new Scanner(System.in);
        // skriv någonting
        String input ;
        while(true){
            System.out.println("Enter your name: ");
            input = scanner.nextLine().trim();
            if(input.isEmpty()){
                System.out.println("Input can not be empty.");
            }
//            chooseFighter();
            setName(input);
            return;
        }


    }

    public void chooseFighter(){
        // skriv någonting
        System.out.println(" Karaktär finns:");
        System.out.println("1. Warrior har specialförmåga-> 120 HP, Defend");
        System.out.println("2. Mage har specialförmåga -> 90 HP Heal");
        System.out.println("3. Ranger har specialförmåga -> 105 HP, Precise Shot");
        System.out.println("Välj en karaktär");

        String input = scanner.nextLine().trim();

        switch (input){
            case "1": fighter = new Warrior();
            break;
            case "2": fighter = new Mage();
            break;
            case "3": fighter = new Ranger();
            break;
            default:
                System.out.println("Ogiltigt val, ange mellan 1 och 3.");
        }
    }
    public int inputCommand(){
        // skriv någonting


        return 0;
    }

}
