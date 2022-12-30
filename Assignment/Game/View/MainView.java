package Game.View;

import Game.Controller.EventHandler.CustomizedGameEH;
import Game.Controller.EventHandler.SelectModelEH;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
/**
 * This class Displays the initial game MainView Stage
 *
 */
public class MainView extends Application {



    /**
      MainView Stage start method.
      Provide Start Game button and Customized Game button and bind the corresponding events respectively.
     * @return Nothing.
     */

    @Override
    public void start(Stage stage) throws Exception {

        /* Add vertical layout*/
        VBox vBox = new VBox();

        /* Add horizontal layout*/
        HBox hBox1 = new HBox();
        hBox1.setAlignment(Pos.CENTER);
        hBox1.setPadding(new Insets(100,100,25,100));

        HBox hBox2 = new HBox();
        hBox2.setAlignment(Pos.CENTER);
        hBox2.setPadding(new Insets(350,100,25,100));
        hBox2.setSpacing(100);

        /* Title */
        Label label = new Label("Simon’s Race");
        label.setFont(new Font("Arial", 90));
        label.setTextFill(Color.web("black"));


        /* Create Start Game button and add mouse click event
        *  Click will turn the difficulty selection stage
        * */
        Button start = new Button("Start Game");
        start.setOnAction(new SelectModelEH(stage));
        start.setPrefSize(200,60);

        /* Create Customized Game button and add mouse click event
         *  Clicking on it will transfer the custom game interface
         * */
        Button set = new Button("Customized Game");
        set.setOnAction(new CustomizedGameEH(stage));
        set.setPrefSize(200,60);

        /* Add to horizontal layout */
        hBox1.getChildren().add(label);
        hBox2.getChildren().addAll(start,set);

        /* Add to vertical layout*/
        vBox.getChildren().addAll(hBox1,hBox2);




        /* Add the Scene to the Stage*/
        Scene scene = new Scene(vBox,800,800);
        stage.setScene(scene);
        stage.setTitle("Simon’s Race");
        stage.getIcons().add(new Image("Game/Img/Icons/UCD.png"));
        stage.setResizable(false);
        stage.show();


    }


}
