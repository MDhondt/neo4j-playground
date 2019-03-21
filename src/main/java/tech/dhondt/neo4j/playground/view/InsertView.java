package tech.dhondt.neo4j.playground.view;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import tech.dhondt.neo4j.playground.presenter.InsertPresenter;

import static java.lang.Double.MAX_VALUE;
import static javafx.geometry.Pos.TOP_CENTER;

public class InsertView {

    private TitledPane pane;
    private InsertPresenter presenter;

    public InsertView(InsertPresenter presenter) {
        this.presenter = presenter;

        VBox content = new VBox(10);
        content.setAlignment(TOP_CENTER);

        TextArea inputField = new TextArea();
        inputField.setMaxWidth(MAX_VALUE);
        inputField.setPrefHeight(400);
        inputField.setWrapText(true);
        inputField.setText("List<Org> orgs = new ArrayList<>();\n" +
                                   "Org orgA = new Org(\"ClientA\");\n" +
                                   "Org orgB = new Org(\"ClientB\");\n" +
                                   "Role roleAdmin = new Role(\"Administrator\");\n" +
                                   "Role roleManager = new Role(\"Manager\");\n" +
                                   "User user1 = new User(\"User1\");\n" +
                                   "User user2 = new User(\"User2\");\n" +
                                   "User user3 = new User(\"User3\");\n" +
                                   "\n" +
                                   "user1.addRole(roleAdmin);\n" +
                                   "user2.addRole(roleManager);\n" +
                                   "user3.addRole(roleAdmin);\n" +
                                   "\n" +
                                   "orgA.addUser(user1);\n" +
                                   "orgA.addUser(user2);\n" +
                                   "orgB.addUser(user3);\n" +
                                   "\n" +
                                   "Location buildingX = new Location(\"Building X\");\n" +
                                   "Location buildingXWing1 = new Location(\"Wing 1\");\n" +
                                   "Location buildingXWing2 = new Location(\"Wing 2\");\n" +
                                   "Location buildingXWing3 = new Location(\"Wing 3\");\n" +
                                   "Location buildingXWing1Floor1 = new Location(\"Floor 1\");\n" +
                                   "Location buildingXWing1Floor2 = new Location(\"Floor 2\");\n" +
                                   "Location buildingXWing1Floor3 = new Location(\"Floor 3\");\n" +
                                   "Location buildingXWing2Floor1 = new Location(\"Floor 1\");\n" +
                                   "Location buildingXWing2Floor2 = new Location(\"Floor 2\");\n" +
                                   "Location buildingXWing3Floor3 = new Location(\"Floor 2\");\n" +
                                   "Location buildingXWing1Floor1RoomA = new Location(\"Room A\");\n" +
                                   "Location buildingXWing1Floor1RoomB = new Location(\"Room B\");\n" +
                                   "Location buildingXWing1Floor2RoomC = new Location(\"Room C\");\n" +
                                   "Location buildingXWing1Floor3RoomD = new Location(\"Room D\");\n" +
                                   "Location buildingXWing1Floor3RoomE = new Location(\"Room E\");\n" +
                                   "Location buildingXWing1Floor3RoomF = new Location(\"Room F\");\n" +
                                   "Location buildingY = new Location(\"Building Y\");\n" +
                                   "Location buildingZ = new Location(\"Building Z\");\n" +
                                   "Location buildingZWing1 = new Location(\"Wing 1\");\n" +
                                   "Location buildingZWing2 = new Location(\"Wing 2\");\n" +
                                   "Location buildingZWing1Floor1 = new Location(\"Floor 1\");\n" +
                                   "Location buildingZWing1Floor2 = new Location(\"Floor 2\");\n" +
                                   "\n" +
                                   "orgA.addLocation(buildingX);\n" +
                                   "orgA.addLocation(buildingY);\n" +
                                   "orgB.addLocation(buildingZ);\n" +
                                   "buildingX.addLocation(buildingXWing1);\n" +
                                   "buildingX.addLocation(buildingXWing2);\n" +
                                   "buildingX.addLocation(buildingXWing3);\n" +
                                   "buildingXWing1.addLocation(buildingXWing1Floor1);\n" +
                                   "buildingXWing1.addLocation(buildingXWing1Floor2);\n" +
                                   "buildingXWing1.addLocation(buildingXWing1Floor3);\n" +
                                   "buildingXWing2.addLocation(buildingXWing2Floor1);\n" +
                                   "buildingXWing2.addLocation(buildingXWing2Floor2);\n" +
                                   "buildingXWing3.addLocation(buildingXWing3Floor3);\n" +
                                   "buildingXWing1Floor1.addLocation(buildingXWing1Floor1RoomA);\n" +
                                   "buildingXWing1Floor1.addLocation(buildingXWing1Floor1RoomB);\n" +
                                   "buildingXWing1Floor2.addLocation(buildingXWing1Floor2RoomC);\n" +
                                   "buildingXWing1Floor3.addLocation(buildingXWing1Floor3RoomD);\n" +
                                   "buildingXWing1Floor3.addLocation(buildingXWing1Floor3RoomE);\n" +
                                   "buildingXWing1Floor3.addLocation(buildingXWing1Floor3RoomF);\n" +
                                   "buildingZ.addLocation(buildingZWing1);\n" +
                                   "buildingZ.addLocation(buildingZWing2);\n" +
                                   "buildingZWing1.addLocation(buildingZWing1Floor1);\n" +
                                   "buildingZWing1.addLocation(buildingZWing1Floor2);\n" +
                                   "\n" +
                                   "Painting painting1 = new Painting(\"#1\", \"someone\");\n" +
                                   "Painting painting2 = new Painting(\"#2\", \"no-one\");\n" +
                                   "Statue statue1 = new Statue(\"#1\", \"John\");\n" +
                                   "Statue statue2 = new Statue(\"#2\", \"Jane\");\n" +
                                   "\n" +
                                   "buildingXWing1Floor1RoomA.addItem(painting1);\n" +
                                   "buildingXWing1Floor2RoomC.addItem(painting2);\n" +
                                   "buildingY.addItem(statue1);\n" +
                                   "buildingZWing1Floor2.addItem(statue2);\n" +
                                   "\n" +
                                   "orgs.add(orgA);\n" +
                                   "orgs.add(orgB);\n" +
                                   "return orgs;");

        Button insertButton = new Button("Insert above entities");
        insertButton.setOnAction(event -> presenter.fillDb(inputField.getText()));

        Button removeButton = new Button("Clear db");
        removeButton.setOnAction(event -> presenter.deleteAll());

        content.getChildren().addAll(inputField, insertButton, removeButton);

        pane = new TitledPane("Insert", content);
    }

    public TitledPane getPane() {
        return pane;
    }
}