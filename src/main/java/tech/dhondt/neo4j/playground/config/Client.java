package tech.dhondt.neo4j.playground.config;

import javafx.application.Application;
import javafx.stage.Stage;

public class Client extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}