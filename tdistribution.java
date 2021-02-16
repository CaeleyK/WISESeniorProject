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
        Text info = new Text("Description of t-distributions");
        infoBox.getChildren().add(info);
        infoBox.setAlignment(Pos.CENTER);
        page.getChildren().add(infoBox);

        //create box for formula
        VBox formulaBox = new VBox();
        Image formula = new Image(new FileInputStream("/Users/caeleykardell/IdeaProjects/HomePage/MainDirectory/Screen Shot 2020-11-01 at 10.33.45 PM.png"));
        ImageView formula1 = new ImageView(formula);
        formulaBox.getChildren().add(formula1);
        formula1.setPreserveRatio(true);
        formula1.setFitHeight(100);
        formulaBox.setAlignment(Pos.CENTER);
        page.getChildren().add(formulaBox);

        //graph for interactive aspect
        VBox graphBox = new VBox();
        Image graph = new Image(new FileInputStream("/Users/caeleykardell/IdeaProjects/HomePage/MainDirectory/My Plot.png"));
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

        ScrollPane sp = new ScrollPane();
        sp.setContent(page);
        sp.setFitToHeight(true);
        sp.setFitToWidth(true);
        Scene s = new Scene(sp, Color.LIGHTSKYBLUE);
        ps.setMaximized(true);
        ps.setScene(s);
        ps.show();
    }

    public void runR(TextField n, VBox page) {
        //check to see if taking user input
        System.out.println(n.getText());
        try {
            //write n to file for R to read
            FileWriter fw = new FileWriter(new File("/Users/caeleykardell/Desktop/test2"), false);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(n.getText());
            pw.close();

            //run R
            String[]  s = new String[]{(String) n.getText()};
            File file = new File("/Users/caeleykardell/IdeaProjects/tDistribution/src/FINALnormalandtdistribution.R");
            file.setExecutable(true, true);
            Process p = Runtime.getRuntime().exec("Rscript /Users/caeleykardell/IdeaProjects/tDistribution/src/FINALnormalandtdistribution.R");
            p.waitFor();

            //display results
            VBox testBox = new VBox();
            Image testI = new Image(new FileInputStream("/Users/caeleykardell/Desktop/My Plot.png"));
            ImageView graphIV = new ImageView(testI);
            page.getChildren().add(graphIV);
        }
        catch (Exception ex) {
        }
    }

    public void backToHome(Stage t) {
        //t.show();
        Home h2 = new Home();
        try {
            //ps.close();
            h2.assembleHP(t);
            //ps.close();
        }
        catch (Exception ex) {

        }
    }
}
