package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private int index = 0;

  /*  public  Server(){
        try {
            Server server = new ServerSocket(8080);
            while (true) initConnections();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void initConnections(){
        Socket clientSocket =server.accept();

        if(clientSocket.isConnected())
            new Thread(() ->{
                index++;
                System.out.println("New Client connected");
                ConnectedClient client = new ConnectedClient( clientSocket, index);
                try {
                    client.readMessages();
                    client.close();
                    System.out.println("Client Disconnected");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }).start();

    }*/
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

            System.out.println("Server started on port 8080");

            while (true) {

                Socket clientSocket = server.accept();
                //System.out.println("Client is connected");
                // Phase 1
                if(clientSocket.isConnected())
                    new Thread(() ->{
                       // index++;
                        System.out.println("New Client connected");
                        try {
                            BufferedReader in = new BufferedReader
                                    (new InputStreamReader
                                            (clientSocket.getInputStream()));
                            PrintWriter out = new PrintWriter
                                    (new OutputStreamWriter
                                            (clientSocket.getOutputStream()),true);
                            String request = in.readLine();
                            if(request == null){
                                return;
                            }
                            switch (request) {
                                case "SAVE" -> ;//clientSocket.save() ;
                                case "LOAD" ->  ;//clientSocket.load();
                                default -> System.out.println("Invalid request"); ;
                            }

                            clientSocket.close();
                            System.out.println("Client Disconnected");

                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                       // ConnectedClient client = new ConnectedClient(clientSocket,index);

                    }).start();


            }

        } catch (IOException e){
            // TODO: Visa fel meddelande.
        } finally {
            pool.shutdown();
        }


    }
}
