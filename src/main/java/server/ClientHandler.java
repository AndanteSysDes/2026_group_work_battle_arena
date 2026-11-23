package server;

import game.BattleResult;

import java.lang.reflect.Array;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable {
    private final Socket socket;
    private FileIO fileHandler;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {

    }

    private String save(){
        return "";
    }

    private String load(){
        // TODO
        // Få ArrayList från FileIO och modifiera den till String.
        return null;
    }
}
