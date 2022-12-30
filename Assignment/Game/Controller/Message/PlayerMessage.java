package Game.Controller.Message;

import Game.Model.Player.Player;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
/**
 * Display player movement information
 *
 */
public class PlayerMessage {
    Alert alert ;// Create a message dialog
    ButtonType button;

    /**
     Construction

     * @param  dir player's direction.
     * @param  p current player.

     */
    public PlayerMessage(Player p, int dir ) {
        this.alert = new Alert(Alert.AlertType.INFORMATION);
        this.button = new ButtonType("Yes");
        alert.setTitle("Move!");
        setAlert(p,dir);
    }


    /**
     Display the current player status

     * @param  p current player.
     * @param  dir player's direction.
     *
     * @return Nothing.

     */
    private void setAlert(Player p , int dir){

        alert.setHeaderText("Player: "+ p.getName() +" Message");
        // Four directions of player movement
        String Dir = null;
        if(dir == 1)
            Dir = "Move UP!";
        if(dir ==2)
            Dir ="Move DOWN!";
        if (dir ==3)
            Dir ="Move LEFT!";
        if(dir ==4)
            Dir = "Move RIGHT!";

        alert.setContentText(Dir);
        alert.getButtonTypes().setAll(this.button);
        alert.showAndWait();
    }



}
