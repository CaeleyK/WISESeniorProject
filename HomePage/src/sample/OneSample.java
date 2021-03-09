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
        //Text info = new Text("Brief Description of one sample test");
        Text info = new Text("A one sample t-test is used when you are comparing a sample with a known mean and standard deviation to a population with a known mean and unknown standard deviation to see if they are significantly different.  An example where you would use a one sample t-test would be: Do students on a high school baseball team have significantly higher test scores than the rest of students in the school?  In this example, the baseball team is the sample and the school is the population.  This is also considered a one-tailed t-test because your question is directional.  Here are the different forms of hypotheses that you may test with a one sample t-test:");
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

        //graph for interactive aspect n
        VBox graphBox = new VBox();
        Image graph = new Image(new FileInputStream(System.getProperty("user.dir") + "/MainDirectory/OneSample1.png"));
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
        Enter_n.setOnMousePressed(event -> runR(t_n, page));
        Enter_n.setOnKeyPressed(new EventHandler<KeyEvent>() {@Override
        public void handle(KeyEvent k) {
            if (k.getCode().equals(KeyCode.ENTER)) {
                runR(t_n, page);
            }
        }
        });
        interactiveAspect_n.setOnKeyReleased(event -> {if (event.getCode() == KeyCode.ENTER) {runR(t_n, page);}});

        //graph for interactive aspect MSD
        VBox graphBox_MSD = new VBox();
        Image graph_MSD = new Image(new FileInputStream(System.getProperty("user.dir") + "/MainDirectory/OneSampleMSD.png"));
        ImageView graphIV_MSD = new ImageView(graph_MSD);
        graphBox_MSD.getChildren().add(graphIV_MSD);
        graphIV_MSD.setPreserveRatio(true);
        graphIV_MSD.setFitHeight(500);
        graphBox_MSD.setAlignment(Pos.CENTER);
        page.getChildren().add(graphBox_MSD);

        //create interactive aspect mean and sd
        Text prompt_mean = new Text("Enter mean (M): ");
        javafx.scene.control.TextField t_mean = new TextField();
        Text prompt_sd = new Text("Enter standard deviation (sd): ");
        javafx.scene.control.TextField t_sd = new TextField();
        HBox interactiveAspect_MSD = new HBox();
        interactiveAspect_MSD.getChildren().add(prompt_mean);
        interactiveAspect_MSD.getChildren().add(t_mean);
        interactiveAspect_MSD.getChildren().add(prompt_sd);
        interactiveAspect_MSD.getChildren().add(t_sd);
        interactiveAspect_MSD.setAlignment(Pos.CENTER);
        interactiveAspect_MSD.setSpacing(10);
        page.getChildren().add(interactiveAspect_MSD);

        javafx.scene.control.Button Enter_2 = new javafx.scene.control.Button("Enter");
        interactiveAspect_MSD.getChildren().add(Enter_2);
        Enter_2.setOnMousePressed(event -> runR2(t_mean, t_sd, page));
        Enter_2.setOnKeyPressed(new EventHandler<KeyEvent>() {@Override
        public void handle(KeyEvent k) {
            if (k.getCode().equals(KeyCode.ENTER)) {
                runR2(t_mean, t_sd, page);
            }
        }
        });
        interactiveAspect_MSD.setOnKeyReleased(event -> {if (event.getCode() == KeyCode.ENTER) {runR2(t_mean, t_sd, page);}});


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
        Scene s = new Scene(sp, Color.LIGHTSKYBLUE);
        info.wrappingWidthProperty().bind(s.widthProperty().subtract(15));
        stage.setScene(s);
        stage.setMaximized(true);
        stage.show();

        //run(primaryStage);
    }

    public void runR(TextField n, VBox page) {
        //check to see if taking user input
        System.out.println(n.getText());
        try {
            //write n to file for R to read
            FileWriter fw = new FileWriter(new File(System.getProperty("user.dir") + "/MainDirectory/OneSampleNFile"), false);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(n.getText());
            pw.close();

            //run R
            String[]  s = new String[]{(String) n.getText()};
            File file = new File(System.getProperty("user.dir") + "/MainDirectory/OneSampleSampleSize.R");
            file.setExecutable(true, true);
            Process p = Runtime.getRuntime().exec("Rscript " + System.getProperty("user.dir") + "/MainDirectory/OneSampleSampleSize.R");
            p.waitFor();

            //display results
            Image testI = new Image(new FileInputStream(System.getProperty("user.dir") + "/MainDirectory/OneSample1.png"));
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

    public void runR2(TextField mean, TextField sd, VBox page) {
        //check to see if taking user input
        System.out.println(mean.getText());
        System.out.println(sd.getText());
        try {
            //write n to file for R to read
            FileWriter fw = new FileWriter(new File(System.getProperty("user.dir") + "/MainDirectory/OneSampleMSDFile"), false);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(mean.getText());
            pw.println(sd.getText());
            pw.close();

            //run R
            String[]  s = new String[]{(String) mean.getText()};
            File file = new File(System.getProperty("user.dir") + "/MainDirectory/OneSampleMSD.R");
            file.setExecutable(true, true);
            Process p = Runtime.getRuntime().exec("Rscript " + System.getProperty("user.dir") + "/MainDirectory/OneSampleMSD.R");
            p.waitFor();

            //display results
            Image testI = new Image(new FileInputStream(System.getProperty("user.dir") + "/MainDirectory/OneSampleMSD.png"));
            ImageView graphIV = new ImageView(testI);
            VBox graphBox = new VBox();
            graphBox.getChildren().add(graphIV);
            graphIV.setPreserveRatio(true);
            graphIV.setFitHeight(500);
            graphBox.setAlignment(Pos.CENTER);
            page.getChildren().set(5, graphBox);
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
