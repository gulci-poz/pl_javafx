package com.gulci.javafx.pl_javafx.apress;

import javafx.application.Application;
import javafx.application.Platform;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;
import java.util.Map;

public class HelloFXApp extends Application {

    // JavaFX runtime (launch() method) creates threads (there are more): JavaFX-Launcher, JavaFX Application Thread
    // JavaFX Application Thread is the operating system level thread (it also manages events)
    // Prism and MediaEngine have its own threads
    // we don't create application object, JavaFX does it after launching (on the JavaFX Application Thread)
    // JavaFX-Launcher calls init() of the new object,
    // we can override this method, we can create UI controls there (but not Stage or Scene)
    // Stage and Scene objects are then created on the JavaFX Application Thread (it calls start() method)
    // launch() awaits for the app finish, then JavaFX Application Thread calls stop()

    // life-cycle:
    // main(String[] args) -> Application.launch(args) -> no-args constructor
    // Application.init()
    // Application.start()
    // Stage.show()
    // Application.stop()

    // main is optional, without it Application.launch() is called automatically(), a JavaFX packager synthesizes one
    // some IDEs require main in particular cases

    public static void main(String[] args) {

        // launch() does not return until all windows are closed or the application exits using the Platform.exit()
        // from javafx.application.Platform
        // the call to launch() blocks until the application is terminated

        // by default caller class type is checked
        // if there's no inheritance from Application (direct or indirect), an error will be thrown
        // indirect may be from inside of an anonymous class
        Application.launch(args);

        // it is possible to launch JavaFX app from other class that doesn't inherit from Application
        // we use overloaded launch() and specify class reference as a first argument
        //static void launch(Class<? extends Application> appClass, String... args)
        //Application.launch(MyJavFXApp.class, args);

        //Application.launch(HelloFXApp.class, args);

        // we can use simple launch() - Java will match it with Application
    }

    // application class must have a no-args constructor (the default one is sufficient)
    // if we add a constructor with args and don't provide a no-args one, we'll have an error

    @Override
    public void start(Stage primaryStage) {
        // return the reference of the Application.Parameters class (it's inner class)
        // the reference is available in the init() and in the code that executes afterward
        // not in the app's constructor - getParameters() returns null
        // we use this, because getParameters() is non-static and we can't use it with Application's static context
        // we can use simple getParameters() - Java will match it with this
        Parameters p = this.getParameters();

        Map<String, String> namedParams = p.getNamed();
        List<String> unnamedParams = p.getUnnamed();
        List<String > rawParams = p.getRaw();

        String paramStr = "Named Parameters: " + namedParams + "\n"
                + "Unnamed Parameters: " + unnamedParams + "\n"
                + "Raw Parameters: " + rawParams;

        TextArea taParams = new TextArea(paramStr);
        Group groupParams = new Group(taParams);

        Text hello = new Text("Hello JavaFX");
        Label nameLbl = new Label("Enter your name:");
        TextField nameFld = new TextField();
        Label msg = new Label();

        msg.setStyle("-fx-text-fill: blue;");

        Button sayHelloButton = new Button("Say Hello");
        Button exitBtn = new Button("Exit");

        // when the button is clicked, an ActionEvent is fired

        // handler using lambdas
        exitBtn.setOnAction(e -> Platform.exit());

        // handler using anonymous function
        /*
        exitBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });
        */

        sayHelloButton.setOnAction(e -> {
            String name = nameFld.getText();
            if (name.trim().length() > 0) {
                msg.setText("Hello " + name);
            } else {
                msg.setText("Hello there");
            }
        });

        // root node must inherit from javafx.scene.Parent
        VBox root = new VBox();
        root.setSpacing(5);

        // a node that can have children provides getChildren() that returns an ObservableList
        root.getChildren().addAll(hello, nameLbl, nameFld, msg, sayHelloButton, exitBtn, groupParams);

        Scene scene = new Scene(root, 640, 480);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Improved Hello JavaFX Application");
        primaryStage.show();
    }
}
