package Game.View;

import Game.Controller.EventHandler.AddPlayerEH;
import Game.Controller.EventHandler.CGameViewEH;
import Game.Controller.EventHandler.MainViewEH;
import Game.Model.Player.Player;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.util.HashSet;


/**
 * Customized game view
 * Provides add player button, you can add players after clicking
 * Provides player customization of rows and columns and number of obstacles
 * Provides start, and return buttons
 */
public class CustomizedGameView extends Application {

    private HashSet<Player> players = new HashSet<>();



    /**
     * Customized game view start method.
     * Provides add player button, you can add players after clicking
     * Provides player customization of rows and columns and number of obstacles
     * Provides start, and return buttons
     *
     * @return Nothing.
     */
    @Override
    public void start(Stage stage) {


        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        // Add Player Button
        Button AddPlayer  = new Button("Add Player");
        // Add Event
        AddPlayer.setOnAction(new AddPlayerEH(players));

        AddPlayer.setPrefSize(100,60);

        // Three input boxes
        Label row = new Label("Row:");
        Label col =new Label("Col:");
        Label count = new Label("Obstacles:");

        grid.add(row, 0, 1);// 6 - 17
        TextField RowTextField = new TextField("6");
        grid.add(RowTextField, 1, 1);

        grid.add(col, 0, 2);// 2 - 23
        TextField ColTextField = new TextField("6");
        grid.add(ColTextField, 1, 2);

        grid.add(count, 0, 3);
        TextField CountTextField = new TextField("1");
        grid.add(CountTextField, 1, 3);


        vBox.getChildren().addAll(AddPlayer, grid);

        // Start game button and Back to main screen button
        Button start = new Button("Start");
        // Add Event
        Button Re = new Button("Return");
        Re.setOnAction(new MainViewEH(stage));
        HBox hBox = new HBox
                (10);

        hBox.setAlignment(Pos.BOTTOM_RIGHT);
        hBox.getChildren().addAll(Re,start);
        start.setOnAction(new CGameViewEH(stage,RowTextField,ColTextField,CountTextField,players));
        grid.add(hBox,1,4);




        Scene scene = new Scene(vBox,400,400);


        stage.setScene(scene);
        stage.setTitle("Simon’s Race");
        stage.getIcons().add(new Image("Game/Img/Icons/UCD.png"));
        stage.setResizable(false);
        stage.show();

    }


}
