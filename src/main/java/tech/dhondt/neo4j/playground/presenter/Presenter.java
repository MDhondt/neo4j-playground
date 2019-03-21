package tech.dhondt.neo4j.playground.presenter;

import javafx.stage.Stage;
import org.springframework.stereotype.Component;
import tech.dhondt.neo4j.playground.view.View;

import javax.inject.Inject;

@Component
public class Presenter {

    @Inject
    private InsertPresenter insertPresenter;
    @Inject
    private RetrievePresenter retrievePresenter;

    private final View view;

    private Presenter() {
        this.view = new View();
    }

    public void show(Stage mainStage) {
        view.setStage(mainStage);

        insertPresenter.init();
        retrievePresenter.init();

        view.addTools(insertPresenter.pane(), retrievePresenter.pane());

        view.show();
    }
}