package server;

import game.BattleResult;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable {
    private final Socket socket;
    private FileIO fileIo;

    public ClientHandler(Socket socket, FileIO fileIo) {
        this.socket = socket;
        this.fileIo = fileIo;
    }

    @Override
    public void run() {

        try(Socket client = socket){
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            String message;

            while((message = in.readLine()) != null) {
                if(message.equals("SAVE")){
                    out.println("Accept save request");
                    if((message = in.readLine()) != null){
                        String result = save(message);
                        out.println(result);
                        System.out.println("Save success.");
                        break;
                    }
                } else if(message.equals("LOAD")){
                    String loadData = load();
                    out.println(loadData);
                    System.out.println("load success.");
                    break;
                } else {
                    out.println("Invalid request");
                }
            }

        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }

    private String save(String latestData){
        /*
         TODO
         Check if the data structure is correct.
         if not, return  "Invalid data structure"
         otherwise call FileIo.save().
         */

        String[] data = latestData.split(",");




        return "TEST SAVE SUCCESS";
    }

    private String load(){
        // TODO
        // Få ArrayList från FileIO och modifiera den till String.
        return "TEST LOAD SUCCESS";
    }
}
