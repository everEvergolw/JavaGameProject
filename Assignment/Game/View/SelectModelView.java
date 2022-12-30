package Game.View;

import Game.Controller.EventHandler.GameViewEH;
import Game.Controller.EventHandler.MainViewEH;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *   This class provides a choice of different difficulty levels and creates the corresponding stage
 *
 */
public class SelectModelView extends Application {


    /**
     SelectModelView start method.
     provides a choice of different difficulty levels and creates the corresponding stage

     * @return Nothing.
     */


    @Override
    public void start(Stage stage) throws Exception {

        /* Add vertical layout */
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(100);

        /*
         * Display three buttons
         * Offers a choice of three difficulty levels
         * */
        Button easy  = new Button("Easy");
        Button normal = new Button("Normal");
        Button hard   = new Button("Hard");

        /*
         * Add mouse click events to three buttons
         * Create three separate Stages for different difficulty options
         * count: Determine the number of SpecialSites in different difficulty Stages
         * */
        easy.setOnAction(new GameViewEH(stage,5));
        normal.setOnAction(new GameViewEH(stage,10));
        hard.setOnAction(new GameViewEH(stage,15));

        /* Set button width and height */
        easy.setPrefSize(200,60);
        normal.setPrefSize(200,60);
        hard.setPrefSize(200,60);

        /* Add Return button and mouse click events
        *  can return to the main screen
        * */
        Button Re = new Button("Return");
        Re.setOnAction(new MainViewEH(stage));
        Re.setPrefSize(100,30);


        /* Add to the vertical layout */
        vBox.getChildren().addAll(easy,normal,hard,Re);


        /* Add the Scene to the Stage*/
        Scene scene = new Scene(vBox,800,800);
        stage.setScene(scene);
        stage.setTitle("Simon’s Race");
        stage.getIcons().add(new Image("Game/Img/Icons/UCD.png"));
        stage.setResizable(false);
        stage.show();


    }



}
