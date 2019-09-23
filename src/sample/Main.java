package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.background.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        Buch nMedium = new Buch(23992839,23.34,2002,"E4","Hallo", "Shakespeares", "978-3-86680-192-9");
        nMedium.gibAllesAufKonsoleAus();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
