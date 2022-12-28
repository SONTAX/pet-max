package com.example.petmax;

import entity.CreditSystem;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    private final CreditSystem creditSystem;

    @FXML
    private Button btn1;
    @FXML
    private Button btn3;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private Button btn6;
    @FXML
    private Button btn7;

    public MainController(CreditSystem creditSystem) {
        this.creditSystem = creditSystem;
    }

    public void transferMoney() {
        Dialog<Double> transferDialog = new TransferDialog(null);
        Optional<Double> result = transferDialog.showAndWait();
        if (result.isPresent()) {
            Double amount = result.get();
            successMessage(creditSystem.transferMoney(amount));
        }
    }

    public void payUp() {
        Dialog<Double> paymentDialog = new PaymentDialog(null);
        Optional<Double> result = paymentDialog.showAndWait();
        if (result.isPresent()) {
            Double amount = result.get();
            successMessage(creditSystem.transferMoney(amount));
        }
    }

    public void showBalance() {
        new Alert(Alert.AlertType.INFORMATION, "На рахунку: " + creditSystem.balance() + " грошей!").show();
    }

    public void withdraw() {
        Dialog<Double> withdrawDialog = new WithdrawDialog(null);
        Optional<Double> result = withdrawDialog.showAndWait();
        if (result.isPresent()) {
            Double amount = result.get();
            successMessage(creditSystem.transferMoney(amount));
        }
    }

    public void topUp() {
        Dialog<Double> topUpDialog = new TopUpDialog(null);
        Optional<Double> result = topUpDialog.showAndWait();
        if (result.isPresent()) {
            Double amount = result.get();
            creditSystem.topUpAccount(amount);
            new Alert(Alert.AlertType.INFORMATION, "Рахунок успішно поповненно!").show();
        }
    }

    public void successMessage(boolean isSuccessful) {
        if (isSuccessful) {
            new Alert(Alert.AlertType.INFORMATION, "Гроші успішно переведені!").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Не достатньо грошей на рахунку!").show();
        }
    }

    private void changeWindow() throws Exception {
        ProfileApplication profileApplication = new ProfileApplication();
        profileApplication.showWindow(creditSystem);
        Stage stage = (Stage) btn7.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btn1.setOnAction(actionEvent -> transferMoney());
        btn3.setOnAction(actionEvent -> payUp());
        btn4.setOnAction(actionEvent -> showBalance());
        btn5.setOnAction(actionEvent -> withdraw());
        btn6.setOnAction(actionEvent -> topUp());
        btn7.setOnAction(actionEvent -> {
            try {
                changeWindow();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}
