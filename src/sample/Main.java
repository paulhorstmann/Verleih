package sample;


import static sample.basic.contrans.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.background.*;
import java.util.GregorianCalendar;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("./assets/fxml/sample.fxml"));
//        primaryStage.setTitle("Herder Books");
//        primaryStage.setScene(new Scene(root, 950, 600));
//        primaryStage.show();

        test t = new test(true, true, true);
//        long Zeit = (new GregorianCalendar().getTimeInMillis())/(1000*60*60*24);
//        System.out.println(Zeit);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
