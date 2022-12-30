package Game.Controller.EventHandler;

import Game.View.MainView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;

/**
 * Click event to enter the main view
 *
 */
public class MainViewEH implements EventHandler {
    private Stage s;

    public MainViewEH(Stage s) {
        this.s = s;
    }

    private Stage getS() {
        return s;
    }


    /**

     Click event
     * @param  event Event.

     * @return Nothing.

     */
    @Override
    public void handle(Event event) {
        // Open another window, i.e. the game window
        MainView mv = new MainView();
        try {
            mv.start(new Stage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // Close the start screen
        this.getS().close();
    }


}
