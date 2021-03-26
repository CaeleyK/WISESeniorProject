package sample;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Home {
    VBox hp;


    public Home() {
        hp = new VBox();
        hp.setSpacing(80);
        hp.setBackground(new Background(new BackgroundFill(Color.AZURE, CornerRadii.EMPTY, Insets.EMPTY)));
        //hp.setAlignment(Pos.CENTER);
    }

    public void assembleHP(Stage homeStage) throws FileNotFoundException {
        //Title
        Text appName = new Text("Hypothesis Testing: To a T");
        appName.setFont(Font.font ("Verdana", FontWeight.BOLD, 40));
        TextFlow tfTitle = new TextFlow(appName);
        tfTitle.setPadding(new Insets(50, 0, 0, 0));
        HBox Title = new HBox(tfTitle);
        Title.setAlignment(Pos.CENTER);
        hp.getChildren().add(Title);

        //layer 1
        HBox layer1 = new HBox();
        layer1.setAlignment(Pos.CENTER);
        layer1.setSpacing(350);
        Button Intro = new Button("Introduction to t-distributions");
        Intro.setFont(new Font("Verdana", 20));
        Intro.setOnMousePressed(event -> openButton1(homeStage));

        //Overview
        Button Overview = new Button("Overview of hypothesis testing");
        Overview.setFont(new Font("Verdana", 20));
        layer1.getChildren().add(Intro);
        layer1.getChildren().add(Overview);
        VBox.setMargin(layer1, new Insets(0, 50, 0, 50));
        hp.getChildren().add(layer1);
        Overview.setOnMousePressed(event -> openButton2(homeStage));

        //layer 2
        Text layer2Text = new Text("Which type of t-test should you use?");
        layer2Text.setFont(Font.font ("Verdana", FontWeight.BOLD, 25));
        HBox layer2 = new HBox(layer2Text);
        layer2.setAlignment(Pos.CENTER);
        VBox.setMargin(layer2, new Insets(0, 50, 0, 50));
        hp.getChildren().add(layer2);

        //arrow1
        //Image arrow = new Image(new FileInputStream(System.getProperty("user.dir") + "/MainDirectory/arrow_down.png"));
        Image arrow = new Image(new FileInputStream("/Users/caeleykardell/IdeaProjects/HomePage/MainDirectory/arrow_down.png"));
        ImageView arrow1 = new ImageView(arrow);
        arrow1.setPreserveRatio(true);
        arrow1.setFitHeight(100);
        hp.setAlignment(Pos.CENTER);
        VBox.setMargin(arrow1, new Insets(0, 50, 0, 50));
        hp.getChildren().add(arrow1);

        //layer 3
        Text layer3Text = new Text("What kind of means are you comparing?");
        layer3Text.setFont(Font.font ("Verdana", FontWeight.BOLD, 25));
        HBox layer3 = new HBox(layer3Text);
        layer3.setAlignment(Pos.CENTER);
        VBox.setMargin(layer3, new Insets(0, 50, 0, 50));
        hp.getChildren().add(layer3);

        //arrow2
        ImageView arrow2 = new ImageView(arrow);
        ImageView arrow3 = new ImageView(arrow);
        arrow2.setPreserveRatio(true);
        arrow2.setFitHeight(100);
        arrow3.setPreserveRatio(true);
        arrow3.setFitHeight(100);
        VBox twoArrowsa = new VBox(arrow2);
        twoArrowsa.setPrefWidth((homeStage.getWidth()/2)-100);
        twoArrowsa.setAlignment(Pos.CENTER);
        VBox twoArrowsb = new VBox(arrow3);
        twoArrowsb.setPrefWidth((homeStage.getWidth()/2)-100);
        twoArrowsb.setAlignment(Pos.CENTER);
        HBox twoArrows = new HBox(twoArrowsa, twoArrowsb);
        twoArrows.setAlignment(Pos.CENTER);
        //twoArrows.setSpacing(200);
        VBox.setMargin(twoArrows, new Insets(0, 50, 0, 50));
        hp.getChildren().add(twoArrows);

        //layer 4
        Text layer4Text1 = new Text("One sample mean and one population mean");
        layer4Text1.setFont(Font.font ("Verdana", FontWeight.BOLD, 25));
        Text layer4Text2 = new Text("Two sample means");
        layer4Text2.setFont(Font.font ("Verdana", FontWeight.BOLD, 25));
        VBox layer4a = new VBox(layer4Text1);
        layer4a.setPrefWidth((homeStage.getWidth()/2)-100);
        layer4a.setAlignment(Pos.CENTER);
        VBox layer4b = new VBox(layer4Text2);
        layer4b.setPrefWidth((homeStage.getWidth()/2)-100);
        layer4b.setAlignment(Pos.CENTER);
        HBox layer4 = new HBox(layer4a, layer4b);
        //layer4.setSpacing(100);
        layer4.setAlignment(Pos.CENTER);
        //VBox.setMargin(layer4, new Insets(0, 50, 0, 50));
        hp.getChildren().add(layer4);

        //arrow3
        ImageView arrow4 = new ImageView(arrow);
        ImageView arrow5 = new ImageView(arrow);
        arrow4.setPreserveRatio(true);
        arrow4.setFitHeight(100);
        arrow5.setPreserveRatio(true);
        arrow5.setFitHeight(100);
        VBox twoArrowsa4 = new VBox(arrow4);
        twoArrowsa4.setPrefWidth((homeStage.getWidth()/2)-100);
        twoArrowsa4.setAlignment(Pos.CENTER);
        VBox twoArrowsa5 = new VBox(arrow5);
        twoArrowsa5.setPrefWidth((homeStage.getWidth()/2)-100);
        twoArrowsa5.setAlignment(Pos.CENTER);
        HBox twoArrows2 = new HBox(twoArrowsa4, twoArrowsa5);
        twoArrows2.setAlignment(Pos.CENTER);
        //VBox.setMargin(twoArrows2, new Insets(0, 50, 0, 50));
        hp.getChildren().add(twoArrows2);

        //layer 5
        Text layer5Text1 = new Text("Is the population standard deviation known?");
        layer5Text1.setFont(Font.font ("Verdana", FontWeight.BOLD, 25));
        Text layer5Text2 = new Text("How are the data structured?");
        layer5Text2.setFont(Font.font ("Verdana", FontWeight.BOLD, 25));
        VBox layer5a = new VBox(layer5Text1);
        layer5a.setPrefWidth((homeStage.getWidth()/2)-100);
        layer5a.setAlignment(Pos.CENTER);
        VBox layer5b = new VBox(layer5Text2);
        layer5b.setPrefWidth((homeStage.getWidth()/2)-100);
        layer5b.setAlignment(Pos.CENTER);
        HBox layer5 = new HBox(layer5a, layer5b);
        //layer5.setSpacing(350);
        layer5.setAlignment(Pos.CENTER);
        //VBox.setMargin(layer5, new Insets(0, 50, 0, 50));
        hp.getChildren().add(layer5);

        //arrow4
        ImageView arrow6 = new ImageView(arrow);
        ImageView arrow7 = new ImageView(arrow);
        ImageView arrow8 = new ImageView(arrow);
        ImageView arrow9 = new ImageView(arrow);
        arrow6.setPreserveRatio(true);
        arrow6.setFitHeight(100);
        arrow7.setPreserveRatio(true);
        arrow7.setFitHeight(100);
        arrow8.setPreserveRatio(true);
        arrow8.setFitHeight(100);
        arrow9.setPreserveRatio(true);
        arrow9.setFitHeight(100);
        VBox twoArrowsa6 = new VBox(arrow6);
        twoArrowsa6.setPrefWidth((homeStage.getWidth()/2)-100);
        twoArrowsa6.setAlignment(Pos.CENTER);
        VBox twoArrowsa7 = new VBox(arrow7);
        twoArrowsa7.setPrefWidth((homeStage.getWidth()/2)-100);
        twoArrowsa7.setAlignment(Pos.CENTER);
        VBox twoArrowsa8 = new VBox(arrow8);
        twoArrowsa8.setPrefWidth((homeStage.getWidth()/2)-100);
        twoArrowsa8.setAlignment(Pos.CENTER);
        VBox twoArrowsa9 = new VBox(arrow9);
        twoArrowsa9.setPrefWidth((homeStage.getWidth()/2)-100);
        twoArrowsa9.setAlignment(Pos.CENTER);
        HBox fourArrows = new HBox(twoArrowsa6, twoArrowsa7, twoArrowsa8, twoArrowsa9);
        fourArrows.setAlignment(Pos.CENTER);
        //VBox.setMargin(fourArrows, new Insets(0, 50, 0, 50));
        hp.getChildren().add(fourArrows);

        //layer 6
        Text layer6Text1 = new Text("Yes");
        layer6Text1.setFont(Font.font ("Verdana", FontWeight.BOLD, 25));
        Text layer6Text2 = new Text("No");
        layer6Text2.setFont(Font.font ("Verdana", FontWeight.BOLD, 25));
        Text layer6Text3 = new Text("Independent");
        layer6Text3.setFont(Font.font ("Verdana", FontWeight.BOLD, 25));
        Text layer6Text4 = new Text("Paired");
        layer6Text4.setFont(Font.font ("Verdana", FontWeight.BOLD, 25));
        VBox layer6a = new VBox(layer6Text1);
        layer6a.setPrefWidth((homeStage.getWidth()/2)-100);
        layer6a.setAlignment(Pos.CENTER);
        VBox layer6b = new VBox(layer6Text2);
        layer6b.setPrefWidth((homeStage.getWidth()/2)-100);
        layer6b.setAlignment(Pos.CENTER);
        VBox layer6c = new VBox(layer6Text3);
        layer6c.setPrefWidth((homeStage.getWidth()/2)-100);
        layer6c.setAlignment(Pos.CENTER);
        VBox layer6d = new VBox(layer6Text4);
        layer6d.setPrefWidth((homeStage.getWidth()/2)-100);
        layer6d.setAlignment(Pos.CENTER);
        HBox layer6 = new HBox(layer6a, layer6b, layer6c, layer6d);
        //layer6.setSpacing(350);
        layer6.setAlignment(Pos.CENTER);
        //VBox.setMargin(layer6, new Insets(0, 100, 0, 50));
        hp.getChildren().add(layer6);

        //arrow5
        ImageView arrow10 = new ImageView(arrow);
        ImageView arrow11 = new ImageView(arrow);
        ImageView arrow12 = new ImageView(arrow);
        ImageView arrow13 = new ImageView(arrow);
        arrow10.setPreserveRatio(true);
        arrow10.setFitHeight(100);
        arrow11.setPreserveRatio(true);
        arrow11.setFitHeight(100);
        arrow12.setPreserveRatio(true);
        arrow12.setFitHeight(100);
        arrow13.setPreserveRatio(true);
        arrow13.setFitHeight(100);
        VBox twoArrowsa10 = new VBox(arrow10);
        twoArrowsa10.setPrefWidth((homeStage.getWidth()/2)-100);
        twoArrowsa10.setAlignment(Pos.CENTER);
        VBox twoArrowsa11 = new VBox(arrow11);
        twoArrowsa11.setPrefWidth((homeStage.getWidth()/2)-100);
        twoArrowsa11.setAlignment(Pos.CENTER);
        VBox twoArrowsa12 = new VBox(arrow12);
        twoArrowsa12.setPrefWidth((homeStage.getWidth()/2)-100);
        twoArrowsa12.setAlignment(Pos.CENTER);
        VBox twoArrowsa13 = new VBox(arrow13);
        twoArrowsa13.setPrefWidth((homeStage.getWidth()/2)-100);
        twoArrowsa13.setAlignment(Pos.CENTER);
        HBox fourArrows2 = new HBox(twoArrowsa10, twoArrowsa11, twoArrowsa12, twoArrowsa13);
        fourArrows2.setAlignment(Pos.CENTER);
        //VBox.setMargin(fourArrows2, new Insets(0, 50, 0, 50));
        hp.getChildren().add(fourArrows2);

        //layer 7
        Text layer7Text1 = new Text("z-test");
        layer7Text1.setFont(Font.font ("Verdana", FontWeight.BOLD, 25));
        HBox layer7 = new HBox();
        VBox text7 = new VBox(layer7Text1);
        text7.setPrefWidth((homeStage.getWidth()/4)-50);
        text7.setAlignment(Pos.CENTER);
        layer7.setAlignment(Pos.CENTER);
        layer7.getChildren().add(text7);
        //layer7.setSpacing(300);
        Button oneSample = new Button("One sample t-test");
        oneSample.setFont(new Font("Verdana", 20));
        oneSample.setOnMousePressed(event -> openButton3(homeStage));
        VBox oneSampleBox = new VBox(oneSample);
        oneSampleBox.setPrefWidth((homeStage.getWidth()/4)-50);
        oneSampleBox.setAlignment(Pos.CENTER);
        Button twoSample = new Button("Independent samples t-test");
        twoSample.setFont(new Font("Verdana", 20));
        VBox twoSampleBox = new VBox(twoSample);
        twoSampleBox.setPrefWidth((homeStage.getWidth()/4)-50);
        twoSampleBox.setAlignment(Pos.CENTER);
        Button paired = new Button("Paired samples t-test");
        VBox pairedBox = new VBox(paired);
        pairedBox.setPrefWidth((homeStage.getWidth()/4)-50);
        pairedBox.setAlignment(Pos.CENTER);
        paired.setFont(new Font("Verdana", 20));
        layer7.getChildren().add(oneSampleBox);
        layer7.getChildren().add(twoSampleBox);
        layer7.getChildren().add(pairedBox);
        //hp.getChildren().add(layer7);

        //One Sample button
        //oneSample.setOnMousePressed(event -> openButton3(homeStage));
        twoSample.setOnMousePressed(event -> openButton4(homeStage));
        paired.setOnMousePressed(event -> openButton5(homeStage));
        VBox.setMargin(layer7, new Insets(0, 0, 50, 0));
        hp.getChildren().add(layer7);


        //make scrollable and set scene
        //VBox.setMargin(hp, new Insets(50, 50, 50, 50));
        ScrollPane sp = new ScrollPane();
        sp.setContent(hp);
        sp.fitToWidthProperty().set(true);
        sp.fitToHeightProperty().set(true);
        sp.setPrefViewportWidth(homeStage.getWidth());
        sp.setPrefViewportHeight(homeStage.getHeight());
        sp.vbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.ALWAYS);

        Scene homeScreen = new Scene(sp, Color.LIGHTSKYBLUE);
        //homeStage.setTitle("App Name");
        homeStage.setScene(homeScreen);

        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        homeStage.setX(bounds.getMinX());
        homeStage.setY(bounds.getMinY());
        homeStage.setWidth(bounds.getWidth());
        homeStage.setHeight(bounds.getHeight());

        homeStage.show();
    }

    public void openButton1(Stage primaryStage) {
        //primaryStage.setMaximized(true);
        new tdistribution(primaryStage);
    }

    public void openButton2(Stage primaryStage) {
        primaryStage.setMaximized(true);
        new Overview(primaryStage);
    }

    public void openButton3(Stage primaryStage) {
        primaryStage.setMaximized(true);
        new OneSample(primaryStage);
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
