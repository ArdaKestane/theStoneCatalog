package com.example.ce216;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main extends Application {


    private Catalog catalog = Catalog.getCatalogInstance();
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("LandingPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Catalog");
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(windowEvent -> {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("EXIT");
            alert.setContentText("Would you like to save?");
            AtomicBoolean b = new AtomicBoolean(false);
            ButtonType yesButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
            ButtonType noButton = new ButtonType("No", ButtonBar.ButtonData.NO);
            alert.getButtonTypes().setAll(yesButton, noButton);
            alert.showAndWait().ifPresent(choice -> {
                b.set(choice != noButton);
            });
            if(b.get())
                catalog.writeToFile();
        });
    }

    public static void main(String[] args) {
        launch();
    }
}