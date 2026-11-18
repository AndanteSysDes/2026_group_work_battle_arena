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

    public Player() {
        this.name = "";
        this.scanner = new Scanner(System.in);
    }

    public Player(Scanner scanner) {
        this.scanner = scanner;
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


    public void inputName() {

        String input;

        do {
            System.out.println("Ange ditt namn: ");
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Namnet får inte vara tomt.");
            }
        } while (input.isEmpty());
        setName(input);

    }

    public void chooseFighter() {
        String errorMessage = "Ogiltigt val, ange mellan 1 och 3.";
        boolean isInvalidValue = false;
        while (fighter == null) {
            if (isInvalidValue) {
                System.out.println(errorMessage);
            }

            System.out.println(" Karaktär finns:");
            System.out.println("1. Warrior har specialförmåga-> 120 HP, Defend");
            System.out.println("2. Mage har specialförmåga -> 90 HP Heal");
            System.out.println("3. Ranger har specialförmåga -> 105 HP, Precise Shot");
            System.out.println("Välj ditt karaktär: ");


            String input = scanner.nextLine();
            if (input == null) {
                System.out.println(errorMessage);
                continue;
            }

            input = input.trim();
            isInvalidValue = false;

            switch (input) {
                case "1" -> fighter = new Warrior();
                case "2" -> fighter = new Mage();
                case "3" -> fighter = new Ranger();
                default -> {
                    fighter = null;
                    isInvalidValue = true;
                }
            }
        }
    }

    public int inputCommand() {

        String MessageForNullValue = "Du måste skriva en siffra.";
        String MessageForInvalidValue = "Du måste skriva en siffra.";
        String input;

        while (true) {

            System.out.println("Välj handling : ");
            System.out.println("1. Vanlig attack");
            System.out.println("2. Specialförmåga");
            System.out.println(" Skriv ditt kommando : ");

            input = scanner.nextLine();
            if (input == null) {
                System.out.println(MessageForNullValue);
                continue;
            }

            input = input.trim();
            if (input.equals("1") || input.equals("2")) {

                try {
                    int selectValue = Integer.parseInt(input);
                    return selectValue;
                } catch (NumberFormatException e) {
                    System.out.println("Du måste skriva en siffra.");
                    continue;
                }
            }
            System.out.println(MessageForInvalidValue);

        }
    }
}


