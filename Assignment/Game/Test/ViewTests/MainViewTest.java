package Game.Test.ViewTests;

import Game.View.MainView;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
/**
 * Test MainView scenarios
 * Test Buttons in the scenarios
 */
public class MainViewTest {

    @Test
    public void testMainView() {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                new JFXPanel(); // Initializes the JavaFx Platform
                Platform.runLater(new Runnable() {

                    @Override
                    public void run() {
                        try {
                            new MainView().start(new Stage());

                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
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

    }

}



