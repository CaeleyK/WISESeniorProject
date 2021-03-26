package sample;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
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
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.stage.Screen;
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
        page.setSpacing(80);
        page.setBackground(new Background(new BackgroundFill(Color.AZURE, CornerRadii.EMPTY, Insets.EMPTY)));
        VBox backBox = new VBox();
        //create back button
        Button back = new Button("Back to Homepage");
        backBox.getChildren().add(back);
        backBox.setAlignment(Pos.TOP_LEFT);
        back.setOnMousePressed(event -> backToHome(stage));

        //create title for page
        Text title = new Text("One Sample Test");
        title.setFont(Font.font ("Verdana", FontWeight.BOLD, 30));
        VBox titleBox = new VBox();
        titleBox.getChildren().add(title);
        titleBox.setAlignment(Pos.CENTER);
        page.getChildren().addAll(backBox, titleBox);

        //TextFlow 1
        TextFlow tf1 = new TextFlow();
        VBox tfBox1 = new VBox();
        tf1.setLineSpacing(20);
        tfBox1.setAlignment(Pos.CENTER);
        tf1.setPrefWidth(stage.getWidth()-100);
        tf1.setPadding(new Insets(0,50, 0, 50));

        //create box for description 1
        Text info1 = new Text("A one sample t-test is used when you are comparing a sample with a known mean and standard deviation to a population with a known mean and unknown standard deviation to see if they are significantly different.  An example where you would use a one sample t-test would be: Do students on a high school baseball team have significantly higher test scores than the rest of the students in the school?  In this example, the baseball team is the sample and the school is the population.  This is also considered a one-tailed t-test because your question is directional.  Here are the different forms of hypotheses that you may test with a one sample t-test:" + "\n" + "\n" +
                "Directional 1: testing to see if the sample has a lower mean than the population" + "\n" +
                "Directional 2: testing to see if the sample has a higher mean than the population" + "\n" +
                "Nondirectional: testing to see if the sample does not have the same mean as the population" + "\n" + "\n" +
                "To calculate the test statistic for a one sample t-test, you can use this equation:");
        info1.setFont(Font.font("Verdana", 20));
        tf1.getChildren().add(info1);
        tfBox1.getChildren().add(tf1);
        VBox.setMargin(tfBox1, new Insets(0,50, 0, 50));
        page.getChildren().add(tfBox1);




        //create box for formula
        VBox formulaBox = new VBox();
        Image formula = new Image(new FileInputStream(System.getProperty("user.dir") + "/MainDirectory/OneSampleFormula.png"));
        ImageView formula1 = new ImageView(formula);
        formulaBox.getChildren().add(formula1);
        formula1.setPreserveRatio(true);
        formula1.setFitHeight(150);
        formulaBox.setAlignment(Pos.CENTER);
        page.getChildren().add(formulaBox);


        //key
        VBox keyBox = new VBox();
        Image key1 = new Image(new FileInputStream(System.getProperty("user.dir") + "/MainDirectory/OneSampleKey.png"));
        ImageView key = new ImageView(key1);
        keyBox.getChildren().add(key);
        key.setPreserveRatio(true);
        //key.setFitHeight(100);
        key.setFitWidth(stage.getWidth()-300);
        keyBox.setAlignment(Pos.CENTER);
        page.getChildren().add(keyBox);


        //TextFlow 2
        TextFlow tf2 = new TextFlow();
        VBox tfBox2 = new VBox();
        tf2.setLineSpacing(20);
        tfBox2.setAlignment(Pos.CENTER);
        tf2.setPrefWidth(stage.getWidth()-100);
        tf2.setPadding(new Insets(0,50, 0, 50));

        //create box for description 2
        Text info2 = new Text("Your calculated test statistic is compared to your critical value to determine if your sample is significantly different from the population.  The critical value is a significance threshold and varies as a function of alpha and sample size.  A larger alpha and larger sample size leads to a lower significance threshold, which means that the null is more likely to be rejected.  The critical value has already been calculated for you in the visuals below." + "\n" +
                "When comparing your calculated test statistic to your critical value, the following outcome would yield a significant result (i.e. the sample is significantly different from the population) regardless of your hypothesis: \n \n");
        info2.setFont(Font.font("Verdana", 20));

        //insert rejection region inequality

        Text info4 = new Text("Below is a distribution of t-values taken from a larger population where the null hypothesis is true.  In this example, it is assumed that you are comparing a sample (N=100) to a population with a mean of zero and an unknown standard deviation.  The dot represents your test statistic and the region shaded in blue represents your rejection region.  This particular example has a significance level of .05 and is a one-tailed t-test (directional 2) because there is only one rejection region.  Try putting in different (positive) means and standard deviations for your sample to see if the null hypothesis should be rejected (p<.05) or not (p>.05).  If the point representing the test statistic turns red, that means that the test statistic is greater than the critical value and you should reject the null hypothesis." + "\n" + "\n" +
                "Are you more likely to reject the null hypothesis when the mean of your sample is larger or smaller?\n" +
                "What about your standard deviation?\n");
        info4.setFont(Font.font("Verdana", 20));


        tf2.getChildren().addAll(info2, info4);
        tfBox2.getChildren().add(tf2);
        VBox.setMargin(tfBox2, new Insets(0,50, 0, 50));
        page.getChildren().add(tfBox2);


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
        TextFlow prompt_mean = new TextFlow();
        //Text prompt_mean = new Text("Enter mean (M): ");
        //prompt_mean.setFont(Font.font("Verdana", 20));
        Text promptM1 = new Text("Enter mean (");
        Text promptM2 = new Text("M");
        Text promptM3 = new Text("): ");
        promptM1.setFont(Font.font("Verdana",  20));
        promptM2.setFont(Font.font("Verdana", FontPosture.ITALIC, 20));
        promptM3.setFont(Font.font("Verdana",  20));
        prompt_mean.getChildren().addAll(promptM1, promptM2, promptM3);
        javafx.scene.control.TextField t_mean = new TextField();
        TextFlow prompt_sd = new TextFlow();
        //Text prompt_sd = new Text("Enter standard deviation (sd): ");
        //prompt_sd.setFont(Font.font("Verdana", 20));
        Text promptSD1 = new Text("Enter standard deviation (");
        Text promptSD2 = new Text("SD");
        Text promptSD3 = new Text("): ");
        promptSD1.setFont(Font.font("Verdana",  20));
        promptSD2.setFont(Font.font("Verdana", FontPosture.ITALIC, 20));
        promptSD3.setFont(Font.font("Verdana",  20));
        prompt_sd.getChildren().addAll(promptSD1, promptSD2, promptSD3);
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


        //TextFlow 3
        TextFlow tf3 = new TextFlow();
        VBox tfBox3 = new VBox();
        tf3.setLineSpacing(20);
        tfBox3.setAlignment(Pos.CENTER);
        tf3.setPrefWidth(stage.getWidth()-100);
        tf3.setPadding(new Insets(0,50, 0, 50));


        //create box for info 5
        Text info5 = new Text("As you can tell by trying out different numbers, increasing the mean (in the case of a directional 2 hypothesis) and decreasing the standard deviation causes the test statistic value to approach the rejection region.\n" + "\n" +
                "Below is another example of comparing a sample to a population with a mean of zero and an unknown standard deviation.  This time, the mean and standard deviation of the sample are constant and you can change the sample size.\n" + "\n" +
                "What happens to the test statistic when your sample size gets larger? \n");
        info5.setFont(Font.font("Verdana", 20));
        tf3.getChildren().add(info5);
        tfBox3.getChildren().add(tf3);
        VBox.setMargin(tfBox3, new Insets(0,50, 0, 50));
        page.getChildren().add(tfBox3);


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
        //Text prompt_n = new Text("Enter sample size (n): ");
        //prompt_n.setFont(Font.font("Verdana", 20));
        TextFlow prompt_n = new TextFlow();
        Text promptN1 = new Text("Enter sample size (");
        Text promptN2 = new Text("n");
        Text promptN3 = new Text("): ");
        promptN1.setFont(Font.font("Verdana",  20));
        promptN2.setFont(Font.font("Verdana", FontPosture.ITALIC, 20));
        promptN3.setFont(Font.font("Verdana",  20));
        prompt_n.getChildren().addAll(promptN1, promptN2, promptN3);
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


        //TextFlow 4
        TextFlow tf4 = new TextFlow();
        VBox tfBox4 = new VBox();
        tf4.setLineSpacing(20);
        tfBox4.setAlignment(Pos.CENTER);
        tf4.setPrefWidth(stage.getWidth()-100);
        tf4.setPadding(new Insets(0,50, 0, 50));

        //create box for info 6
        Text info6 = new Text("As you can tell by this visual, having a larger sample size increases the likelihood that your test statistic will be extreme enough to reject the null hypothesis (p<.05).  In addition, notice that the sample size influences the shape of your t-distribution (see our “Introduction to t-distributions” page) and the size of your rejection region.  This did not occur when you only changed the mean and standard deviation of your sample.");
        info6.setFont(Font.font("Verdana", 20));
        tf4.getChildren().add(info6);
        tfBox4.getChildren().add(tf4);
        VBox.setMargin(tfBox4, new Insets(0,50, 50, 50));
        page.getChildren().add(tfBox4);


        //scroll
        ScrollPane sp = new ScrollPane();
        sp.setContent(page);
        sp.fitToWidthProperty().set(true);
        sp.fitToHeightProperty().set(true);
        sp.setPrefViewportWidth(stage.getWidth());
        sp.setPrefViewportHeight(stage.getHeight());
        sp.vbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.ALWAYS);
        Scene s = new Scene(sp, Color.LIGHTSKYBLUE);
        //info.wrappingWidthProperty().bind(s.widthProperty().subtract(15));
        stage.setScene(s);
        //stage.setMaximized(true);
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        stage.setX(bounds.getMinX());
        stage.setY(bounds.getMinY());
        stage.setWidth(bounds.getWidth());
        stage.setHeight(bounds.getHeight());

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
            page.getChildren().set(9, graphBox);
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
            page.getChildren().set(6, graphBox);
        }
        catch (Exception ex) {
        }
    }


    public void backToHome(Stage t) {
        Home h2 = new Home();
        try {
            //t.setMaximized(true);
            h2.assembleHP(t);
        }
        catch (Exception ex) {

        }
    }
}
