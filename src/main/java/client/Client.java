package client;

import game.BattleResult;

import java.io.BufferedReader;
import java.io.PrintWriter;
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

    public String save(BattleResult battleResult) {
        /*
         TODO:
          Skicka meddelande "SAVE" till Server.
          När Clienten får connection med server,
          skapa String data från parametern battleResult (använd "," för dela orden)
          och skicka texten till server.
          Och sedan returnerar den andra svaran från server.
          (Det lyckas att spara data, eller inte.)
         */

        return "";
    }

    public ArrayList<BattleResult> load(){

        /*
         TODO:
          Skicka meddelande "LOAD" till Server.
          När Clienten får connection med server,
          servern ska skickar text data.
          Clienten ska skapa BattleResult instanser från text datan.(använd "," för dela orden)
          Och sedan skapa ArrayList<BattleResult> och returnera den.
         */

        return new ArrayList<>();
    }



}
