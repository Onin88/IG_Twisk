package twisk;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import twisk.mondeIG.*;
import twisk.vues.*;

public class MainTwisk extends Application {

    public void start(Stage primaryStage){
        MondeIG md = new MondeIG();

        BorderPane root = new BorderPane();
        root.setBottom(new VueOutils(md));

        root.setCenter(new VueMondeIG(md));
        root.setStyle("-fx-background-color: #3F3A64");
        root.setTop(new VueMenu(md));

        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
