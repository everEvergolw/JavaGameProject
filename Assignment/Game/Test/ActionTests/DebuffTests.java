package Game.Test.ActionTests;


import Game.Controller.Action.Debuff;
import Game.Model.Player.Player;
import Game.Model.Player.PlayerType;
import Game.Model.SpecialSites.Gold;
import Game.Model.SpecialSites.SpecialSites;
import Game.Model.SpecialSites.Stay;
import Game.Model.SpecialSites.Transport;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;

/**
 *  Test special obstacles in the board.
 *  Stay:Stay some rounds.
 *  Gold: player add 5 score.
 *  Transport: change two players' position.
 */

public class DebuffTests {

    @Test
    public void testStay() {

        // Create barriers
        HashSet<SpecialSites> s = new HashSet<>();
        HashSet<Player> P = new HashSet<>();
        // Create a player with position (2,2)
        Player p = new Player(2,2, PlayerType.B.getUrl(), 0,"Trump");

        // There is a special object in the current position
        s.add(new Stay(2,2));

        Debuff.debuff(p,s,P,1);

        assertEquals(true, p.isStay());


    }


    @Test
    public void testGold() {

        // Create barriers
        HashSet<SpecialSites> s = new HashSet<>();
        HashSet<Player> P = new HashSet<>();
        // Create a player with position (2,2)
        Player p = new Player(2,2, PlayerType.B.getUrl(), 0,"Trump");

        // There is a special object in the current position
        s.add(new Gold(2,2));

        // add 5 score
        Debuff.debuff(p,s,P,1);

        assertEquals(5, p.getCurScore());


    }

    @Test
    public void testTransport() {

        // Create barriers
        HashSet<SpecialSites> s = new HashSet<>();
        HashSet<Player> P = new HashSet<>();

        // Create a player with position (2,2)
        Player p = new Player(2,2, PlayerType.B.getUrl(), 0,"Trump");
        Player p2 = new Player(3,3,PlayerType.T.getUrl(), 1,"BD");

        P.add(p);
        P.add(p2);
        // There is a special object in the current position
        s.add(new Transport(2,2));

        // Change two players' position
        Debuff.debuff(p,s,P,1);

        assertEquals(3, p.getCurX());
        assertEquals(3, p.getCurY());

        assertEquals(2, p2.getCurX());
        assertEquals(2, p2.getCurY());


    }



}
