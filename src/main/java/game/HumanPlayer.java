package game;

import model.*;

import java.io.EOFException;
import java.util.Scanner;

public class HumanPlayer extends Player {

    Scanner scanner;

    public HumanPlayer() {
        super();
        this.scanner = new Scanner(System.in);
    }

    public HumanPlayer(Scanner scanner) {
        this.scanner = scanner;
    }


    public void inputName() throws EOFException {

        String input;

        while (true) {
            System.out.println("Ange ditt namn: ");

            if (!scanner.hasNextLine()) {
                throw new EOFException("Inmatningen avslutades.");
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

    public void chooseFighter() throws EOFException {
        String errorMessage = "Ogiltigt val, ange mellan 1 och 3.";
        String warriorDescription = "1. Warrior ---  HP:120\n    Specialförmåga: " + ActionType.DEFENCE.getDisplayName()
                + "\n    " + ActionType.DEFENCE.getDescription() ;
        String mageDescription = "2. Mage ---  HP:90\n    Specialförmåga: " + ActionType.HEAL.getDisplayName()
                + "\n    " + ActionType.HEAL.getDescription() ;
        String rangerDescription = "3. Ranger ---  HP:105\n    Specialförmåga: " + ActionType.PRECISE_SHOT.getDisplayName()
                + "\n    " + ActionType.PRECISE_SHOT.getDescription() ;
        boolean isInvalidValue = false;

        while (getFighter() == null) {
            if (isInvalidValue) {
                System.out.println(errorMessage);
            }
            isInvalidValue = false;

            System.out.println("Välj bland följande karaktärer:");
            System.out.println(warriorDescription);
            System.out.println(mageDescription);
            System.out.println(rangerDescription);
            System.out.print("\nVälj ditt karaktär: ");

            if (!scanner.hasNextLine()) {
                throw new EOFException("Inmatningen avslutades.");
            }

            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                isInvalidValue = true;
                continue;
            }

            switch (input) {
                case "1" -> setFighter(new Warrior());
                case "2" -> setFighter(new Mage());
                case "3" -> setFighter(new Ranger());
                default -> {
                    isInvalidValue = true;
                }
            }
        }
    }

    public int inputCommand() throws EOFException {

        String MessageForInvalidValue = "Du måste skriva en siffra.";
        String MessageForUsedAbility = "* Specialförmågan är redan använd.";
        String input;

        while (true) {
            boolean specialAbilityUsed = (getFighter() != null && getFighter().isHasSpecialAbilityUsed());
            System.out.println("Välj handling : ");
            System.out.println("1. " + getFighter().getNormalAbility().getDisplayName());
            if(specialAbilityUsed) {
                System.out.println(MessageForUsedAbility);
            }
            else {
                System.out.println("2. " + getFighter().getSpecialAbility().getDisplayName() + " (Du kan använda bara en gång.)");
            }
            System.out.print("\n Skriv ditt kommando : ");


            if (!scanner.hasNextLine()) {
                throw new EOFException("Inmatningen avslutades.");
            }

            input = scanner.nextLine().trim();



            if (input.equals("1")) {
                return 1;
            } else if (input.equals("2")) {
                if (specialAbilityUsed) {
                    System.out.println(MessageForUsedAbility);
                    continue;
                }
                return 2;
            }
            System.out.println(MessageForInvalidValue);
        }
    }
}


