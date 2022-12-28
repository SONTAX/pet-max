package com.example.petmax;

import entity.CreditSystem;
import entity.Role;
import entity.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    private CreditSystem creditSystem;

    @FXML
    private ComboBox<Role> roleCbx;

    @FXML
    private TextField name;

    @FXML
    private TextField surname;

    @FXML
    private TextField id;

    @FXML
    private Button btn;

    public void loadComboBox() {
        roleCbx.getItems().setAll(Role.values());
    }

    public void login() throws Exception {
        if (!name.getText().equals("") && !surname.getText().equals("") && !id.getText().equals("")) {
            this.creditSystem = new CreditSystem(new User(name.getText(), surname.getText(), roleCbx.getValue(), id.getText()));
            changeWindow();
        } else {
            new Alert(Alert.AlertType.ERROR, "Усі поля мають бути заповненні!").show();
        }
    }

    private void changeWindow() throws Exception {
        MainApplication mainApplication = new MainApplication();
        mainApplication.showWindow(creditSystem);
        Stage stage = (Stage) btn.getScene().getWindow();
        stage.close();
        new Alert(Alert.AlertType.INFORMATION, "Ви успішно увійшли!").show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadComboBox();
    }
}