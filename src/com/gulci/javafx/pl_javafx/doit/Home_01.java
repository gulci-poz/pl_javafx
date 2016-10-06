package com.gulci.javafx.pl_javafx.doit;

        import javafx.application.Application;
        import javafx.scene.Group;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.stage.Stage;

public class Home_01 extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        // STAGE - main container, JavaFX runtime creates the primary stage
        // our application may contain more than one stage
        // stage may contain a number of SCENES
        // each scene contains a ROOT NODE which is a root for a SCENE GRAPH
        // root node contains NODES and PARENT NODES that can contain other nodes and paren nodes
        // example: GROUP is a parent node (in this case - root node), that contains other nodes (BUTTON, LABEL)
        // LAYOUT - container node: HBox, VBox, FlowPane, BorderPane, GridPane, TilePane, StackPane, AnchorPane
        // no constraints for node count
        // BorderPane splits into 5 regions: Top, Bottom, Left, Right, Center
        // each region is optional, can be of any size, can only have one node (it may contain other layout)
        // layouts can contain other layouts

        Group g = new Group();

        //g.getChildren().add(new Button("First Button"));

        Button b1 = new Button("1");
        Button b2 = new Button("2");
        g.getChildren().addAll(b1, b2);

        // in this case we only need to move the button in X (to the right)
        b2.setLayoutX(25);

        Scene scene = new Scene(g, 640, 480);
        stage.setScene(scene);
        stage.setTitle("Do-It!");
        stage.setAlwaysOnTop(true);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
