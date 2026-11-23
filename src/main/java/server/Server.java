package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(10);

        try (ServerSocket server = new ServerSocket(8080)) {
            /*
            TODO:
            Skapa while loop och acceptera socket från clienter.

            Phase 1.
                skapa in och out. Exempel:
                    BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    out = new PrintWriter(client.getOutputStream(), true);
                Se om clienten skickar "SAVE" eller "LOAD".
                CASE: "SAVE"
                    Ta emot String data och modifiera till battleResult (använd "," för dela orden)
                    Skicka OKEY meddelande till clienten.
                CASE: "LOAD"
                    Skicka "player1,Warrior,Mage,player1,20".

            Phase 2 (Efter vi skapade ClientHandler och FileHandler)
                Skapa en ny ClientHandler instans och sätt socket som parameter.
                anropa pool.execute(clientHandler)
             */

        } catch (IOException e){
            // TODO: Visa fel meddelande.
        } finally {
            pool.shutdown();
        }
    }
}
