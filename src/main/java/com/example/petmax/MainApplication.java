package com.example.petmax;

import entity.CreditSystem;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class MainApplication extends Application {
    Stage stage = new Stage();
    CreditSystem creditSystem;
    @Override
    public void start(Stage stage) throws Exception {
        MainController mainController = new MainController(creditSystem);
        FXMLLoader fxmlLoader = new FXMLLoader(CreditSystemApplication.class.getResource("main-view.fxml"));
        fxmlLoader.setController(mainController);
        Scene scene = new Scene(fxmlLoader.load(), 480, 480);

        stage.setTitle("Credit System");
        stage.setScene(scene);

        stage.show();
    }

    public void showWindow(CreditSystem creditSystem) throws Exception {
        this.creditSystem = creditSystem;
        start(stage);
    }
}
