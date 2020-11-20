package sample;

import com.sun.deploy.uitoolkit.impl.text.TextConsoleWindow;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
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
import javafx.scene.control.ScrollBar;
import org.rosuda.JRI.Rengine;
import org.rosuda.JRI.RMainLoopCallbacks;

import java.io.*;
import java.util.Random;
import java.util.Scanner;


//import java.awt.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //ScrollBar scroll = new ScrollBar();
        //scroll.setOrientation(Orientation.VERTICAL);


        //create VBox for page
        VBox page = new VBox();
        //page.getChildren().add(scroll);
        page.setSpacing(200);
        page.setBackground(new Background(new BackgroundFill(Color.AZURE, CornerRadii.EMPTY, Insets.EMPTY)));
        HBox titleBox = new HBox();
        titleBox.setSpacing(450);
        //create back button
        Button back = new Button("Back to Homepage");
        titleBox.getChildren().add(back);
        //bp.setMargin(back, Insets(100));

        //create title for page
        Text title = new Text("Introduction to t-distributions");
        title.setFont(Font.font ("Verdana", FontWeight.BOLD, 30));
        titleBox.getChildren().add(title);
        titleBox.setAlignment(Pos.TOP_LEFT);
        page.getChildren().add(titleBox);

        //create box for description
        VBox infoBox = new VBox();
        Text info = new Text("Description of t-distributions");
        infoBox.getChildren().add(info);
        infoBox.setAlignment(Pos.CENTER);
        page.getChildren().add(infoBox);

        //create box for formula
        VBox formulaBox = new VBox();
        Image formula = new Image(new FileInputStream("/Users/caeleykardell/IdeaProjects/tDistribution/Senior Project/Screen Shot 2020-11-01 at 10.33.45 PM.png"));
        ImageView formula1 = new ImageView(formula);
        formulaBox.getChildren().add(formula1);
        formula1.setPreserveRatio(true);
        formula1.setFitHeight(100);
        //formula1.setFitWidth(200);
        formulaBox.setAlignment(Pos.CENTER);
        page.getChildren().add(formulaBox);

        //graph for interactive aspect
        VBox graphBox = new VBox();
        Image graph = new Image(new FileInputStream("/Users/caeleykardell/IdeaProjects/tDistribution/Senior Project/My Plot.png"));
        ImageView graphIV = new ImageView(graph);
        graphBox.getChildren().add(graphIV);
        graphIV.setPreserveRatio(true);
        graphIV.setFitHeight(500);
        //formula1.setFitWidth(200);
        graphBox.setAlignment(Pos.CENTER);
        page.getChildren().add(graphBox);

        //create interactive aspect
        Text prompt = new Text("Enter sample size (n): ");
        javafx.scene.control.TextField t = new TextField();
        HBox interactiveAspect = new HBox();
        interactiveAspect.getChildren().add(prompt);
        interactiveAspect.getChildren().add(t);
        interactiveAspect.setAlignment(Pos.CENTER);
        interactiveAspect.setSpacing(10);
        page.getChildren().add(interactiveAspect);

        javafx.scene.control.Button Enter = new javafx.scene.control.Button("Enter");
        interactiveAspect.getChildren().add(Enter);
        Enter.setOnMousePressed(event -> runR(t));
        Enter.setOnKeyPressed(new EventHandler<KeyEvent>() {@Override
            public void handle(KeyEvent k) {
                if (k.getCode().equals(KeyCode.ENTER)) {
                    runR(t);
                }
            }
        });
        interactiveAspect.setOnKeyReleased(event -> {if (event.getCode() == KeyCode.ENTER) {runR(t);}});

        ScrollPane sp = new ScrollPane();
        sp.setContent(page);
        sp.setFitToHeight(true);
        sp.setFitToWidth(true);
        //sp.vbarPolicyProperty(ScrollPane.ScrollBarPolicy );
        //create scene and run stage
        Scene s = new Scene(sp, Color.LIGHTSKYBLUE);
        primaryStage.setMaximized(true);
        primaryStage.setScene(s);
        primaryStage.show();

        //run(primaryStage);
    }

    public void runR(TextField n) {
        //check to see if taking user input
        System.out.println(n.getText());
        try {
            //write n to file for R to read
            FileWriter fw = new FileWriter(new File("/Users/caeleykardell/IdeaProjects/tDistribution/Senior Project/test"), false);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(n.getText());
            pw.close();

            //read file from R
            //VBox v2 = new VBox();
            //Image graph2 = new Image(new FileInputStream("/Users/caeleykardell/Desktop/My Plot.png"));
            //ImageView graphIV2 = new ImageView(graph2);
            //v2.getChildren().add(graphIV2);
            //v.getChildren().get(4);
            //graphBox.getChildren().add(graphIV);
        }
        catch (Exception ex) {
        }



        //interact with R to create visual
        String[]  s = new String[]{(String) n.getText()};
        //Rengine re= new Rengine(s, true, new TextConsole());
        /*if (!Rengine.versionCheck()) {
            System.err.println("not right version");
            System.exit(1);
        }*/
    }

    public void interAspect() {

    }


    public static void main(String[] args) {
        launch(args);
    }
}
