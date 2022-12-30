package Game.Model.Pane;


import Game.File.Save;
import Game.Model.Player.Player;
import Game.Model.Player.PlayerType;
import Game.Model.SpecialSites.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

/**
 * BackgroundPane class
 * Initialize the board,
 * Initialize the players,
 * Initialize SpecialSites.
 *
 */

public class BackgroundPane extends Pane {

    private BackgroundBoard backgroundBoard;
    private Canvas canvas;
    private GraphicsContext gc;
    private HashSet<SpecialSites> Site;
    private HashSet<Player> players;

    // Is it occupied When generating barriers.
    int[][] Ocupy = new int[20][20];


    /**
     Construction
     * @param  backgroundBoard Pixel size.
     * @param  count Number of Obstacles.
     * @param   players All players.
     */
    public BackgroundPane(BackgroundBoard backgroundBoard,int count,HashSet<Player> players) {
        this.setBackgroundBoard(backgroundBoard);
        canvas = new Canvas(backgroundBoard.getCol() * backgroundBoard.getCellLength(), backgroundBoard.getRow() * backgroundBoard.getCellLength());

        this.setSite(count);

        this.setPlayer(players);

        gc = canvas.getGraphicsContext2D();

        this.draw();
        this.getChildren().add(canvas);

        // Initialize to 0
        for (int i = 0; i < Ocupy.length; i++) {
            Arrays.fill(Ocupy[i],0);
        }
    }



    /**
     Initialize the main game view
     @return Nothing.
     */
    public void draw(){
        drawBoard();
        drawSite();
        drawPlayer();

    }



    /**
     Initializing the board
     @return Nothing.
     */
    public void drawBoard(){

        gc.clearRect(0,0, backgroundBoard.getCol() * backgroundBoard.getCellLength(), backgroundBoard.getRow() * backgroundBoard.getCellLength());

        double x = backgroundBoard.getStartX();

        double y = backgroundBoard.getStartY();

        double cell = backgroundBoard.getCellLength();

        gc.setStroke(Color.BLACK);

        // Painting grid, four colors
        for(int i = 0; i< backgroundBoard.getRow(); i++){

            for(int j = 0; j< backgroundBoard.getCol(); j++){
                if( i == 0){
                    gc.setFill(Color.valueOf("#7FFF00"));
                    gc.fillRect(x+ j*cell ,  y +i*cell ,cell  , cell);
                }
                else if(i == backgroundBoard.getRow()-1)
                {
                    gc.setFill(Color.valueOf("#6495ED"));
                    gc.fillRect(x+ j*cell ,  y +i*cell ,cell  , cell);
                }

                else {gc.strokeRect( x+ j*cell , y+i*cell ,cell  , cell);

                if(i%2 == 0){
                gc.setFill(Color.valueOf("#DCDCDC"));
                gc.fillRect(x+ j*cell ,  y +i*cell ,cell  , cell);
                }
                else {
                    gc.setFill(Color.valueOf("#483D8B"));
                    gc.fillRect(x + j*cell , y  +i*cell ,cell  , cell);
                }
                }
            }
        }


        gc.strokeRect(x,y,cell * backgroundBoard.getCol(), cell* backgroundBoard.getRow());


    }


    /**
     Draw SpecialSites according to the set pixel size and position
     @return Nothing.
     */
    public void drawSite(){

        double cell = backgroundBoard.getCellLength();
        // Iterate through the drawing Site images
        Site.forEach(e->{
                if(e.isVisible()){
                Image image = new Image(e.getUrl());
                gc.drawImage(image,
                    backgroundBoard.getStartX() + e.getCol() * cell,
                    backgroundBoard.getStartY() + e.getRow() * cell,
                    cell, cell);}
           // }
        });

    }


    /**
     Initialize Site
     @return Nothing.
     */
    public void setSite(int count) {
        Site = new HashSet<>();
        Random r = new Random();
        //Five types Sites

        // the number of fire
       for (int i = 0; i < count;) {

            int x = r.nextInt(1, backgroundBoard.getRow()-2);
            //int x =backgroundBoard.getRow()-2;
            int y = r.nextInt(0, backgroundBoard.getCol());
            if(IsOccupyBlcok(x, y)&& IsOccupyBlcok(x+1, y)){
            Ocupy[x][y] = 1;
            Ocupy[x+1][y] = 1;
            Site.add(new FireSite(x,y,Type.values()[0].getUrl()));
            Site.add(new FireSite(x + 1,y,Type.values()[1].getUrl()));
                i++;
            }
        }

        // the number of BlackHoll
        for (int i = 0; i < count ;) {

            int x = r.nextInt(1, backgroundBoard.getRow()-1);
            int y = r.nextInt(0, backgroundBoard.getCol());

            if(IsOccupyBlcok(x, y)){
                Ocupy[x][y] = 1;
                Site.add(new BlackHoll(x, y));
                i++;
            }

        }

        // the number of Stay /2
        for (int i = 0; i < count/2; ) {

            int x = r.nextInt(1, backgroundBoard.getRow() - 1);
            int y = r.nextInt(0, backgroundBoard.getCol());

            if(IsOccupy(x, y)) {
                Ocupy[x][y] = 1;
                Site.add(new Stay(x, y));
                i++;
            }


        }

        // the number of Transport /2
        for (int i = 0; i < count/2; ) {

            int x = r.nextInt(1, backgroundBoard.getRow() - 1);
            int y = r.nextInt(0, backgroundBoard.getCol());

            if( IsOccupy(x, y)) {
                Ocupy[x][y] = 1;
                Site.add(new Transport(x, y));
                i++;
            }


        }

        for (int i = 0; i < count/2;) {

            int x = r.nextInt(1, backgroundBoard.getRow() - 1);
            int y = r.nextInt(0, backgroundBoard.getCol());

            if( IsOccupy(x, y)) {
                Ocupy[x][y] = 1;
                Site.add(new Gold(x, y));
                i++;
            }

        }



    }



    /**
     Draw players according to the set pixel size and position
     @return Nothing.
     */
    public void drawPlayer(){
        double cell = backgroundBoard.getCellLength();
        // Iterate through the drawing player images
        players.forEach(e->{

            Image image = new Image(e.getUrl());
            gc.drawImage(image,
                    backgroundBoard.getStartX() + e.getCurY() * cell,
                    backgroundBoard.getStartY() + e.getCurX() * cell,
                    cell, cell);
        });
    }


    /**
     Initialize player
     @param   players All players.
     @return Nothing.
     */
    public void setPlayer(HashSet<Player> players){
        this.players = players;

        // When the number of players is 0, the default player creation is called
        if(this.players.size()==0){
            //The default creation is for these two players Trump and Bidden
            players.add(new Player(backgroundBoard.getRow()-1,0, PlayerType.T.getUrl(),0,"Trump"));
            players.add(new Player(backgroundBoard.getRow()-1,1, PlayerType.B.getUrl(),1,"Bidden"));
        }
        // Customized player creation
        else {
            // Initialize player location
        players.forEach(o->
        {
            o.setCurX(backgroundBoard.getRow()-1);
            o.setCurY(o.getId());
        });}


        // Save Player
        new Save().saveInfo(players);

    }






    /**
     Determine if the location generated by SpecialSites is occupied or not
     @param   x curX.
     @param   y cruY.
     @return true or false.
     */
    private boolean IsOccupyBlcok(int x, int y){
        boolean flag = false;
        if(Ocupy[x][y] != 0)
            flag = false;

        // The first situation
       else if(y-1<0){
            if(Ocupy[x+1][y+1] == 0 )
                flag =true;
            else flag =false;
        }
       // The second situation
       else if(y-2<0){
            if(Ocupy[x-1][y-1] == 0)
                flag =true;
            else flag =false;
        }

        // The third situation
        else if(y+1 == backgroundBoard.getCol() )
        {
            if(Ocupy[x+1][y-1] ==0)
                flag =true;
            else flag =false;
        }
        //The fourth situation
        else if(y+2 == backgroundBoard.getCol()){
            if(Ocupy[x-1][y+1] == 0)
                flag =true;
            else flag =false;
        }

        //The fifth situation
        else {
            if((Ocupy[x+1][y-1] ==0 && Ocupy[x+1][y+1] == 0)
                    && ((Ocupy[x][y+2] ==0 && Ocupy[x-1][y+1] == 0))
                    && (Ocupy[x][y-2] ==0 && Ocupy[x-1][y-1] == 0))

                flag =true;

            else flag =false;


        }


        return flag;
    }



    /**
     Non-blocking site
     @param   x curX.
     @param   y cruY.
     @return true or false.
     */
    private boolean IsOccupy(int x, int y){
        if(Ocupy[x][y] != 0)
            return false;
        return true;

    }





    public BackgroundBoard getBackgroundBoard() {
        return backgroundBoard;
    }
    public void setBackgroundBoard(BackgroundBoard backgroundBoard) {
        this.backgroundBoard = backgroundBoard;
    }

    public HashSet<Player> getPlayers() {
        return players;
    }
    public HashSet<SpecialSites> getSpecialSites() {
        return Site;
    }


}