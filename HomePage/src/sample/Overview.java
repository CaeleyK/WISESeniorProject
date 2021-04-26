package sample;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Overview {
    public Overview(Stage stage) {
        try {
            runOverview(stage);
        }
        catch (Exception ex) {

        }
    }

    public void runOverview(Stage stage) throws FileNotFoundException {
        //create VBox for page
        VBox page = new VBox();
        page.setSpacing(80);
        page.setBackground(new Background(new BackgroundFill(Color.AZURE, CornerRadii.EMPTY, Insets.EMPTY)));


        VBox backBox = new VBox();
        backBox.setAlignment(Pos.TOP_LEFT);
        Button back = new Button("Back to Homepage");

        back.setOnMousePressed(event -> backToHome(stage));
        back.setOnKeyPressed(new EventHandler<KeyEvent>() {@Override
        public void handle(KeyEvent k) {
            if (k.getCode().equals(KeyCode.ENTER)) {
                backToHome(stage);
            }
        }
        });
        back.setOnKeyReleased(event -> {if (event.getCode() == KeyCode.ENTER) {backToHome(stage);}});

        backBox.getChildren().add(back);

        //create title for page
        Text title = new Text("Overview of Hypothesis Testing");
        title.setFont(Font.font ("Verdana", FontWeight.BOLD, 30));
        VBox titleBox = new VBox();
        titleBox.getChildren().add(title);
        titleBox.setAlignment(Pos.CENTER);
        page.getChildren().add(backBox);
        page.getChildren().add(titleBox);

        TextFlow tf = new TextFlow();
        VBox tfBox = new VBox();
        tf.setLineSpacing(20);
        tfBox.setAlignment(Pos.CENTER);
        tf.setPrefWidth(stage.getWidth()-100);
        tf.setPadding(new Insets(0,50, 0, 50));

        //create box for intro
        Text intro = new Text("In the 6th Edition of ");
        intro.setFont(Font.font("Verdana", 20));
        Text intro2 = new Text("Statistics for Psychology,");
        intro2.setFont(Font.font("Verdana", FontPosture.ITALIC, 20));
        Text intro3 = new Text(" hypothesis testing is defined as “a systematic procedure for deciding whether the results of a research study, which examines a sample, support a hypothesis which applies to a population” (Aron, Aron, & Coups, 2006).  In other words, hypothesis testing is a useful tool in psychology which allows you to test whether or not your research question is likely to be true, or if your research hypothesis is supported by your data.  Before you explore some of the different testing options, we would like to give you a brief overview of the steps of hypothesis testing to help orient you to the process." + "\n" + "\n" +
                "Aron, A., Aron, E., & Coups, E. J. (2006). ");
        intro3.setFont(Font.font("Verdana", 20));
        Text intro4 = new Text("Statistics for psychology. ");
        intro4.setFont(Font.font("Verdana", FontPosture.ITALIC,20));
        Text intro5 = new Text("Upper Saddle River, N.J: Pearson Education." + "\n" + "\n");
        intro5.setFont(Font.font("Verdana", 20));
        tf.getChildren().addAll(intro, intro2, intro3, intro4, intro5);

        //Step 1: title
        Text step1Title = new Text("Step 1: Define a research and null hypothesis" + "\n");
        step1Title.setFont(Font.font ("Verdana", FontWeight.BOLD, 20));
        tf.getChildren().add(step1Title);


        //step 1: research hypothesis
        Text altHyp = new Text("Research (alternative) hypothesis:");
        altHyp.setFont(Font.font("Verdana", 20));
        altHyp.setUnderline(true);
        Text altHyp2 = new Text(" H");
        altHyp2.setFont(Font.font("Verdana", 20));
        Text sub1 = new Text("1");
        sub1.setFont(Font.font("Verdana"));
        sub1.setTranslateY(6);
        Text altHyp3 = new Text(": This is the specific prediction that you will be testing and can be directional or nondirectional.  There are two types of directional hypotheses.  Below are examples of the three cases of research hypotheses:" + "\n" + "\n");
        altHyp3.setFont(Font.font("Verdana", 20));
        tf.getChildren().addAll(altHyp, altHyp2, sub1, altHyp3);


        //step 1: Directional 1
        Text dir1_1 = new Text("Directional 1: “Students with a pet dog ");
        dir1_1.setFont(Font.font("Verdana", 20));
        Text dir1_2 = new Text("report lower");
        dir1_2.setFont(Font.font("Verdana", FontPosture.ITALIC, 20));
        Text dir1_3 = new Text(" levels of stress than students who do not have a pet dog.”" + "\n");
        dir1_3.setFont(Font.font("Verdana", 20));
        tf.getChildren().addAll(dir1_1, dir1_2, dir1_3);


        //step 1: Directional 2
        Text dir2_1 = new Text("Directional 2: “Students with a pet dog ");
        dir2_1.setFont(Font.font("Verdana", 20));
        Text dir2_2 = new Text("report higher");
        dir2_2.setFont(Font.font("Verdana", FontPosture.ITALIC, 20));
        Text dir2_3 = new Text(" levels of stress than students who do not have a pet dog.”" + "\n");
        dir2_3.setFont(Font.font("Verdana", 20));
        tf.getChildren().addAll(dir2_1, dir2_2, dir2_3);

        //step 1: Nondirectional
        Text nondir1 = new Text("Nondirectional: “Students with a pet dog ");
        nondir1.setFont(Font.font("Verdana", 20));
        Text nondir2 = new Text("do report different");
        nondir2.setFont(Font.font("Verdana", FontPosture.ITALIC, 20));
        Text nondir3 = new Text(" levels of stress than students who do not have a pet dog.”" + "\n" + "\n");
        nondir3.setFont(Font.font("Verdana", 20));
        tf.getChildren().addAll(nondir1, nondir2, nondir3);

        //step 1: info3
        Text step1info = new Text("Since this app focuses on t-testing, if you are testing a directional hypothesis, you will need to use a one-tailed t-test.  If you are testing a nondirectional hypothesis, you will need to use a two-tailed t-test." + "\n" + "\n");
        step1info.setFont(Font.font("Verdana", 20));
        tf.getChildren().add(step1info);

        //tf.setPrefWidth(stage.getWidth()-100);
        //tf.setPadding(new Insets(0,50, 0, 50));
        //beforeChartBox.getChildren().add(tf);
        //VBox.setMargin(beforeChartBox, new Insets(0,50, 0, 50));
        //page.getChildren().add(beforeChartBox);

        //step 1: null hypothesis
        Text nullHyp = new Text("Null hypothesis:");
        nullHyp.setFont(Font.font("Verdana", 20));
        nullHyp.setUnderline(true);
        Text nullHyp2 = new Text(" H");
        nullHyp2.setFont(Font.font("Verdana", 20));
        Text sub0 = new Text("0");
        sub0.setFont(Font.font("Verdana"));
        sub0.setTranslateY(6);
        Text nullHyp3 = new Text(": This is the opposite of your research hypothesis and assumes that there is not a statistically significant difference between two groups (in the case of t-testing).  Assuming that you decided to use the nondirectional hypothesis, the null hypothesis here would be “Students who have a pet dog do not report different levels of stress than students who do not have a pet dog.”  If the results of your experiment are statistically significant (i.e. the data shows that students with dogs do have lower levels of stress), you can “reject” your null hypothesis." + "\n" + "\n");
        nullHyp3.setFont(Font.font("Verdana", 20));
        tf.getChildren().addAll(nullHyp, nullHyp2, sub0, nullHyp3);


        //Step 2: title
        Text step2Title = new Text("Step 2: Define your level of significance" + "\n" + "\n");
        step2Title.setFont(Font.font ("Verdana", FontWeight.BOLD, 20));
        tf.getChildren().add(step2Title);

        //step 2: info
        Text step2info = new Text("Your level of significance is also known as your alpha (" + "\u03B1" + ") value.  Your alpha value is the maximum probability that you will reject your null hypothesis and accept your research hypothesis when the null is actually true (i.e. a “false positive”).  A commonly used level of significance is .05.  If your alpha value is .05 and you accept your research hypothesis that students with dogs report different levels of stress, there is a 5% chance that your result was a “false positive” and that both groups of students (with and without dogs) exhibit no significant difference in their stress levels." + "\n" + "\n");
        step2info.setFont(Font.font("Verdana", 20));
        tf.getChildren().add(step2info);

        //step 3: title
        Text step3Title = new Text("Step 3: Calculate your test statistic" + "\n" + "\n");
        step3Title.setFont(Font.font ("Verdana", FontWeight.BOLD, 20));
        tf.getChildren().add(step3Title);

        //step 3: info1
        Text step3info1 = new Text("Your test statistic is a variable which you will calculate as a helpful point of comparison for use in later steps.  For now, it is just important to know that you will need to calculate it and keep that number in mind!  The equation for calculating a test statistic will be different depending on which statistical test you are using, but here are some symbols/variables that you will need to know to plug into the equations that you will find on each page of this app.");
        step3info1.setFont(Font.font("Verdana", 20));
        tf.getChildren().add(step3info1);

        tfBox.getChildren().add(tf);
        VBox.setMargin(tfBox, new Insets(0,50, 0, 50));
        page.getChildren().add(tfBox);

        //step 3: chart
        VBox chartBox = new VBox();
        Image chart1 = new Image(new FileInputStream(System.getProperty("user.dir") + "/MainDirectory/OverviewSymbols.png"));
        ImageView chart = new ImageView(chart1);
        chartBox.getChildren().add(chart);
        chart.setPreserveRatio(true);
        //chart.setFitHeight(250);
        chart.setFitWidth(stage.getWidth()-300);
        chartBox.setAlignment(Pos.CENTER);
        VBox.setMargin(chartBox, new Insets(0,50, 0, 50));
        page.getChildren().add(chartBox);

        //Textflow 2
        TextFlow tf2 = new TextFlow();
        VBox tfBox2 = new VBox();
        tf2.setLineSpacing(20);
        tfBox2.setAlignment(Pos.CENTER);
        tf2.setPrefWidth(stage.getWidth()-100);
        tf2.setPadding(new Insets(0,50, 0, 50));

        //step 3: info2
        Text step3info2 = new Text("Sample size: ");
        step3info2.setFont(Font.font("Verdana", 20));
        Text step3info2n = new Text("n \n \n");
        step3info2n.setFont(Font.font("Verdana", FontPosture.ITALIC, 20));
        tf2.getChildren().addAll(step3info2, step3info2n);

        //step 4: title
        Text step4Title = new Text("Step 4: Find your critical value" + "\n" + "\n");
        step4Title.setFont(Font.font ("Verdana", FontWeight.BOLD, 20));
        tf2.getChildren().add(step4Title);

        //step 4: critical value
        Text critVal = new Text("Critical value:");
        critVal.setFont(Font.font("Verdana", 20));
        critVal.setUnderline(true);
        Text critVal2 = new Text(" To find your critical value, you will need to know your alpha value and your sample size.  This value is the number that you will be comparing your test statistic to in the next step to determine the rejection region. The rejection region represents the range of test statistics which would yield a statistically significant result. \n \n");
        critVal2.setFont(Font.font("Verdana", 20));
        tf2.getChildren().addAll(critVal, critVal2);


        //step 5: title
        Text step5Title = new Text("Step 5: Use the rejection region to make a decision" + "\n" + "\n");
        step5Title.setFont(Font.font ("Verdana", FontWeight.BOLD, 20));
        tf2.getChildren().add(step5Title);

        //step 5: info
        Text step5info = new Text("Take your test statistic that you calculated in step 3 and compare it to the critical value that you found in step 4.  ");
        Text info5 = new Text("A larger alpha and larger sample size leads to a lower significance threshold, which means that the null is more likely to be rejected." + "\n" +
                "When comparing your calculated test statistic to your critical value, depending on your research hypothesis, the rejection regions that would lead you to reject your null hypothesis are: \n \n" +
                "Directional 1: ");
        Text info5b = new Text("test statistic");
        Text info5c = new Text(" \u2264 " + "–(");
        Text info5d = new Text("critical value");
        Text info5e = new Text(") \n");
        Text info5f = new Text("Directional 2: ");
        Text info5g = new Text("test statistic");
        Text info5h = new Text(" \u2265 ");
        Text info5i = new Text("critical value \n");
        Text info5j = new Text("Nondirectional: |");
        Text info5k = new Text("test statistic");
        Text info5l = new Text("|" + " \u2265 ");
        Text info5m = new Text("critical value \n \n");
        info5.setFont(Font.font("Verdana", 20));
        info5b.setFont(Font.font("Verdana", FontPosture.ITALIC, 20));
        info5c.setFont(Font.font("Verdana", 20));
        info5d.setFont(Font.font("Verdana", FontPosture.ITALIC, 20));
        info5e.setFont(Font.font("Verdana", 20));
        info5f.setFont(Font.font("Verdana", 20));
        info5g.setFont(Font.font("Verdana", FontPosture.ITALIC, 20));
        info5h.setFont(Font.font("Verdana", 20));
        info5i.setFont(Font.font("Verdana", FontPosture.ITALIC, 20));
        info5j.setFont(Font.font("Verdana", 20));
        info5k.setFont(Font.font("Verdana", FontPosture.ITALIC, 20));
        info5l.setFont(Font.font("Verdana", 20));
        info5m.setFont(Font.font("Verdana", FontPosture.ITALIC, 20));

        step5info.setFont(Font.font("Verdana", 20));
        tf2.getChildren().addAll(step5info, info5, info5b, info5c, info5d, info5e, info5f, info5g, info5h, info5i, info5j, info5k, info5l, info5m);

        //step 6: title
        Text step6Title = new Text("Step 6: Calculate and interpret your p-value (optional)" + "\n \n");
        step6Title.setFont(Font.font ("Verdana", FontWeight.BOLD, 20));
        tf2.getChildren().add(step6Title);

        //step 6: info
        Text step6info = new Text("The p-value measures the significance of your results.  The smaller your p-value, the greater the likelihood that your research hypothesis is true.  Since you already determined the outcome of your test in the previous step, you can use this to verify your calculations and get a better understanding of the significance of your results.  The p-values will be calculated for you on each page of this app. \n \n" +
                " If p " + "\u2264" + " \u03B1" + " then you reject your null hypothesis \n" +
                " If p >" + " \u03B1" + " then you accept your null hypothesis \n \n");
        step6info.setFont(Font.font("Verdana", 20));
        tf2.getChildren().add(step6info);

        //Error section
        Text error = new Text("When using t-tests (and hypothesis testing in general), there is always a chance that the conclusion you come to will not be correct.  A Type I error occurs when you incorrectly reject the null hypothesis (a false positive) and a Type II error occurs when you accept the null hypothesis but it is actually false.  Here is a helpful chart to clarify the difference between Type I and Type II errors:");
        error.setFont(Font.font("Verdana", 20));
        tf2.getChildren().add(error);

        tfBox2.getChildren().add(tf2);
        VBox.setMargin(tfBox2, new Insets(0,50, 0, 50));
        page.getChildren().add(tfBox2);

        //Error chart
        VBox errorChartBox = new VBox();
        Image chart2 = new Image(new FileInputStream(System.getProperty("user.dir") + "/MainDirectory/OverviewErrorChart.png"));
        ImageView errorChart = new ImageView(chart2);
        errorChartBox.getChildren().add(errorChart);
        errorChart.setPreserveRatio(true);
        //chart.setFitHeight(250);
        errorChart.setFitWidth(stage.getWidth()-300);
        errorChartBox.setAlignment(Pos.CENTER);
        VBox.setMargin(errorChartBox, new Insets(0,50, 50, 50));
        page.getChildren().add(errorChartBox);





        //set scene
        //VBox.setMargin(tfBox1, new Insets(0,50, 0, 50));
        ScrollPane sp = new ScrollPane();
        sp.setContent(page);
        sp.fitToWidthProperty().set(true);
        sp.fitToHeightProperty().set(true);
        sp.setPrefViewportWidth(stage.getWidth());
        sp.setPrefViewportHeight(stage.getHeight());
        sp.vbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.ALWAYS);
        Scene s = new Scene(sp, Color.LIGHTSKYBLUE);
        stage.setScene(s);
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        stage.setX(bounds.getMinX());
        stage.setY(bounds.getMinY());
        stage.setWidth(bounds.getWidth());
        stage.setHeight(bounds.getHeight());
        stage.show();
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
