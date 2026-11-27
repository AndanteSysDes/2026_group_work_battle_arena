import client.Client;
import game.BattleResult;
import game.Game;
import game.Menu;

public Scanner in = new Scanner(System.in);

void main() {

    showWelcomeMessage();

    while (true) {
      showMenu();
      String userInput = takeUserInput();
        if(userInput.equals(Menu.GAME_START.getInputValue())){
            startGame();
        }
        if(userInput.equals(Menu.SHOW_HISTORY.getInputValue())){
            showHistory();
        }
        if(userInput.equals(Menu.END_SYSTEM.getInputValue())){
            end();
        }

    }

}

private String takeUserInput() {

    while (true) {
        System.out.print("DITT VAL : ");

        if (!in.hasNextLine()) {
            System.out.println("Inmatningen har avbrutits.");
            return Menu.END_SYSTEM.getInputValue();
        }

        String userInput = in.nextLine().trim();

        if(!Menu.containsMenuOption(userInput)){
            System.out.println("Ogiltig inmatning. Pröva igen.");
            continue;
        }

        return userInput;
    }
}

private void showMenu() {
    System.out.println("=========================================================");
    System.out.println("Välj följande meny:");
    System.out.println(Menu.GAME_START.getDisplayName());
    System.out.println(Menu.SHOW_HISTORY.getDisplayName());
    System.out.println(Menu.END_SYSTEM.getDisplayName());
}

private void showWelcomeMessage() {
    System.out.println("Välkommen till Battle Arena spelet!");
}

private void startGame() {
  System.out.println(" -- Starta Spelet -- ");
  Game game = new Game();
  game.playGame();
}

private void showHistory() {
  System.out.println(" -- Visa Historiken -- ");
  Client client = new Client();
  ArrayList<BattleResult> loadData = client.load();
  for (int i = 0 ; loadData.size() > i ; i++) {
      System.out.println( "Datanummer : " + (i + 1) );
      System.out.println(loadData.get(i).toString());
      System.out.println("------------------------------------------");
  }
}

private void end() {
  System.out.println("Hej då!");
  in.close();
  System.exit(0);
}
