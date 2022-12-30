package Game.Controller.EventHandler;

import Game.Model.Player.Player;
import Game.View.GameView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.HashSet;

/**
 * This is the click event in the custom game view.
 * Provide TextField to get the number of rows, columns, and obstacles specified by player input
 * and will make a legality determination on the data.
 * If the data input is not legal, the player will be prompted and re-entered,
 * otherwise the game interface cannot be accessed.
 */

public class CGameViewEH implements EventHandler {

    private Stage s;

    private TextField count;
    private TextField row;
    private TextField col;
    private HashSet<Player> players = new HashSet<>();
    public CGameViewEH(Stage s, TextField row, TextField  col ,TextField count, HashSet<Player> players) {
        this.setS(s);
        this.setCount(count);
        this.setRow(row);
        this.setCol(col);
        this.setPlayers(players);
    }


    /**

     Click event
     * @param  event Event.

     * @return Nothing.

     */
    @Override
    public void handle(Event event) {

        int Row = this.getRow();
        int Col = this.getCol();
        int Count = this.getCount();

        // If the data entered by the user is legal, the game screen is redirected
        if(judge(Row,Col,Count,players)){
        GameView gv = new GameView(Row,Col,Count,players);

        try {
            gv.start(new Stage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // Close the current screen
        this.getS().close();
        }
    }

    /**

     Determine if user input is legal

     * @param  Row Rows.
     * @param  Col Cols.
     * @param  count Number of Obstacles.
     * @param  players All players.

     * @return Nothing.

     */

    private boolean judge(int Row, int Col, int count ,HashSet<Player> players ){

        // The number of players cannot be equal to 0
        if(players.size() == 0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("INPUT ERROR!");
            alert.setContentText("Must add players!");
            alert.setTitle("Error!");
            alert.showAndWait();
            return false;
        }


        if(Row < 6 || Row > 17){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("INPUT ERROR!");
            alert.setContentText("The input Col should be between 6 and 17!");
            alert.setTitle("Error!");
            alert.showAndWait();
            return false;
        }

        if(Col < 3 || Col >23 || Col< players.size()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("INPUT ERROR!");
            if(Col < 3 || Col >23) alert.setContentText("The input Col should be between 3 and 23!");
            else alert.setContentText("columns are less than players's number!");
            alert.setTitle("Error!");
            alert.showAndWait();
            return false;
        }

        // The number of obstacles cannot be less than or equal to 0 and cannot exceed (3*Row*Col/45)+1
        if(count <= 0 || count > ((3*Row*Col/45)+1)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("INPUT ERROR!");
            alert.setContentText("Count should be between 1 and "+((3*Row*Col/45)+1)+"!");
            alert.setTitle("Error!");
            alert.showAndWait();
            return false;
        }

        return true;

    }








    public void setRow(TextField row) {
        this.row = row;
    }
    public void setCol(TextField col) {

        this.col = col;
    }
    public void setPlayers(HashSet<Player> players) {
        this.players = players;
    }
    public int getRow() {

        return Integer.parseInt(row.getText());
    }
    public int getCol() {


        return Integer.parseInt(col.getText());
    }
    public HashSet<Player> getPlayers() {
        return players;
    }
    public void setS(Stage s) {
        this.s = s;
    }
    public void setCount(TextField count) {
        this.count = count;
    }
    private int getCount() {

        return Integer.parseInt(count.getText());
    }
    private Stage getS() {
        return s;
    }


}
