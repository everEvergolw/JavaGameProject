package Game.Test.PaneTests;

import Game.Model.Pane.BackgroundBoard;
import Game.Model.Pane.BackgroundPane;
import Game.Model.Player.Player;
import Game.Model.Player.PlayerType;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaneTests {

    @Test
    public void testSetPlayers() {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                new JFXPanel(); // Initializes the JavaFx Platform
                Platform.runLater(new Runnable() {
                    // 1 2 3  4 5
                    @Override
                    public void run() {
                        try {

                            // add 3 players
                            Player p = new Player(2,3, PlayerType.B.getUrl(), 0,"BD");
                            Player p2 = new Player(2,4, PlayerType.T.getUrl(), 1,"T");
                            Player p3 = new Player(2,5, PlayerType.BS.getUrl(), 2,"BS");
                            HashSet<Player> P = new HashSet<>();
                            P.add(p);
                            P.add(p2);
                            P.add(p3);

                            BackgroundBoard BB = BackgroundBoard.getInstance(50,16,14);
                            BackgroundPane BP = new BackgroundPane(BB,5,P);

                            assertEquals(3, BP.getPlayers().size());


                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
            }
        });
        thread.start();// Initialize the thread
        try {
            Thread.sleep(1000); // Time to use the app, with out this, the thread

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void testSetSites() {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                new JFXPanel(); // Initializes the JavaFx Platform
                Platform.runLater(new Runnable() {
                    // 1 2 3  4 5
                    @Override
                    public void run() {
                        try {

                            // add 3 players
                            Player p = new Player(2,3, PlayerType.B.getUrl(), 0,"BD");
                            Player p2 = new Player(2,4, PlayerType.T.getUrl(), 1,"T");
                            Player p3 = new Player(2,5, PlayerType.BS.getUrl(), 2,"BS");
                            HashSet<Player> P = new HashSet<>();
                            P.add(p);
                            P.add(p2);
                            P.add(p3);

                            // Number of barriers
                            int count = 9;
                            BackgroundBoard BB = BackgroundBoard.getInstance(50,16,14);
                            BackgroundPane BP = new BackgroundPane(BB,count,P);
                            // Fire: 2*count
                            // BlakHoll: count
                            // Stay: count/2
                            // Gold: count/2
                            // Transport: count/2
                            int answer = count*2 + count  +  count/2 +  count/2 +  count/2;

                            assertEquals(answer, BP.getSpecialSites().size());




                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
            }
        });
        thread.start();// Initialize the thread
        try {
            Thread.sleep(1000); // Time to use the app, with out this, the thread

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


}
