package com.example.petmax;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class IdDialog extends Dialog<String> {
    private final String id;
    private TextField newId;

    public IdDialog(String id) {
        super();
        this.setTitle("Зміна ідентифікаційного номеру");
        this.id = id;
        buildUI();
        setResultConverter();
    }

    private void buildUI() {
        Pane pane = createGridPane();
        getDialogPane().setContent(pane);

        getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        Button button = (Button) getDialogPane().lookupButton(ButtonType.OK);
        button.addEventFilter(ActionEvent.ACTION, new EventHandler<>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (!validateDialog()) {
                    actionEvent.consume();
                }
            }

            private boolean validateDialog() {
                return (!newId.getText().isEmpty());
            }
        });
    }

    private void setResultConverter() {
        Callback<ButtonType, String> doubleResultConverter = buttonType -> {
            if (buttonType == ButtonType.OK) {
                return newId.getText();
            } else {
                return null;
            }
        };
        setResultConverter(doubleResultConverter);
    }

    private Pane createGridPane() {
        VBox content = new VBox(10);

        Label newIdLabel = new Label("Номер рахунку");
        this.newId = new TextField(id);
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(5);
        grid.add(newIdLabel, 0, 0);
        grid.add(newId, 1, 0);
        GridPane.setHgrow(this.newId, Priority.ALWAYS);

        content.getChildren().add(grid);

        return content;
    }
}
