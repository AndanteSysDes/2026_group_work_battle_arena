package server;

import client.Client;
import game.BattleResult;
import game.BattleResultConverter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Logger;

public class ClientHandler implements Runnable {

    private static final Logger logger =Logger.getLogger(ClientHandler.class.getName());
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
//                String[] parts = line.trim().split(" ",2);
//                String command = parts[0].toUpperCase();
                String[] parts = message.trim().split(" ",2);
                String data = parts.length > 1 ? parts[1] : "";
                String command = parts[0].toUpperCase();

                switch (command) {
                    case "SAVE" -> {
                        //out.println("Accept save request");

                        if((message = in.readLine()) != null){
                            String result = save(message);
                            logger.info(client + " Accept save request" + data);
                            out.println(result);
                        }
                    }
                    case "LOAD" -> {
                        String loadData = load();
                        out.println(loadData);
                    }
                    default -> {
                        out.println("Invalid request");
                    }

                }
                break;
            }

        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }

    private String save(String latestData){
        try{
            BattleResult saveData = BattleResultConverter.parse(latestData);
            String result = fileIo.save(saveData);

            return result;

        } catch (IllegalArgumentException e) {
            return "The data you sent has invalid data structure: " + e.getMessage();
        } catch (IOException e) {
            System.out.println("An error occurred during file saving: " + e.getMessage());
            return "An error occurred during file saving.";
        }
    }

    private String load(){
        try{
            String loadData = fileIo.load();
            return loadData;
        } catch (IOException e) {
            System.out.println("An error occurred during file loading: " + e.getMessage());
            return "An error occurred during file loading.";
        }
    }
}
