package Game.Test.FileTests;

import Game.File.Read;
import Game.File.Save;
import Game.Model.Player.Player;
import Game.Model.Player.PlayerType;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;

import static java.nio.file.Files.deleteIfExists;
import static org.junit.Assert.assertEquals;

public class ReadAndSaveTests {


    @Test
    public void testSaveAndRead() {
        //Where to save the file
        String pathname = "src/Game/File/info.txt";

        // Create two players with position (1,2) (1,3)  Endpoint X = 0
        Player p = new Player(1,2, PlayerType.B.getUrl(), 0,"Test1");
        Player p2 = new Player(1,3,PlayerType.T.getUrl(), 1,"Test2");
        // set score to save
        p.setCurScore(55);
        p2.setCurScore(30);

        String answer = "RANK TOP TEN\n" +
                "1. Test1, Score: 55\n"
                +"2. Test2, Score: 30";

        //add players
        HashSet<Player> P = new HashSet<>();
        P.add(p);
        P.add(p2);

        File file = new File(pathname);

        // Test cases
        if(file.exists()){
            try {
                deleteIfExists(file.toPath());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        new Save().saveInfo(P);

        // Same result as expected
        assertEquals(answer,new Read().showAll().trim());






    }




}
