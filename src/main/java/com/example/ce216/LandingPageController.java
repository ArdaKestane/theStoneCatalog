package com.example.ce216;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class LandingPageController {

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
    private Button contact;

    @FXML
    private Pane pane1;

    @FXML
    private Pane pane2;

    @FXML
    private Pane pane3;

    @FXML
    private Button add;

    @FXML
    private Button edit;

    @FXML
    private Button delete;

    @FXML
    private Button search;

    @FXML
    private Region region;

    @FXML
    private Button nextPage;

    @FXML
    private Button nextPage2;

    @FXML
    private Button prevPage;

    @FXML
    private Button prevPage2;


    @FXML
    private ImageView next;

    @FXML
    private ImageView prev;

    @FXML
    private Pane helpPane;

    @FXML
    private Pane helpPane2;


    @FXML
    private HBox hBoxClose;

    @FXML
    private Label mailLabel;

    @FXML
    private Pane generalHelp;

    @FXML
    private Pane addHelp;

    @FXML
    private Pane editHelp;

    @FXML
    private Pane deleteHelp;

    @FXML
    private Pane treeViewPane;

    @FXML
    private VBox vBox2;

    @FXML
    private Pane searchPane;



    @FXML
    public void starter() {
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(2), vBox);
        translateTransition.setToX(-root.getPrefWidth() / 2 + vBox.getWidth() / 2);
        translateTransition.play();

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1.5), vBox2);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();


        FadeTransition fadeTransition2 = new FadeTransition(Duration.seconds(0.6), pane1);
        fadeTransition2.setFromValue(1);
        fadeTransition2.setToValue(0);
        fadeTransition2.play();

        FadeTransition fadeTransition3 = new FadeTransition(Duration.seconds(0.6), pane2);
        fadeTransition3.setFromValue(1);
        fadeTransition3.setToValue(0);
        fadeTransition3.play();

        FadeTransition fadeTransition4 = new FadeTransition(Duration.seconds(0.6), pane3);
        fadeTransition4.setFromValue(0);
        fadeTransition4.setToValue(1);
        fadeTransition4.play();


        button.setVisible(false);
        button2.setVisible(false);

        add.setVisible(true);
        edit.setVisible(true);
        delete.setVisible(true);
        search.setVisible(true);

        treeViewPane.setVisible(true);
        FadeTransition fadeTransition5 = new FadeTransition(Duration.seconds(1.5), treeViewPane);
        fadeTransition5.setFromValue(0);
        fadeTransition5.setToValue(1);
        fadeTransition5.play();


    }

    @FXML
    public void nextPage() {

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.6), pane1);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();

        FadeTransition fadeTransition2 = new FadeTransition(Duration.seconds(0.6), pane2);
        fadeTransition2.setFromValue(0);
        fadeTransition2.setToValue(1);

        fadeTransition2.play();

        button.setStyle("-fx-background-radius: 100; -fx-background-color: white; -fx-border-color: black;-fx-border-radius:100; -fx-border-width:3");
        button2.setStyle("-fx-background-radius: 100; -fx-background-color: black; -fx-border-color: black;-fx-border-radius:100; -fx-border-width:3");


        pane2.toFront();
    }

    @FXML
    public void previousPage() {


        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.6), pane2);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();

        FadeTransition fadeTransition2 = new FadeTransition(Duration.seconds(0.6), pane1);
        fadeTransition2.setFromValue(0);
        fadeTransition2.setToValue(1);
        fadeTransition2.play();

        pane1.toFront();

        button.setStyle("-fx-background-radius: 100; -fx-background-color: black; -fx-border-color: black;-fx-border-radius:100; -fx-border-width:3");
        button2.setStyle("-fx-background-radius: 100; -fx-background-color: white; -fx-border-color: black;-fx-border-radius:100; -fx-border-width:3");
    }

    public void setLandingPage(ActionEvent actionEvent) {
        Stage stage = (Stage) pane1.getScene().getWindow();
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

    public void onHoverColor(){
       nextPage.setVisible(false);
       nextPage2.setVisible(true);
    }

    public void onHoverColorExit(){
        nextPage.setVisible(true);
        nextPage2.setVisible(false);
    }


    public void onHoverColor2(){
        prevPage.setVisible(false);
        prevPage2.setVisible(true);
    }

    public void onHoverColorExit2(){
        prevPage.setVisible(true);
        prevPage2.setVisible(false);
    }


    public void help(){

        helpPane.setVisible(true);
        hBoxClose.setOpacity(0.35);
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.6), helpPane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();

    }

    public void helpSecondPage(){
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.6), helpPane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();

        helpPane2.setVisible(true);
        FadeTransition fadeTransition2 = new FadeTransition(Duration.seconds(0.6), helpPane2);
        fadeTransition2.setFromValue(0);
        fadeTransition2.setToValue(1);
        fadeTransition2.play();

    }

    public void contact(){
        contact.setVisible(false);
        mailLabel.setVisible(true);
    }

    public void contact2(){
        contact.setVisible(true);
        mailLabel.setVisible(false);
    }

    public void closeAllHelp(){
        generalHelp.setVisible(false);

        FadeTransition fadeTransition2 = new FadeTransition(Duration.seconds(0.6), addHelp);
        fadeTransition2.setFromValue(1);
        fadeTransition2.setToValue(0);
        fadeTransition2.play();

        FadeTransition fadeTransition3 = new FadeTransition(Duration.seconds(0.6), editHelp);
        fadeTransition3.setFromValue(1);
        fadeTransition3.setToValue(0);
        fadeTransition3.play();

        FadeTransition fadeTransition4 = new FadeTransition(Duration.seconds(0.6), deleteHelp);
        fadeTransition4.setFromValue(1);
        fadeTransition4.setToValue(0);
        fadeTransition4.play();
    }

    public void closeHelp(){
        hBoxClose.setOpacity(1);
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.6), helpPane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();
    }
    public void generalHelp(){
        closeAllHelp();

        generalHelp.setVisible(true);

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.6), generalHelp);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
    }

   public void addHelp(){
        closeAllHelp();

        addHelp.setVisible(true);

       FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.6), addHelp);
       fadeTransition.setFromValue(0);
       fadeTransition.setToValue(1);
       fadeTransition.play();
   }

    public void editHelp(){
        closeAllHelp();

        editHelp.setVisible(true);

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.6), editHelp);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
    }

    public void deleteHelp(){
        closeAllHelp();

        deleteHelp.setVisible(true);

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.6), deleteHelp);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
    }
}
