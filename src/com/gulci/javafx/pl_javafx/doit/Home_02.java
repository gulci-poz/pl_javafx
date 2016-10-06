package com.gulci.javafx.pl_javafx.doit;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Home_02 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        HBox hbox = new HBox();
        hbox.setSpacing(5);

        Button[] buttons = new Button[10];

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new Button(String.valueOf(i + 1));
            buttons[i].setPrefSize(30, 30);
            hbox.getChildren().add(buttons[i]);
        }

        Scene scene = new Scene(hbox);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
