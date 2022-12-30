package Game.Test.ModelTests.SpecialSitesTests;

import Game.Controller.Action.Debuff;
import Game.Model.Player.Player;
import Game.Model.Player.PlayerType;
import Game.Model.SpecialSites.*;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;


/** Test for visibility and blocking and URL
 * */
public class SpercialSitesTests {




    @Test
    public void testSpercialSitesVisible() {

        // Create barriers
        FireSite fs = new FireSite(2,1, Type.Fire1.getUrl());
        BlackHoll bh = new BlackHoll(2,2);
        Gold g = new Gold(2,3);
        Stay s = new Stay(2,4);
        Transport ts = new Transport(2,5);

        // Both are visible return true
        assertEquals(true, fs.isVisible());
       assertEquals(true, bh.isVisible());
        assertEquals(true, g.isVisible());
        assertEquals(true, s.isVisible());
       assertEquals(true, ts.isVisible());


        // Create barriers
        HashSet<SpecialSites> ss = new HashSet<>();
        ss.add(fs);
        ss.add(bh);
        ss.add(g);
        ss.add(s);
        ss.add(ts);

        // Create player
        Player p = new Player(2,3, PlayerType.B.getUrl(), 0,"BD");
        HashSet<Player> P = new HashSet<>();
        P.add(p);
        //If the player's position is the same as Gold's,
        // Gold's effect is triggered.
        // The player adds five score and Gold is not visible.
        Debuff.debuff(p,ss,P,1);

       assertEquals(5,p.getCurScore());
        assertEquals(false, g.isVisible());

        // Set the score to 0
        p.setCurScore(0);
        //The current Gold is no longer visible, meaning it has disappeared at this location.
        // Triggering the special event at the current position again will not add five score.
        Debuff.debuff(p,ss,P,1);
        assertEquals(0,p.getCurScore());


    }



    @Test
    public void testSpercialSitesBlock() {

        // Create barriers
        FireSite fs = new FireSite(2,1, Type.Fire1.getUrl());
        BlackHoll bh = new BlackHoll(2,2);
        Gold g = new Gold(2,3);
        Stay s = new Stay(2,4);
        Transport ts = new Transport(2,5);

        // some are block return true
        //Block means blocking the player's progress

        // There are some special locations that do not block the player's progress
        // and will trigger special events when the player advances to the current location.
        assertEquals(true, fs.isBlock());
        assertEquals(true, bh.isBlock());
        assertEquals(false, g.isBlock());
        assertEquals(false, s.isBlock());
       assertEquals(false, ts.isBlock());



    }



    @Test
    public void testSpercialSitesUrl() {
        String Fire1 = "Game/Img/SS/Fire1.png";
        String Fire2 = "Game/Img/SS/Fire2.png";
        String Black = "Game/Img/SS/BlackHoll.png";
        String stay = "Game/Img/SS/Stop.png";
        String Tp = "Game/Img/SS/Tp.png";
        String Gold = "Game/Img/SS/Gold.png";


        // Create barriers
        FireSite fs = new FireSite(2,1, Type.Fire1.getUrl());
        FireSite fs2 = new FireSite(2,1, Type.Fire2.getUrl());
        BlackHoll bh = new BlackHoll(2,2);
        Gold g = new Gold(2,3);
        Stay s = new Stay(2,4);
        Transport ts = new Transport(2,5);

        assertEquals(Fire1, fs.getUrl());
       assertEquals(Fire2, fs2.getUrl());
        assertEquals(Black, bh.getUrl());
        assertEquals(stay, s.getUrl());
        assertEquals(Tp, ts.getUrl());
       assertEquals(Gold, g.getUrl());




    }




}
