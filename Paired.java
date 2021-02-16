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

public class Paired {
    public Paired(Stage stage) {
        try {
            runPaired(stage);
        }
        catch(Exception ex) {
        }
    }

    public void runPaired(Stage stage) throws FileNotFoundException {
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
        Text title = new Text("Paired Sample Test");
        title.setFont(Font.font ("Verdana", FontWeight.BOLD, 30));
        titleBox.getChildren().add(title);
        page.getChildren().add(titleBox);

        //create box for description
        VBox infoBox = new VBox();
        Text info = new Text("Brief Description of paired sample test");
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

        //graph for interactive aspect
        VBox graphBox = new VBox();
        Image graph = new Image(new FileInputStream("/Users/caeleykardell/IdeaProjects/HomePage/MainDirectory/Screen Shot 2020-11-30 at 12.42.44 PM.png"));
        ImageView graphIV = new ImageView(graph);
        graphBox.getChildren().add(graphIV);
        graphIV.setPreserveRatio(true);
        graphIV.setFitHeight(500);
        graphBox.setAlignment(Pos.CENTER);
        page.getChildren().add(graphBox);

        //create interactive aspect input n1
        Text prompt_n1 = new Text("Enter sample size of sample 1 (n): ");
        javafx.scene.control.TextField t_n1 = new TextField();
        HBox interactiveAspect_n1 = new HBox();
        interactiveAspect_n1.getChildren().add(prompt_n1);
        interactiveAspect_n1.getChildren().add(t_n1);
        interactiveAspect_n1.setAlignment(Pos.CENTER_LEFT);
        interactiveAspect_n1.setSpacing(10);
        page.getChildren().add(interactiveAspect_n1);

        javafx.scene.control.Button Enter_n1 = new javafx.scene.control.Button("Enter");
        interactiveAspect_n1.getChildren().add(Enter_n1);
        Enter_n1.setOnMousePressed(event -> runR(t_n1));
        Enter_n1.setOnKeyPressed(new EventHandler<KeyEvent>() {@Override
        public void handle(KeyEvent k) {
            if (k.getCode().equals(KeyCode.ENTER)) {
                runR(t_n1);
            }
        }
        });
        Enter_n1.setOnKeyReleased(event -> {if (event.getCode() == KeyCode.ENTER) {runR(t_n1);}});



        //create interactive aspect sd1
        Text prompt_sd1 = new Text("Enter standard deviation of sample 1 (sd): ");
        javafx.scene.control.TextField t_sd1 = new TextField();
        interactiveAspect_n1.getChildren().add(prompt_sd1);
        interactiveAspect_n1.getChildren().add(t_sd1);

        javafx.scene.control.Button Enter_sd1 = new javafx.scene.control.Button("Enter");
        interactiveAspect_n1.getChildren().add(Enter_sd1);
        Enter_sd1.setOnMousePressed(event -> runR(t_sd1));
        Enter_sd1.setOnKeyPressed(new EventHandler<KeyEvent>() {@Override
        public void handle(KeyEvent k) {
            if (k.getCode().equals(KeyCode.ENTER)) {
                runR(t_sd1);
            }
        }
        });
        Enter_sd1.setOnKeyReleased(event -> {if (event.getCode() == KeyCode.ENTER) {runR(t_sd1);}});

        //create interactive aspect input n2
        Text prompt_n2 = new Text("Enter sample size of sample 2 (n): ");
        javafx.scene.control.TextField t_n2 = new TextField();
        HBox interactiveAspect_n2 = new HBox();
        interactiveAspect_n2.getChildren().add(prompt_n2);
        interactiveAspect_n2.getChildren().add(t_n2);
        interactiveAspect_n2.setAlignment(Pos.CENTER_LEFT);
        interactiveAspect_n2.setSpacing(10);
        page.getChildren().add(interactiveAspect_n2);

        javafx.scene.control.Button Enter_n2 = new javafx.scene.control.Button("Enter");
        interactiveAspect_n2.getChildren().add(Enter_n2);
        Enter_n2.setOnMousePressed(event -> runR(t_n2));
        Enter_n2.setOnKeyPressed(new EventHandler<KeyEvent>() {@Override
        public void handle(KeyEvent k) {
            if (k.getCode().equals(KeyCode.ENTER)) {
                runR(t_n2);
            }
        }
        });
        Enter_n2.setOnKeyReleased(event -> {if (event.getCode() == KeyCode.ENTER) {runR(t_n2);}});



        //create interactive aspect sd2
        Text prompt_sd2 = new Text("Enter standard deviation of sample 2 (sd): ");
        javafx.scene.control.TextField t_sd2 = new TextField();
        //HBox interactiveAspect_sd1 = new HBox();
        interactiveAspect_n2.getChildren().add(prompt_sd2);
        interactiveAspect_n2.getChildren().add(t_sd2);

        javafx.scene.control.Button Enter_sd2 = new javafx.scene.control.Button("Enter");
        interactiveAspect_n2.getChildren().add(Enter_sd2);
        Enter_sd2.setOnMousePressed(event -> runR(t_sd2));
        Enter_sd2.setOnKeyPressed(new EventHandler<KeyEvent>() {@Override
        public void handle(KeyEvent k) {
            if (k.getCode().equals(KeyCode.ENTER)) {
                runR(t_sd2);
            }
        }
        });
        Enter_sd2.setOnKeyReleased(event -> {if (event.getCode() == KeyCode.ENTER) {runR(t_sd2);}});


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
