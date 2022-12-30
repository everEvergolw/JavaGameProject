package Game.Controller.Action;

import Game.Model.Player.Player;
import Game.Model.SpecialSites.SpecialSites;

import java.util.HashSet;

/**
 * When the player reaches a special position,
 * the corresponding effect is to be called
 * */

public class Debuff {


    /**
     Iterate through the special obstacles
     call the corresponding method when the current player position matches.
     * @param p Current Player.
     * @param s All SpecialSites.
     * @param ps All Players.
     * @return Nothing.
     */

    public static void debuff(Player p ,HashSet<SpecialSites> s, HashSet<Player> ps){

           s.forEach(o->{
               //call the corresponding method when the current player position matches.
               if(p.getCurX() == o.getRow() && p.getCurY()== o.getCol()){
                    o.debuff(p,ps,o);
               }

           });

    }



    /**
     Iterate through the special obstacles
     call the corresponding method when the current player position matches.
     * @param p Current Player.
     * @param s All SpecialSites.
     * @param ps All Players.
     * @param test Just test.
     * @return Nothing.
     */
    public static void debuff(Player p ,HashSet<SpecialSites> s, HashSet<Player> ps,int test){
        s.forEach(o->{
            //call the corresponding method when the current player position matches.
            if(p.getCurX() == o.getRow() && p.getCurY()== o.getCol()){

                o.debuff(p,ps,o,test);
            }

        });

    }


}
