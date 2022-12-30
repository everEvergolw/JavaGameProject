package Game.Controller.EventHandler;

import Game.Controller.Action.Debuff;
import Game.Controller.Action.Move;
import Game.Controller.Action.Wining;
import Game.Controller.Message.GameMessage;
import Game.Model.Dice.DirectionDice;
import Game.Model.Dice.MoveDice;
import Game.Model.Pane.BackgroundBoard;
import Game.Model.Pane.BackgroundPane;
import Game.Model.Player.Player;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.HashSet;


/**
 * Click event of button Roll
 * Each click will generate the direction of the current player movement, and the number of steps to move.
 * It will also determine if the player triggers a debuff in a special location,
 * as well as determine if the player is winning.
 *
 * Real-time display of information about the current player dice,
 * and information about the player's upcoming action.
 *
 */

public class RollDiceEH implements EventHandler {

    private BackgroundPane BP;
    private MoveDice MD = new MoveDice();
    private DirectionDice DD = new DirectionDice();
    private VBox left;


    /**
     Custom construction

     * @param  BP BackgroundPane.
     * @param  left Information bar on the left.

     */
    public RollDiceEH(BackgroundPane BP, VBox left) {
        this.BP = BP;
        this.left = left;
    }

    /**

     Click event
     * @param  event Event.

     * @return Nothing.

     */
    @Override
    public void handle(Event event) {
        BackgroundBoard BB = this.BP.getBackgroundBoard();

        System.out.println("Player：" + BB.getCurPlayer());

        // Get Directions
        int dir = DD.Roll();
        //int dir = 2;
        System.out.println("DIR ：" + dir);

        this.addPlayerText(BB.getCurPlayer(),BP.getPlayers());
        this.addDirText(dir);
        // Get steps
        int step = dir == 0? 0 : MD.Roll();
        System.out.println("DICE：" + step);
        this.addStepText(step);
        this.addGameInfo(BB.getCurPlayer(),step,dir,BP.getPlayers());

           // Iterate to find the player of the current turn
           for (Player p:this.BP.getPlayers()
                ) {
               if(BB.getCurPlayer() == p.getId())
               // Dice are thrown to stop the round
               {if(dir == 0 && p.isStay() == false){
                   System.out.println("Player: "+BB.getCurPlayer()+" Stay");
                   this.addStepText(0);
                   this.addGameInfo(BB.getCurPlayer(),0,dir,BP.getPlayers());

                   // Game Tip Message
                   new GameMessage(dir,p);
                   // Detects if a player triggers a debuff
                   Debuff.debuff(p,this.BP.getSpecialSites(),this.BP.getPlayers());

                   break;
               }
               else {

                // Players do not stop then advance
               if(p.isStay() == false) {

                   // Player movement
                   Move.playerMove(BB.getCurPlayer(), step, dir, BB.getRow(), BB.getRow(), p, this.BP.getSpecialSites(), this.BP.getPlayers());
               }else {
                   // Detects if a player triggers a debuff
                   Debuff.debuff(p,this.BP.getSpecialSites(),this.BP.getPlayers());
                   break;
               }
                   // Detects if a player triggers a debuff
               Debuff.debuff(p,this.BP.getSpecialSites(),this.BP.getPlayers());
               // Detects if the player has reached the end
               Wining.judgeGame(p.isWinning(),p.getName(),p,this.BP.getPlayers());
           }

           }}
            // The next player's turn
            BB.changCurPlayer((this.BP.getPlayers().size()));
        }






    /**
     Display information about the current player's next step

     * @param  id Player's id.
     * @param   players All players.
     * @return Nothing.
     *
     */
    private  void addPlayerText(int id, HashSet<Player> players){
        String name =null;
        for (Player p :players
             ) {
            if (p.getId() == id)
                name = p.getName();
        }
        String s = "Player: " + name;
        Text t = (Text) this.left.getChildren().get(0);
        t.setText(s);
    }






    /**
     Show the direction of the direction dice

     * @param  dir Player's direction.
     * @return Nothing.

     */
    private  void addDirText(int dir){
        String s = " DirDice:";
        if(dir ==1 ) s = s + " UP";
        else if(dir ==2) s = s + " DOWN";
        else  s = s + " STAY";
        Text t = (Text) this.left.getChildren().get(1);
        t.setText(s);
        }





    /**
     Shows the number of steps to move the dice

     * @param  step Players steps.

     * @return Nothing.

     */
    private  void addStepText(int step){
        String s = "StepDice: " + step;
        Text t = (Text) this.left.getChildren().get(2);
        t.setText(s);
    }


    /**
     Add information about a player's two dice and movement

     * @param  id Player's id .
     * @param  step Player's steps.
     * @param  dir Player's direction.
     * @param  players All players.


     * @return Nothing.

     */
   private void addGameInfo(int id ,int step ,int dir,HashSet<Player> players){
        String name =null;
        for (Player p :players
        ) {
            if (p.getId() == id)
                name = p.getName();
        }
        String  Dir = null;
        if(dir == 1)
            Dir = "Player: "+name+" Move Up " +step+" Steps!";
        if(dir ==2)
            Dir ="Player: "+name+" Move Down " +step+" Steps!";

        if(dir ==0)
            Dir = "Player: "+name+" Stay One Round!";
        Text t = (Text)  this.left.getChildren().get(3);
        t.setText(Dir);
     }





}




