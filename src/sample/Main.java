//Landry Argabright
//8 December 2018
//Program, is a whack-a-mole game that awards ten points and a slapping noise whenever a player presses a mole image
//player is given ten seconds to press as many moles as possible
//the game has a start and reset button
package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("WHACK-A-MOLE");
        primaryStage.setScene(new Scene(root, 1000, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
