package Game.Controller.Message;

import Game.Model.Player.Player;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;


import java.util.Optional;
/**
 * When the player's movement is blocked,
 * provide the player with three choices left, right, stay

 */
public class SelectViewMessage {

    Alert alert;
    ButtonType buttonLeft;

    ButtonType buttonStay;
    ButtonType buttonRight;


    /**
     Construction

     * @param  p current player.

     */
    public SelectViewMessage(Player p) {
        this.alert = new Alert(Alert.AlertType.CONFIRMATION);
        this.buttonLeft =  new ButtonType("Left");
        this.buttonStay =  new ButtonType("Stay");
        this.buttonRight =  new ButtonType("Right");
        alert.setTitle("Can't Move!");
        alert.setHeaderText("Player: "+p.getName()+ " Can't Move!");
        alert.setContentText("Choose your option.");
        alert.getButtonTypes().setAll(this.buttonLeft,this.buttonStay,this.buttonRight);

    }




    /**
     Returns the value of the button clicked by the player

     * @return Returns the value of the button clicked by the player

     */
    public int Option(){



        Optional<ButtonType> result = alert.showAndWait();
        int flag = 0;
        // 3: left
        if (result.get() == this.buttonLeft){
             flag = 3;
             // 4: right
        } else if (result.get() == this.buttonRight) {
            flag = 4;
            // 0 : stay
        } else if (result.get() == buttonStay) {
            flag = 0;
        }
        return flag;
        }








}
