package client;

import game.BattleResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {
    Client client;
    ArrayList<BattleResult> expectedLoadData;

    @BeforeEach
    void setUp() {
        expectedLoadData = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            expectedLoadData.add(
                    new BattleResult(
                            "player1",
                            "Warrior",
                            "Mage",
                            "player1",
                            20
                    )
            );
        }
    }

    @Test
    void save(){
        BattleResult saveData = new BattleResult(
                "Asuka",
                "Mage",
                "Ranger",
                "AutoPlayer",
                2
        );

        client = new Client();
        String response = client.save(saveData);

        assertEquals(response, "Saved successfully!");

    }

    @Test
    void load() throws InterruptedException {

        client = new Client();
        ArrayList<BattleResult> loadData = client.load();

        assertEquals(expectedLoadData.size(), loadData.size());
        assertEquals(expectedLoadData.get(0).getWinner(), loadData.get(0).getWinner());
        assertEquals(expectedLoadData.get(loadData.size()-1).getTotalRounds(), loadData.get(loadData.size()-1).getTotalRounds());

    }

}