package Game.Controller.Action;

import Game.Controller.Message.GameMessage;
import Game.Model.Player.Player;
import Game.Model.SpecialSites.SpecialSites;

import Game.Controller.Message.PlayerMessage;
import Game.Controller.Message.SelectViewMessage;



import java.util.HashSet;

/**
 *  Enables players to move around the board
 *  Determine if the next position the player moves to is blocked
 *  isBarriers?
 *  isPlayer?
 *  canMove?
 *  Provide playerMove method
 * */
public class Move {

    /**
     Player movement in four directions
     * @param  id Current Player ID.
     * @param  step Number of player movement steps.
     * @param  dir Player movement direction.
     * @param  X Upper boundary X.
     * @param  Y Right border Y.
     * @param  p Current Player.
     * @param  s All SpecialSite.
     * @param  ps All Players.
     * @return Nothing.
     */
    public static void playerMove(int id, int step, int dir, int X, int Y, Player p , HashSet<SpecialSites> s, HashSet<Player> ps) {


        if (p.getId() == id ) {

            // 1: Move UP
            System.out.println("Player:"+ id +" round");
            for (int i = 0; i < step; i++) {
                // Judge Forward direction, when dir = 1, player moves up.
                // otherwise, moves down.
                int temp = (dir == 1 ? -1 : 1);

                if(canMove(dir,X,Y,p,s,ps))
                {
                    // Determine if the end point is reached
                    if(p.getCurX()<=0){
                        p.setWinning(true);
                        break;
                    }

                    // Ability to move
                    p.setCurX(p.getCurX() + temp);
                    // Add steps
                    p.setSteps(p.getSteps()+1);
                    //A message indicating where the player has moved to
                    new PlayerMessage(p,dir);
                    //Default forward, can go forward, the latter will not need to be judged in
                    continue;

                }

                int Dir = 0;
                // 2: Move down
                if(dir !=2){
                    //When the forward is blocked and not backward
                    // prompt the player to make the choice of left, right and stay.
                    Dir = new SelectViewMessage(p).Option() ;}

                // Dir = 3 Players choose to go left
                if(dir !=2 && Dir ==3 ){
                if (canMove(Dir,X,Y,p,s,ps) )
                {
                    temp = -1;
                    if(p.getCurX()<=0){

                        p.setWinning(true);
                        break;
                    }

                    p.setCurY(p.getCurY() + temp);
                    p.setSteps(p.getSteps()+1);
                    new PlayerMessage(p,Dir);
                }
                }

                // Dir = 3 Players choose to go right
                if(dir !=2 &&  Dir ==4)
                if (canMove(Dir,X,Y,p,s,ps) && dir!=2)
                {   temp = 1;
                    if(p.getCurX()<=0){
                        p.setWinning(true);
                        break;
                    }

                    p.setCurY(p.getCurY() + temp);
                    p.setSteps(p.getSteps()+1);
                    new PlayerMessage(p,Dir);
                }


                // Dir = 0
                // The player chooses to stay a round
                // and does not have to perform the rest of the steps
                if(Dir==0){break;}


            }

            // Determine if the end point is reached
            if(p.getCurX()<=0){
                p.setWinning(true);

            }
        }


    }




    /**
      Determine if the player can move to the next position

     * @param  dir Player movement direction.
     * @param  X Upper boundary X.
     * @param  Y Right border Y.
     * @param  p Current Player.
     * @param  s All SpecialSite.
     * @param  ps All Players.
     * @return true or false.
     */
    public static boolean canMove(int dir, int X, int Y, Player p, HashSet<SpecialSites> s, HashSet<Player> ps) {
        // Determine if the boundary is crossed,
        // if there is a player,
        // and if the Barriers is in the way.

        // Move up
        if(dir ==1){
            if(isBarriers(dir,p,s) || isPlayers(dir,p,ps)){
                // Cannot move then prompt message
                new GameMessage(dir,p);
                return false;
            }
        }
        // move down
        else if(dir ==2){
            if((p.getCurX() + 1 )>= X || isBarriers(dir,p,s) || isPlayers(dir,p,ps)){
                // Cannot move then prompt message
                new GameMessage(dir,p);

                return false;
            }
        }//move left
        else if(dir ==3){
        if( (p.getCurY() - 1 ) < 0|| isBarriers(dir,p,s) || isPlayers(dir,p,ps)){
            // Cannot move then prompt message
            new GameMessage(dir,p);
            return false;
        }}
        //move right
        else if(dir == 4){
            if((p.getCurY() + 1 >= Y) || isBarriers(dir,p,s) || isPlayers(dir,p,ps)){
                // Cannot move then prompt message
            new GameMessage(dir,p);
            return false;
        }}


        return true;
    }



    /**
     Determine if the next position is Barriers

     * @param  dir Player movement direction.
     * @param  p Current Player.
     * @param  s All SpecialSite.

     * @return true or false.
     */

    public static boolean isBarriers(int dir,Player p ,HashSet<SpecialSites> s){

        int up = (dir == 1? -1 : 0);
        int down = (dir == 2? 1 : 0);
        int left = (dir == 3? -1 : 0);
        int right = (dir == 4? 1 : 0);


        for (SpecialSites o : s) {
            if (p.getCurX() + up + down == o.getRow() && p.getCurY() + left + right == o.getCol()) {
                // There are some Barriers that can block the player's progress
                // Blocking returns true
                return o.isBlock();
            }
        }
        // otherwise return false
        return false;

    }



    /**
     Determine if the next position is blocked by another player

     * @param  dir Player movement direction.
     * @param  p Current Player.
     * @param  ps All Players.
     *
     * @return true or false.
     */

    public static boolean isPlayers(int dir, Player p ,HashSet<Player> ps){

        int up = (dir == 1? -1 : 0);
        int down = (dir == 2? 1 : 0);
        int left = (dir == 3? -1 : 0);
        int right = (dir == 4? 1 : 0);

        for (Player o: ps) {
            if (p.getCurX() + up + down == o.getCurX() && p.getCurY() + left + right == o.getCurY()) {
                return true;
            }
        }

        return false;
    }






    /**

     Testing without creating messages
     Determine if the player can move to the next position

     * @param  dir Player movement direction.
     * @param  X Upper boundary X.
     * @param  Y Right border Y.
     * @param  p Current Player.
     * @param  s All SpecialSite.
     * @param  ps All Players.
     * @return true or false.
     */
    public static boolean canMove(int dir, int X, int Y, Player p, HashSet<SpecialSites> s, HashSet<Player> ps,int test) {

        if(dir ==1){
            if(isBarriers(dir,p,s) || isPlayers(dir,p,ps)){

                return false;
            }
        }

        else if(dir ==2){
            if((p.getCurX() + 1 )>= X || isBarriers(dir,p,s) || isPlayers(dir,p,ps)){

                return false;
            }
        }
        else if(dir ==3){
            if( (p.getCurY() - 1 ) < 0|| isBarriers(dir,p,s) || isPlayers(dir,p,ps)){

                return false;
            }}

        else if(dir == 4){
            if((p.getCurY() + 1 >= Y) || isBarriers(dir,p,s) || isPlayers(dir,p,ps)){
                return false;
            }}


        return true;
    }


    /**
     Testing without creating messages
     Player movement in four directions
     * @param  id Current Player ID.
     * @param  step Number of player movement steps.
     * @param  dir Player movement direction.
     * @param  X Upper boundary X.
     * @param  Y Right border Y.
     * @param  p Current Player.
     * @param  s All SpecialSite.
     * @param  ps All Players.
     * @param  test just test.
     *
     * @return Nothing.
     */

    public static void playerMove(int id, int step, int dir, int X, int Y, Player p , HashSet<SpecialSites> s, HashSet<Player> ps,int test) {

        if (p.getId() == id ) {


            for (int i = 0; i < step; i++) {

                int temp = (dir == 1 ? -1 : 1);
                if(canMove(dir,X,Y,p,s,ps,test))
                {
                    if(p.getCurX()<=0){

                        p.setWinning(true);
                        break;
                    }

                    p.setCurX(p.getCurX() + temp);
                    p.setSteps(p.getSteps()+1);
                    continue;

                }




                int Dir = 0;

                if(dir !=2 && Dir ==3 ){
                    if (canMove(Dir,X,Y,p,s,ps,test) )
                    {
                        temp = -1;
                        if(p.getCurX()<=0){

                            p.setWinning(true);
                            break;
                        }


                        p.setCurY(p.getCurY() + temp);
                        p.setSteps(p.getSteps()+1);

                    }
                }

                if(dir !=2 &&  Dir ==4)
                    if (canMove(Dir,X,Y,p,s,ps,test) && dir!=2)
                    {   temp = 1;
                        if(p.getCurX()<=0){

                            p.setWinning(true);
                            break;
                        }


                        p.setCurY(p.getCurY() + temp);
                        p.setSteps(p.getSteps()+1);

                    }
                if(Dir==0){break;}





            }

            if(p.getCurX()<=0){

                p.setWinning(true);

            }
        }


    }






}
