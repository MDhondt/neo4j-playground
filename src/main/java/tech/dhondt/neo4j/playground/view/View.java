package tech.dhondt.neo4j.playground.view;

import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import tech.dhondt.neo4j.playground.view.component.AccordionPane;

public class View {

    private Stage mainStage;
    private Scene scene;
    private BorderPane mainPane;
    private Accordion tools;

    public View() {
        mainPane = new BorderPane();
        scene = new Scene(mainPane);
        tools = new Accordion();
        tools.setMinWidth(500);
        tools.setMinHeight(600);
    }

    public void show() {
        populateStage();
        mainStage.show();
    }

    public void setStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

    private void populateStage() {
        mainStage.setScene(scene);
    }

    public void addTools(AccordionPane... panes) {
        for (AccordionPane pane : panes) {
            tools.getPanes().add(pane.pane());
        }
        tools.setExpandedPane(panes[0].pane());
        mainPane.setCenter(tools);
    }
}