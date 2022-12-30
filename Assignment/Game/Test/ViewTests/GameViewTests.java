package Game.Test.ViewTests;


import Game.View.GameView;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

/**
 * Test three different difficulty scenarios
 * Test Buttons in the scenarios
 */
public class GameViewTests {


    @Test
    public void testGameViewEasy() {

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                new JFXPanel(); // Initializes the JavaFx Platform
                Platform.runLater(new Runnable() {

                    @Override
                    public void run() {
                        try {
                            new GameView(5).start(new Stage() );
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }

                        // initialize
                        // your app.

                    }
                });
            }
        });
        thread.start();// Initialize the thread
        try {
            Thread.sleep(2000); // Time to use the app, with out this, the thread
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // will be killed before you can tell.


    }
    @Test
    public void testGameViewNormal() {

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                new JFXPanel(); // Initializes the JavaFx Platform
                Platform.runLater(new Runnable() {

                    @Override
                    public void run() {
                        try {
                            new GameView(10).start(new Stage());
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }

                        // initialize
                        // your app.

                    }
                });
            }
        });
        thread.start();// Initialize the thread
        try {
            Thread.sleep(2000); // Time to use the app, with out this, the thread
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // will be killed before you can tell.
    }
    @Test
    public void testGameViewHard() {

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                new JFXPanel(); // Initializes the JavaFx Platform
                Platform.runLater(new Runnable() {

                    @Override
                    public void run() {
                        try {
                            new GameView(15).start(new Stage());
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }

                        // initialize
                        // your app.

                    }
                });
            }
        });
        thread.start();// Initialize the thread
        try {
            Thread.sleep(2000); // Time to use the app, with out this, the thread
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // will be killed before you can tell.
    }
}
