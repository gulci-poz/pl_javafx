package com.gulci.javafx.pl_javafx.doit;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Home extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Group g = new Group();

        Label l1 = new Label();
        Label l2 = new Label("Search");

        //Image image = new Image(getClass().getResourceAsStream("search-icon.png"));
        Image image = new Image("search-icon.png");
        l1.setGraphic(new ImageView(image));

        TextField tf = new TextField();
        tf.setPromptText(l2.getText());

        ComboBox cb = new ComboBox();
        cb.getItems().addAll("Highest", "High", "Normal", "Low");
        cb.setValue("Normal");

        CheckBox chb1 = new CheckBox("True");
        chb1.setSelected(true);

        CheckBox chb2 = new CheckBox("False");
        chb2.setSelected(false);

        TableView tv = new TableView();
        tv.setEditable(true);
        TableColumn tc1 = new TableColumn("First Name");
        TableColumn tc2 = new TableColumn("Last Name");
        tv.getColumns().addAll(tc1, tc2);

        ProgressBar progressBar = new ProgressBar();

        Spinner<Integer> spinner = new Spinner(0, 100, 0);
        spinner.setEditable(true);

        g.getChildren().addAll(l1, l2, tf, cb, chb1, chb2, tv, progressBar, spinner);
        l2.setLayoutX(35);
        tf.setLayoutX(80);
        cb.setLayoutX(250);
        chb1.setLayoutX(350);
        chb2.setLayoutX(350);
        chb2.setLayoutY(20);
        tv.setLayoutY(50);
        progressBar.setLayoutX(300);
        progressBar.setLayoutY(50);
        spinner.setLayoutX(300);
        spinner.setLayoutY(100);

        Scene scene = new Scene(g, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
