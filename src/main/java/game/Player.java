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
        this.name = "";
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

        String input ;
       // while(true){
        do {
            System.out.println("Ange ditt namn: ");
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Namnet får inte vara tomt.");
            }
        }while (input.isEmpty());
            setName(input);
           // return;
        //}


    }

    public void chooseFighter(){
        while (fighter == null)
        {

            System.out.println(" Karaktär finns:");
            System.out.println("1. Warrior har specialförmåga-> 120 HP, Defend");
            System.out.println("2. Mage har specialförmåga -> 90 HP Heal");
            System.out.println("3. Ranger har specialförmåga -> 105 HP, Precise Shot");
            System.out.println("Välj ditt karaktär: ");

            String input = scanner.nextLine().trim();

            switch (input) {
                case "1" -> fighter = new Warrior();
                // break;
                case "2" -> fighter = new Mage();
                // break;
                case "3" -> fighter = new Ranger();
                //break;
                default -> throw new IllegalStateException(
                        "Ogiltigt val, ange mellan 1 och 3." + input);
            }
        }
    }
    public int inputCommand(){

        //int selectValue;
        while(true) {

            System.out.println("Välj handling : ");
            System.out.println("1. Vanlig attack");
            System.out.println("2. Specialförmåga");
            System.out.println(" Skriv ditt kommando : ");
            String input = scanner.nextLine().trim();
            try {
                int selectValue = Integer.parseInt(input);
                if (selectValue == 1 || selectValue == 2) {
                    return selectValue;
                }
                System.out.println("Skriv 1 eller 2.");
            } catch (NumberFormatException e) {
                System.out.println("Du måste skriva en siffra.");
            }
        }

    }

}
