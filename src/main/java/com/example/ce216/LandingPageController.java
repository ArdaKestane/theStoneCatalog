package com.example.ce216;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LandingPageController  {

    @FXML
    private VBox root;

    @FXML
    private StackPane stackPane;

    @FXML
    private VBox vBox;

    @FXML
    private Button button;

    @FXML
    private Button button2;


    @FXML
    private Pane pane1;

    @FXML
    private Pane pane2;

    @FXML
    private Button add;

    @FXML
    private Button edit;

    @FXML
    private Button delete;

    @FXML
    private Button search;

    @FXML
    public void starter(){
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(2),vBox);
        translateTransition.setToX(-root.getPrefWidth()/2+vBox.getPrefWidth()/2);
        translateTransition.play();

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1.5),stackPane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();

        button.setVisible(false);
        button2.setVisible(false);

        add.setVisible(true);
        edit.setVisible(true);
        delete.setVisible(true);
        search.setVisible(true);

 }

 @FXML
    public void nextPage(){
        pane1.setVisible(false);
        pane2.setVisible(true);
     button.setStyle("-fx-background-radius: 100; -fx-background-color: white; -fx-border-color: black;-fx-border-radius:100; -fx-border-width:3");
     button2.setStyle("-fx-background-radius: 100; -fx-background-color: black; -fx-border-color: black;-fx-border-radius:100; -fx-border-width:3");
 }

 @FXML
    public void previousPage(){
        pane2.setVisible(false);
        pane1.setVisible(true);
     button.setStyle("-fx-background-radius: 100; -fx-background-color: black; -fx-border-color: black;-fx-border-radius:100; -fx-border-width:3");
     button2.setStyle("-fx-background-radius: 100; -fx-background-color: white; -fx-border-color: black;-fx-border-radius:100; -fx-border-width:3");
 }

    public void setLandingPage(ActionEvent actionEvent) {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("LandingPage.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
        stage.show();
    }
}
