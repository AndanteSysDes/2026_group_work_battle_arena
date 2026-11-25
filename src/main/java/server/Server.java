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

            }

        } catch (IOException e){
            // TODO: Visa fel meddelande.
        } finally {
            pool.shutdown();
        }


    }
}
