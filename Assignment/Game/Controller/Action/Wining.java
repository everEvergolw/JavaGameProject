package Game.Controller.Action;

import Game.File.Save;
import Game.Model.Player.Player;
import javafx.scene.control.Alert;

import java.util.HashSet;
/**
 *
 * Determine if the player reaches the end.
 * If the player wins, the player is prompted with a victory message,
 * and all player information (current score) is saved,
 * and the program ends
 *
 * */
public class Wining {



    /**
     Determining whether to win

     * @param  flag The sign of winning or not.
     * @param  name Current Player's name.
     * @param  p Current Player.
     * @param  P All Players.
     * @return Nothing.
     */
    public static void judgeGame(boolean flag, String name, Player p, HashSet<Player> P){
        if(flag) {
            // Win plus 30 points
            p.setCurScore(Score());
            // Save player information
            new Save().saveInfo(P);
            // Tip Message
            printIF(name,p.getSteps());
            // Exit
            System.exit(0);
        }

    }


    /**
     Win plus 30 points

     * @return 30 points.
     */
    private static int Score(){
        return 30;
    }



    /**
     Game Winning Tips

     * @param  name Current Player's name.
     * @param  steps Player's total steps.

     * @return Nothing.
     */
    private static void printIF(String name,int steps){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("CONGRATULATIONS!");
        alert.setContentText("Player："+ name +" WINS！"+"Using "+steps+" Steps!");
        alert.setTitle("GAME OVER!");
        alert.showAndWait();
    }


    /**

     Testing without creating messages
     Determining whether to win
     * @param  flag The sign of winning or not.
     * @param  name Current Player's name.
     * @param  p Current Player.
     * @param  P All Players.
     * @param  test test.
     * @return Nothing.
     */

    public static void judgeGame(boolean flag, String name, Player p, HashSet<Player> P,int test){
        if(flag) {
            p.setCurScore(Score());
        }
    }

}
