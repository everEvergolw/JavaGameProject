package Game.Controller.EventHandler;


import Game.View.SelectModelView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;
/**
 *  Click event of the button Start Game
 *  Click on it to jump to a selection of three modes
 *  Easy, normal, Hard
 */
public class SelectModelEH implements EventHandler {

    private Stage s ;

    public SelectModelEH(Stage s) {
        this.s = s;
    }

    public Stage getS() {
        return s;
    }

    /**

     Click event
     * @param  event Event.

     * @return Nothing.

     */
    @Override
    public void handle(Event event) {

        SelectModelView sm = new SelectModelView();
        try {
            sm.start(new Stage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        this.getS().close();

    }
}
