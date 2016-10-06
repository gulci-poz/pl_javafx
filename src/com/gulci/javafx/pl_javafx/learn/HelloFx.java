package com.gulci.javafx.pl_javafx.learn;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class HelloFx extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("HelloFx");
        Integer width = Integer.parseInt(getParameters().getNamed().get("width"));
        Integer height = Integer.parseInt(getParameters().getNamed().get("height"));
        System.out.println(getParameters().getUnnamed());
        System.out.println(getParameters().getRaw());
        // we can use Label
        Group group = new Group(new Button("HelloFx Button"));
        Scene scene = new Scene(group, width, height);
        stage.setScene(scene);
        stage.show();
    }
}
