package sample;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Home {
    VBox hp;


    public Home() {
        hp = new VBox();
        hp.setBackground(new Background(new BackgroundFill(Color.AZURE, CornerRadii.EMPTY, Insets.EMPTY)));
        //hp.setAlignment(Pos.CENTER);
    }

    public void assembleHP(Stage homeStage) throws FileNotFoundException {
        //Title
        HBox Title = new HBox(new Text("That's the T"));
        Title.setAlignment(Pos.CENTER);
        Title.setSpacing(350);
        hp.getChildren().add(Title);

        //layer 1
        HBox layer1 = new HBox();
        layer1.setAlignment(Pos.CENTER);
        layer1.setSpacing(350);
        Button Intro = new Button("Intro to t-distributions");
        Intro.setOnMousePressed(event -> openButton1(homeStage));

        //Overview
        Button Overview = new Button("Overview of hypothesis testing");
        layer1.getChildren().add(Intro);
        layer1.getChildren().add(Overview);
        hp.getChildren().add(layer1);
        Overview.setOnMousePressed(event -> openButton2(homeStage));

        //layer 2
        HBox layer2 = new HBox(new Text("comparing means"));
        layer2.setAlignment(Pos.CENTER);
        layer2.setSpacing(350);
        hp.getChildren().add(layer2);

        //arrow1
        Image arrow = new Image(new FileInputStream("/Users/caeleykardell/IdeaProjects/HomePage/MainDirectory/arrow_down.png"));
        ImageView arrow1 = new ImageView(arrow);
        hp.setAlignment(Pos.CENTER);
        hp.getChildren().add(arrow1);

        //layer 3
        HBox layer3 = new HBox(new Text("which kind of means?"));
        layer3.setAlignment(Pos.CENTER);
        layer3.setSpacing(350);
        hp.getChildren().add(layer3);

        //arrow2
        HBox twoArrows = new HBox(new ImageView(arrow), new ImageView(arrow));
        twoArrows.setAlignment(Pos.CENTER);
        hp.getChildren().add(twoArrows);

        //layer 4
        HBox layer4 = new HBox(new Text("One sample mean and one population mean"), new Text("Two sample means"));
        layer4.setSpacing(350);
        layer4.setAlignment(Pos.CENTER);
        hp.getChildren().add(layer4);

        //arrow3
        HBox twoArrows2 = new HBox(new ImageView(arrow), new ImageView(arrow));
        twoArrows2.setAlignment(Pos.CENTER);
        hp.getChildren().add(twoArrows2);

        //layer 5
        HBox layer5 = new HBox(new Text("Is the population standard deviation known?"), new Text("How are the data structured?"));
        layer5.setSpacing(350);
        layer5.setAlignment(Pos.CENTER);
        hp.getChildren().add(layer5);

        //arrow4
        HBox fourArrows = new HBox(new ImageView(arrow), new ImageView(arrow), new ImageView(arrow), new ImageView(arrow));
        fourArrows.setAlignment(Pos.CENTER);
        hp.getChildren().add(fourArrows);

        //layer 6
        HBox layer6 = new HBox(new Text("Yes"), new Text("No"), new Text("Independent"), new Text("Paired"));
        layer6.setSpacing(350);
        layer6.setAlignment(Pos.CENTER);
        hp.getChildren().add(layer6);

        //arrow5
        HBox fourArrows2 = new HBox(new ImageView(arrow), new ImageView(arrow), new ImageView(arrow), new ImageView(arrow));
        fourArrows2.setAlignment(Pos.CENTER);
        hp.getChildren().add(fourArrows2);

        //layer 7
        HBox layer7 = new HBox(new Text ("z-test"));
        layer7.setAlignment(Pos.CENTER);
        layer7.setSpacing(350);
        Button oneSample = new Button("One sample t-test");
        Button twoSample = new Button("Independent samples t-test");
        Button paired = new Button("Paired samples t-test");
        layer7.getChildren().add(oneSample);
        layer7.getChildren().add(twoSample);
        layer7.getChildren().add(paired);
        //hp.getChildren().add(layer7);

        //One Sample button
        oneSample.setOnMousePressed(event -> openButton3(homeStage));
        twoSample.setOnMousePressed(event -> openButton4(homeStage));
        paired.setOnMousePressed(event -> openButton5(homeStage));
        hp.getChildren().add(layer7);

        //layer 8
        HBox layer8 = new HBox();
        layer8.setAlignment(Pos.CENTER);
        layer8.setSpacing(300);
        Button runTest = new Button("Run your own test");
        layer8.getChildren().add(runTest);
        hp.getChildren().add(layer8);

        //make scrollable and set scene
        ScrollPane sp = new ScrollPane();
        sp.setContent(hp);
        sp.setFitToHeight(true);
        sp.setFitToWidth(true);
        Scene homeScreen = new Scene(sp, Color.LIGHTSKYBLUE);
        //homeStage.setMaximized(true);
        homeStage.setTitle("App Name");
        homeStage.setScene(homeScreen);
        homeStage.show();
    }

    public void openButton1(Stage primaryStage) {
        primaryStage.setMaximized(true);
        tdistribution t = new tdistribution(primaryStage);
    }

    public void openButton2(Stage primaryStage) {
        primaryStage.setMaximized(true);
        Overview o = new Overview(primaryStage);
    }

    public void openButton3(Stage primaryStage) {
        primaryStage.setMaximized(true);
        OneSample one = new OneSample(primaryStage);
    }

    public void openButton4(Stage primaryStage) {
        primaryStage.setMaximized(true);
        new TwoSamples(primaryStage);
    }

    public void openButton5(Stage primaryStage) {
        primaryStage.setMaximized(true);
        new Paired(primaryStage);
    }




}
