package Game.Model.SpecialSites;

import Game.Model.Player.Player;

import java.util.HashSet;
/**
 *    SpecialSites class
 *    The properties are Row Col
 *    Is visible
 *    Provides the corresponding Debuff method
 */
public class SpecialSites{

    private int Row;
    private int Col;

    private boolean Visible;


    /**
     Construction

     * @param  row SpecialSites' position row.
     * @param  col SpecialSites' position col.


     */
    public SpecialSites(int row, int col) {
        setRow(row);
        setCol(col);
        setVisible(true);
    }


    public boolean isVisible() {
        return Visible;
    }

    public void setVisible(boolean visible) {
        Visible = visible;
    }

    public void setRow(int row) {
        Row = row;
    }

    public void setCol(int col) {
        Col = col;
    }

    public int getRow() {
        return Row;
    }

    public int getCol() {
        return Col;
    }

    public String getUrl(){
        return null;
    }

    public boolean isBlock(){
        return false;
    }

    /**


     The corresponding Debuff method
     * @param  p Current Player.
     * @param  ss All SpecialSite.
     * @param  ps All Players.

     * @return Nothing.
     */

    public void debuff(Player p, HashSet<Player> ps,SpecialSites ss){

    }



    /**
     Testing without creating messages.
     The corresponding Debuff method
     * @param  p Current Player.
     * @param  ss All SpecialSite.
     * @param  ps All Players.
     * @param  test just test.
     *
     * @return Nothing.
     */

    public void debuff(Player p, HashSet<Player> ps,SpecialSites ss,int test){

    }



}
