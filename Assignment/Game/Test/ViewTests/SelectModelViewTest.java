package Game.Test.ViewTests;

import Game.View.SelectModelView;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
/**
 * Test SelectModelView scenarios
 * Test Buttons in the scenarios
 */
public class SelectModelViewTest {
    @Test
    public void testSelectModelView() {
        {
            Thread thread = new Thread(new Runnable() {

                @Override
                public void run() {
                    new JFXPanel(); // Initializes the JavaFx Platform
                    Platform.runLater(new Runnable() {

                        @Override
                        public void run() {
                            try {
                                new SelectModelView().start(new Stage()); // Create and
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
                Thread.sleep(10000); // Time to use the app, with out this, the thread
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // will be killed before you can tell.
        }
    }


}
