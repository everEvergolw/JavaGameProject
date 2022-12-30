package Game.Model.SpecialSites;

import Game.Model.Player.Player;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.HashSet;


/**
 * Gold class
 *  Players who stay here will add five points.
 *  And then Gold disappears
  * */
public class Gold extends SpecialSites{


    private final String url = Type.Gold.getUrl();

    public Gold(int row, int col) {
        super(row, col);
    }


    @Override
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
     Gold's debuff: Players who stay here will add five points.
     And then Gold disappears
     * @param  p Current Player.
     * @param  ps All players.
     * @param  ss All SpecialSites.

     * @return Nothing.
     */
    @Override
    public void debuff(Player p, HashSet<Player> ps, SpecialSites ss){

        if(ss.isVisible() == true)
        {   // add 5 score
            p.setCurScore((p.getCurScore()+5));
            // Disappear
            ss.setVisible(false);
            Info(p);
        }

    }




    /**
     Game Tip Message
     * @param  p Current Player.

     * @return Nothing.
     */
    private void Info(Player p){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("LUCKY!");
        alert.setContentText("Player："+ p.getName()+" Gain 5 Score!");
        alert.setTitle("Gold");
        alert.getButtonTypes().setAll(new ButtonType("Yes"));
        alert.showAndWait();
    }




    /**
      Testing without creating messages.
     Gold's debuff: Players who stay here will add five points.
     And then Gold disappears
     * @param  p Current Player.
     * @param  ps All players.
     * @param  ss All SpecialSites.

     * @return Nothing.
     */

    @Override
    public void debuff(Player p, HashSet<Player> ps, SpecialSites ss,int test){
        if(ss.isVisible() == true)
        {
        p.setCurScore((p.getCurScore()+5));
        ss.setVisible(false);
        }

    }


}
