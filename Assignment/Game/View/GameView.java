package Game.View;

import Game.Controller.EventHandler.GameViewEH;
import Game.Controller.EventHandler.MainViewEH;
import Game.Controller.EventHandler.RollDiceEH;
import Game.File.Read;
import Game.Model.Pane.BackgroundBoard;
import Game.Model.Pane.BackgroundPane;
import Game.Model.Player.Player;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.HashSet;

/**
 *  This class is the game running view
 *
 */
public class GameView extends Application  {

    // Pixel size
    private int cellLength;
    private int row;
    private int col;
    private int count;

    private BackgroundBoard backgroundBoard;
    private BackgroundPane pane;
    private HashSet<Player> players = new HashSet<>();




    /**
     Game default initialization

     * @param  count Number of Obstacles.

     */
    public GameView(int count) {
        //Default Properties
        this.setCellLength(50);
        this.setRow(16);
        this.setCol(14);
        this.setCount(count);
        backgroundBoard = BackgroundBoard.getInstance(this.getCellLength(),this.getRow(),this.getCol());
        pane = new BackgroundPane(backgroundBoard,this.getCount(),this.players);

    }



    /**
     Game customization initialization

     * @param  row rows.
     * @param  col cols.
     * @param  count Number of Obstacles.
     * @param  players All players.

     */
    public GameView(int row, int col,int count ,HashSet<Player> players) {
        this.setCellLength(50);
        this.setRow(row);
        this.setCol(col);
        this.setCount(count);
        this.setPlayers(players);
        backgroundBoard = BackgroundBoard.getInstance(this.getCellLength(),this.getRow(),this.getCol());
        pane = new BackgroundPane(backgroundBoard,this.getCount(),this.players);

    }




    /**
     *
     GameView  start method.
     On the left side of the interface provides player game information, game tips information.
     The right side provides information about the player's scoreboard.
     In the middle is the game running interface.
     The bottom side provides three buttons Return Roll Reset.

     * @return Nothing.
     */

    @Override
    public void start(Stage stage) throws Exception {

        BorderPane borderPane = new BorderPane();


        HBox hBox1 = new HBox();
        //Set centering
        hBox1.setAlignment(Pos.CENTER);
        hBox1.getChildren().add(pane);

        hBox1.setPrefHeight(this.getRow()*this.getCellLength());
        hBox1.setPrefWidth(this.getCol()*this.getCellLength());

        //Adding events to a pane

        VBox left = new VBox(10);
        left.setPadding(new Insets(20));

        // In-game player movement change information
        Text playerInfor = new Text("Player:");
        Text DirInfo = new Text("DirDice:");
        Text StepInfo = new Text("StepDice:");
        Text GameInfo = new Text("First step!");

        // Special Location Alert Messages
        VBox Site = new VBox(100);
        Site.setAlignment(Pos.CENTER);
        Label SiteInfo = new Label("SpecialSites InFo\n" +" \n"
                                    +"Fire: Block The Front \n" +" \n"
                                    + "BlakHoll: Block The Front \n"+" \n"
                                    + "Stay: Stop A Few Rounds \n"+" \n"
                                    + "Transport: Exchange Positions \n" +"\n"
                                    + "Gold: Add Score \n"
        );
        SiteInfo.setWrapText(true);
        SiteInfo.setPrefSize(200,200);

        Site.getChildren().add(SiteInfo);

        left.getChildren().addAll(playerInfor,DirInfo,StepInfo,GameInfo,Site);
        left.setPrefHeight(200);
        left.setPrefWidth(250);

        borderPane.setLeft(left);


        VBox right = new VBox(10);
        right.setPadding(new Insets(20));
        right.setPrefHeight(200);
        right.setPrefWidth(200);
        // Scoreboard
        Label PlayerInfo = new Label(new Read().showAll());
        PlayerInfo.setWrapText(true);
        PlayerInfo.setTextFill(Color.web("black"));
        PlayerInfo.setPrefSize(200,200);
        right.getChildren().add(PlayerInfo);
        borderPane.setRight(right);

        borderPane.setCenter(hBox1);


        HBox hbox2 = new HBox(50);
        hbox2.setMaxHeight(50);
        hbox2.setAlignment(Pos.TOP_CENTER);


        //  Three buttons corresponding to different events
        Button Re = new Button("Return");
        Button Roll = new Button("Roll");

        Button Reset = new Button("Reset");

        //Adding events to buttons
        Re.setOnAction(new MainViewEH(stage));
        Roll.setOnAction(new RollDiceEH(pane, left));
        Reset.setOnAction(new GameViewEH(stage,this.getRow(),this.getCol(),this.getCount(),this.getPlayers()));

        // Multi-threaded implementation refreshes the view every time a player makes a move

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                Runnable updater = new Runnable() {

                    @Override
                    public void run() {
                        pane.draw();
                    }
                };

                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                    }

                    // UI update is run on the Application thread
                    Platform.runLater(updater);
                }
            }

        });
        // don't let thread prevent JVM shutdown
        thread.setDaemon(true);
        thread.start();



        // Adding buttons inside the layout
        hbox2.getChildren().addAll(Re,Roll,Reset);
        //Put it under
        borderPane.setBottom(hbox2);



        /* Adding a Scene to a Stage*/
        Scene scene = new Scene(borderPane,(this.getCol()+8+1)*this.getCellLength(),(this.getRow()+1)*this.getCellLength());
        stage.setScene(scene);
        stage.setTitle("Simon’s Race");
        stage.getIcons().add(new Image("Game/Img/Icons/UCD.png"));
        stage.show();


    }


    /* set and get method*/
    private void setPlayers(HashSet<Player> players) {
        this.players = players;
    }

    public HashSet<Player> getPlayers() {
        return players;
    }

    private void setCellLength(int cellLength) {
        this.cellLength = cellLength;
    }

    private void setRow(int row) {
        this.row = row;
    }

    private void setCol(int col) {
        this.col = col;
    }

    private int getCellLength() {
        return cellLength;
    }

    private int getRow() {
        return row;
    }

    private int getCol() {
        return col;
    }

    private void setCount(int count) {
        this.count = count;
    }

   private int getCount() {
        return count;
    }



}
