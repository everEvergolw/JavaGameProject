package Game.Controller.EventHandler;


import Game.Model.Player.Player;
import Game.View.GameView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import java.util.HashSet;


/**
 *  Click event to enter the game view
 *  Two construction methods are provided
 */

public class GameViewEH implements EventHandler {

    private Stage s;

    private int count;

    private int ROW;
    private int COL;

    private boolean Customization ;
    private HashSet<Player> players;

    /**

     Default construction
     * @param  s stage.
     * @param  count Number of Obstacles.


     */

    public GameViewEH(Stage s,int count) {
        this.setS(s);
        this.setCount(count);
        this.setCustomization(false);

    }



    /**
     Custom construction

     Default construction
     * @param  s stage.
     * @param  ROW ROWS.
     * @param  COL COLS.
     * @param  count Number of Obstacles.
     * @param  p All players.

     */
    public GameViewEH(Stage s,int ROW,int COL,int count,HashSet<Player> p) {
        this.setS(s);
        this.setCount(count);
        this.setROW(ROW);
        this.setCOL(COL);
        this.setPlayers(p);
        this.setCustomization(true);
    }
    /**

     Click event
     * @param  event Event.

     * @return Nothing.

     */
    @Override
    public void handle(Event event) {

        try {

            if(this.isCustomization()){
                GameView gv = new GameView(this.getROW(),this.getCOL(),this.getCount(),this.getPlayers());
                gv.start(new Stage());
            }

            else {
                GameView gv = new GameView(this.getCount());
                gv.start(new Stage());
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        this.getS().close();
    }


    public void setCustomization(boolean customization) {
        Customization = customization;
    }

    public boolean isCustomization() {
        return Customization;
    }

    public HashSet<Player> getPlayers() {
        return players;
    }

    public void setPlayers(HashSet<Player> players) {
        this.players = players;
    }

    public void setROW(int ROW) {
        this.ROW = ROW;
    }

    public void setCOL(int COL) {
        this.COL = COL;
    }

    public int getROW() {
        return ROW;
    }

    public int getCOL() {
        return COL;
    }



    public void setS(Stage s) {
        this.s = s;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private int getCount() {
        return count;
    }

    private Stage getS() {
        return s;
    }

}
