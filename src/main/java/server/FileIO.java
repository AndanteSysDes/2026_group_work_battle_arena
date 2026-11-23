package server;

import game.BattleResult;
import game.BattleResultConverter;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

// "FileHandler" class finns i java.util bibliotek, så jag ändrade namnet för den här klassen.
public class FileIO {
    private final Path file;

    public FileIO(){
        this.file = Path.of("save.txt");
    }
    public FileIO(Path file) {
        this.file = file;
    }

    public synchronized String save(BattleResult saveData) throws IOException {

        String saveText = BattleResultConverter.format(saveData);

        Files.writeString(
                file,
                saveText,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
        );

        System.out.println("Saved: " + saveText);
        return "Saved successfully!";

    }

    public synchronized String load() throws IOException {

        StringBuilder loadData = new StringBuilder();

        BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8);
        String line;
        while ((line = reader.readLine()) != null) {
            loadData.append(line);
            loadData.append("\n");
        }

        return loadData.toString();
    }

}
