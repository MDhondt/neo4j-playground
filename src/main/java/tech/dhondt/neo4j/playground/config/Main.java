package tech.dhondt.neo4j.playground.config;

import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tech.dhondt.neo4j.playground.presenter.Presenter;

import static javafx.stage.StageStyle.DECORATED;

@SpringBootApplication
public class Main extends Application {

    private AnnotationConfigApplicationContext applicationContext;

    @Override
    public void start(Stage primaryStage) {
        applicationContext = new AnnotationConfigApplicationContext(Config.class);
        Presenter presenter = applicationContext.getBean(Presenter.class);
        Stage mainStage = new Stage(DECORATED);
        mainStage.setTitle("Neo4J Demo");
        mainStage.setOnCloseRequest(event -> System.exit(0));
        presenter.show(mainStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}