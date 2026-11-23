package client;

import game.BattleResult;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class Client {
    // Jag skriver ner variablerna och constructören tillfälligt.
    // Om det behövs inte, till exempel om du vill skapa try satsen med resourse, kan du ändra eller sudda dem.
    Socket socket;
    BufferedReader in;
    PrintWriter out;

    public Client(Socket socket) {
        this.socket = socket;
    }

    public void createReaderAndWriter() throws IOException {
        if(in == null) {
            in = new BufferedReader
                    (new InputStreamReader
                            (socket.getInputStream()));
        }

        if(out == null) {
            out = new PrintWriter
                    (new OutputStreamWriter
                            (socket.getOutputStream()),true);
        }

    }

    public String save(BattleResult battleResult) throws IOException {
        /*
         TODO:
          Skicka meddelande "SAVE" till Server.
          När Clienten får connection med server,
          skapa String data från parametern battleResult (använd "," för dela orden)
          och skicka texten till server.
          Och sedan returnerar den andra svaran från server.
          (Det lyckas att spara data, eller inte.)
         */

        if (battleResult == null) {

            return "Ingen resultat har sparat.";
        }

        createReaderAndWriter();
        out.println("SAVE");
        String response = in.readLine();
        System.out.println("Server response : " + response);

        out.println(response);






        return "";
    }

    public ArrayList<BattleResult> load() throws IOException {

        /*
         TODO:
          Skicka meddelande "LOAD" till Server.
          När Clienten får connection med server,
          servern ska skickar text data.
          Clienten ska skapa BattleResult instanser från text datan.(använd "," för dela orden)
          Och sedan skapa ArrayList<BattleResult> och returnera den.
         */

        ArrayList<BattleResult> results = new ArrayList<>();
        try {
            createReaderAndWriter();
            out.println("LOAD");

            String line;
            while ((line = in.readLine()) != null) {
                BattleResult result ;
                if (line != null) {
                    results.add(result);
                }
            }

        }
        catch (IOException e){
            System.out.println("Server error" + e.getMessage());
        }

        return results;
        //return new ArrayList<>();


    }

    public static String toData(BattleResult battleResult) {
        return battleResult.getUserName() + ","
                + battleResult.getUserCharacter() + ","
                + battleResult.getComputerCharacter() + ","
                + battleResult.getWinner() + ","
                + battleResult.getTotalRounds();
    }

    public void close(){

    }



}
