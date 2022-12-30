package Game.Test.ActionTests;

import Game.Controller.Action.Move;
import Game.Controller.Action.Wining;
import Game.Model.Player.Player;
import Game.Model.Player.PlayerType;
import Game.Model.SpecialSites.BlackHoll;
import Game.Model.SpecialSites.SpecialSites;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;

public class WiningTest {


    @Test
    public void testWining() {


        // Create two players with position (1,2) (1,3)  Endpoint X = 0
        Player p = new Player(1,2, PlayerType.B.getUrl(), 0,"Trump");
        Player p2 = new Player(1,3,PlayerType.T.getUrl(), 1,"BD");

        //add barriers
        HashSet<SpecialSites> s = new HashSet<>();
        //add players
        HashSet<Player> P = new HashSet<>();
        P.add(p);
        P.add(p2);

        // First add barriers in two directions
        // left
        s.add(new BlackHoll(2,1));
        // right
        s.add(new BlackHoll(2,3));

        // Player p moves up to win the game
        Move.playerMove(p.getId(),1,1,9,9,p,s,P,1);
        assertEquals(true,p.isWinning());
        // Score 30
        Wining.judgeGame(p.isWinning(),p.getName(),p,P,1);
        assertEquals(30,p.getCurScore());


        // Player p2 moves up to win the game
        Move.playerMove(p2.getId(),1,1,9,9,p2,s,P,1);
        assertEquals(true,p2.isWinning());
        // Score 30
        Wining.judgeGame(p2.isWinning(),p2.getName(),p2,P,1);
        assertEquals(30,p2.getCurScore());


    }

}
