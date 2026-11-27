package game;

import model.*;

import java.io.EOFException;
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

    public void inputName() throws EOFException {

        String input;

        while (true) {
            System.out.println("ANGE DITT NAMN : ");

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

        System.out.println("------------------------------------------------");

        String errorMessage = "Ogiltigt val, ange mellan 1 och 3.";
        boolean isInvalidValue = false;

        while (fighter == null) {
            if (isInvalidValue) {
                System.out.println(errorMessage);
            }
            isInvalidValue = false;

            System.out.println("Välj bland följande karaktärer:");
            System.out.println(FighterType.WARRIOR.getDescription());
            System.out.println(FighterType.MAGE.getDescription());
            System.out.println(FighterType.RANGER.getDescription());
            System.out.print("\nVÄLJ DITT KARAKTÄR : ");

            if (!scanner.hasNextLine()) {
                throw new EOFException("Inmatningen avslutades.");
            }

            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                isInvalidValue = true;
                continue;
            }
            if(!FighterType.containsFighterOption(input)){
                isInvalidValue = true;
                continue;
            }

            if(input.equals(FighterType.WARRIOR.getInputValue())){
                fighter = new Warrior();
            } else if(input.equals(FighterType.MAGE.getInputValue())){
                fighter = new Mage();
            } else if(input.equals(FighterType.RANGER.getInputValue())){
                fighter = new Ranger();
            }

        }
    }

    public int inputCommand() throws EOFException {

        String MessageForInvalidValue = "Du måste skriva en siffra.";
        String MessageForUsedAbility = "* Specialförmågan är redan använd.";
        String input;

        while (true) {
            boolean specialAbilityUsed = fighter != null && fighter.isHasSpecialAbilityUsed();
            System.out.println("Välj handling : ");
            System.out.println("1. " + getFighter().getNormalAbility().getDisplayName());
            if(specialAbilityUsed) {
                System.out.println(MessageForUsedAbility);
            }
            else {
                System.out.println("2. " + getFighter().getSpecialAbility().getDisplayName() + " (Du kan använda bara en gång.)");
            }
            System.out.print("\nSKRIV DITT KOMMANDO : ");


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
                int selectValue = Integer.parseInt(input);
                return selectValue;

            }
            System.out.println(MessageForInvalidValue);
        }
    }
}


