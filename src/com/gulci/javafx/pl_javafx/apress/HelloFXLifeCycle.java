package com.gulci.javafx.pl_javafx.apress;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloFXLifeCycle extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    public HelloFXLifeCycle() {
        System.out.println("HelloFXLifeCycle() constructor: " + Thread.currentThread().getName());
    }

    @Override
    public void init() {
        System.out.println("init() method: " + Thread.currentThread().getName());
    }

    @Override
    public void start(Stage primaryStage) {
        System.out.println("start() method: " + Thread.currentThread().getName());
        Scene scene = new Scene(new Group(), 200, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("HelloFXLifeCycle Application Life Cycle");
        primaryStage.show();

        // we may explicitly terminate the app by calling Platform.exit() - then stop() is called
        // if it's called from init() or constructor - stop() may not be called
        // stop() may not have any effect in web browser environment

        // default: true, application is closed when last window is closed
        // stop() is called before terminating the JavaFX Application Thread
        // ~ if there are only daemon threads running, the JVM will exit
        // if we put false, we must call Platform.exit()
        // if not, JavaFX Application Thread may be terminated, but not JVM
        //Platform.setImplicitExit(true);
    }

    @Override
    public void stop() {
        System.out.println("stop() method: " + Thread.currentThread().getName());
    }
}
