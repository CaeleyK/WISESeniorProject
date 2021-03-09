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

import java.awt.*;
import java.io.*;

public class TwoSamples {
    public TwoSamples(Stage stage) {
        try {
            runTwoSamples(stage);
        }
        catch(Exception ex) {
        }
    }

    public void runTwoSamples(Stage stage) throws FileNotFoundException {
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
        Text title = new Text("Two Sample Test");
        title.setFont(Font.font ("Verdana", FontWeight.BOLD, 30));
        titleBox.getChildren().add(title);
        page.getChildren().add(titleBox);

        //create box for description
        VBox infoBox = new VBox();
        Text info = new Text("Brief Description of two sample test");
        infoBox.getChildren().add(info);
        infoBox.setAlignment(Pos.CENTER);
        page.getChildren().add(infoBox);

        //create box for formula
        VBox formulaBox = new VBox();
        Image formula = new Image(new FileInputStream(System.getProperty("user.dir") + "/MainDirectory/Screen Shot 2020-11-01 at 10.33.45 PM.png"));
        ImageView formula1 = new ImageView(formula);
        formulaBox.getChildren().add(formula1);
        formula1.setPreserveRatio(true);
        formula1.setFitHeight(100);
        formulaBox.setAlignment(Pos.CENTER);
        page.getChildren().add(formulaBox);

        //graph for interactive aspect
        VBox graphBox = new VBox();
        Image graph = new Image(new FileInputStream(System.getProperty("user.dir") + "/MainDirectory/TwoSample.png"));
        ImageView graphIV = new ImageView(graph);
        graphBox.getChildren().add(graphIV);
        graphIV.setPreserveRatio(true);
        graphIV.setFitHeight(500);
        graphBox.setAlignment(Pos.CENTER);
        page.getChildren().add(graphBox);

        //boxes for input
        Text prompt_mean1 = new Text("Enter mean of sample 1 (M1): ");
        javafx.scene.control.TextField t_mean1 = new TextField();
        Text prompt_sd1 = new Text("Enter standard deviation of sample 1 (sd1): ");
        javafx.scene.control.TextField t_sd1 = new TextField();
        Text prompt_mean2 = new Text("Enter mean of sample 2 (M2): ");
        javafx.scene.control.TextField t_mean2 = new TextField();
        Text prompt_sd2 = new Text("Enter standard deviation of sample 2 (sd2): ");
        javafx.scene.control.TextField t_sd2 = new TextField();
        HBox interactiveAspectS1 = new HBox();
        interactiveAspectS1.getChildren().add(prompt_mean1);
        interactiveAspectS1.getChildren().add(t_mean1);
        interactiveAspectS1.getChildren().add(prompt_sd1);
        interactiveAspectS1.getChildren().add(t_sd1);
        HBox interactiveAspectS2 = new HBox();
        interactiveAspectS2.getChildren().add(prompt_mean2);
        interactiveAspectS2.getChildren().add(t_mean2);
        interactiveAspectS2.getChildren().add(prompt_sd2);
        interactiveAspectS2.getChildren().add(t_sd2);

        interactiveAspectS1.setAlignment(Pos.CENTER);
        interactiveAspectS1.setSpacing(10);
        interactiveAspectS2.setAlignment(Pos.CENTER);
        interactiveAspectS2.setSpacing(10);
        page.getChildren().add(interactiveAspectS1);
        page.getChildren().add(interactiveAspectS2);


        javafx.scene.control.Button Enter = new javafx.scene.control.Button("Enter");
        HBox EnterButton = new HBox();
        EnterButton.getChildren().add(Enter);
        EnterButton.setAlignment(Pos.CENTER);
        Enter.setOnMousePressed(event -> runR(t_mean1, t_sd1, t_mean2, t_sd2, page));
        Enter.setOnKeyPressed(new EventHandler<KeyEvent>() {@Override
        public void handle(KeyEvent k) {
            if (k.getCode().equals(KeyCode.ENTER)) {
                runR(t_mean1, t_sd1, t_mean2, t_sd2, page);
            }
        }
        });
        EnterButton.setOnKeyReleased(event -> {if (event.getCode() == KeyCode.ENTER) {runR(t_mean1, t_sd1, t_mean2, t_sd2, page);}});

        page.getChildren().add(EnterButton);


        //scroll
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();
        ScrollPane sp = new ScrollPane();
        sp.setContent(page);
        sp.fitToWidthProperty().set(true);
        sp.fitToHeightProperty().set(true);
        sp.setPrefViewportWidth(stage.getWidth());
        sp.setPrefViewportHeight(stage.getHeight());
        //sp.setPrefViewportHeight(height);
        //sp.setPrefViewportWidth(width);
        //sp.setFitToHeight(true);
        //sp.setFitToWidth(true);
        //create scene and run stage
        Scene s = new Scene(sp, Color.LIGHTSKYBLUE);
        stage.setScene(s);
        stage.setMaximized(true);
        stage.show();
    }

    public void runR(TextField mean1, TextField sd1, TextField mean2, TextField sd2, VBox page) {
        //check to see if taking user input
        System.out.println(mean1.getText());
        try {
            //write n to file for R to read
            FileWriter fw = new FileWriter(new File(System.getProperty("user.dir") + "/MainDirectory/TwoSampleFile"), false);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(mean1.getText());
            pw.println(sd1.getText());
            pw.println(mean2.getText());
            pw.println(sd2.getText());
            pw.close();

            //run R
            //String[]  s = new String[]{(String) mean.getText()};
            File file = new File(System.getProperty("user.dir") + "/MainDirectory/TwoSample.R");
            file.setExecutable(true, true);
            Process p = Runtime.getRuntime().exec("Rscript " + System.getProperty("user.dir") + "/MainDirectory/TwoSample.R");
            p.waitFor();

            //display results
            Image testI = new Image(new FileInputStream(System.getProperty("user.dir") + "/MainDirectory/TwoSample.png"));
            ImageView graphIV = new ImageView(testI);
            VBox graphBox = new VBox();
            graphBox.getChildren().add(graphIV);
            graphIV.setPreserveRatio(true);
            graphIV.setFitHeight(500);
            graphBox.setAlignment(Pos.CENTER);
            page.getChildren().set(3, graphBox);
        }
        catch (Exception ex) {
        }
    }

    public void backToHome(Stage t) {
        Home h2 = new Home();
        try {
            t.setMaximized(true);
            h2.assembleHP(t);
        }
        catch (Exception ex) {
        }
    }
}
