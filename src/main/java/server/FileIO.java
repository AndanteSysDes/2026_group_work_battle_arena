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

/**
 * Handles saving and loading battle results.
 * Each saved record is terminated with a colon (:).
 *
 * Thread-safe when the same instance is shared
 * among multiple threads.
 */
public class FileIO {
    private final Path file;

    public FileIO(){
        this.file = Path.of("save.txt");
    }
    public FileIO(Path file) {
        this.file = file;
    }

    /**
     * Appends a battle result to the file,
     * followed by a colon (:).
     *
     * @param saveData the battle result to save
     * @return a confirmation message
     * @throws IOException if writing to the file fails
     */
    public synchronized String save(BattleResult saveData) throws IOException {

        String saveText = BattleResultConverter.format(saveData);

        Files.writeString(
                file,
                saveText +":",
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
        );

        System.out.println("Saved: " + saveText);
        return "Saved successfully!";

    }

    /**
     * Loads all saved battle results as a single string,
     * preserving the colon (:) separators.
     *
     * @return all saved battle results as a colon-separated string
     * @throws IOException if reading from the file fails
     */
    public synchronized String load() throws IOException {
        return Files.readString(file, StandardCharsets.UTF_8);
    }

}
