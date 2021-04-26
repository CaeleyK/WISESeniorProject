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
        page.setSpacing(80);
        page.setBackground(new Background(new BackgroundFill(Color.AZURE, CornerRadii.EMPTY, Insets.EMPTY)));
        VBox backBox = new VBox();
        backBox.setAlignment(Pos.TOP_LEFT);
        //create back button
        Button back = new Button("Back to Homepage");
        back.setOnMousePressed(event -> backToHome(stage));
        backBox.getChildren().add(back);

        //create title for page
        Text title = new Text("Independent Samples Test");
        title.setFont(Font.font ("Verdana", FontWeight.BOLD, 30));
        VBox titleBox = new VBox();
        titleBox.setAlignment(Pos.CENTER);
        titleBox.getChildren().add(title);
        page.getChildren().addAll(backBox, titleBox);

        //TextFlow 1
        TextFlow tf1 = new TextFlow();
        VBox tfBox1 = new VBox();
        tf1.setLineSpacing(20);
        tfBox1.setAlignment(Pos.CENTER);
        tf1.setPrefWidth(stage.getWidth()-100);
        tf1.setPadding(new Insets(0,50, 0, 50));


        //create box for description 1
        Text info1 = new Text("An independent samples t-test is used to determine whether or not two samples are significantly different (i.e. do not come from the same population).  An example of a time where you would use an independent samples t-test is: Do high school students get different amounts of sleep than college students?  This is considered a two-tailed test because the question is nondirectional.  Here are the different forms of hypotheses that you may test with an independent samples t-test:" + "\n" + "\n" +
                "Directional 1: testing to see if sample 1 has a lower mean than sample 2" + "\n" +
                "Directional 2: testing to see if sample 1 has a higher mean than sample 2" + "\n" +
                "Nondirectional: testing to see if sample 1 has a different mean than sample 2" + "\n" + "\n" +
                "To calculate the test statistic for an independent samples t-test, you can use this equation:");
        info1.setFont(Font.font("Verdana", 20));
        tf1.getChildren().add(info1);
        tfBox1.getChildren().add(tf1);
        VBox.setMargin(tfBox1, new Insets(0,50, 0, 50));
        page.getChildren().add(tfBox1);

        //create box for formula
        VBox formulaBox = new VBox();
        Image formula = new Image(new FileInputStream(System.getProperty("user.dir") + "/MainDirectory/TwoSampleFormula.png"));
        ImageView formula1 = new ImageView(formula);
        formulaBox.getChildren().add(formula1);
        formula1.setPreserveRatio(true);
        formula1.setFitHeight(150);
        formulaBox.setAlignment(Pos.CENTER);
        page.getChildren().add(formulaBox);

        //insert key
        VBox keyBox = new VBox();
        Image key1 = new Image(new FileInputStream(System.getProperty("user.dir") + "/MainDirectory/TwoSampleKey.png"));
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

        //create box for info 2
        Text info2 = new Text("A larger alpha and larger sample size leads to a lower significance threshold, which means that the null is more likely to be rejected." + "\n" +
                "When comparing your calculated test statistic to your critical value, depending on your research hypothesis, the rejection regions that would lead you to reject your null hypothesis are: \n \n" +
                "Directional 1: ");
        Text info2b = new Text("test statistic");
        Text info2c = new Text(" \u2264 " + "–(");
        Text info2d = new Text("critical value");
        Text info2e = new Text(") \n");
        Text info2f = new Text("Directional 2: ");
        Text info2g = new Text("test statistic");
        Text info2h = new Text(" \u2265 ");
        Text info2i = new Text("critical value \n");
        Text info2j = new Text("Nondirectional: |");
        Text info2k = new Text("test statistic");
        Text info2l = new Text("|" + " \u2265 ");
        Text info2m = new Text("critical value \n \n");
        info2.setFont(Font.font("Verdana", 20));
        info2b.setFont(Font.font("Verdana", FontPosture.ITALIC, 20));
        info2c.setFont(Font.font("Verdana", 20));
        info2d.setFont(Font.font("Verdana", FontPosture.ITALIC, 20));
        info2e.setFont(Font.font("Verdana", 20));
        info2f.setFont(Font.font("Verdana", 20));
        info2g.setFont(Font.font("Verdana", FontPosture.ITALIC, 20));
        info2h.setFont(Font.font("Verdana", 20));
        info2i.setFont(Font.font("Verdana", FontPosture.ITALIC, 20));
        info2j.setFont(Font.font("Verdana", 20));
        info2k.setFont(Font.font("Verdana", FontPosture.ITALIC, 20));
        info2l.setFont(Font.font("Verdana", 20));
        info2m.setFont(Font.font("Verdana", FontPosture.ITALIC, 20));

        Text info4 = new Text("Below, you can enter the mean and standard deviations for two different samples in order to determine if the sample means are significantly different from each other.  If the samples are significantly different, the vertical lines representing each sample mean will turn red.  This means that you can reject your null hypothesis and accept your research hypothesis.  If the vertical lines turn green, this means that you will not reject your null hypothesis which suggests that the samples come from the same population." + "\n" + "\n" +
                "In this example, the mean of each sample can be positive or negative." + "\n" + "\n" +
                "What happens when the difference between means is larger or smaller?" + "\n" +
                "What about when your samples have a larger or smaller standard deviation?");
        info4.setFont(Font.font("Verdana", 20));

        tf2.getChildren().addAll(info2, info2b, info2c, info2d, info2e, info2f, info2g, info2h, info2i, info2j, info2k, info2l, info2m, info4);
        tfBox2.getChildren().add(tf2);
        VBox.setMargin(tfBox2, new Insets(0,50, 0, 50));
        page.getChildren().add(tfBox2);


        //graph for interactive aspect
        VBox graphBox = new VBox();
        Image graph = new Image(new FileInputStream(System.getProperty("user.dir") + "/MainDirectory/TwoSample.png"));
        ImageView graphIV = new ImageView(graph);
        graphBox.getChildren().add(graphIV);
        graphIV.setPreserveRatio(true);
        graphIV.setFitHeight(500);
        graphBox.setAlignment(Pos.CENTER);
        //page.getChildren().add(graphBox);

        StackPane SgraphBox = new StackPane();
        SgraphBox.getChildren().addAll(graphBox, createSuggestionKey(stage));
        StackPane.setAlignment(graphBox, Pos.CENTER);
        page.getChildren().add(SgraphBox);

        //boxes for input
        VBox totalPrompts = new VBox();

        TextFlow prompt_mean1 = new TextFlow();
        Text prompt_mean1a = new Text("Enter mean of sample 1 (");
        prompt_mean1a.setFont(Font.font("Verdana", 20));
        Text prompt_mean1b = new Text("M");
        prompt_mean1b.setFont(Font.font ("Verdana", FontPosture.ITALIC, 20));
        Text prompt_mean1c = new Text("1");
        prompt_mean1c.setFont(Font.font("Verdana"));
        prompt_mean1c.setTranslateY(6);
        Text prompt_mean1d = new Text("): ");
        prompt_mean1d.setFont(Font.font("Verdana", 20));
        prompt_mean1.getChildren().addAll(prompt_mean1a, prompt_mean1b, prompt_mean1c, prompt_mean1d);
        javafx.scene.control.TextField t_mean1 = new TextField();


        //Text prompt_sd1 = new Text("Enter standard deviation of sample 1 (sd1): ");
        //prompt_sd1.setFont(Font.font("Verdana", 20));

        TextFlow prompt_sd1 = new TextFlow();
        Text prompt_sd1a = new Text("Enter standard deviation of sample 1 (");
        prompt_sd1a.setFont(Font.font("Verdana", 20));
        Text prompt_sd1b = new Text("s");
        prompt_sd1b.setFont(Font.font ("Verdana", FontPosture.ITALIC, 20));
        Text prompt_sd1c = new Text("1");
        prompt_sd1c.setFont(Font.font("Verdana"));
        prompt_sd1c.setTranslateY(6);
        Text prompt_sd1d = new Text("): ");
        prompt_sd1d.setFont(Font.font("Verdana", 20));
        prompt_sd1.getChildren().addAll(prompt_sd1a, prompt_sd1b, prompt_sd1c, prompt_sd1d);
        javafx.scene.control.TextField t_sd1 = new TextField();


        //Text prompt_mean2 = new Text("Enter mean of sample 2 (M2): ");
        //prompt_mean2.setFont(Font.font("Verdana", 20));
        TextFlow prompt_mean2 = new TextFlow();
        Text prompt_mean2a = new Text("Enter mean of sample 2 (");
        prompt_mean2a.setFont(Font.font("Verdana", 20));
        Text prompt_mean2b = new Text("M");
        prompt_mean2b.setFont(Font.font ("Verdana", FontPosture.ITALIC, 20));
        Text prompt_mean2c = new Text("2");
        prompt_mean2c.setFont(Font.font("Verdana"));
        prompt_mean2c.setTranslateY(6);
        Text prompt_mean2d = new Text("): ");
        prompt_mean2d.setFont(Font.font("Verdana", 20));
        prompt_mean2.getChildren().addAll(prompt_mean2a, prompt_mean2b, prompt_mean2c, prompt_mean2d);
        javafx.scene.control.TextField t_mean2 = new TextField();


        //Text prompt_sd2 = new Text("Enter standard deviation of sample 2 (sd2): ");
        //prompt_sd2.setFont(Font.font("Verdana", 20));
        TextFlow prompt_sd2 = new TextFlow();
        Text prompt_sd2a = new Text("Enter standard deviation of sample 2 (");
        prompt_sd2a.setFont(Font.font("Verdana", 20));
        Text prompt_sd2b = new Text("s");
        prompt_sd2b.setFont(Font.font ("Verdana", FontPosture.ITALIC, 20));
        Text prompt_sd2c = new Text("2");
        prompt_sd2c.setFont(Font.font("Verdana"));
        prompt_sd2c.setTranslateY(6);
        Text prompt_sd2d = new Text("): ");
        prompt_sd2d.setFont(Font.font("Verdana", 20));
        prompt_sd2.getChildren().addAll(prompt_sd2a, prompt_sd2b, prompt_sd2c, prompt_sd2d);


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

        //page.getChildren().add(interactiveAspectS1);
        //page.getChildren().add(interactiveAspectS2);


        javafx.scene.control.Button Enter = new javafx.scene.control.Button("Enter");
        HBox EnterButton = new HBox();
        EnterButton.getChildren().add(Enter);
        EnterButton.setAlignment(Pos.CENTER);
        Enter.setOnMousePressed(event -> runR(t_mean1, t_sd1, t_mean2, t_sd2, page, createSuggestionKey(stage)));
        Enter.setOnKeyPressed(new EventHandler<KeyEvent>() {@Override
        public void handle(KeyEvent k) {
            if (k.getCode().equals(KeyCode.ENTER)) {
                runR(t_mean1, t_sd1, t_mean2, t_sd2, page, createSuggestionKey(stage));
            }
        }
        });
        EnterButton.setOnKeyReleased(event -> {if (event.getCode() == KeyCode.ENTER) {runR(t_mean1, t_sd1, t_mean2, t_sd2, page, createSuggestionKey(stage));}});

        //page.getChildren().add(EnterButton);
        totalPrompts.getChildren().addAll(interactiveAspectS1, interactiveAspectS2, EnterButton);
        totalPrompts.setSpacing(50);
        page.getChildren().add(totalPrompts);


        //TextFlow 3
        TextFlow tf3 = new TextFlow();
        VBox tfBox3 = new VBox();
        tf3.setLineSpacing(20);
        tfBox3.setAlignment(Pos.CENTER);
        tf3.setPrefWidth(stage.getWidth()-100);
        tf3.setPadding(new Insets(0,50, 0, 50));

        //create box for info 2
        Text info5 = new Text("As you can see from this visual representation, you will be more likely to reject the null hypothesis (i.e. have 2 samples with significantly different means) when the means are farther apart and when your standard deviations are smaller.\n");
        info5.setFont(Font.font("Verdana", 20));

        tf3.getChildren().add(info5);
        tfBox3.getChildren().add(tf3);
        VBox.setMargin(tfBox3, new Insets(0,50, 50, 50));
        page.getChildren().add(tfBox3);

        //scroll
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
        sp.vbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.ALWAYS);
        Scene s = new Scene(sp, Color.LIGHTSKYBLUE);
        stage.setScene(s);
        //stage.setMaximized(true);
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        stage.setX(bounds.getMinX());
        stage.setY(bounds.getMinY());
        stage.setWidth(bounds.getWidth());
        stage.setHeight(bounds.getHeight());
        stage.show();
    }

    public void runR(TextField mean1, TextField sd1, TextField mean2, TextField sd2, VBox page, VBox Key) {
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
            //page.getChildren().set(6, graphBox);

            StackPane SgraphBox = new StackPane();
            SgraphBox.getChildren().addAll(graphBox, Key);
            StackPane.setAlignment(graphBox, Pos.CENTER);
            page.getChildren().set(6, SgraphBox);
        }
        catch (Exception ex) {
        }
    }

    public VBox createSuggestionKey(Stage stage){
        VBox suggestionBox = new VBox();
        try {
            //VBox suggestionBox = new VBox();
            TextFlow tf_sugestion = new TextFlow();
            tf_sugestion.setLineSpacing(20);
            tf_sugestion.setPrefWidth(stage.getWidth() - 100);

            tf_sugestion.setPadding(new Insets(115, 50, 0, 3 * (stage.getWidth() / 4)));
            Text colorKey = new Text("green = accept the null hypothesis \nred = reject the null hypothesis \n \n");
            colorKey.setFont(Font.font("Verdana", 15));
            Text suggestion1 = new Text("Suggestions to try");
            suggestion1.setFont(Font.font("Verdana", 15));
            suggestion1.setUnderline(true);
            Text suggestion1b = new Text("\naccept the null hypothesis: \n");
            suggestion1b.setFont(Font.font("Verdana", 15));

            Text suggestionM1a = new Text("M");
            suggestionM1a.setFont(Font.font("Verdana", FontPosture.ITALIC, 15));
            Text suggestionM1asub = new Text("1");
            suggestionM1asub.setFont(Font.font("Verdana"));
            suggestionM1asub.setTranslateY(6);
            Text suggestionM1anum = new Text(" = 2, ");
            suggestionM1anum.setFont(Font.font("Verdana", 15));

            Text suggestionSD1a = new Text("s");
            suggestionSD1a.setFont(Font.font("Verdana", FontPosture.ITALIC, 15));
            Text suggestionSD1asub = new Text("1");
            suggestionSD1asub.setFont(Font.font("Verdana"));
            suggestionSD1asub.setTranslateY(6);
            Text suggestionSD1anum = new Text(" = 8;   ");
            suggestionSD1anum.setFont(Font.font("Verdana", 15));

            Text suggestionM2a = new Text("M");
            suggestionM2a.setFont(Font.font("Verdana", FontPosture.ITALIC, 15));
            Text suggestionM2asub = new Text("2");
            suggestionM2asub.setFont(Font.font("Verdana"));
            suggestionM2asub.setTranslateY(6);
            Text suggestionM2anum = new Text(" = 1, ");
            suggestionM2anum.setFont(Font.font("Verdana", 15));

            Text suggestionSD2a = new Text("s");
            suggestionSD2a.setFont(Font.font("Verdana", FontPosture.ITALIC, 15));
            Text suggestionSD2asub = new Text("2");
            suggestionSD2asub.setFont(Font.font("Verdana"));
            suggestionSD2asub.setTranslateY(6);
            Text suggestionSD2anum = new Text(" = 4");
            suggestionSD2anum.setFont(Font.font("Verdana", 15));

            Text suggestion2b = new Text("\nreject the null hypothesis: \n");
            suggestion2b.setFont(Font.font("Verdana", 15));

            Text suggestionM1b = new Text("M");
            suggestionM1b.setFont(Font.font("Verdana", FontPosture.ITALIC, 15));
            Text suggestionM1bsub = new Text("1");
            suggestionM1bsub.setFont(Font.font("Verdana"));
            suggestionM1bsub.setTranslateY(6);
            Text suggestionM1bnum = new Text(" = 3, ");
            suggestionM1bnum.setFont(Font.font("Verdana", 15));

            Text suggestionSD1b = new Text("s");
            suggestionSD1b.setFont(Font.font("Verdana", FontPosture.ITALIC, 15));
            Text suggestionSD1bsub = new Text("1");
            suggestionSD1bsub.setFont(Font.font("Verdana"));
            suggestionSD1bsub.setTranslateY(6);
            Text suggestionSD1bnum = new Text(" = 3;   ");
            suggestionSD1bnum.setFont(Font.font("Verdana", 15));

            Text suggestionM2b = new Text("M");
            suggestionM2b.setFont(Font.font("Verdana", FontPosture.ITALIC, 15));
            Text suggestionM2bsub = new Text("2");
            suggestionM2bsub.setFont(Font.font("Verdana"));
            suggestionM2bsub.setTranslateY(6);
            Text suggestionM2bnum = new Text(" = 1, ");
            suggestionM2bnum.setFont(Font.font("Verdana", 15));

            Text suggestionSD2b = new Text("s");
            suggestionSD2b.setFont(Font.font("Verdana", FontPosture.ITALIC, 15));
            Text suggestionSD2bsub = new Text("2");
            suggestionSD2bsub.setFont(Font.font("Verdana"));
            suggestionSD2bsub.setTranslateY(6);
            Text suggestionSD2bnum = new Text(" = 4");
            suggestionSD2bnum.setFont(Font.font("Verdana", 15));


            tf_sugestion.getChildren().addAll(colorKey, suggestion1, suggestion1b, suggestionM1a, suggestionM1asub, suggestionM1anum, suggestionSD1a, suggestionSD1asub, suggestionSD1anum, suggestionM2a, suggestionM2asub, suggestionM2anum, suggestionSD2a, suggestionSD2asub, suggestionSD2anum, suggestion2b, suggestionM1b, suggestionM1bsub, suggestionM1bnum, suggestionSD1b, suggestionSD1bsub, suggestionSD1bnum, suggestionM2b, suggestionM2bsub, suggestionM2bnum, suggestionSD2b, suggestionSD2bsub, suggestionSD2bnum);
            suggestionBox.getChildren().add(tf_sugestion);

            //StackPane.setAlignment(suggestionBox, Pos.CENTER_RIGHT);
            return suggestionBox;
        }
        catch (Exception ex) {
            return suggestionBox;
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
