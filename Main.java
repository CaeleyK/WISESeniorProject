package sample;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Home testt = new Home();
        primaryStage.setMaximized(true);
        testt.assembleHP(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
