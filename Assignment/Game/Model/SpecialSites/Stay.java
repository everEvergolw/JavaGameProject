package Game.Model.SpecialSites;


import Game.Model.Player.Player;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
/**
 * Stay class
 * Players arrive here and will randomly stop for a few rounds
 *
 */
public class Stay extends SpecialSites{

    private HashMap<String, Integer> hm = new HashMap<>();

    private final String url = Type.stay.getUrl();
    private Random r ;



    public Stay(int row, int col) {
        super(row, col);
        r = new Random();
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

     Stay's debuff: Players arrive here and will randomly stop for a few rounds.

     * @param  p Current Player.
     * @param  ps All players.
     * @param  ss All SpecialSites.

     * @return Nothing.
     */
    @Override
    public void debuff(Player p, HashSet<Player> ps, SpecialSites ss){


        // Add the player to the HashMap for recording
        if(!hm.containsKey(String.valueOf(p.getId())))
        {   int temp = r.nextInt(5);
            // Need to wait temp rounds
            hm.put(String.valueOf(p.getId()),temp);
            // Tip Message
            Info(p,temp+2);
            // Cannot move
            p.setStay(true);

            return;
        }

        // Players can move again after waiting for the end of the turn
        if(hm.get(String.valueOf(p.getId())) == 0){
            // can move
            p.setStay(false);
            // Tip Message
            Info(p,1);

        }
        else {
            //Subtract one for each round that passes.
            int x = hm.get(String.valueOf(p.getId()));
            x--;
            Info(p,x+2);
            hm.put(String.valueOf(p.getId()),x);
        }

    }



    /**
     Game Tip Message
     * @param  p Current Player.
     * @param  count number of stop rounds .

     * @return Nothing.
     */
    private void Info(Player p,int count){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("BAD LUCKY!");
        alert.setContentText("Player："+ p.getName()+" Stay "+ count +" Round!");
        alert.getButtonTypes().setAll(new ButtonType("Yes"));
        alert.setTitle("Stay");
        alert.showAndWait();
    }




    /**
     Testing without creating messages.
     Stay's debuff: Players arrive here and will randomly stop for a few rounds.

     * @param  p Current Player.
     * @param  ps All players.
     * @param  ss All SpecialSites.

     * @return Nothing.
     */
    @Override
    public void debuff(Player p, HashSet<Player> ps, SpecialSites ss,int test){

        if(!hm.containsKey(String.valueOf(p.getId())))
        {   int temp = r.nextInt(5);
            hm.put(String.valueOf(p.getId()),temp);
            p.setStay(true);

            return;
        }

        if(hm.get(String.valueOf(p.getId())) == 0){
            p.setStay(false);

        }
        else {
            int x = hm.get(String.valueOf(p.getId()));
            x--;
            hm.put(String.valueOf(p.getId()),x);
        }

    }



}
