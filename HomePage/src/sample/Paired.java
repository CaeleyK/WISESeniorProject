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
import javafx.stage.Screen;
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
        page.setSpacing(80);
        page.setBackground(new Background(new BackgroundFill(Color.AZURE, CornerRadii.EMPTY, Insets.EMPTY)));
        VBox backBox = new VBox();
        backBox.setAlignment(Pos.TOP_LEFT);
        //create back button
        Button back = new Button("Back to Homepage");
        backBox.getChildren().add(back);
        back.setOnMousePressed(event -> backToHome(stage));

        //create title for page
        Text title = new Text("Paired Samples Test");
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
        Text info1 = new Text("A paired samples t-test is used when you are collecting two data points from the same subject.  These may be two data points collected at two different points in time or two data points collected in two different conditions.  An example where you would use a paired samples t-test is: Do students’ heart rates change after consuming caffeine?  This is considered a two-tailed test because your question is nondirectional.  Here are the different forms of hypotheses that you may test with a paired samples t-test:" + "\n" + "\n" +
                "Directional 1: testing to see if the sample mean is lower at time point 1 (condition 1) than time point 2 (condition 2)" + "\n" +
                "Directional 2: testing to see if the sample mean is higher at time point 1 (condition 1) than time point 2 (condition 2)" + "\n" +
                "Nondirectional: testing to see if the sample mean is different at time point 2 than time point 1" + "\n" + "\n" +
                "Before you calculate the test statistic for a paired samples t-test, you will need to find the difference score for each subject.  For every subject, the difference score can be calculated by subtracting data point 1 from data point 2.  To calculate the test statistic, you can then use this equation.");
        info1.setFont(Font.font("Verdana", 20));
        tf1.getChildren().add(info1);
        tfBox1.getChildren().add(tf1);
        VBox.setMargin(tfBox1, new Insets(0,50, 0, 50));
        page.getChildren().add(tfBox1);

        //create box for formula
        VBox formulaBox = new VBox();
        Image formula = new Image(new FileInputStream(System.getProperty("user.dir") + "/MainDirectory/PairedFormula.png"));
        ImageView formula1 = new ImageView(formula);
        formulaBox.getChildren().add(formula1);
        formula1.setPreserveRatio(true);
        formula1.setFitHeight(150);
        formulaBox.setAlignment(Pos.CENTER);
        page.getChildren().add(formulaBox);

        //insert key
        VBox keyBox = new VBox();
        Image key1 = new Image(new FileInputStream(System.getProperty("user.dir") + "/MainDirectory/PairedKey.png"));
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
        Text step2info = new Text("Take your test statistic that you calculated in step 3 and compare it to the critical value that you found in step 4.  ");
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
        //insert rejection region inequality

        Text info4 = new Text("Below is an example of a two-tailed paired samples t-test.  You can enter the mean and standard deviation for your difference scores and see the distribution generate below.  This visual is assuming a constant sample size of 100 subjects.  The mean of your difference scores is being compared to a set value of 0, which represents the null hypothesis.  In the case of a paired samples t-test, the null hypothesis is that the difference scores between the two time points (or conditions) have an average of zero, which would mean that there are no differences over time (or across conditions).  If the distribution turns red, that means that you would reject your null hypothesis based off of the data." + "\n" + "\n" +
                "Are you more or less likely to reject the null when the mean of the difference scores increases?" + "\n" +
                "What about when it decreases?" + "\n" +
                "How does standard deviation affect whether or not you will reject your null hypothesis?");
        info4.setFont(Font.font("Verdana", 20));

        tf2.getChildren().addAll(info2, info2b, info2c, info2d, info2e, info2f, info2g, info2h, info2i, info2j, info2k, info2l, info2m, info4);
        tfBox2.getChildren().add(tf2);
        VBox.setMargin(tfBox2, new Insets(0,50, 0, 50));
        page.getChildren().add(tfBox2);


        //graph for interactive aspect
        VBox graphBox = new VBox();
        Image graph = new Image(new FileInputStream(System.getProperty("user.dir") + "/MainDirectory/Paired.png"));
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

        //create interactive aspect input n1
        //Text prompt_mean = new Text("Enter mean (M): ");
        //prompt_mean.setFont(Font.font("Verdana", 20));
        TextFlow prompt_mean = new TextFlow();
        Text promptM1 = new Text("Enter mean (");
        Text promptM2 = new Text("M");
        Text promptM3 = new Text("): ");
        promptM1.setFont(Font.font("Verdana",  20));
        promptM2.setFont(Font.font("Verdana", FontPosture.ITALIC, 20));
        promptM3.setFont(Font.font("Verdana",  20));
        prompt_mean.getChildren().addAll(promptM1, promptM2, promptM3);
        javafx.scene.control.TextField t_mean = new TextField();

        //Text prompt_sd = new Text("Enter standard deviation (sd): ");
        //prompt_sd.setFont(Font.font("Verdana", 20));
        TextFlow prompt_sd = new TextFlow();
        Text promptSD1 = new Text("Enter standard deviation (");
        Text promptSD2 = new Text("SD");
        Text promptSD3 = new Text("): ");
        promptSD1.setFont(Font.font("Verdana",  20));
        promptSD2.setFont(Font.font("Verdana", FontPosture.ITALIC, 20));
        promptSD3.setFont(Font.font("Verdana",  20));
        prompt_sd.getChildren().addAll(promptSD1, promptSD2, promptSD3);

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
        Enter.setOnMousePressed(event -> runR(t_mean, t_sd, page, createSuggestionKey(stage)));
        Enter.setOnKeyPressed(new EventHandler<KeyEvent>() {@Override
        public void handle(KeyEvent k) {
            if (k.getCode().equals(KeyCode.ENTER)) {
                runR(t_mean, t_sd, page, createSuggestionKey(stage));
            }
        }
        });
        Enter.setOnKeyReleased(event -> {if (event.getCode() == KeyCode.ENTER) {runR(t_mean, t_sd, page, createSuggestionKey(stage));}});


        //TextFlow 3
        TextFlow tf3 = new TextFlow();
        VBox tfBox3 = new VBox();
        tf3.setLineSpacing(20);
        tfBox3.setAlignment(Pos.CENTER);
        tf3.setPrefWidth(stage.getWidth()-100);
        tf3.setPadding(new Insets(0,50, 0, 50));

        //create box for info 2
        Text info5 = new Text("As you can see from this visual representation, you will be more likely to reject the null hypothesis (i.e. have 2 sets of time points or conditions with significantly different means) when the mean of your difference scores is farther from zero (in the positive or negative direction) and when the standard deviation of your difference scores is smaller.\n");
        info5.setFont(Font.font("Verdana", 20));

        tf3.getChildren().add(info5);
        tfBox3.getChildren().add(tf3);
        VBox.setMargin(tfBox3, new Insets(0,50, 50, 50));
        page.getChildren().add(tfBox3);

        //testing
        /*
        StackPane test = new StackPane();
        //StackPane.setMargin(test, new Insets(0,50, 50, 50));
        Image test1b = new Image(new FileInputStream(System.getProperty("user.dir") + "/MainDirectory/Paired.png"));
        ImageView test2b = new ImageView(test1b);
        test.getChildren().add(test2b);
        test2b.setPreserveRatio(true);
        test2b.setFitHeight(500);
        //StackPane.setAlignment(test, Pos.CENTER);
        StackPane.setAlignment(test2b, Pos.CENTER);


        VBox suggestionBox = new VBox();
        TextFlow tf_sugestion = new TextFlow();
        tf_sugestion.setLineSpacing(20);
        tf_sugestion.setPrefWidth(stage.getWidth()-100);

        tf_sugestion.setPadding(new Insets(0,50, 0, 3*(stage.getWidth()/4)));
        Text colorKey = new Text("green = accept the null hypothesis \nred = reject the null hypothesis \n \n");
        colorKey.setFont(Font.font("Verdana", 15));
        Text suggestion1 = new Text("Suggestions to try");
        suggestion1.setFont(Font.font("Verdana", 15));
        suggestion1.setUnderline(true);
        Text suggestion1b = new Text("\naccept the null hypothesis: \n");
        suggestion1b.setFont(Font.font("Verdana", 15));
        Text suggestionM1 = new Text("M");
        suggestionM1.setFont(Font.font("Verdana", FontPosture.ITALIC, 15));
        Text suggestionM1b = new Text(" = .5, ");
        suggestionM1b.setFont(Font.font("Verdana", 15));
        Text suggestionSD1 = new Text("SD");
        suggestionSD1.setFont(Font.font("Verdana", FontPosture.ITALIC, 15));
        Text suggestionSD1b = new Text(" = 2 \n");
        suggestionSD1b.setFont(Font.font("Verdana", 15));
        Text suggestion2 = new Text("reject the null hypothesis: \n");
        suggestion2.setFont(Font.font("Verdana", 15));
        Text suggestionM2 = new Text("M");
        suggestionM2.setFont(Font.font("Verdana", FontPosture.ITALIC, 15));
        Text suggestionM2b = new Text(" = .5, ");
        suggestionM2b.setFont(Font.font("Verdana", 15));
        Text suggestionSD2 = new Text("SD");
        suggestionSD2.setFont(Font.font("Verdana", FontPosture.ITALIC, 15));
        Text suggestionSD2b = new Text(" = 10");
        suggestionSD2b.setFont(Font.font("Verdana", 15));
        tf_sugestion.getChildren().addAll(colorKey, suggestion1, suggestion1b, suggestionM1, suggestionM1b, suggestionSD1, suggestionSD1b, suggestion2, suggestionM2, suggestionM2b, suggestionSD2, suggestionSD2b);
        suggestionBox.getChildren().add(tf_sugestion);

        //StackPane.setAlignment(suggestionBox, Pos.CENTER_RIGHT);
        test.getChildren().add(suggestionBox);
        StackPane.setAlignment(suggestionBox, Pos.CENTER_RIGHT);
        //StackPane.setMargin(tf_sugestion, new Insets(0,50, 50, 50));
        page.getChildren().add(test);

         */


        //scroll
        ScrollPane sp = new ScrollPane();
        sp.setContent(page);
        sp.fitToWidthProperty().set(true);
        sp.fitToHeightProperty().set(true);
        sp.setPrefViewportWidth(stage.getWidth());
        sp.setPrefViewportHeight(stage.getHeight());
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

    public void runR(TextField mean, TextField sd, VBox page, VBox Key) {
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
            //page.getChildren().set(6, graphBox);

            StackPane SgraphBox = new StackPane();
            SgraphBox.getChildren().addAll(graphBox, Key);
            StackPane.setAlignment(graphBox, Pos.CENTER);
            //StackPane.setAlignment(suggestionBox);
            //page.getChildren().add(SgraphBox);
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
            Text suggestionM1 = new Text("M");
            suggestionM1.setFont(Font.font("Verdana", FontPosture.ITALIC, 15));
            Text suggestionM1b = new Text(" = .5, ");
            suggestionM1b.setFont(Font.font("Verdana", 15));
            Text suggestionSD1 = new Text("SD");
            suggestionSD1.setFont(Font.font("Verdana", FontPosture.ITALIC, 15));
            Text suggestionSD1b = new Text(" = 10 \n");
            suggestionSD1b.setFont(Font.font("Verdana", 15));
            Text suggestion2 = new Text("reject the null hypothesis: \n");
            suggestion2.setFont(Font.font("Verdana", 15));
            Text suggestionM2 = new Text("M");
            suggestionM2.setFont(Font.font("Verdana", FontPosture.ITALIC, 15));
            Text suggestionM2b = new Text(" = .5, ");
            suggestionM2b.setFont(Font.font("Verdana", 15));
            Text suggestionSD2 = new Text("SD");
            suggestionSD2.setFont(Font.font("Verdana", FontPosture.ITALIC, 15));
            Text suggestionSD2b = new Text(" = 2");
            suggestionSD2b.setFont(Font.font("Verdana", 15));
            tf_sugestion.getChildren().addAll(colorKey, suggestion1, suggestion1b, suggestionM1, suggestionM1b, suggestionSD1, suggestionSD1b, suggestion2, suggestionM2, suggestionM2b, suggestionSD2, suggestionSD2b);
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
            //t.setMaximized(true);
            h2.assembleHP(t);
        }
        catch (Exception ex) {
        }
    }
}
