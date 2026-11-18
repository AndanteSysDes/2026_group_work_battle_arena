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

        while (true) {
            System.out.println("Ange ditt namn: ");

            if(!scanner.hasNextLine()) {
                // User inputs EOF. We will think about it later...
                System.out.println("Inmatningen avslutades.");
                return;
            }

            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Namnet får inte vara tomt.");
                continue;
            }
            setName(input);
            break;

        }

    }

    public void chooseFighter() {
        String errorMessage = "Ogiltigt val, ange mellan 1 och 3.";
        boolean isInvalidValue = false;

        while (fighter == null) {
            if (isInvalidValue) {
                System.out.println(errorMessage);
            }
            isInvalidValue = false;

            System.out.println(" Karaktär finns:");
            System.out.println("1. Warrior har specialförmåga-> 120 HP, Defend");
            System.out.println("2. Mage har specialförmåga -> 90 HP Heal");
            System.out.println("3. Ranger har specialförmåga -> 105 HP, Precise Shot");
            System.out.println("Välj ditt karaktär: ");

            if(!scanner.hasNextLine()) {
                // User inputs EOF. We will think about it later...
                System.out.println("Inmatningen avslutades.");
                return;
            }

            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                isInvalidValue = true;
                continue;
            }

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

        String MessageForNullValue = "Inmatningen avslutades.";
        String MessageForInvalidValue = "Du måste skriva en siffra.";
        String MessageForError = "Ett problem uppstod. Försök igen.";
        String input;

        while (true) {

            System.out.println("Välj handling : ");
            System.out.println("1. Vanlig attack");
            System.out.println("2. Specialförmåga");
            System.out.println(" Skriv ditt kommando : ");

            if(!scanner.hasNextLine()) {
                // User inputs EOF. We will think about it later...
                System.out.println(MessageForNullValue);
                return -1;
            }

            input = scanner.nextLine().trim();
            if (input.equals("1") || input.equals("2")) {

                try {
                    int selectValue = Integer.parseInt(input);
                    return selectValue;
                } catch (NumberFormatException e) {
                    System.out.println(MessageForError);
                    continue;
                }
            }
            System.out.println(MessageForInvalidValue);

        }
    }
}


