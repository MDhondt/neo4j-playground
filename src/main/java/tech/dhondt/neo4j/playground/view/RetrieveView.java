package tech.dhondt.neo4j.playground.view;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import tech.dhondt.neo4j.playground.presenter.RetrievePresenter;

import static javafx.geometry.Pos.TOP_CENTER;

public class RetrieveView {

    private TitledPane pane;
    private RetrievePresenter presenter;

    public RetrieveView(RetrievePresenter presenter) {
        this.presenter = presenter;

        VBox content = new VBox(10);
        content.setAlignment(TOP_CENTER);

        Button retrieveAll = new Button("RetrieveAll");
        retrieveAll.setOnAction(event -> System.out.println(presenter.findAll()));

        HBox findByIdBox = new HBox(10);
        TextField locationId = new TextField();
        locationId.setPrefWidth(40);
        Button findByIdButton = new Button("Retrieve location tree and items starting from location id");
        findByIdButton.setOnAction(event -> System.out.println(presenter.findAllItemsForLocation(Long.parseLong(locationId.getText()))));
        findByIdBox.getChildren().addAll(findByIdButton, locationId);

        HBox findByOrgIdBox = new HBox(10);
        TextField orgId = new TextField();
        orgId.setPrefWidth(40);
        Button findByOrgIdButton = new Button("Retrieve location tree starting from org id ");
        findByOrgIdButton.setOnAction(event -> System.out.println(presenter.findAllLocationsForOrg(Long.parseLong(orgId.getText()))));
        findByOrgIdBox.getChildren().addAll(findByOrgIdButton, orgId);

        content.getChildren().addAll(retrieveAll, findByIdBox, findByOrgIdBox);

        pane = new TitledPane("Retrieve", content);
    }

    public TitledPane getPane() {
        return pane;
    }
}