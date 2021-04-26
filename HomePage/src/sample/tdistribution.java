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

public class tdistribution {

    public tdistribution(Stage ps) {
        try {
            //ps.setMaximized(true);
            runTPage(ps);
        }
        catch(Exception ex) {
            System.out.println("file not found");
        }
    }

    public void runTPage(Stage ps) throws FileNotFoundException {
        //create VBox for page
        VBox page = new VBox();
        page.setSpacing(80);
        page.setBackground(new Background(new BackgroundFill(Color.AZURE, CornerRadii.EMPTY, Insets.EMPTY)));
        VBox backBox = new VBox();
        backBox.setAlignment(Pos.TOP_LEFT);
        Button back = new Button("Back to Homepage");

        back.setOnMousePressed(event -> backToHome(ps));
        backBox.getChildren().add(back);

        //create title for page
        Text title = new Text("Introduction to t-distributions");
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
        tf.setPrefWidth(ps.getWidth()-100);
        tf.setPadding(new Insets(0,50, 0, 50));

        //create box for info
        VBox infoBox = new VBox();
        Text info = new Text("When you do not know the mean and standard deviation of a population, you can use a t-distribution to estimate what the population distribution looks like.  A t-distribution is the equivalent of taking a sample from a normally distributed population where the null hypothesis is true.  On other pages of this app, you will be placing your test statistic on various t-distributions in order to determine if your sample aligns with the null hypothesis.  As the sample size of a t-distribution gets larger, the shape becomes more similar to a normal distribution.  When your sample size is smaller, the t-distribution gives a more accurate depiction of your data because the t-distribution is more spread out than the normal distribution at lower sample sizes.  Try placing different sample sizes for your t-distribution into the box and watch as the shape of the t-distribution changes in relation to a normal distribution.");
        info.setFont(Font.font("Verdana", 20));
        tf.getChildren().add(info);
        tfBox.getChildren().add(tf);
        VBox.setMargin(tfBox, new Insets(0,50, 0, 50));
        page.getChildren().add(tfBox);

        //create box for formula
        VBox formulaBox = new VBox();
        Image formula = new Image(new FileInputStream(System.getProperty("user.dir") + "/MainDirectory/tdistributionFormula.png"));
        ImageView formula1 = new ImageView(formula);
        formulaBox.getChildren().add(formula1);
        formula1.setPreserveRatio(true);
        formula1.setFitHeight(150);
        formulaBox.setAlignment(Pos.CENTER);
        page.getChildren().add(formulaBox);

        //graph for interactive aspect
        VBox graphBox = new VBox();
        Image graph = new Image(new FileInputStream(System.getProperty("user.dir") + "/MainDirectory/tdistributionPlot.png"));
        ImageView graphIV = new ImageView(graph);
        graphBox.getChildren().add(graphIV);
        graphIV.setPreserveRatio(true);
        graphIV.setFitHeight(500);
        graphBox.setAlignment(Pos.CENTER);
        //page.getChildren().add(graphBox);

        StackPane SgraphBox = new StackPane();
        SgraphBox.getChildren().addAll(graphBox, createSuggestionKey(ps));
        StackPane.setAlignment(graphBox, Pos.CENTER);
        page.getChildren().add(SgraphBox);

        //create interactive aspect
        TextFlow tf1 = new TextFlow();
        Text prompt1 = new Text("Enter sample size (");
        Text prompt2 = new Text("n");
        Text prompt3 = new Text("): ");
        prompt1.setFont(Font.font("Verdana",  20));
        prompt2.setFont(Font.font("Verdana", FontPosture.ITALIC, 20));
        prompt3.setFont(Font.font("Verdana",  20));
        tf1.getChildren().addAll(prompt1, prompt2, prompt3);
        javafx.scene.control.TextField t = new TextField();
        HBox interactiveAspect = new HBox();
        interactiveAspect.getChildren().add(tf1);
        interactiveAspect.getChildren().add(t);
        interactiveAspect.setAlignment(Pos.CENTER);
        interactiveAspect.setSpacing(10);
        VBox.setMargin(interactiveAspect, new Insets(0, 0, 50, 0));
        page.getChildren().add(interactiveAspect);

        javafx.scene.control.Button Enter = new javafx.scene.control.Button("Enter");
        interactiveAspect.getChildren().add(Enter);
        Enter.setOnMousePressed(event -> runR(t, page, createSuggestionKey(ps)));
        Enter.setOnKeyPressed(new EventHandler<KeyEvent>() {@Override
        public void handle(KeyEvent k) {
            if (k.getCode().equals(KeyCode.ENTER)) {
                runR(t, page, createSuggestionKey(ps));
            }
        }
        });
        interactiveAspect.setOnKeyReleased(event -> {if (event.getCode() == KeyCode.ENTER) {runR(t, page, createSuggestionKey(ps));}});

        ScrollPane sp = new ScrollPane();
        sp.setContent(page);
        sp.fitToWidthProperty().set(true);
        sp.fitToHeightProperty().set(true);
        sp.setPrefViewportWidth(ps.getWidth());
        sp.setPrefViewportHeight(ps.getHeight());
        sp.vbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.ALWAYS);
        Scene s = new Scene(sp, Color.LIGHTSKYBLUE);
        ps.setScene(s);

        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        ps.setX(bounds.getMinX());
        ps.setY(bounds.getMinY());
        ps.setWidth(bounds.getWidth());
        ps.setHeight(bounds.getHeight());

        ps.show();
    }

    public void runR(TextField n, VBox page, VBox Key) {
        //check to see if taking user input
        System.out.println(n.getText());
        /*if (!(Double.parseDouble(n.getText()) >= 1)) {
            VBox pop = new VBox();
            Text errorMessage = new Text("Please enter a positive whole number");
            pop.getChildren().add(errorMessage);
            pop.setAlignment(Pos.CENTER);
            Scene popup = new Scene(pop);
            Stage popS = new Stage();
            popS.setScene(popup);
            popS.setWidth(100);
            popS.setWidth(100);
            popS.show();
        }
        */
        try {
            //write n to file for R to read
            FileWriter fw = new FileWriter(new File(System.getProperty("user.dir") + "/MainDirectory/tdistributionFile"), false);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(n.getText());
            pw.close();

            //run R
            String[]  s = new String[]{(String) n.getText()};
            File file = new File(System.getProperty("user.dir") + "/MainDirectory/tdistributionRcode.R");
            file.setExecutable(true, true);
            Process p = Runtime.getRuntime().exec("Rscript " + System.getProperty("user.dir") + "/MainDirectory/tdistributionRcode.R");
            p.waitFor();

            //display results
            Image testI = new Image(new FileInputStream(System.getProperty("user.dir") + "/MainDirectory/tdistributionPlot.png"));
            ImageView graphIV = new ImageView(testI);
            VBox graphBox = new VBox();
            graphBox.getChildren().add(graphIV);
            graphIV.setPreserveRatio(true);
            graphIV.setFitHeight(500);
            graphBox.setAlignment(Pos.CENTER);
            //page.getChildren().set(4, graphBox);

            StackPane SgraphBox = new StackPane();
            SgraphBox.getChildren().addAll(graphBox, Key);
            StackPane.setAlignment(graphBox, Pos.CENTER);
            page.getChildren().set(4, SgraphBox);


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
            Text suggestion1 = new Text("Suggestions to try");
            suggestion1.setFont(Font.font("Verdana", 15));
            suggestion1.setUnderline(true);
            Text suggestionn1 = new Text("\n \nn");
            suggestionn1.setFont(Font.font("Verdana", FontPosture.ITALIC, 15));
            Text suggestionn1b = new Text(" = 5\n");
            suggestionn1b.setFont(Font.font("Verdana", 15));
            Text suggestionn2 = new Text("n");
            suggestionn2.setFont(Font.font("Verdana", FontPosture.ITALIC, 15));
            Text suggestionn2b = new Text(" = 2\n");
            suggestionn2b.setFont(Font.font("Verdana", 15));
            Text suggestionn3 = new Text("n");
            suggestionn3.setFont(Font.font("Verdana", FontPosture.ITALIC, 15));
            Text suggestionn3b = new Text(" = 8");
            suggestionn3b.setFont(Font.font("Verdana", 15));
            tf_sugestion.getChildren().addAll(suggestion1, suggestionn1, suggestionn1b, suggestionn2, suggestionn2b, suggestionn3, suggestionn3b);
            suggestionBox.getChildren().add(tf_sugestion);

            //StackPane.setAlignment(suggestionBox, Pos.CENTER_RIGHT);
            return suggestionBox;
        }
        catch (Exception ex) {
            return suggestionBox;
        }
    }

    public void backToHome(Stage t) {
        //t.show();
        Home h2 = new Home();
        try {
            //ps.close();
            //t.setMaximized(true);
            h2.assembleHP(t);
            //ps.close();
        }
        catch (Exception ex) {

        }
    }
}
