package com.example.petmax;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class TransferDialog extends Dialog<Double> {
    private String amount;
    private TextField accountNumber;
    private TextField moneyAmount;

    public TransferDialog(String amount) {
        super();
        this.setTitle("Перевід грошей");
        this.amount = amount;
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
                return (!accountNumber.getText().isEmpty()) && (!moneyAmount.getText().isEmpty());
            }
        });
    }

    private void setResultConverter() {
        Callback<ButtonType, Double> doubleResultConverter = buttonType -> {
            if (buttonType == ButtonType.OK) {
                return Double.parseDouble(moneyAmount.getText());
            } else {
                return null;
            }
        };
        setResultConverter(doubleResultConverter);
    }

    private Pane createGridPane() {
        VBox content = new VBox(10);

        Label accountNumberLabel = new Label("Номер рахунку");
        Label moneyAmountLabel = new Label("Сума переводу");
        this.accountNumber = new TextField();
        this.moneyAmount = new TextField();
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(5);
        grid.add(accountNumberLabel, 0, 0);
        grid.add(moneyAmountLabel, 0, 1);
        grid.add(accountNumber, 1, 0);
        GridPane.setHgrow(this.accountNumber, Priority.ALWAYS);
        grid.add(moneyAmount, 1, 1);
        GridPane.setHgrow(this.moneyAmount, Priority.ALWAYS);

        content.getChildren().add(grid);

        return content;

    }
}
