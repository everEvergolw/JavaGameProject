package Game.Test.ModelTests.PlayerTest;


import Game.Model.Player.Player;
import Game.Model.Player.PlayerType;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


/**
 * Test toString and URL
 * */

public class PlayerTests {


    @Test
    public void testPlayerToString() {
        Player p = new Player(2,2, PlayerType.B.getUrl(), 0,"BD");
        Player p2 = new Player(2,3, PlayerType.T.getUrl(), 1,"Trump");
        p.setScore(30);
        p2.setScore(40);

       assertEquals("Player: BD, Score - 30", p.toString());
        assertEquals("Player: Trump, Score - 40", p2.toString());


    }


    @Test
    public void testPlayerUrl() {
        Player p = new Player(2,2, PlayerType.B.getUrl(), 0,"BD");
        Player p2 = new Player(2,3, PlayerType.T.getUrl(), 1,"Trump");

        assertEquals("Game/Img/Player/B.jpg", p.getUrl());
        assertEquals("Game/Img/Player/T.jpg", p2.getUrl());


    }


}
