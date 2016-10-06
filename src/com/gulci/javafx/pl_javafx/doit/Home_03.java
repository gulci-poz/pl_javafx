package com.gulci.javafx.pl_javafx.doit;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Home_03 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);
        grid.setHgap(5);
        grid.setVgap(5);

        final int SIZE = 30;

        Button[] buttons = new Button[SIZE];
        int countEven = 0;
        int countOdd = 0;

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new Button(String.valueOf(i + SIZE / 2));
            grid.getChildren().add(buttons[i]);
            if (i % 2 == 0) {
                countEven++;
                GridPane.setConstraints(buttons[i], countEven, 1);
            } else {
                countOdd++;
                GridPane.setConstraints(buttons[i], countOdd, 2);
            }
        }

        BorderPane bp = new BorderPane();
        bp.setTop(new Button("Top"));
        bp.setBottom(new Button("Bottom"));
        bp.setLeft(new Button("Left"));
        bp.setRight(new Button("Right"));
        bp.setCenter(new Button("Center"));
        // the last two parameters give us ability to stretch bp to SIZE / 2 cells in one row
        GridPane.setConstraints(bp, 1, 3, SIZE / 2, 1);

        grid.getChildren().add(bp);

        Scene scene = new Scene(grid);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
