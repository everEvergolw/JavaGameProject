package Game.Model.SpecialSites;

import Game.Model.Player.Player;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.HashSet;
/**
 * Transport class
 *  Players arriving here will swap positions with the player acting on the next turn.
 *
 */
public class Transport extends SpecialSites{

    private final String url = Type.Tp.getUrl();

    public Transport(int row, int col) {
        super(row, col);
    }


    public String getUrl() {
        return url;
    }


    /**
     Will not block players
     * @return true or false
     */
    @Override
    public boolean isBlock() {
        return false;
    }


    /**
     Transport 's debuff: Players arriving here will swap positions with the player acting on the next turn.

     * @param  p Current Player.
     * @param  ps All players.
     * @param  ss All SpecialSites.

     * @return Nothing.
     */
    @Override
    public void debuff(Player p, HashSet<Player> ps, SpecialSites ss) {
        //Iterate to find the current player and find the next player
        ps.forEach(o->{
            if((p.getId()+1) % ps.size() == o.getId()){
                // Swap the two positions of the two players
                int x,y;
                x = p.getCurX();
                y = p.getCurY();
                p.setCurX(o.getCurX());
                p.setCurY(o.getCurY());
                o.setCurX(x);
                o.setCurY(y);

                // Game Message
                Info(p,o);
            }


        });


    }


    /**
     Game Tip Message
     * @param  p Current Player.
     * @param  o Other player .

     * @return Nothing.
     */
    private void Info(Player p, Player o){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("MAYBE BAD LUCKY!");
        alert.setContentText("Player："+ p.getName() +" And Player："+o.getName()+" Exchange position!");
        alert.setTitle("Transport");
        alert.getButtonTypes().setAll(new ButtonType("Yes"));
        alert.showAndWait();
    }



    /**
     * Testing without creating messages
     Transport 's debuff: Players arriving here will swap positions with the player acting on the next turn.

     * @param  p Current Player.
     * @param  ps All players.
     * @param  ss All SpecialSites.

     * @return Nothing.
     */
    @Override
    public void debuff(Player p, HashSet<Player> ps, SpecialSites ss,int test) {
        ps.forEach(o->{
            if((p.getId()+1) % ps.size() == o.getId()){
                int x,y;
                x = p.getCurX();
                y = p.getCurY();
                p.setCurX(o.getCurX());
                p.setCurY(o.getCurY());
                o.setCurX(x);
                o.setCurY(y);
            }


        });


    }

}
