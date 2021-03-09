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
        Image formula = new Image(new FileInputStream(System.getProperty("user.dir") + "/MainDirectory/Screen Shot 2020-11-01 at 10.33.45 PM.png"));
        ImageView formula1 = new ImageView(formula);
        formulaBox.getChildren().add(formula1);
        formula1.setPreserveRatio(true);
        formula1.setFitHeight(100);
        formulaBox.setAlignment(Pos.CENTER);
        page.getChildren().add(formulaBox);

        //graph for interactive aspect
        VBox graphBox = new VBox();
        Image graph = new Image(new FileInputStream(System.getProperty("user.dir") + "/MainDirectory/Paired.png"));
        ImageView graphIV = new ImageView(graph);
        graphBox.getChildren().add(graphIV);
        graphIV.setPreserveRatio(true);
        graphIV.setFitHeight(500);
        graphBox.setAlignment(Pos.CENTER);
        page.getChildren().add(graphBox);

        //create interactive aspect input n1
        Text prompt_mean = new Text("Enter mean (M): ");
        javafx.scene.control.TextField t_mean = new TextField();
        Text prompt_sd = new Text("Enter standard deviation (sd): ");
        javafx.scene.control.TextField t_sd = new TextField();
        HBox interactiveAspect = new HBox();
        interactiveAspect.getChildren().add(prompt_mean);
        interactiveAspect.getChildren().add(t_mean);
        interactiveAspect.getChildren().add(prompt_sd);
        interactiveAspect.getChildren().add(t_sd);
        interactiveAspect.setAlignment(Pos.CENTER);
        interactiveAspect.setSpacing(10);
        page.getChildren().add(interactiveAspect);

        javafx.scene.control.Button Enter = new javafx.scene.control.Button("Enter");
        interactiveAspect.getChildren().add(Enter);
        Enter.setOnMousePressed(event -> runR(t_mean, t_sd, page));
        Enter.setOnKeyPressed(new EventHandler<KeyEvent>() {@Override
        public void handle(KeyEvent k) {
            if (k.getCode().equals(KeyCode.ENTER)) {
                runR(t_mean, t_sd, page);
            }
        }
        });
        Enter.setOnKeyReleased(event -> {if (event.getCode() == KeyCode.ENTER) {runR(t_mean, t_sd, page);}});




        //scroll
        ScrollPane sp = new ScrollPane();
        sp.setContent(page);
        sp.fitToWidthProperty().set(true);
        sp.fitToHeightProperty().set(true);
        sp.setPrefViewportWidth(stage.getWidth());
        sp.setPrefViewportHeight(stage.getHeight());
        //create scene and run stage
        Scene s = new Scene(sp, Color.LIGHTSKYBLUE);
        stage.setScene(s);
        stage.setMaximized(true);
        stage.show();
    }

    public void runR(TextField mean, TextField sd, VBox page) {
        //check to see if taking user input
        System.out.println(mean.getText());
        System.out.println(sd.getText());
        try {
            //write n to file for R to read
            FileWriter fw = new FileWriter(new File(System.getProperty("user.dir") + "/MainDirectory/PairedFile"), false);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(mean.getText());
            pw.println(sd.getText());
            pw.close();

            //run R
            String[]  s = new String[]{(String) mean.getText()};
            File file = new File(System.getProperty("user.dir") + "/MainDirectory/Paired.R");
            file.setExecutable(true, true);
            Process p = Runtime.getRuntime().exec("Rscript " + System.getProperty("user.dir") + "/MainDirectory/Paired.R");
            p.waitFor();

            //display results
            Image testI = new Image(new FileInputStream(System.getProperty("user.dir") + "/MainDirectory/Paired.png"));
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
