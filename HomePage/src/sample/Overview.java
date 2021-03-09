package sample;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;

public class Overview {
    public Overview(Stage stage) {
        runOverview(stage);
    }

    public void runOverview(Stage stage) {
        //create VBox for page
        VBox page = new VBox();
        page.setSpacing(200);
        page.setBackground(new Background(new BackgroundFill(Color.AZURE, CornerRadii.EMPTY, Insets.EMPTY)));
        HBox titleBox = new HBox();
        titleBox.setSpacing(350);
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

        titleBox.getChildren().add(back);

        //create title for page
        Text title = new Text("Overview of Hypothesis Testing");
        title.setFont(Font.font ("Verdana", FontWeight.BOLD, 30));
        titleBox.getChildren().add(title);
        titleBox.setAlignment(Pos.TOP_LEFT);
        page.getChildren().add(titleBox);

        //create box for description
        VBox infoBox = new VBox();
        Text info = new Text("Content");
        infoBox.getChildren().add(info);
        infoBox.setAlignment(Pos.CENTER);
        page.getChildren().add(infoBox);

        //set scene
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
        stage.setScene(s);
        stage.setMaximized(true);
        //stage.setWidth(width);
        //stage.setHeight(height);
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
