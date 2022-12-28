package com.example.petmax;

import entity.CreditSystem;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class ProfileController implements Initializable {
    private final CreditSystem creditSystem;

    @FXML
    private TextField name;

    @FXML
    private TextField surname;

    @FXML
    private Button btn;

    @FXML
    private Button btn1;

    public ProfileController(CreditSystem creditSystem) {
        this.creditSystem = creditSystem;
    }

    public void changeId() {
        Dialog<String> idDialog = new IdDialog(creditSystem.getUser().getIdentificationNumber());
        Optional<String> result = idDialog.showAndWait();
        result.ifPresent(creditSystem::changeId);
    }

    private void changeWindow() throws Exception {
        MainApplication mainApplication = new MainApplication();
        mainApplication.showWindow(creditSystem);
        Stage stage = (Stage) btn.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setText(creditSystem.getUser().getName());
        surname.setText(creditSystem.getUser().getSurname());
        name.setOnAction(actionEvent -> creditSystem.getUser().setName(name.getText()));
        surname.setOnAction(actionEvent -> creditSystem.getUser().setSurname(surname.getText()));
        btn.setOnAction(actionEvent -> changeId());
        btn1.setOnAction(actionEvent -> {
            try {
                changeWindow();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}
