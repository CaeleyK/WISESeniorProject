package sample;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;

public class OneSample {
    public OneSample(Stage stage) {
        try {
            runOneSample(stage);
        }
        catch(Exception ex) {
        }
    }

    public void runOneSample(Stage stage) throws FileNotFoundException {
        //create VBox for page
        VBox page = new VBox();
        page.setSpacing(200);
        page.setBackground(new Background(new BackgroundFill(Color.AZURE, CornerRadii.EMPTY, Insets.EMPTY)));
        HBox titleBox = new HBox();
        titleBox.setSpacing(450);
        //create back button
        Button back = new Button("Back to Homepage");
        titleBox.getChildren().add(back);
        back.setOnMousePressed(event -> backToHome(stage));

        //create title for page
        Text title = new Text("One Sample Test");
        title.setFont(Font.font ("Verdana", FontWeight.BOLD, 30));
        titleBox.getChildren().add(title);
        page.getChildren().add(titleBox);

        //create box for description
        VBox infoBox = new VBox();
        Text info = new Text("Brief Description of one sample test");
        infoBox.getChildren().add(info);
        infoBox.setAlignment(Pos.CENTER);
        page.getChildren().add(infoBox);

        //create box for formula
        VBox formulaBox = new VBox();
        Image formula = new Image(new FileInputStream("/Users/caeleykardell/IdeaProjects/HomePage/MainDirectory/Screen Shot 2020-11-01 at 10.33.45 PM.png"));
        ImageView formula1 = new ImageView(formula);
        formulaBox.getChildren().add(formula1);
        formula1.setPreserveRatio(true);
        formula1.setFitHeight(100);
        formulaBox.setAlignment(Pos.CENTER);
        page.getChildren().add(formulaBox);

        //graph for interactive aspect n
        VBox graphBox = new VBox();
        Image graph = new Image(new FileInputStream("/Users/caeleykardell/IdeaProjects/HomePage/MainDirectory/Screen Shot 2020-11-30 at 12.42.44 PM.png"));
        ImageView graphIV = new ImageView(graph);
        graphBox.getChildren().add(graphIV);
        graphIV.setPreserveRatio(true);
        graphIV.setFitHeight(500);
        graphBox.setAlignment(Pos.CENTER);
        page.getChildren().add(graphBox);

        //create interactive aspect n
        Text prompt_n = new Text("Enter sample size (n): ");
        javafx.scene.control.TextField t_n = new TextField();
        HBox interactiveAspect_n = new HBox();
        interactiveAspect_n.getChildren().add(prompt_n);
        interactiveAspect_n.getChildren().add(t_n);
        interactiveAspect_n.setAlignment(Pos.CENTER);
        interactiveAspect_n.setSpacing(10);
        page.getChildren().add(interactiveAspect_n);

        javafx.scene.control.Button Enter_n = new javafx.scene.control.Button("Enter");
        interactiveAspect_n.getChildren().add(Enter_n);
        Enter_n.setOnMousePressed(event -> runR(t_n));
        Enter_n.setOnKeyPressed(new EventHandler<KeyEvent>() {@Override
        public void handle(KeyEvent k) {
            if (k.getCode().equals(KeyCode.ENTER)) {
                runR(t_n);
            }
        }
        });
        interactiveAspect_n.setOnKeyReleased(event -> {if (event.getCode() == KeyCode.ENTER) {runR(t_n);}});

        //graph for interactive aspect sd
        VBox graphBox_sd = new VBox();
        Image graph_sd = new Image(new FileInputStream("/Users/caeleykardell/IdeaProjects/HomePage/MainDirectory/Screen Shot 2020-11-30 at 12.42.44 PM.png"));
        ImageView graphIV_sd = new ImageView(graph);
        graphBox_sd.getChildren().add(graphIV_sd);
        graphIV_sd.setPreserveRatio(true);
        graphIV_sd.setFitHeight(500);
        graphBox_sd.setAlignment(Pos.CENTER);
        page.getChildren().add(graphBox_sd);

        //create interactive aspect sd
        Text prompt_sd = new Text("Enter standard deviation (sd): ");
        javafx.scene.control.TextField t_sd = new TextField();
        HBox interactiveAspect_sd = new HBox();
        interactiveAspect_sd.getChildren().add(prompt_sd);
        interactiveAspect_sd.getChildren().add(t_sd);
        interactiveAspect_sd.setAlignment(Pos.CENTER);
        interactiveAspect_sd.setSpacing(10);
        page.getChildren().add(interactiveAspect_sd);

        javafx.scene.control.Button Enter_sd = new javafx.scene.control.Button("Enter");
        interactiveAspect_sd.getChildren().add(Enter_sd);
        Enter_sd.setOnMousePressed(event -> runR(t_sd));
        Enter_sd.setOnKeyPressed(new EventHandler<KeyEvent>() {@Override
        public void handle(KeyEvent k) {
            if (k.getCode().equals(KeyCode.ENTER)) {
                runR(t_sd);
            }
        }
        });
        interactiveAspect_sd.setOnKeyReleased(event -> {if (event.getCode() == KeyCode.ENTER) {runR(t_sd);}});

        //scroll
        ScrollPane sp = new ScrollPane();
        sp.setContent(page);
        sp.setFitToHeight(true);
        sp.setFitToWidth(true);
        //create scene and run stage
        Scene s = new Scene(sp, Color.LIGHTSKYBLUE);
        stage.setMaximized(true);
        stage.setScene(s);
        stage.show();

        //run(primaryStage);
    }

    public void runR(TextField n) {
        //check to see if taking user input
        System.out.println(n.getText());
        try {
            //write n to file for R to read
            FileWriter fw = new FileWriter(new File("/Users/caeleykardell/IdeaProjects/HomePage/MainDirectory/test"), false);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(n.getText());
            pw.close();
        }
        catch (Exception ex) {
        }
    }

    public void backToHome(Stage t) {
        Home h2 = new Home();
        try {
            h2.assembleHP(t);
        }
        catch (Exception ex) {

        }
    }
}
