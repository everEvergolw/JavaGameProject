package Game.Controller.Message;

import Game.Model.Player.Player;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
/**
 *
 * Provides information about the player's hints during the game.
 */
public class GameMessage {

    Alert alert;// Create a message dialog
    ButtonType button;


    /**
       Construction

     * @param  dir player's direction.
     * @param  p current player.

     */
    public GameMessage(int dir, Player p) {
        this.alert = new Alert(Alert.AlertType.INFORMATION);
        this.button = new ButtonType("Yes");
        alert.setTitle("GameMessage!");
        alert.setHeaderText("Player: " + p.getName() + " Message");
        setAlert(dir);


    }



    /**
     Display the current player status

     * @param  dir player's direction.
     *
     * @return Nothing.

     */
    private void setAlert(int dir) {


        String Dir = null;
        if (dir == 0)
            Dir = "Stop one round!";
        if (dir == 1)
            Dir = "Front is blocked!";
        if (dir == 2)
            Dir = "Rear is blocked!";
        if (dir == 3)
            Dir = "Left side is blocked!";
        if (dir == 4)
            Dir = "Right side is blocked!";


        alert.setContentText(Dir);
        alert.getButtonTypes().setAll(this.button);
        alert.showAndWait();
    }


}