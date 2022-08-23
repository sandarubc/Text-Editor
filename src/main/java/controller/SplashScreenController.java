package controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.WeakEventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;

public class SplashScreenController {
    public Label lblStatus;
    public void initialize(){
        Timeline timeline = new Timeline();
        var frame1 = new KeyFrame(Duration.millis(500), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lblStatus.setText("Loading Plugins");

            }
        });
        var frame2 = new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lblStatus.setText("Loading Plugins");

            }
        });
         var frame3 = new KeyFrame(Duration.millis(1500), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lblStatus.setText("Initializing...");
            }
        });
        var frame4 = new KeyFrame(Duration.millis(3500), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    URL resource = this.getClass().getResource("/view/TextEditorForm.fxml");
                    Parent container = FXMLLoader.load(resource);
                    Scene scene = new Scene(container);
                    Stage primaryStage = new Stage();
                    primaryStage.setScene(scene);
                    primaryStage.setTitle("Text Editor");
                    primaryStage.centerOnScreen();
                    primaryStage.show();
                    lblStatus.getScene().getWindow().hide();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        });
        timeline.getKeyFrames().addAll(frame1,frame2,frame3,frame4);
        timeline.playFromStart();



    }

}
