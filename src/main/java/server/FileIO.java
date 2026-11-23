package server;

import java.io.IOException;
import java.nio.file.Path;

// "FileHandler" class finns i java.util bibliotek, så jag ändrade namnet för den här klassen.
public class FileIO {
    private final Path file;

    public FileIO(){
        this.file = Path.of("save.txt");
    }
    public FileIO(Path file) {
        this.file = file;
    }

    public synchronized String save(String latestData) throws IOException {
        // TODO
        // Skriva latestData till Filen.
        // Returnera det lyckas eller inte.
        return "";
    }

    public synchronized String load(){
        // TODO
        // Läsa Filen och returnera texten för alla data.

        return "";
    }

}
