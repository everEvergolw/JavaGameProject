package Game.Test.ViewTests;

import Game.View.CustomizedGameView;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

/**
 * Test CustomizedGameView scenarios
 * Test Buttons in the scenarios
 */
public class CustomizedGameViewTest {

    @Test
    public void testCustomizedGameView() {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                new JFXPanel(); // Initializes the JavaFx Platform
                Platform.runLater(new Runnable() {

                    @Override
                    public void run() {
                        try {
                            new CustomizedGameView().start(new Stage()); // Create and
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
