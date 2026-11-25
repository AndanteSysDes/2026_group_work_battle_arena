package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(10);
        FileIO fileHandler = new FileIO();

        try (ServerSocket server = new ServerSocket(8080)) {
            System.out.println("Server started on port 8080");

            while (true) {
                Socket clientSocket = server.accept();
                ClientHandler handler = new ClientHandler(clientSocket, fileHandler);
                pool.execute(handler);

//                try(Socket clientSocket = server.accept()) {
//
//                    System.out.println("New Client connected" );
//
//
//                    BufferedReader in = new BufferedReader
//                                        (new InputStreamReader
//                                                (clientSocket.getInputStream()));
//                    PrintWriter out = new PrintWriter
//                                        (new OutputStreamWriter
//                                                (clientSocket.getOutputStream()),true);
//                    String request = in.readLine();
//                    if(request == null){
//                        return;
//                    }
//
//                    switch (request) {
//                        case "SAVE" -> {
//                            out.println("SAVE");
//                            String request1 =in.readLine();
//                            System.out.println( request1);
//                            out.println(request1);
//                        }
//                        case "LOAD" -> System.out.println("LOAD");//String värde
//
//                        default -> System.out.println("Invalid request");
//                    }
//
//
//                    System.out.println("Client Disconnected");
//
//                }catch (IOException e){
//                    e.printStackTrace();
//
//                }

            }

        } catch (IOException e){
            // TODO: Visa fel meddelande.
        } finally {
            pool.shutdown();
        }


    }
}
