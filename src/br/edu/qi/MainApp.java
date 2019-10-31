/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi;

import br.edu.qi.controller.DetranViewController;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Huilton
 */
public class MainApp extends Application {

    private static Stage stage;
    private static Scene locEditView;
    private static Scene locConsultaView;

    // Huilton
    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = new Stage();
        FXMLLoader fmlxLocEditView = new FXMLLoader(MainApp.class.getResource("view/Detran.fxml"));
        AnchorPane rootFmlxLocEditView = (AnchorPane) fmlxLocEditView.load();
        locEditView = new Scene(rootFmlxLocEditView);
        locEditView.getStylesheets().add(getClass().getResource("/Style/CssBotoes.css").toExternalForm());
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setTitle("Cadastro");

        stage.setScene(locEditView);
        stage.show();
    }

    public static void changeScreen(String scene) throws IOException {
        switch (scene) {
            case "Detran":
                stage.setScene(locEditView);
                break;
            case "locConsultaView":
                FXMLLoader fmlxLocConsultaView = new FXMLLoader(MainApp.class.getResource("view/ConsultaView.fxml"));
                AnchorPane rootFmlxLocConsultaView = (AnchorPane) fmlxLocConsultaView.load();
                locConsultaView = new Scene(rootFmlxLocConsultaView);
                stage.setScene(locConsultaView);
                break;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
