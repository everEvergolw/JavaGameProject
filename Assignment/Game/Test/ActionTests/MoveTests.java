package Game.Test.ActionTests;

import Game.Controller.Action.Move;
import Game.Model.Player.Player;
import Game.Model.Player.PlayerType;
import Game.Model.SpecialSites.BlackHoll;
import Game.Model.SpecialSites.SpecialSites;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;


/**
 *  Test whether a player can move around the board,
 *  whether he can be blocked,
 *  whether he can move,
 *  whether he exceeds the board boundaries.

 */


public class MoveTests {


    @Test
    public void testIsBarriers() {

        // Create barriers
        HashSet<SpecialSites> s = new HashSet<>();
        // Create a player with position (2,2)
        Player p = new Player(2,2, PlayerType.B.getUrl(), 0,"Trump");
        // First add barriers in three directions
        // left
        s.add(new BlackHoll(2,1));
        // right
        s.add(new BlackHoll(2,3));
        // up
        s.add(new BlackHoll(1,2));
        // down
        s.add(new BlackHoll(3,2));

        // Is the up side an obstacle
        assertEquals(true,Move.isBarriers(1,p,s));
        // Is the down side an obstacle
        assertEquals(true,Move.isBarriers(2,p,s));
        // Is the left side an obstacle
        assertEquals(true,Move.isBarriers(3,p,s));
        // Is the right side an obstacle
        assertEquals(true,Move.isBarriers(4,p,s));


    }

    @Test
    public void testIsPlayers() {

        // Create players
        HashSet<Player> P = new HashSet<>();
        // Create a player with position (2,2)
        Player p = new Player(2,2, PlayerType.B.getUrl(), 0,"BD");
        // First add players  in four directions

        // left
        P.add(new Player(2,1,PlayerType.T.getUrl(), 0,"Trump"));
        // right
        P.add(new Player(2,3,PlayerType.T.getUrl(), 0,"Trump"));
        // up
        P.add(new Player(1,2,PlayerType.T.getUrl(), 0,"Trump"));
        // down
        P.add(new Player(3,2,PlayerType.T.getUrl(), 0,"Trump"));

        // Is the up side a player
        assertEquals(true,Move.isPlayers(1,p,P));
        // Is the down side a player
        assertEquals(true,Move.isPlayers(2,p,P));
        // Is the left side a player
        assertEquals(true,Move.isPlayers(3,p,P));
        // Is the right side a player
        assertEquals(true,Move.isPlayers(4,p,P));




    }


    @Test
    public void testCanMove() {
        // Create

        HashSet<Player> P = new HashSet<>();
        HashSet<SpecialSites> s = new HashSet<>();

        // Create a player with position (2,2)
        Player p = new Player(2,2, PlayerType.B.getUrl(), 0,"BD");
        // First add players  in three directions

        // left
        s.add(new BlackHoll(2,1));
        // right
        P.add(new Player(2,3,PlayerType.T.getUrl(), 0,"Trump"));
        // up
        s.add(new BlackHoll(1,2));

        //Going down there is no blocking only going down will return true

        // Moving up
        assertEquals(false,Move.canMove(1,9,9,p,s,P,1));
        // Moving down
        assertEquals(true,Move.canMove(2,9,9,p,s,P,2));
        // Moving left
        assertEquals(false,Move.canMove(3,9,9,p,s,P,3));
        // Moving right
        assertEquals(false,Move.canMove(4,9,9,p,s,P,4));

        // Set the boundary value to 2,
        // i.e. the player's initial position is the starting point and cannot go backwards,
        // so it returns to false
        // Moving down
        assertEquals(false,Move.canMove(2,2,9,p,s,P,2));


        // Add another player below the current player, so he can't go backwards either.
        // down
        P.add(new Player(3,2,PlayerType.T.getUrl(), 0,"Trump"));

        // Moving up
        assertEquals(false,Move.canMove(1,9,9,p,s,P,1));
        // Moving down
        assertEquals(false,Move.canMove(2,9,9,p,s,P,2));
        // Moving left
        assertEquals(false,Move.canMove(3,9,9,p,s,P,3));
        // Moving right
        assertEquals(false,Move.canMove(4,9,9,p,s,P,4));

    }

    @Test
    public void testPlayerMove() {
        // Create

        HashSet<Player> P = new HashSet<>();
        HashSet<SpecialSites> s = new HashSet<>();

        // Create a player with position (2,2)
        Player p = new Player(2,2, PlayerType.B.getUrl(), 0,"BD");
        // First add players  in three directions

        // left
        s.add(new BlackHoll(2,1));
        // right
        P.add(new Player(2,3,PlayerType.T.getUrl(), 0,"Trump"));
        // up
        s.add(new BlackHoll(1,2));


        //Going down there is no blocking only going down will change p's position
        //Up
        Move.playerMove(0,1,1,9,9,p,s,P,1);
        assertEquals(2,p.getCurX());
        //left
        Move.playerMove(0,1,3,9,9,p,s,P,1);
        assertEquals(2,p.getCurY());
        //right
        Move.playerMove(0,1,4,9,9,p,s,P,1);


        //down
        Move.playerMove(0,1,2,9,9,p,s,P,1);
        assertEquals(3,p.getCurX());

        p.setCurX(2);
        // down
        P.add(new Player(3,2,PlayerType.T.getUrl(), 0,"Trump"));
        // now the player can not go down
        Move.playerMove(0,1,2,9,9,p,s,P,1);
        assertEquals(2,p.getCurX());

    }




}
