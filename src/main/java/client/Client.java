package client;

import game.BattleResult;
import game.BattleResultConverter;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

//public class Client implements Runnable{
public class Client{
    private String protocol;
    private static final String HOST = "127.0.0.1";;
    private static final int PORT = 8080;;

    private BattleResult saveData;

    public Client() {
    }

    public Client(String protocol) {
        this.protocol = protocol;
    }

    public Client (String protocol, BattleResult saveData){
        this.protocol = protocol;
        this.saveData = saveData;
    }

    private String communicateServer() throws IOException {
        try (Socket socket = new Socket(HOST, PORT)){

            BufferedReader in = new BufferedReader
                    (new InputStreamReader
                            (socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);


            if(protocol.equals("SAVE")){
                out.println(protocol);

                String response = in.readLine();
                if(response == null){
                    String errorMessage = "Server is closed. Task: " + protocol + " is failed.";
                    System.out.println(errorMessage);
                    return errorMessage;
                }
                System.out.println(response);
                String data = BattleResultConverter.format(saveData);
                out.println(data);
                String response2 = in.readLine();
                System.out.println(response2);
                return response2;
            }

            if(protocol.equals("LOAD")){
                out.println(protocol);
                String response = in.readLine();
                if(response == null){
                    String errorMessage = "Server is closed. Task: " + protocol + " is failed.";
                    System.out.println(errorMessage);
                    return errorMessage;
                }

                System.out.println(response);
                return response;
            }

            throw new IOException("Protocol error: Invalid protocol");

        }catch(IOException e){
           throw new IOException("Connection error: " + e.getMessage());
        }
    }

    public String save(BattleResult battleResult) {
        this.protocol = "SAVE";
        this.saveData = battleResult;
        try{
            String response = communicateServer();
            return response;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return "Det gick inte att spara data. Kontrollera att servern är igång.";
        }
    }

    public ArrayList<BattleResult> load() {
        this.protocol = "LOAD";
        try{
            String response = communicateServer();

            String[] responseArray = response.split(":");
            ArrayList<BattleResult> loadData = new ArrayList<>();

            for(String row : responseArray){
                loadData.add(BattleResultConverter.parse(row));
            }

            return loadData;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Det gick inte att ladda data. Kontrollera att servern är igång.");
            return new ArrayList<BattleResult>();
        }


    }

}
