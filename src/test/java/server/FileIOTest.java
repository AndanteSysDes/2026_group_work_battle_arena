package server;

import game.BattleResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileIOTest {

    @TempDir
    Path tempDir;

    Path testFile;
    FileIO fileIO;

    @BeforeEach
    void setUp() throws IOException {
        testFile = tempDir.resolve("testSave.txt");
        Files.createFile(testFile);
        fileIO = new FileIO(testFile);

    }

    @Test
    void saveShouldWriteDataOnFile() throws IOException {
        String message = fileIO.save(new BattleResult(
                "Asuka",
                "Warrior",
                "Mage",
                "Asuka",
                5
        ));

        System.out.println(message);

        String expected ="Asuka,Warrior,Mage,Asuka,5:";
        assertEquals(List.of(expected) , Files.readAllLines(testFile));
        assertEquals("Saved successfully!", message);

    }


    @Test
    void saveShouldWriteDataOnFileEvenIfItCallsManyTimes() throws IOException {
        for (int i = 0; i < 10; i++) {

            String message = fileIO.save(new BattleResult(
                    "Asuka",
                    "Warrior",
                    "Mage",
                    "Asuka",
                    5
            ));

            System.out.println(message);
        }

        String expected = "";
        for (int i = 0; i < 10; i++) {
            expected += "Asuka,Warrior,Mage,Asuka,5:";
        }

        assertEquals(List.of(expected) , Files.readAllLines(testFile));

    }

    @Test
    void saveShouldNotWriteOverIfTheFileHasAlreadyData() throws IOException {

        Files.writeString(
                testFile,
                "Maheshwari,Ranger,Ranger,AutoPlayer,11:"
        );

        String message = fileIO.save(new BattleResult(
                "Asuka",
                "Warrior",
                "Mage",
                "Asuka",
                5
        ));

        System.out.println(message);

        String expected ="Maheshwari,Ranger,Ranger,AutoPlayer,11:" + "Asuka,Warrior,Mage,Asuka,5:";

        System.out.println(Files.readAllLines(testFile));
        assertEquals(List.of(expected) , Files.readAllLines(testFile));
    }



    @Test
    void loadShouldReadFile() throws IOException {
        Files.writeString(
                testFile,
                "Asuka,Warrior,Mage,Asuka,5:"
        );

        String loadData = fileIO.load();

        assertEquals("Asuka,Warrior,Mage,Asuka,5:", loadData);
    }

    @Test
    void loadShouldReadFileEvenIfFileHasManyDatas() throws IOException {
        String expected = "";
        for (int i = 0; i < 10; i++) {
            expected += "Asuka,Warrior,Mage,Asuka,5:";
        }

        Files.writeString(
                testFile,
                expected
        );

        String loadData = fileIO.load();
        System.out.println(loadData);

        assertEquals(expected, loadData);
    }
}