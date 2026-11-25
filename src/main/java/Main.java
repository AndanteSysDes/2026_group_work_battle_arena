import client.Client;
import game.BattleResult;
import game.Game;
import server.Server;

public Scanner in = new Scanner(System.in);

void main() {
    showWelcomeMessage();

    while (true) {
      showMenu();
      int userInput = takeUserInput(in);
      switch (userInput) {
        case 1 -> startGame();
        case 2 -> showHistory();
        case 0 -> end();
      }
    }

}

private int takeUserInput(Scanner in) {

    while (true) {
        System.out.print("DITT VAL : ");

        if (!in.hasNextLine()) {
            // TODO User inputs EOF. We will think about it later...
            System.out.println("Inmatningen har avbrutits.");
            return 0;
        }

        String userInput = in.nextLine().trim();
        switch (userInput) {
            case "0":
                return 0;
            case "1":
                return 1;
            case "2":
                return 2;
            default:
                System.out.println("Ogiltig inmatning. Pröva igen.");
        }
    }
}

private void showMenu() {
    System.out.println("=========================================================");
    System.out.println("Välj följande meny:");
    System.out.println("1. Starta spelet");
    System.out.println("2. Visa spelhistoriken");
    System.out.println("0. Avsluta spelet.");
}

private void showWelcomeMessage() {
    System.out.println("Välkommen till Battle Arena spelet!");
}

private void startGame() {
  System.out.println(" -- startGame -- ");
  Game game = new Game();

  game.playGame();

}

private void showHistory() {

  System.out.println(" -- showHistory -- ");

  Client client = new Client();
  ArrayList<BattleResult> loadData = client.load();
  for (int i = 0 ; loadData.size() > i ; i++) {

      System.out.println( "Data number : " + (i +1) );
      System.out.println(loadData.get(i).toString());
      System.out.println("------------------------------------------");

  }

}

private void end() {
  System.out.println("Hej då!");
  in.close();
  System.exit(0);

}
