package Game.Controller.EventHandler;

import Game.View.CustomizedGameView;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;

/**
 * This is a custom game of mouse click events
 * After clicking on it,
 * turn the custom game screen
 * and enter the player's custom information
 */

public class CustomizedGameEH implements EventHandler {
    private Stage s;


    public CustomizedGameEH(Stage s) {
        this.setS(s);

    }

    public void setS(Stage s) {
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

        // Open custom  view
        CustomizedGameView CGV = new CustomizedGameView();
        try {
            CGV.start(new Stage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Close the current screen
        this.getS().close();
    }




}
