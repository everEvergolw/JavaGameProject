package Game.Controller.EventHandler;

import Game.Model.Player.Player;
import Game.Model.Player.PlayerType;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;


import java.util.HashSet;
import java.util.Optional;

/**
 * This is an add player mouse click event
 * Click on it to jump to the window,
 * input the player's name
 * and automatically initialize the picture for the player
 */
public class AddPlayerEH implements EventHandler {

    private HashSet<Player> players;
    private  int id;

    public AddPlayerEH(HashSet<Player> players) {
        this.players = players;
        this.id = 0;
    }

    /**

      Click event
     * @param  event Event.

     * @return Nothing.

     */
    @Override
    public void handle(Event event) {

        // Prompt for inputting name
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Create a Player");
        dialog.setHeaderText(null);
        dialog.setContentText("Input your name:");

        Optional<String> result = dialog.showAndWait();

        if (result.isPresent()) {
            // Get the name input by the player
            String name = result.get();
            if(name != "" && id <10)
            {// Adding players and initializing
            this.players.add(new Player(0,1, PlayerType.values()[id].getUrl(),this.id,name));
            id++;
            }else if(id ==10){
                PlayerInfo();
            }
            else {
                Info();
            }

        }

    }

    /**

     No more than ten players

     * @return Nothing.

     */
    private void PlayerInfo(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("INPUT ERROR!");
        alert.setContentText("Players cannot exceed ten!");
        alert.setTitle("Error!");
        alert.getButtonTypes().setAll(new ButtonType("Yes"));
        alert.showAndWait();

    }


    /**
     Name cannot be empty
     * @return Nothing.

     */
    private void Info(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("INPUT ERROR!");
        alert.setContentText("Name cannot be empty!");
        alert.setTitle("Error!");
        alert.getButtonTypes().setAll(new ButtonType("Yes"));
        alert.showAndWait();

    }

}