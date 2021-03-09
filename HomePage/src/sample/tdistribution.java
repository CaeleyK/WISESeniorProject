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

public class tdistribution {

    public tdistribution(Stage ps) {
        try {
            ps.setMaximized(true);
            runTPage(ps);
        }
        catch(Exception ex) {
            System.out.println("file not found");
        }
    }

    public void runTPage(Stage ps) throws FileNotFoundException {
        //create VBox for page
        VBox page = new VBox();
        page.setSpacing(200);
        page.setBackground(new Background(new BackgroundFill(Color.AZURE, CornerRadii.EMPTY, Insets.EMPTY)));
        HBox titleBox = new HBox();
        titleBox.setSpacing(350);
        Button back = new Button("Back to Homepage");

        back.setOnMousePressed(event -> backToHome(ps));

        titleBox.getChildren().add(back);

        //create title for page
        Text title = new Text("Introduction to t-distributions");
        title.setFont(Font.font ("Verdana", FontWeight.BOLD, 30));
        titleBox.getChildren().add(title);
        titleBox.setAlignment(Pos.TOP_LEFT);
        page.getChildren().add(titleBox);

        //create box for description
        VBox infoBox = new VBox();
        //Text info = new Text("Description of t-distributions");
        Text info = new Text("When you do not know the mean and standard deviation of a population, you can use a t-distribution to estimate what the population distribution looks like.  A t-distribution is the equivalent of taking a sample from a normally distributed population where the null hypothesis is true.  On other pages of this app, you will be placing your test statistic on various t-distributions in order to determine if your sample aligns with the null hypothesis.  As the sample size of a t-distribution gets larger, the shape becomes more similar to a normal distribution.  When your sample size is smaller, the t-distribution gives a more accurate depiction of your data because the t-distribution is more spread out than the normal distribution at lower sample sizes.  Try placing different sample sizes for your t-distribution into the box and watch as the shape of the t-distribution changes in relation to a normal distribution.");
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
        Image graph = new Image(new FileInputStream(System.getProperty("user.dir") + "/MainDirectory/tdistributionPlot.png"));
        ImageView graphIV = new ImageView(graph);
        graphBox.getChildren().add(graphIV);
        graphIV.setPreserveRatio(true);
        graphIV.setFitHeight(500);
        graphBox.setAlignment(Pos.CENTER);
        page.getChildren().add(graphBox);

        //create interactive aspect
        Text prompt = new Text("Enter sample size (n): ");
        javafx.scene.control.TextField t = new TextField();
        HBox interactiveAspect = new HBox();
        interactiveAspect.getChildren().add(prompt);
        interactiveAspect.getChildren().add(t);
        interactiveAspect.setAlignment(Pos.CENTER);
        interactiveAspect.setSpacing(10);
        page.getChildren().add(interactiveAspect);

        javafx.scene.control.Button Enter = new javafx.scene.control.Button("Enter");
        interactiveAspect.getChildren().add(Enter);
        Enter.setOnMousePressed(event -> runR(t, page));
        Enter.setOnKeyPressed(new EventHandler<KeyEvent>() {@Override
        public void handle(KeyEvent k) {
            if (k.getCode().equals(KeyCode.ENTER)) {
                runR(t, page);
            }
        }
        });
        interactiveAspect.setOnKeyReleased(event -> {if (event.getCode() == KeyCode.ENTER) {runR(t, page);}});

        //create box for R-code
        VBox RBox = new VBox();
        Text R = new Text("R-code");
        RBox.getChildren().add(R);
        RBox.setAlignment(Pos.CENTER);
        page.getChildren().add(RBox);

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();
        ScrollPane sp = new ScrollPane();
        sp.setContent(page);
        sp.fitToWidthProperty().set(true);
        sp.fitToHeightProperty().set(true);
        sp.setPrefViewportWidth(ps.getWidth());
        sp.setPrefViewportHeight(ps.getHeight());
        Scene s = new Scene(sp, Color.LIGHTSKYBLUE);
        info.wrappingWidthProperty().bind(s.widthProperty().subtract(15));
        ps.setScene(s);
        ps.setMaximized(true);
        ps.show();
    }

    public void runR(TextField n, VBox page) {
        //check to see if taking user input
        System.out.println(n.getText());
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
            page.getChildren().set(3, graphBox);


        }
        catch (Exception ex) {
        }
    }

    public void backToHome(Stage t) {
        //t.show();
        Home h2 = new Home();
        try {
            //ps.close();
            t.setMaximized(true);
            h2.assembleHP(t);
            //ps.close();
        }
        catch (Exception ex) {

        }
    }
}
